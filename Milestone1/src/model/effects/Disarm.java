package model.effects;

import model.abilities.AreaOfEffect;
import model.abilities.DamagingAbility;
import model.world.Champion;

public class Disarm extends Effect{
	public Disarm(int duration) {
		super("Disarm",duration,EffectType.DEBUFF);
	}

			//NEED	TO	BE	REFACTORED	!!!!!
	@Override
	public	void apply(Champion c) {																	
		c.getAbilities().add(new DamagingAbility("Punch", 0, 1, 1, AreaOfEffect.SINGLETARGET, 1, 50));
	}
	@Override	//  DONE REFACTORED
	public	void remove(Champion c) {
		int size = c.getAbilities().size(), i=0;
		while(i<size) {							// might need flag to stop after removing one Punch
			String n = c.getAbilities().get(i).getName();
			if(n.equals("Punch"))
				c.getAbilities().remove(i);
			i++;
		}
	}

}
