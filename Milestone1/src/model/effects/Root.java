package model.effects;

import model.world.Champion;
import model.world.Condition;


							//NEED	TO	BE	REFACTORED	!!!!!


public class Root extends Effect{
	public Root(int duration) {
		super("Root",duration,EffectType.DEBUFF);
	}

	@Override
	public	void apply(Champion c) {
		if(c.getCondition() != Condition.INACTIVE)
		c.setCondition(Condition.ROOTED);		
		c.getAppliedEffects().add(this);
	}

	@Override
	public	void remove(Champion c) {
		if(c.getCondition() != Condition.INACTIVE) 
			c.setCondition(Condition.ACTIVE);		
		c.getAppliedEffects().remove(this);
		
		for(int i = 0; i<c.getAppliedEffects().size();i++) {
			if(c.getAppliedEffects().get(i) instanceof Root) {
				if(c.getCondition() != Condition.INACTIVE) 
					c.setCondition(Condition.ACTIVE);				
			}
		}
	}
}