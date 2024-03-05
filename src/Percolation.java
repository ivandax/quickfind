import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.Arrays;

public class Percolation {
    private WeightedQuickUnionUF grid;
    private boolean[] openState;
    private int gridSize;

    public Percolation(int n){
        if(n < 1){
            throw new IllegalArgumentException("n cannot be lower than 1");
        }
        setGridSize(n);
        int totalItems = n * (n + 2);
        grid = new WeightedQuickUnionUF(totalItems);
        boolean[] initialStates = new boolean[totalItems];
        for(int i = 0; i < totalItems; i++){
            if(i < n || i > (n * n) + n - 1){
                System.out.println("we get 1");
                initialStates[i] = true;
            } else {
                System.out.println("we get 2");
                initialStates[i] = false;
            }
        }
        setOpenState(initialStates);
    }

    private int xyTo1D(int row, int col){
        return row * gridSize + col;
    }

    private void validateIndices(int row, int col ){
        if(row - 1 < 0 || col - 1 < 0){
            throw new IllegalArgumentException("Row and col cannot be below 1");
        } else if (row > gridSize || col > gridSize) {
            throw new IllegalArgumentException("Row and col cannot be greater than n");
        }
    }

    public boolean isOpen(int row, int col){
        validateIndices(row, col);
        int rowIndex = row - 1;
        int colIndex = col - 1;
        int index = xyTo1D(rowIndex, colIndex);
        return openState[index];
    }

    public void open(int row, int col){
        validateIndices(row, col);
        int rowIndex = row - 1;
        int colIndex = col - 1;
        int index = xyTo1D(rowIndex, colIndex);
        boolean notOpenYet = !openState[index];
        if(notOpenYet){

        }
    }

    public WeightedQuickUnionUF getGrid() {
        return grid;
    }

    public void setGrid(WeightedQuickUnionUF grid) {
        this.grid = grid;
    }

    public int getGridSize() {
        return gridSize;
    }

    public void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }

    public boolean[] getOpenState() {
        return openState;
    }

    public void setOpenState(boolean[] openState) {
        this.openState = openState;
    }

    public void check(){
        System.out.println("Open states");
        System.out.println(Arrays.toString(getOpenState()));
        System.out.println("Grid size");
        System.out.println(getGridSize());
    }
}
