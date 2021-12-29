package com.test.tdd.rpgcombat;

import static org.junit.Assert.*;

import org.junit.Test;

public class SecondIteration {
	@Test
	public void test1() {
		Character missFortune = new RangedFighter(1,1);
		missFortune.dealDamages(missFortune, 300);
		assertEquals(1000, missFortune.getHealth(), 0);

		Character teemo = new RangedFighter(2,1);
		teemo.dealDamages(missFortune, 200);
		assertEquals(800, missFortune.getHealth(), 0);

	}

	@Test
	public void test2() {
		Character missFortune = new RangedFighter(2,1);
		assertEquals(1000, missFortune.getHealth(), 0);

		Character teemo = new RangedFighter(1,1);
		teemo.dealDamages(missFortune, 200);

		assertEquals(800, missFortune.getHealth(), 0);

		Character sona = new RangedFighter(1,0);

		sona.heal(missFortune, 200);
		assertEquals(800, missFortune.getHealth(), 0);

		missFortune.heal(missFortune, 200);
		assertEquals(1000, missFortune.getHealth(), 0);
	}

	@Test
	public void test3() {
		Character missFortune = new RangedFighter(-2,1);
		missFortune.increaseLevel();
		missFortune.increaseLevel();
		missFortune.increaseLevel();
		missFortune.increaseLevel();
		missFortune.increaseLevel();
		assertEquals(6, missFortune.getLevel(), 0);

		Character teemo = new RangedFighter(1,1);
		assertEquals(1, teemo.getLevel(), 0);

		teemo.dealDamages(missFortune, 100);
		assertEquals(950, missFortune.getHealth(), 0);

		missFortune.dealDamages(teemo, 100);
		assertEquals(850, teemo.getHealth(), 0);
	}

}
