package model.abilities;

import java.util.ArrayList;

import model.world.Damageable;

public class HealingAbility extends Ability{
	private int healAmount;
	
	public HealingAbility(String name, int cost, int baseCoolDown, int castRange, AreaOfEffect area, int required,int heal) {
		super(name, cost,baseCoolDown,castRange, area,required);
		this.healAmount	=	heal;
	}

	public int getHealAmount() {
		return healAmount;
	}

	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount;
	}

	@Override
	public void execute(ArrayList<Damageable> targets) {
		int supply = this.healAmount;
		for(int i = 0; i<targets.size();i++) {
			targets.get(i).setCurrentHP(targets.get(i).getCurrentHP()+supply);
		}
	}
}
