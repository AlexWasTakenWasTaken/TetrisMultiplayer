//SEE INCLUDED DOC FOR EXPLANATION

import java.awt.Point;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Board extends JPanel {

    //Board Number used to assign a position to the board on the frame
    private int boardNumber;

    Board(int boardNumber) {
        this.boardNumber = boardNumber;
    }

    private int score;

    //The current co-ordinate of the current piece, with 0,0 being the top right square
    private Point piecePoint;
    //The rotational position of the piece (one of four orientations)
    private int curRot;

    private int curPiece;
    private int nextPiece;
    private int heldPiece;

    //Point [piece number][rotaion][points]
    private Point[][][] pieceSet = Pieces.getPieceSet();
    private int[][] board = new int[Const.BOARDWIDTH][Const.BOARDHEIGHT];

    private int[][] pieceLookAheadBox = new int[5][5];
    private int[][] piecePrisonCell = new int[5][5];

	public void holdPiece() {

        int tempPiece;
        //if no piece is prisoned
        if (heldPiece == -1) {
            //"arrests" the current piece
            heldPiece = curPiece;
            //resets position and other variable for the next "free" piece
            resetPiece();
            curPiece = nextPiece;
            nextPiece = getNextPiece();

        } else {
            tempPiece = heldPiece;
            heldPiece = curPiece;
            resetPiece();
            //sets new piece to the piece that was previosouly trapped
            curPiece = tempPiece;
        }
		repaint();
    }

	public void hardDrop() {

        while (true) {
            if (!checkCol(curRot, piecePoint.x, piecePoint.y + 1)) {
                //continuosly drops the piece until it collides
                piecePoint.y++;
            } else {
                //when collision occurs, lock the piece in place
                lockPiece();
                break;
            }
        }
        repaint();
    }

    private int getNextPiece() {

        return (int) Math.floor(Math.random() * (Pieces.getNumPieces()));
    }

    private Point generatePiecePointPosition() {

        return new Point((int) Math.floor((Const.BOARDWIDTH - 5) / 2), -1);
    }

	public void rotate(int reqRotations) {
		int newRotation = (curRot + reqRotations) % 4;
		if (newRotation < 0) {
			newRotation = newRotation + 4;
		}
		if (!checkCol(newRotation,piecePoint.x, piecePoint.y)) {
			curRot = newRotation;
		}
	}

    private void resetPieceRot() {
        curRot = 0;
    }

    private void resetPiece() {
        piecePoint = generatePiecePointPosition();
        resetPieceRot();
    }
	
    public void resetBoard() {
        //clears board and fills with -1 which is code for empty chunk
        for (int x = 0; x < Const.BOARDWIDTH; x++) {
            for (int y = 0; y < Const.BOARDHEIGHT; y++) {

                board[x][y] = -1;
            }
        }

        for (int x = 0; x < x; x++) {
            for (int y = 0; y < 5; y++) {

                piecePrisonCell[x][y] = -1;
                pieceLookAheadBox[x][y] = -1;
            }
        }

        resetPiece();
        //gets the first piece on the board
        curPiece = getNextPiece();
        nextPiece = getNextPiece();
        //sets the held piece to be empty
        heldPiece = -1;
    }
    
	public void softDrop(int deltaY) {
        //checks whetjer tje desired change in y is valid
		if (!checkCol(curRot, piecePoint.x, piecePoint.y + deltaY)) {
			piecePoint.y += deltaY;
		} else {
            //if a piece can no longer travel downwards it is trapped in place 
			lockPiece();
		}	
	}
	
	public void move(int deltaX){
        //checks whetjer tje desired change in x is valid
		if (!checkCol(curRot, piecePoint.x + deltaX, piecePoint.y)) {
            piecePoint.x += deltaX;
        }
	}


    private void generatePiece(int nextGeneratedPiece) {
        resetPiece();
        curPiece = nextGeneratedPiece;
    }

    private boolean checkCol(int rotation, int pieceX, int pieceY) {

		//for each of possible chunks in a shape in the current rotation, we check whether that point will collide or is out of bounds
		for (Point checkerPoint : pieceSet[curPiece][rotation]) {
			try {                
				if (board[checkerPoint.x + pieceX][checkerPoint.y + pieceY] != -1) {
					return true;
				}
			} 
            //only occurs when moving/rotating into a wall
            catch (IndexOutOfBoundsException ex){  
				return true;                        
			}	
		}
		return false;
	}

    public void lockPiece() {

		//for each of 5 possible chunks in a shape, we add that point into the board since we know it doesnt collide
		for (Point p : pieceSet[curPiece][curRot]) {
			
			try {                
				board[piecePoint.x + p.x][piecePoint.y + p.y] = curPiece;
			} 
			// only occurs when piece is above row 0 and thus game is voer
			catch (IndexOutOfBoundsException ex){  
				//Game Over
				Tetris.gameOver();          
			}
		}
		//checks whether a row is full so it can be ermoved

		for (int y = Const.BOARDHEIGHT - 1; y > 0; y--) {
			 boolean isHole = false;
			for (int x = 0; x < Const.BOARDWIDTH; x++) {
				if (board[x][y] == -1) {
					isHole = true;
					break;
				}
			}
			if (!isHole) {

				for (int tempY = y-1; tempY > 0; tempY--) {
					for (int x = 0; x < Const.BOARDWIDTH; x++) {
						//copies the value of the grid above into itself
						board[x][tempY+1] = board[x][tempY];
					}
				}
				score++;
				y ++;
			}
		}

		generatePiece(nextPiece);
		nextPiece = getNextPiece();
		repaint();
	}

    @Override
    public void paintComponent(Graphics g) {
        GameGraphics.paintComponent(g, this.boardNumber, board, pieceSet, curPiece, curRot, piecePoint, nextPiece, heldPiece, score);
    }
}