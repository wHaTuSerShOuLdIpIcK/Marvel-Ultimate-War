package model.world;

import java.util.ArrayList;
import model.effects.*;

public class AntiHero extends Champion{

	public AntiHero(String name, int maxHP, int mana, int maxActionPointsPerTurn, int attackRange, int attackDamage,
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
		for (Champion c : targets) {
			Effect s = new Stun(2);
			s.apply(c);
		}
	}
	
}
