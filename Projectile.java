import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class Projectile extends MovingTowerDefenseObject{

	private int Damage;
	private int proVelo;
	private int proX;
	private int proY;


	public Projectile
	(int newx, int newy, BufferedImage img, int Wd, int Hi, 
			Projectile proje, int range, int delyspeed, int delytime,int damage, int pvelo,
			double xvelo, double yvelo, int enemyhealth) {

		super(newx, newy, img, Wd, Hi, proje, range, delyspeed, delytime, damage, pvelo, xvelo,yvelo,enemyhealth);
		// TODO Auto-generated constructor stub
		Damage=damage;
		proVelo=pvelo;
		proX=newx;
		proY=newy;

	}

	public Projectile(Projectile P) {

//		this.Damage=P.Damage;
//		this.proVelo=P.proVelo;
//		this.Xvelo=P.Xvelo;
//		this.Yvelo=P.Yvelo;
//		this.proX=P.proX;
//		this.proY=P.proY;

	}



	public int getDamage() {
		return Damage;
	}
	public void setDamage(int damage) {
		Damage = damage;
	}
	public int getProVelo() {
		return proVelo;
	}
	public void setProVelo(int proVelo) {
		this.proVelo = proVelo;
	}

	public void getDamageOnEnemy() {

	}

	public void fireAtEnemy(Enemy e) {

		
		this.setXv((e.getTxZB()+25-proX)/25);
		this.setYv((e.getTyZB()+25-proY)/25);


	}

}
