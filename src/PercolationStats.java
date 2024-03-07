import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class PercolationStats {
    double[] thresholds = {};

    public PercolationStats(int n, int trials) {
        int i = 0;
        thresholds = new double[trials];
        while (i < trials) {
            System.out.println("Will run trial " + n);
            double threshold = runPercolationTrial(n);
            thresholds[i] = threshold;
            i++;
        }
    }

    private double runPercolationTrial(int n){
        boolean foundThreshold = false;
        double threshold = 0;
        Percolation percolation = new Percolation(n);
        while(!foundThreshold){
            int row = StdRandom.uniformInt(1, n + 1);
            int col = StdRandom.uniformInt(1, n + 1);
            System.out.println("Will try with row " + row + " and col " + col);
            percolation.open(row, col);
            boolean isFull = percolation.isFull(row, col);
            if(isFull){
                boolean percolates = percolation.percolates();
                if(percolates){
                    threshold = (double) percolation.numberOfOpenSites() / (n * n);
                    foundThreshold = true;
                }
            }
        }
        return threshold;
    }

    public double[] getThresholds() {
        return thresholds;
    }

    public void setThresholds(double[] thresholds) {
        this.thresholds = thresholds;
    }

    public void check() {
        System.out.println(Arrays.toString(getThresholds()));
    }
}
