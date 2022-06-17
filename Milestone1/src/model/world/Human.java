package model.world;
import java.util.ArrayList;

public class Human {
	private int maxHealth;
	private int currentHealth;
	private ArrayList<Gear> gears;
	
	public Human (int maxHealth){
		this.maxHealth = maxHealth;
		this.currentHealth = maxHealth;
		gears = new ArrayList<Gear>();
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int curHeal) {
		if(curHeal>0) {
			if(curHeal>=maxHealth) {
				this.currentHealth = maxHealth;
			}
			else
				this.currentHealth = curHeal;
		}
		else
			this.currentHealth = 0;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public ArrayList<Gear> getGears() {
		return gears;
	}
}
