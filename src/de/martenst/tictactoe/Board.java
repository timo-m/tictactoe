package de.martenst.tictactoe;

public final class Board {
    private static final String ROW = "%s|%s|%s";
    private final char[][] board = new char[3][3];


    public void print() {
        System.out.println("");
        for (int row = 0, maxCol = 2; row <= maxCol; row++) {
            System.out.println(String.format(ROW, board[row][0], board[row][1], board[row][2]));
        }
    }

    public boolean setCharAtIndex(final char c, final int row, final int column) {
        if (row < 0 || row > 2 || column < 0 || column > 2) {
            return false;
        }
        if (this.cellAtIndexIsEmpty(row, column) && !this.hasAWinner()) {
            board[row][column] = c;
            return true;
        }
        return false;
    }

    boolean cellAtIndexIsEmpty(final int row, final int column) {
        return Character.UNASSIGNED == this.getCellAtIndex(row, column);
    }

    private char getCellAtIndex(final int row, final int column) {
        return board[row][column];
    }

    public boolean allCellsAreSet() {
        return rowIsSet(0) && rowIsSet(1) && rowIsSet(2);
    }

    boolean rowIsSet(final int row) {
        return !cellAtIndexIsEmpty(row, 0) && !cellAtIndexIsEmpty(row, 1) && !cellAtIndexIsEmpty(row, 2);
    }

    private boolean columnIsSet(final int column) {
        return !cellAtIndexIsEmpty(0, column) && !cellAtIndexIsEmpty(1, column) && !cellAtIndexIsEmpty(2, column);
    }

    public boolean hasAWinner() {
        return winnerInRow(0) || winnerInRow(1) || winnerInRow(2)
                || winnerInColumn(0) || winnerInColumn(1) || winnerInColumn(2)
                || winnerInDiag1() || winnerInDiag2();
    }

    public boolean makeAMoveIsAllowed() {
        return !this.allCellsAreSet() && !this.hasAWinner();
    }

    boolean winnerInRow(int row) {
        return rowIsSet(row)
                && getCellAtIndex(row, 0) == getCellAtIndex(row, 1)
                && getCellAtIndex(row, 1) == getCellAtIndex(row, 2);
    }

    boolean winnerInColumn(int column) {
        return columnIsSet(column)
                && getCellAtIndex(0, column) == getCellAtIndex(1, column)
                && getCellAtIndex(1, column) == getCellAtIndex(2, column);
    }

    boolean winnerInDiag1() {
        return !cellAtIndexIsEmpty(0, 0)
                && getCellAtIndex(0, 0) == getCellAtIndex(1, 1)
                && getCellAtIndex(1, 1) == getCellAtIndex(2, 2)
                && !cellAtIndexIsEmpty(2, 2);
    }

    boolean winnerInDiag2() {
        return !cellAtIndexIsEmpty(0, 2)
                && getCellAtIndex(0, 2) == getCellAtIndex(1, 1)
                && getCellAtIndex(1, 1) == getCellAtIndex(2, 0)
                && !cellAtIndexIsEmpty(2, 0);
    }
}