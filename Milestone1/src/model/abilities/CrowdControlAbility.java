package model.abilities;

import java.util.ArrayList;

import model.effects.Effect;
import model.effects.EffectType;
import model.world.Champion;
import model.world.Damageable;

public class CrowdControlAbility extends Ability{
	private Effect effect;
	
	public CrowdControlAbility(String name, int cost, int baseCoolDown,
			int castRange, AreaOfEffect area, int required, Effect effect) {
		
		super(name,cost,baseCoolDown,castRange,area,required);
		this.effect		=	effect;
	}

	public Effect getEffect() {
		return effect;
	}

	@Override
	public void execute(ArrayList<Damageable> targets) {//throws CloneNotSupportedException {
		int size = targets.size();
		for(int i = 0; i<size; i++) {
			effect.apply((Champion)targets.get(i));
			((Champion)targets.get(i)).getAppliedEffects().add(effect);
		}
	}
}