package model.world;

import java.awt.Point;

public class Cover  implements Damageable{
	private int currentHP;
	private Point location;
	
	public Cover(int x, int y) {
		currentHP = (int)(Math.random()*900)+100;
		location = new Point(x,y);
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		if(currentHP < 0)	this.currentHP = 0;
		else this.currentHP = currentHP;
	}

	public Point getLocation() {
		return location;
	}	
}	