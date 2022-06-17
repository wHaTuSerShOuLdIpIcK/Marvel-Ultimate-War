package model.effects;

import model.abilities.Ability;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.world.Champion;
import model.world.Hero;

public class PowerUp extends Effect{
	public PowerUp(int duration) {
		super("PowerUp",duration,EffectType.BUFF);
	}

	@Override
	public	void apply(Champion c) {
		for(Ability a : c.getAbilities()) {
			
				if (a instanceof HealingAbility) {
					((HealingAbility) a).setHealAmount((int)(((HealingAbility) a).getHealAmount()*1.2));
				}
				else
					if(a instanceof DamagingAbility) {
						((DamagingAbility) a).setDamageAmount((int)(((DamagingAbility) a).getDamageAmount()*1.2));
					}
		}
	}

	@Override
	public	void remove(Champion c) {}
	
	public static void main(String args[]) {
		Champion c = new Hero("Cap", 4, 43, 54, 65, 76, 8);
		
	}
}
