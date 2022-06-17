package model.world;
import java.util.ArrayList;
import model.abilities.Ability;
import model.effects.Effect;
import java.awt.Point;

public abstract class Champion implements Damageable, Comparable{
	private String name;
	private int maxHP, 	 currentHP,	 mana,	 maxActionPointsPerTurn,
			currentActionPoints, 	 attackRange,	attackDamage,	speed;	
	private ArrayList<Ability> abilities;
	private ArrayList<Effect>appliedEffects;	
	private Condition condition;		
	private Point location;
	
	public Champion(String name, int maxHP, int mana, int maxActions, int speed, int attackRange,  int attackDamage) {
		
		this.name = name;	this.currentHP = maxHP;	this.maxHP = maxHP;		this.mana = mana;	this.speed = speed;		
		this.maxActionPointsPerTurn = maxActions;	this.currentActionPoints = maxActions;		
		this.attackDamage 	= attackDamage;						this.attackRange	=	attackRange;		
		this.appliedEffects	=	new ArrayList<Effect>();		this.abilities		=	new ArrayList<Ability>();
		this.condition		=	Condition.ACTIVE;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {		
		if(currentHP >= 0 ) {
			if(currentHP>maxHP)
				this.currentHP = maxHP;
			else
				this.currentHP = currentHP;
		}
		else
			this.currentHP = 0;		
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getMaxActionPointsPerTurn() {
		return maxActionPointsPerTurn;
	}

	public void setMaxActionPointsPerTurn(int maxActionPointsPerTurn) {
		this.maxActionPointsPerTurn = maxActionPointsPerTurn;
	}

	public int getCurrentActionPoints() {
		return currentActionPoints;
	}

	public void setCurrentActionPoints(int currentActionPoints) {
		if(currentActionPoints >= 0 ) {
			if(currentActionPoints>maxActionPointsPerTurn)
				this.currentActionPoints = maxActionPointsPerTurn;			
			else
				this.currentActionPoints = currentActionPoints;
	}
	else
		this.currentActionPoints = 0;	
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public String getName() {
		return name;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public int getAttackRange() {
		return attackRange;
	}

	public ArrayList<Ability> getAbilities() {
		return abilities;
	}

	public ArrayList<Effect> getAppliedEffects() {
		return appliedEffects;
	}
	
	public abstract void useLeaderAbility(ArrayList<Champion> targets);
	
	public int compareTo(Object x) {
		Champion c = (Champion)x;
		if(this.speed<c.speed)
			return 47;
		else if(this.speed>c.speed) 
			return -47;		
		else
			return this.name.compareTo(c.name);		
	}
}
