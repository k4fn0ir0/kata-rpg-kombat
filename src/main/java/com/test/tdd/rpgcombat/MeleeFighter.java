package com.test.tdd.rpgcombat;

public class MeleeFighter extends Character {
	public static final double MELEE_MAX_ATTACK_RANGE_IN_METER = 2.0;

	public MeleeFighter(int x, int y) {
		super(x, y, MELEE_MAX_ATTACK_RANGE_IN_METER);
	}

}
