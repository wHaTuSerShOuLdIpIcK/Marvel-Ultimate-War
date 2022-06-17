package model.world;

import java.util.ArrayList;

public class Villain extends Champion{

	public Villain(String name, int maxHP, int mana, int maxActionPointsPerTurn, int attackRange, int attackDamage,
			int speed) {
		super(name, maxHP, mana, maxActionPointsPerTurn, attackRange, attackDamage, speed);		
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void useLeaderAbility(ArrayList<Champion> targets) {
		int targetsSize = targets.size();
		for (int i = 0; i<targetsSize;i++) {
			int x = targets.get(i).getCurrentHP();
			double y = targets.get(i).getMaxHP()*0.3;
			if(x<y) {
				if(targets.get(i).getCondition() != Condition.KNOCKEDOUT)
				targets.get(i).setCondition(Condition.KNOCKEDOUT);
			}
		}
	}
}
