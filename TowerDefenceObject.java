import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TowerDefenceObject extends JFrame{

	private int txZB;
	private int tyZB;
	private BufferedImage Towerimg;
	private int timgWidt;
	private int timgHigh;

	private Projectile pro;
	private int rang;
	private int delyspeed;
	private int delytime;
	private int Ddamage;
	private int pvelo;

	private  double Xv;
	private  double Yv;
	private  int enemyHealth;


	public TowerDefenceObject() {

	}

	public TowerDefenceObject
	(int xx, int yy, BufferedImage iimg, int WWd, int HHi, 
			Projectile proje, int range, int delyspeed, int delytime, int damage,int pvelo, 
			double xvelo, double yvelo, int enemyheath) {

		txZB=xx;
		tyZB=yy;
		Towerimg=iimg;
		timgWidt=WWd;
		timgHigh=HHi;

		pro=proje;
		rang=range;
		this.delyspeed=delyspeed;
		this.delytime=delytime;
		Ddamage=damage;
		this.pvelo=pvelo;

		Xv=xvelo;
		Yv=yvelo;
		enemyHealth=enemyheath;

	}


	public void drawTheImage(Graphics g) throws IOException{


		
		g.drawImage(Towerimg, txZB,tyZB, timgWidt, timgHigh,null);
		
			
			for(int i=0; i <5; i++) {
				if((txZB==0-170*i || txZB==-1000) && tyZB==15) {
					Yv=0;
					Xv=1.0;
				}else if(txZB==431 && tyZB==15) {
					Xv=0;
					Yv=1.0;
				}else if(txZB==431 && tyZB==380) {
					Yv=0;
					Xv=1.0;
				}else if(tyZB==380 && txZB==803) {
					Xv=0;
					Yv=-1.0;
				}else if(txZB==803 && tyZB==170) {
					Yv=0;
					Xv=1.0;
				}
				
			}
			
			
			
			txZB+=Xv;
			tyZB+=Yv;
			
	}



	public int getTxZB() {
		return txZB;
	}

	public void setTxZB(int txZB) {
		this.txZB = txZB;
	}

	public int getTyZB() {
		return tyZB;
	}

	public void setTyZB(int tyZB) {
		this.tyZB = tyZB;
	}

	public BufferedImage getTowerimg() {
		return Towerimg;
	}

	public void setTowerimg(BufferedImage towerimg) {
		Towerimg = towerimg;
	}

	public int getTimgWidt() {
		return timgWidt;
	}

	public void setTimgWidt(int timgWidt) {
		this.timgWidt = timgWidt;
	}

	public int getTimgHigh() {
		return timgHigh;
	}

	public void setTimgHigh(int timgHigh) {
		this.timgHigh = timgHigh;
	}

	public Projectile getPro() {
		return pro;
	}

	public void setPro(Projectile pro) {
		this.pro = pro;
	}

	public int getRang() {
		return rang;
	}

	public void setRang(int rang) {
		this.rang = rang;
	}

	public int getDelyspeed() {
		return delyspeed;
	}

	public void setDelyspeed(int delyspeed) {
		this.delyspeed = delyspeed;
	}

	public int getDelytime() {
		return delytime;
	}

	public void setDelytime(int delytime) {
		this.delytime = delytime;
	}

	public int getDdamage() {
		return Ddamage;
	}

	public void setDdamage(int ddamage) {
		Ddamage = ddamage;
	}

	public int getPvelo() {
		return pvelo;
	}

	public void setPvelo(int pvelo) {
		this.pvelo = pvelo;
	}

	public double getXv() {
		return Xv;
	}

	public void setXv(double xv) {
		Xv = xv;
	}

	public double getYv() {
		return Yv;
	}

	public void setYv(double yv) {
		Yv = yv;
	}

	public int getEnemyHealth() {
		return enemyHealth;
	}

	public void setEnemyHealth(int enemyHealth) {
		this.enemyHealth = enemyHealth;
	}

	public static void main (String [] args){
//				TowerDefenceObject tw=new TowerDefenceObject();
		//		tw.setSize(600, 600);
		//		tw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//		tw.setVisible(true);
	}
}
