package de.martenst.tictactoe;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

    private final Board board;
    private final Player player1;
    private final Player player2;

    private Player currentPlayer;

    public Game() {
        this.board = new Board();
        this.player1 = new Player("Player 1", 'X');
        this.player2 = new Player("Player 2", 'O');
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
        game.printWinner();
    }


    private void play() {
        do {
            togglePlayer();
            getPlayerInput();
            board.print();
        } while (this.board.settingIsAllowed());
    }


    private void printWinner() {
        if (board.hasAWinner()) {
            System.out.println("Congratulations '" + currentPlayer.name + "'! You won the game");
        } else {
            System.out.println("The game is a draw. No winners this time.");
        }
    }

    private void togglePlayer() {
        if (currentPlayer == null || currentPlayer == player2) {
            currentPlayer = player1;
        } else
            currentPlayer = player2;
    }

    private void getPlayerInput() {
        int row = -1;
        int column = -1;
        System.out.println(String.format("%s, make your move.", currentPlayer.name));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter row   : ");
            row = Integer.parseInt(br.readLine());
            System.out.print("Enter column: ");
            column = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        board.setCharAtIndex(currentPlayer.symbol, row, column);
    }
}
