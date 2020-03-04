import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


@SuppressWarnings("serial")
public class MapWithEnemy extends JFrame {

	private Enemy e1;
	private Enemy e2;
	private Projectile p1;

	public MapWithEnemy(){
		try {
			BufferedImage enemyImage1 =ImageIO.read(new File("enemy1.png"));
			BufferedImage enemyImage2 =  ImageIO.read(new File("enemy2.png"));
			BufferedImage projectile =  ImageIO.read(new File("Sphere.png"));
			
			p1 = new Projectile(0, 150, projectile, 15, 15, null, 0, 0, 0, 0, 0, 6.0, 3.0, 0);
			e1 = new Enemy(10, 100, enemyImage1, 80, 75, null, 0, 0, 0, 0, 0, 2.0, 1,100);
			e2 = new Enemy(10, 350, enemyImage2, 65, 75, null, 0, 0, 0, 0, 0, 2.0, -1,100);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public void paint(Graphics g){		
		super.paint(g);

		try{	
			p1.drawTheImage(g);
			e1.drawTheImage(g);	
			e2.drawTheImage(g);
			
			Thread.sleep(10);		
			repaint();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}

	}

	public static void main (String [] args){
		MapWithEnemy m = new MapWithEnemy();
		m.setSize(850, 1050);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setVisible(true);
	}
}

