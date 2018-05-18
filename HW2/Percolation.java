import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation{
    // true is open, false is blocked
    private final int n;
    private boolean[] open;
    private int count = 0;
    private final int virtualTop = 0 ;
    private final int virtualBot;
    private final WeightedQuickUnionUF wqf;
    private final WeightedQuickUnionUF backwash;

    //helper function
    //transfer the (row, col) to int
    private int transfer(int row, int col){
        if(row <= 0 || col <= 0 || row > n || col > n){
            throw new java.lang.IllegalArgumentException("invalid argument");
        }
        return (row-1) * n + col;
    }

    //create n-by-n grid, with all sites blocked
    public Percolation(int n){
        if(n <= 0){
            throw new java.lang.IllegalArgumentException("invalid argument");
        }
        this.n = n;
        int totalGrid = n * n;
        this.virtualBot = n * n + 1;
        this.wqf = new WeightedQuickUnionUF(totalGrid + 2 );
        this.backwash = new WeightedQuickUnionUF(totalGrid + 1);
        open = new boolean[totalGrid];
        for (int i = 0; i < totalGrid-1; i ++){
            open[i] = false;
        }
    }

    //is site (row, col) open?
    public boolean isOpen(int row, int col){
        return open[transfer(row, col) - 1];
    }

    //open site (row, col) if it is not open already
    public void open(int row, int col){
        //check corner
        if(row <= 0 || col <= 0 || row > n || col > n){
            throw new java.lang.IllegalArgumentException("invalid argument");
        }
        int index = transfer(row, col);
        if(!isOpen(row, col)){
            open[index-1] = true;
            count ++;
        }else{
            return;
        }
        if(row == 1){
            wqf.union(index, virtualTop);
            backwash.union(index, virtualTop);
        }
        if(row == n){
            wqf.union(index, virtualBot);
        }
        //top  row-1, col
        if(row > 1 && isOpen(row-1, col)){
            wqf.union(index, transfer(row-1, col));
            backwash.union(index, transfer(row-1, col));
        }

        //bot  row+1, col
        if(row < n && isOpen(row + 1, col)){
            wqf.union(index, transfer(row + 1 , col));
            backwash.union(index, transfer(row + 1 , col));
        }

        //left row, col-1
        if(col > 1 && isOpen(row, col - 1)){
            wqf.union(index, transfer(row, col-1));
            backwash.union(index, transfer(row, col-1));
        }

        //right row, col+1
        if(col < n && isOpen(row, col + 1)){
            wqf.union(index, transfer(row, col+1));
            backwash.union(index, transfer(row, col+1));
        }

    }

    //is site (row, col) full?
    //A full site is an open site that can be
    //connected to an open site in the top row via a chain of neighboring (left, right, up, down) open sites
    public boolean isFull(int row, int col){
        return isOpen(row, col) && backwash.connected(transfer(row, col), virtualTop);
    }

    //number of open sites
    public int numberOfOpenSites(){
        return count;
    }

    //does the system percolate?
    public boolean percolates(){
        return this.wqf.connected(virtualBot, virtualTop);
    }
}
