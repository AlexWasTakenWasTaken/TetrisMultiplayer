import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tetris extends JPanel {

    private static boolean isMultiplayer;
    private static boolean isGameActive;

    //creates the board objects
    private static Board board = new Board(1);
    private static Board board2 = new Board(2);

    public static void setMultiplayerStatus(boolean multiplayerStatus) {

        isMultiplayer = multiplayerStatus;
    }
    public static boolean getMultiplayerStatus() {

        return isMultiplayer;
    }
    public static void gameOver() {
        isGameActive = false;
    }
    @Override
    public void paintComponent(Graphics g) {
        board.paintComponent(g);
        board2.paintComponent(g);
    }

    public static void runTetris() {

        JFrame gameScreen = new JFrame();
        Music music = new Music("TetrisMusic.wav");
        Music click = new Music("ClickSound.wav");

        gameScreen.setLocationRelativeTo(null);
        gameScreen.setLocation(0, 0);
        gameScreen.setResizable(false);
        gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameScreen.setVisible(true);

        music.start();
        music.loop();

        isGameActive = true;

        if (isMultiplayer) {
            board2.resetBoard();
            gameScreen.setSize(Const.screenWidth * 2, Const.screenHeight);
        } else {
            gameScreen.setSize(Const.screenWidth, Const.screenHeight);
        }

        board.resetBoard();

        Tetris game = new Tetris();
        gameScreen.add(game);

        // Keyboard controls
        gameScreen.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {}

            public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_W){
					board.rotate(+1);
                    game.repaint();
				}
				if (key == KeyEvent.VK_S){
					board.softDrop(1);
                    game.repaint();
				}
				if (key == KeyEvent.VK_A){
					board.move(-1);
                    game.repaint();
				}
				if (key == KeyEvent.VK_D){
					board.move(1);
                    game.repaint();
				}
				if (key == KeyEvent.VK_SPACE){
					board.hardDrop();
                    click.loop(1);
                    game.repaint();
				}
				if (key == KeyEvent.VK_Q){
					board.rotate(-1);
                    game.repaint();
				}
				if (key == KeyEvent.VK_E){
					board.holdPiece();
                    game.repaint();
				}
                
                if (isMultiplayer) {
                    if (key == KeyEvent.VK_UP){
						board2.rotate(+1);
						game.repaint();
					}
					if (key == KeyEvent.VK_DOWN){
						board2.softDrop(1);
						game.repaint();
					}
					if (key == KeyEvent.VK_LEFT){
						board2.move(-1);
						game.repaint();
					}
					if (key == KeyEvent.VK_RIGHT){
						board2.move(1);
						game.repaint();
					}
					if (key == KeyEvent.VK_CONTROL){
						board2.hardDrop();
						game.repaint();
					}
					if (key == KeyEvent.VK_SHIFT){
						board2.rotate(-1);
						game.repaint();
					}
					if (key == KeyEvent.VK_ENTER){
						board2.holdPiece();
						game.repaint();
					}
                }
            }
            public void keyReleased(KeyEvent e) {}
        });

        new Thread() {
            @Override public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);

						//drops the piece everysecond to force player to take action
                        board.softDrop(1);;
                        if (isMultiplayer) {
                            board2.softDrop(1);;
                        }
                        game.repaint();

                        if (!isGameActive) {
                            gameScreen.setVisible(false);
                            gameScreen.remove(game);
                            music.stop();
                            Credits.runCredits();
                            
                            
                            return;
                        }

                    } catch (InterruptedException e) {}
                }
            }
        }.start();
    }
}