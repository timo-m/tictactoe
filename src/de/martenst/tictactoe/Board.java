package de.martenst.tictactoe;

public final class Board {
    private static final String ROW = "%s|%s|%s";
    private final char[][] board = new char[3][3];

    public static void main(String[] args) {
        Board board = new Board();
        board.print();

        System.out.println();
        board.setCharAtIndex('X', 0, 0);
        board.setCharAtIndex('O', 2, 2);
        board.print();

        System.out.println();
        System.out.println("Empty cell at [0|0]: " + board.cellAtIndexIsEmpty(0, 0));
        System.out.println("Empty cell at [0|1]: " + board.cellAtIndexIsEmpty(0, 1));

        System.out.println();
        System.out.println("Row 1 is set: " + board.rowIsSet(0));
        board.setCharAtIndex('X', 0, 1);
        board.setCharAtIndex('X', 0, 2);
        board.print();
        System.out.println("Row 1 is set: " + board.rowIsSet(0));

        System.out.println();
        board.setCharAtIndex('-', 1, 0);
        board.setCharAtIndex('-', 1, 1);
        board.setCharAtIndex('-', 1, 2);
        board.setCharAtIndex('-', 2, 0);
        board.setCharAtIndex('-', 2, 1);
        board.print();
        System.out.println("All cells are set: " + board.allCellsAreSet());
    }

    public void print() {
        for (int row = 0, maxCol = 2; row <= maxCol; row++) {
            System.out.println(String.format(ROW, board[row][0], board[row][1], board[row][2]));
        }
    }

    public boolean setCharAtIndex(final char c, final int row, final int column) {
        if (this.cellAtIndexIsEmpty(row, column)) {
            board[row][column] = c;
            return true;
        }
        return false;
    }

    private char getCellAtIndex(final int row, final int column) {
        return board[row][column];
    }

    private boolean cellAtIndexIsEmpty(final int row, final int column) {
        return Character.UNASSIGNED == this.getCellAtIndex(row, column);
    }

    private boolean allCellsAreSet() {
        return rowIsSet(0) && rowIsSet(1) && rowIsSet(2);
    }

    private boolean rowIsSet(final int row) {
        return !cellAtIndexIsEmpty(row, 0) && !cellAtIndexIsEmpty(row, 1) && !cellAtIndexIsEmpty(row, 2);
    }
}