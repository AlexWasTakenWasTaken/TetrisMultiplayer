import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Font;

public class GameGraphics {

    private static void drawBoard(Graphics g, int[][] board, int boardNumber) {

        Color defaultColour = Colour.getDefaultColour();
        // draws the board
        g.setColor(Colour.grey);
        g.fillRect(Const.screenWidth * (boardNumber - 1), 0, Const.BLOCKSIZE * Const.BOARDWIDTH, Const.BLOCKSIZE * Const.BOARDHEIGHT);
        for (int i = 0; i < Const.BOARDWIDTH; i++) {
            for (int j = 0; j < Const.BOARDHEIGHT; j++) {

                try {
                    g.setColor(Colour.PieceColors[board[i][j]]);

                } catch (IndexOutOfBoundsException ex) {

                    g.setColor(defaultColour);
                }
                g.fillRect(Const.BLOCKSIZE * i + Const.screenWidth * (boardNumber - 1), Const.BLOCKSIZE * j, Const.BLOCKSIZE - 1, Const.BLOCKSIZE - 1);
            }
        }
    }

    private static void drawScore(Graphics g, int boardNumber, int score) {

        g.setColor(Colour.grey);
        g.fillRect(Const.BLOCKSIZE * Const.BOARDWIDTH + Const.screenWidth * (boardNumber - 1), 0, Const.MenuSize - 2, 50);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.setColor(Colour.white);
        g.drawString("" + score, Const.BLOCKSIZE * Const.BOARDWIDTH + Const.MenuSize / 2 - 30 + Const.screenWidth * (boardNumber - 1), 30);
    }

    private static void drawHeldPiece(Graphics g, Point[][][] pieceSet, int heldPiece, int boardNumber) {

        g.setColor(Colour.grey);
        g.fillRect(Const.BLOCKSIZE * Const.BOARDWIDTH + Const.screenWidth * (boardNumber - 1), 50, Const.MenuSize - 2, 125);

        try {
            g.setColor(Colour.grey);
            g.fillRect(Const.BLOCKSIZE * Const.BOARDWIDTH + Const.screenWidth * (boardNumber - 1), 50, Const.MenuSize - 2, 125);
            g.setColor(Colour.PieceColors[heldPiece]);
            for (Point p: pieceSet[heldPiece][0]) {

                g.fillRect((p.x) * Const.BLOCKSIZE + Const.BLOCKSIZE * Const.BOARDWIDTH + Const.screenWidth * (boardNumber - 1),
                    (p.y) * Const.BLOCKSIZE + 50 + 5,
                    Const.BLOCKSIZE - 1, Const.BLOCKSIZE - 1);
            }

        } catch (IndexOutOfBoundsException ex) {}
    }

    private static void drawNextPiece(Graphics g, Point[][][] pieceSet, int nextPiece, int boardNumber) {

        g.setColor(Colour.grey);
        g.fillRect(Const.BLOCKSIZE * Const.BOARDWIDTH + Const.screenWidth * (boardNumber - 1), 175, Const.MenuSize - 2, 125);
        try {
            g.setColor(Colour.grey);
            g.fillRect(Const.BLOCKSIZE * Const.BOARDWIDTH + Const.screenWidth * (boardNumber - 1), 175, Const.MenuSize - 2, 125);
            g.setColor(Colour.PieceColors[nextPiece]);
            for (Point p: pieceSet[nextPiece][0]) {
                try {
                    g.fillRect((p.x) * Const.BLOCKSIZE + Const.BLOCKSIZE * Const.BOARDWIDTH + Const.screenWidth * (boardNumber - 1),
                        (p.y) * Const.BLOCKSIZE + 175 + 5,
                        Const.BLOCKSIZE - 1, Const.BLOCKSIZE - 1);
                } catch (NullPointerException ex) {}

            }

        } catch (IndexOutOfBoundsException ex) {}
    }

	private static void drawShape(Graphics g, Point[][][] pieceSet, int curPiece, int rot, Point pieceOrigin, int boardNumber) {
        g.setColor(Colour.PieceColors[curPiece]);
        //point p "imitates" each possible point in pieceSet[curPiece][rot] and fills each point with the correct colour
        for (Point p: pieceSet[curPiece][rot]) {
            try {
                g.fillRect((p.x + pieceOrigin.x) * Const.BLOCKSIZE + Const.screenWidth * (boardNumber - 1), (p.y + pieceOrigin.y) * Const.BLOCKSIZE, Const.BLOCKSIZE - 1, Const.BLOCKSIZE - 1);
            } catch (NullPointerException ex) {}
        }
    }


    public static void paintComponent(Graphics g, int boardNumber, int[][] board, Point[][][] pieceSet, int curPiece, int rot, Point pieceOrigin, int nextPiece, int heldPiece, int score) {
        drawBoard(g, board, boardNumber);
        drawScore(g, boardNumber, score);
        drawHeldPiece(g, pieceSet, heldPiece, boardNumber);
        drawNextPiece(g, pieceSet, nextPiece, boardNumber);
        drawShape(g, pieceSet, curPiece, rot, pieceOrigin, boardNumber);
    }
}