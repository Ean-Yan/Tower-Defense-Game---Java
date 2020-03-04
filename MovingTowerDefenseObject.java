import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class MovingTowerDefenseObject extends TowerDefenceObject{

	public double Xvelo;
	public double Yvelo;
	
	public MovingTowerDefenseObject() {
		
	}

	public MovingTowerDefenseObject
			(int newx, int newy, BufferedImage img, int Wd, int Hi,
			Projectile proje,int range, int delyspeed, int delaytime, int damage,int pvelo,
			double xvelo, double yvelo,int enemyhealth) {
		super( newx,  newy,  img,  Wd,  Hi, proje,range, delyspeed, delaytime, damage,pvelo,xvelo, yvelo, enemyhealth);
		
		Xvelo=xvelo;
		Yvelo=yvelo;
		
	}


	public double getXvelo() {
		return Xvelo;
	}

	public void setXvelo(double xvelo) {
		Xvelo = xvelo;
	}

	public double getYvelo() {
		return Yvelo;
	}

	public void setYvelo(double yvelo) {
		Yvelo = yvelo;
	}

}
