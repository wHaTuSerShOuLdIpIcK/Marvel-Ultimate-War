package model.abilities;

import java.util.ArrayList;

import model.world.Damageable;

public abstract class Ability {
	private String name;
	private int manaCost, baseCooldown, currentCooldown, castRange, requiredActionPoints;
	private AreaOfEffect castArea;
	
	public Ability(String name, int cost, int baseCoolDown, int castRange, AreaOfEffect area, int required) {
		this.baseCooldown	=	baseCoolDown;
		this.castArea		=	area;
		this.name			=	name;
		this.manaCost		=	cost;
		this.castRange		=	castRange;
		this.requiredActionPoints		=	required;	
	}
	
	public int getCurrentCooldown() {
		return currentCooldown;
	}

	public void setCurrentCooldown(int currentCooldown) {
		if (currentCooldown<baseCooldown) {
			if (currentCooldown<0)
				this.currentCooldown = 0;
			else 
				this.currentCooldown = currentCooldown;
		}	
		this.currentCooldown = baseCooldown;
	}

	public String getName() {
		return name;
	}

	public int getManaCost() {
		return manaCost;
	}

	public int getBaseCooldown() {
		return baseCooldown;
	}

	public int getCastRange() {
		return castRange;
	}

	public int getRequiredActionPoints() {
		return requiredActionPoints;
	}

	public AreaOfEffect getCastArea() {
		return castArea;
	}
	
	abstract void execute(ArrayList<Damageable> targets) ;//throws CloneNotSupportedException;
	
}
