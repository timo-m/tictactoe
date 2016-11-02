package de.martenst.tictactoe;


public class BoardTest {

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
        System.out.println("All cells are set: " + board.allCellsAreSet());
        board.setCharAtIndex('-', 1, 0);
        board.setCharAtIndex('-', 1, 1);
        board.setCharAtIndex('-', 1, 2);
        board.setCharAtIndex('-', 2, 0);
        board.setCharAtIndex('-', 2, 1);
        board.print();
        System.out.println("All cells are set: " + board.allCellsAreSet());

        System.out.println();
        System.out.println("Winner in row 1: " + board.winnerInRow(0));
        System.out.println("Winner in row 3: " + board.winnerInRow(2));

        System.out.println();
        board = new Board();
        board.setCharAtIndex('X', 0, 0);
        board.setCharAtIndex('X', 1, 0);
        board.setCharAtIndex('X', 2, 0);
        board.setCharAtIndex('-', 1, 1);
        board.setCharAtIndex('O', 2, 1);
        board.print();
        System.out.println("Winner in column 1: " + board.winnerInColumn(0));
        System.out.println("Winner in column 2: " + board.winnerInColumn(1));
        System.out.println("Winner in column 3: " + board.winnerInColumn(2));

        System.out.println();
        board = new Board();
        board.setCharAtIndex('X', 0, 0);
        board.print();
        System.out.println("Winner in diag1: " + board.winnerInDiag1());
        System.out.println("Winner in diag2: " + board.winnerInDiag2());

        System.out.println();
        board = new Board();
        board.setCharAtIndex('X', 0, 0);
        board.setCharAtIndex('X', 1, 1);
        board.setCharAtIndex('X', 2, 2);
        board.print();
        System.out.println("Winner in diag1: " + board.winnerInDiag1());
        System.out.println("Winner in diag2: " + board.winnerInDiag2());

        System.out.println();
        board = new Board();
        board.setCharAtIndex('X', 0, 2);
        board.setCharAtIndex('X', 1, 1);
        board.setCharAtIndex('X', 2, 0);
        board.print();
        System.out.println("Winner in diag1: " + board.winnerInDiag1());
        System.out.println("Winner in diag2: " + board.winnerInDiag2());

        System.out.println();
        board = new Board();
        board.setCharAtIndex('X', 0, 0);
        board.setCharAtIndex('X', 2, 2);
        board.print();
        System.out.println("Winner in diag1: " + board.winnerInDiag1());
        System.out.println("Winner in diag2: " + board.winnerInDiag2());

        System.out.println();
        board = new Board();
        board.setCharAtIndex('X', 0, 2);
        board.setCharAtIndex('X', 2, 0);
        board.print();
        System.out.println("Winner in diag1: " + board.winnerInDiag1());
        System.out.println("Winner in diag2: " + board.winnerInDiag2());
    }
}
