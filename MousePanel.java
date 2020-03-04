//import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * 
 * @Jiazheng
 *
 */
@SuppressWarnings("serial")
public class MousePanel extends JPanel{

	private Tower[] Ttowers;
	private Enemy[] Enemies;
	private Projectile [] Projectile;
	private TowerDefenseGui gui;
	private int x = 0;
	private int y = 0;
	private int projecnum;


	//	private boolean drawTheCircle;

	private int tracktowerIndex;

	private boolean startGame;
	private boolean drawTheTower;
	private boolean printTheTower;
	private boolean buttonpressed;
	private boolean drawMap=true;
	private String [] towers;
	private int TowerIndex;
	private Tower[] defaltTowers;
	private int enemyIndex;
	private int enemyIndex2;


	private BufferedImage map,tower,Enemy1Img,Enemy2Img,ProImg;


	public boolean isStartGame() {
		return startGame;
	}
	public boolean isDrawTheTower() {
		return drawTheTower;
	}
	public boolean printTheTower() {
		return printTheTower;
	}
	public boolean isPressed() {
		return buttonpressed;
	}
	public int towerIndex() {
		return TowerIndex;
	}

	public void setStartGame(boolean Start) {
		startGame=Start;
	}
	public void setDrawTheTower(boolean drawTheTower) {
		this.drawTheTower = drawTheTower;
	}
	public void setprintTower(boolean printTower) {
		printTheTower = printTower;
	}
	public void setPressed(boolean pressbutton) {
		buttonpressed = pressbutton;
	}
	public void setTowerIndex(int Tnum) {
		TowerIndex=Tnum;
	}


	//  Constructor
	public MousePanel(TowerDefenseGui theGui){
		super();

		gui = theGui;

		TowerListenner listen= new TowerListenner();
		this.addMouseMotionListener(listen);
		this.addMouseListener(listen);

		towers= new String[3];
		Ttowers=new Tower[6];
		defaltTowers=new Tower[3];
		Projectile = new Projectile[10000];
		projecnum=0;
		enemyIndex=0;
		enemyIndex2=0;

		Enemies=new Enemy[6];		

		towers[0]="Tower1.png";
		towers[1]="Tower2.png";
		towers[2]="Tower3.png";
		tracktowerIndex=0;
		startGame=false;
		buttonpressed=false;
		drawTheTower=false;
		printTheTower=false;

		try {
			ProImg=ImageIO.read(new File("Sphere.png"));
			Enemy1Img=ImageIO.read(new File("Enemy1.png"));
			Enemy2Img=ImageIO.read(new File("Enemy2.png"));					              //Xv   Yv
			for(int i=0;i<5;i++) {
				Enemies[i]= new Enemy(0-170*i, 15, Enemy1Img, 65, 75, null, 0, 0, 0, 0, 0, 1.0, 1.0, 100);
			}
			Enemies[5]= new Enemy(-1000, 15, Enemy2Img, 60, 75, null, 0, 0, 0, 0, 0, 1.0, 1.0, 150);



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	

	//Paint
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		try {
			map=ImageIO.read(new File("Map.jpg"));
			tower=ImageIO.read(new File(towers[TowerIndex]));

			for(int i=0;i<defaltTowers.length; i++) { 
				//    sizes   Proj  Rg  ds dt Damage  pv  
				defaltTowers[i]=new Tower(x, y, tower, 70, 100, null, 10, 2, 2, 5+5*i, 0, 0, 0, 0);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


		//DrawThings

		if(drawMap==true) {
			g.drawImage(map, 0, 0, getWidth(),getHeight(), null);
		}
		if(drawTheTower==true && buttonpressed==true) {
			g.drawImage(tower, x, y, 70, 100, null);
			repaint();
		}
		if(printTheTower==true&&buttonpressed==false) {
			drawTheTower=false;

			repaint();
		}

		//Enemy Object
		try {
			if(startGame==true) {

				for(int i =0;i<6;i++) {
					if(Enemies[i]!=null && (Enemies[i].getTxZB()>1050 || Enemies[i].getEnemyHealth()<=0)) {
						Enemies[i]=null;
					}
				}

				for(int i=0;i<6;i++) {
					if(Enemies[i]!=null && Enemies[i].getEhealth()>0  ) {
						Enemies[i].drawTheImage(g);
					}
				}

				for(int i=0;i<5;i++) {
					if(Enemies[i]!=null &&Enemies[i].getTxZB()==1050) {
						gui.reduceHealth(10);
					} 
				}
				if(Enemies[5]!=null &&Enemies[5].getTxZB()==1050) {
					gui.reduceHealth(50);
				}
				Thread.sleep(5);
				repaint();

			}
		}catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		//Draw All Tower Objects
		try {
			for(int i=0;i<6;i++) {
				if(Ttowers[i]!=null) {
					Ttowers[i].drawTheImage(g);				

					//Create Projectile And Call FireAtEnemy
					if(enemyIndex<6 && Enemies[enemyIndex]!=null && Ttowers[i].canFire()==true && projecnum<10000 ) {

						Projectile[projecnum] =new Projectile(Ttowers[i].getTx()+28, Ttowers[i].getTy()+25, ProImg, 15, 15, null, 10, 2, 4, 10, 0, 0.0,0.0, 0);
						Ttowers[i].setPaodan(Projectile[projecnum]);

						Projectile[projecnum]=Ttowers[i].fireAtEnemy(Enemies[enemyIndex]);
						Projectile[projecnum].fireAtEnemy(Enemies[enemyIndex]);
						projecnum++;
					}
					if(Enemies[enemyIndex]==null && enemyIndex!=5) {
						enemyIndex++;
					}
				}

			}
		} catch (IOException  e) {
			e.printStackTrace();
		}

		//Draw All Projectile And Hid Action
		try {
			for(int i=0;i<Projectile.length;i++) {
				if(Projectile[i]!=null && enemyIndex2<6 ) {
					Projectile[i].drawTheImage(g);

					if(Enemies[enemyIndex2]!=null && Projectile[i]!=null && 
							Projectile[i].getTxZB()+5>Enemies[enemyIndex2].getTxZB() && Projectile[i].getTxZB()+5<Enemies[enemyIndex2].getTxZB()+45 && 
							Projectile[i].getTyZB()+10>Enemies[enemyIndex2].getTyZB() && Projectile[i].getTyZB()+10<Enemies[enemyIndex2].getTyZB()+65   ){

						Projectile[i]=null;
						Enemies[enemyIndex2].setEnemyHealth(Enemies[enemyIndex2].getEnemyHealth()-Ttowers[0].getDdamage());	
						System.out.println("Enemy Health------"+Enemies[enemyIndex2].getEnemyHealth());
						if(Enemies[enemyIndex2].getEnemyHealth()<=0 || Enemies[enemyIndex2].getTxZB()==1050) {
							enemyIndex2+=1;
						}
						if(Enemies[5].getEnemyHealth()<=0 || (Enemies[5].getEnemyHealth()<=0 && gui.getHealth()>0)) {
							System.out.println("You Win!");
						}
					}

				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}


	}
	//	Click Action
	private class TowerListenner implements MouseMotionListener, MouseListener{



		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

			if(e.getButton() == MouseEvent.BUTTON1 && buttonpressed==true) {

				if(tracktowerIndex<5) {
					printTheTower=true;
					drawTheTower=!drawTheTower;
					buttonpressed=!buttonpressed;
					Ttowers[tracktowerIndex]=defaltTowers[TowerIndex];
					gui.reduceMoney(10*(TowerIndex+1));
					tracktowerIndex+=1;

				}		
			}else if(e.getButton()==MouseEvent.BUTTON3) {
				drawTheTower=false;
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			x = e.getX()-38;
			y = e.getY()-45;		
			repaint();
		}

	}

}
