package model.effects;

import model.world.Champion;

public class SpeedUp extends Effect{
	public SpeedUp(int duration) {
		super("SpeedUp",duration,EffectType.BUFF);
	}

	@Override
	public	void apply(Champion c) {
		c.setSpeed((int)Math.round(c.getSpeed()*1.15));
		int oMaxActPts	=	c.getMaxActionPointsPerTurn(),	nMaxActPts	= oMaxActPts+1,
			oCurActPts	=	c.getCurrentActionPoints(),		nCurActPts	= oCurActPts+1;
			c.setMaxActionPointsPerTurn(nMaxActPts);	c.setCurrentActionPoints(nCurActPts);
	}

	@Override
	public	void remove(Champion c) {
		c.setSpeed((int)Math.round(c.getSpeed()/1.15));
		int oMaxActPts	=	c.getMaxActionPointsPerTurn(),	nMaxActPts	= oMaxActPts-1,
			oCurActPts	=	c.getCurrentActionPoints(),		nCurActPts	= oCurActPts-1;
			c.setMaxActionPointsPerTurn(nMaxActPts);	c.setCurrentActionPoints(nCurActPts);		
	}
}
