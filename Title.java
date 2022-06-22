import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.io.IOException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Rectangle;

public class Title extends JPanel {

    public static JFrame startScreen = new JFrame();
    private static BufferedImage background, easyButton, mediumButton, hardButton, extremeButton, multiplayerButton;
    private static Rectangle easyBounds, mediumBounds, hardBounds, extremeBounds, multiplayerBounds;

    private static void setImages() {
        //creates images and their button hitboxes
        try {
            background = ImageIO.read(new File("startScreenLogo.jpg"));
        } catch (IOException ex) {}
        try {
            easyButton = ImageIO.read(new File("EasyButton.png"));
            easyBounds = new Rectangle(70, 300, easyButton.getWidth(), easyButton.getHeight() + easyButton.getHeight() / 2);
        } catch (IOException ex) {}
        try {
            mediumButton = ImageIO.read(new File("MediumButton.png"));
            mediumBounds = new Rectangle(70, 350, mediumButton.getWidth(), mediumButton.getHeight() + mediumButton.getHeight() / 2);
        } catch (IOException ex) {}
        try {
            hardButton = ImageIO.read(new File("HardButton.png"));
            hardBounds = new Rectangle(70, 400, hardButton.getWidth(), hardButton.getHeight() + hardButton.getHeight() / 2);
        } catch (IOException ex) {}
        try {
            extremeButton = ImageIO.read(new File("ExtremeButton.png"));
            extremeBounds = new Rectangle(70, 450, extremeButton.getWidth(), extremeButton.getHeight() + extremeButton.getHeight() / 2);
        } catch (IOException ex) {}
        try {
            multiplayerButton = ImageIO.read(new File("CasualMultiplayerButton.png"));
            multiplayerBounds = new Rectangle(70, 500, multiplayerButton.getWidth(), multiplayerButton.getHeight() + multiplayerButton.getHeight() / 2);
        } catch (IOException ex) {}
    }

    public static void runTitle() {

        setImages();
        Title startMenu = new Title();

        startScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startScreen.setLocationRelativeTo(null);
        startScreen.setLocation(0, 0);
        startScreen.setResizable(false);
        startScreen.setVisible(true);
        startScreen.setSize(520, 670);
        startScreen.add(startMenu);
        //clicking space will run default tetris
        startScreen.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {}

            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_SPACE:
                        Pieces.setPieceSet(4);
                        Tetris.setMultiplayerStatus(false);
                        startScreen.setVisible(false);
                        Tetris.runTetris();
                        return;
                }
            }
            public void keyReleased(KeyEvent e) {}
        });
        //code to select specific levels
        startScreen.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (easyBounds.contains(e.getX(), e.getY())) {
                        Pieces.setPieceSet(2);
                        Tetris.setMultiplayerStatus(false);
                        startScreen.setVisible(false);
                        Tetris.runTetris();
                        return;
                    }
                    if (mediumBounds.contains(e.getX(), e.getY())) {
                        Pieces.setPieceSet(3);
                        Tetris.setMultiplayerStatus(false);
                        startScreen.setVisible(false);
                        Tetris.runTetris();
                        return;
                    }
                    if (hardBounds.contains(e.getX(), e.getY())) {
                        Pieces.setPieceSet(4);
                        Tetris.setMultiplayerStatus(false);
                        startScreen.setVisible(false);
                        Tetris.runTetris();
                        return;
                    }
                    if (extremeBounds.contains(e.getX(), e.getY())) {
                        Pieces.setPieceSet(5);
                        Tetris.setMultiplayerStatus(false);
                        startScreen.setVisible(false);
                        Tetris.runTetris();
                        return;
                    }
                    if (multiplayerBounds.contains(e.getX(), e.getY())) {
                        Pieces.setPieceSet(0);
                        Tetris.setMultiplayerStatus(true);
                        startScreen.setVisible(false);
                        Tetris.runTetris();
                        return;
                    }
                }
            }

            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}

        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Colour.white);

        g.drawImage(background, 0, 0, null);
        g.setFont(new Font("Impact", Font.BOLD, 50));
        g.drawString("Welcome to", 70, 135);
        g.drawString("TETRIS BATTLES!", 70, 200);

        g.setFont(new Font("Impact", Font.BOLD, 30));
        g.drawString("Select One to Begin:", 70, 295);
        g.drawImage(easyButton, 70, 300, null);
        g.drawImage(mediumButton, 70, 350, null);
        g.drawImage(hardButton, 70, 400, null);
        g.drawImage(extremeButton, 70, 450, null);
        g.drawImage(multiplayerButton, 70, 500, null);

    }
}