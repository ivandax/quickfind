import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.util.Arrays;

public class Percolation {
    private WeightedQuickUnionCopy grid;
    private boolean[] openState;
    private int gridSize;

    public Percolation(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("n cannot be lower than 1");
        }
        setGridSize(n);
        int totalItems = n * (n + 2);
        grid = new WeightedQuickUnionCopy(totalItems);
        boolean[] initialStates = new boolean[totalItems];
        for (int i = 0; i < totalItems - 1; i++) {
            boolean isOnFirstRow = i < n;
            boolean nextIsOnFirstRow = i + 1 < n;
            boolean isOnLastRow = i > (n * n) + n - 1;
            if (isOnFirstRow) {
                initialStates[i] = true;
                if (nextIsOnFirstRow) {
                    grid.union(i, i + 1);
                }
            } else if (isOnLastRow) {
                initialStates[i] = true;
                grid.union(i, i + 1);

            } else {
                initialStates[i] = false;
            }
        }
        setOpenState(initialStates);
    }

    private int xyTo1D(int row, int col) {
        return row * gridSize + col - 1;
    }

    private void validateIndices(int row, int col) {
        if (row < 1 || col < 1) {
            throw new IllegalArgumentException("Row and col cannot be below 1");
        } else if (row > gridSize || col > gridSize) {
            throw new IllegalArgumentException("Row and col cannot be greater than n");
        }
    }

    public boolean isOpen(int row, int col) {
        validateIndices(row, col);
        int index = xyTo1D(row, col);
        return openState[index];
    }

    private boolean internalIsOpen(int row, int col) {
        int index = xyTo1D(row, col);
        System.out.println("is upper open" + openState[index]);
        return openState[index];
    }

    public void open(int row, int col) {
        validateIndices(row, col);
        int index = xyTo1D(row, col);
        System.out.println("index is " + index);
        boolean notOpenYet = !openState[index];
        if (notOpenYet) {
            tryUpperUnion(row, col, index);
        }
    }

    private void tryUpperUnion(int row, int col, int index){
        if(row > 0){
            int upperRow = row - 1;
            boolean isAboveOpen = internalIsOpen(upperRow, col);
            if(isAboveOpen){
                int upperIndex = xyTo1D(upperRow, col);
                System.out.println("upperIndex is " + upperIndex);
                grid.union(index, upperIndex);
            }
        }
    }

    public WeightedQuickUnionCopy getGrid() {
        return grid;
    }

    public void setGrid(WeightedQuickUnionCopy grid) {
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

    public void check() {
        System.out.println("Open states");
        System.out.println(Arrays.toString(getOpenState()));
        System.out.println("Grid size");
        System.out.println(getGridSize());
        System.out.println("Weighted union data structure");
        System.out.println(Arrays.toString(grid.getParent()));
    }
}
