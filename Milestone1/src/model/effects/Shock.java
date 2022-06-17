package model.effects;

import model.world.Champion;

public class Shock extends Effect{
	public Shock(int duration) {
		super("Shock",duration,EffectType.DEBUFF);
	}

	@Override
	public	void apply(Champion c) {
		int x =(int)(c.getSpeed()*0.9);
		c.setSpeed(x);
		c.setAttackDamage((int)(c.getAttackDamage()*0.9));
		c.setMaxActionPointsPerTurn(c.getMaxActionPointsPerTurn()-1);
		c.setCurrentActionPoints(c.getCurrentActionPoints()-1);
	}

	@Override
	public	void remove(Champion c) {
		int x = (int)Math.round(c.getSpeed()*1.1);
		c.setSpeed(x);
		c.getAppliedEffects().remove(this);
		int y = (int)Math.ceil(c.getSpeed()*1.1);
		c.setSpeed(y);
	}

}
