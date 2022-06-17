package model.abilities;

import java.util.ArrayList;

import model.world.Damageable;

public class DamagingAbility extends Ability{
	private int damageAmount;

	public DamagingAbility(String name, int cost, int baseCoolDown, int castRange, AreaOfEffect area, int required, int damageAmount) {
		super(name,cost,baseCoolDown,castRange, area, required);
		this.damageAmount	=	damageAmount;
	}
	
	public int getDamageAmount() {
		return damageAmount;
	}

	public void setDamageAmount(int damageAmount) {
		this.damageAmount = damageAmount;
	}

	@Override
	public void execute(ArrayList<Damageable> targets) {
		int negSupply = this.damageAmount, size = targets.size();
		for(int i = 0; i<size;i++) {
			targets.get(i).setCurrentHP(targets.get(i).getCurrentHP()-negSupply);
		}		
	}
}
