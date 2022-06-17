package model.effects;

import model.abilities.DamagingAbility;
import model.world.Champion;

public class Dodge extends Effect{
	public Dodge( int duration) {
		super("Dodge",duration,EffectType.BUFF);
	}

	public	void apply(Champion c) {
		c.setSpeed((int)(c.getSpeed()*1.05));
	}

	public	void remove(Champion c) {
		int x = (int) Math.round(c.getSpeed()/1.05);
		c.setSpeed(x);	c.getAppliedEffects().remove(this);
	}
}
