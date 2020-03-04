import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class Enemy extends MovingTowerDefenseObject{
	
	public int Ehealth;
	
	public Enemy (int x, int y, BufferedImage img, int Wd, int Hi,
				  Projectile pro,int range, int delyspeed, int delaytime, int damage,int pvelo,
				  double xvelo, double yvelo, int ehealth){
		
		super(x,y, img, Wd, Hi, pro, range, delyspeed, delaytime, damage,pvelo, xvelo, yvelo, ehealth);
		this.Ehealth=ehealth;
	}
	
	public void getHit() {
		
	}
	
	public int getEhealth() {
		return Ehealth;
	}
	public void setEhealth(int ehealth) {
		Ehealth = ehealth;
	}
}
