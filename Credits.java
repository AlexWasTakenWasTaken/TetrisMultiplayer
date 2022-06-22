import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.Font;

public class Credits extends JPanel{

	private static JFrame endScreen = new JFrame();
	private static BufferedImage background;

	private static void setImages(){

		try {                
            background = ImageIO.read(new File("gameOverIcon.png"));
        } 
        catch (IOException ex){System.out.println("File not found!");}

	}
	public static void runCredits(){
		
		setImages();
		Credits endMenu = new Credits();
		
		endScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		endScreen.setLocationRelativeTo(null);
		endScreen.setLocation(0,0);
        endScreen.setResizable(false);
		endScreen.setVisible(true);
		endScreen.setSize(520, 670);
		endScreen.add(endMenu);
		
	}
		

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Colour.beige);
		g.fillRect(0, 0, 520, 670);

        g.setColor(Colour.grey);
		g.setFont(new Font("Impact", Font.BOLD, 30));
		g.drawImage(background, Const.screenHeight / 2 - background.getWidth(), 0, null);
	}	
}