import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class MapWithTowers extends JFrame {

	@Override
	public void paint(Graphics g){
		super.paint(g);
		try{

			//Feel free to use a different image, but I just stuck this here for kicks
			BufferedImage towerImage1 = ImageIO.read(new File("Tower1.png"));
			BufferedImage towerImage2 = ImageIO.read(new File("Tower2.png"));
			BufferedImage towerImage3 = ImageIO.read(new File("Tower3.png"));

			//Use this to test your constructor
			Tower t1 = new Tower(200, 350, towerImage1, 60, 90,  null,0,0,0,0,0,  0,0,0);
			t1.drawTheImage(g);
			Tower t2 = new Tower(100, 100, towerImage2, 60, 90,  null,0,0,0,0,0,  0,0,0);
			t2.drawTheImage(g);
			Tower t3 = new Tower(500, 150, towerImage3, 60, 90,  null,0,0,0,0,0,  0,0,0);
			t3.drawTheImage(g);

		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main (String [] args){
		MapWithTowers m = new MapWithTowers();
		m.setSize(850, 700);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);
	}
}

