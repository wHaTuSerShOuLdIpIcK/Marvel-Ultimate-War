package model.effects;

import model.world.Champion;

public class Silence extends Effect{
	public Silence(int duration) {
		super("Silence",duration,EffectType.DEBUFF);
	}

	@Override
	public	void apply(Champion c) {
		int oMaxActPts	=	c.getMaxActionPointsPerTurn(),	nMaxActPts	= oMaxActPts+2,
			oCurActPts	=	c.getCurrentActionPoints(),		nCurActPts	= oCurActPts+2;
		c.setMaxActionPointsPerTurn(nMaxActPts);	c.setCurrentActionPoints(nCurActPts);
	}

	@Override
	public	void remove(Champion c) {
		int oMaxActPts	=	c.getMaxActionPointsPerTurn(),	nMaxActPts	= oMaxActPts-2,
			oCurActPts	=	c.getCurrentActionPoints(),		nCurActPts	= oCurActPts-2;
			c.setMaxActionPointsPerTurn(nMaxActPts);	c.setCurrentActionPoints(nCurActPts);
	}

}
