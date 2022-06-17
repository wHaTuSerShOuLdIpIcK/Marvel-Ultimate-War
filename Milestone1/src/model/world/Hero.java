package model.world;

import java.util.ArrayList;
import model.effects.*;

public class Hero extends Champion{

	public Hero(String name, int maxHP, int mana, int maxActionPointsPerTurn, int attackRange, int attackDamage,
			int speed) {
		super(name, maxHP, mana, maxActionPointsPerTurn, attackRange, attackDamage, speed);
	}



	@Override
	public void useLeaderAbility(ArrayList<Champion> targets) {
		int targetsSize = targets.size();
		
		for (int i = 0; i<targetsSize; i++) {
			int j =0, AppEffSize = targets.get(i).getAppliedEffects().size();
			while(j<AppEffSize) {
				if ((targets.get(i).getAppliedEffects().get(j)).getType().equals(EffectType.DEBUFF)) {
					targets.get(i).getAppliedEffects().get(j).remove(targets.get(i));
					}
				else
					j++;
				}
			Effect e = new Embrace(2);
			e.apply(targets.get(i));
			targets.get(i).getAppliedEffects().add(e);
			}
		}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	}
/*
				for(int j = 0; j<targets.get(i).getAppliedEffects().size();j++) {
					Effect e = targets.get(i).getAppliedEffects().get(j);
					if ( e.getType() == EffectType.DEBUFF) {
						e.remove(targets.get(i));
						targets.get(i).getAppliedEffects().remove(e);
						j--;*/
//Effect e = targets.get(i).getAppliedEffects().get(j);

