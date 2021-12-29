package com.test.tdd.rpgcombat;

public class RangedFighter extends Character {
	public static final double MELEE_MAX_ATTACK_RANGE_IN_METER = 20.0;

	public RangedFighter(int x, int y) {
		super(x, y, MELEE_MAX_ATTACK_RANGE_IN_METER);
	}

}
