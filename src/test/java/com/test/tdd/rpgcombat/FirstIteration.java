package com.test.tdd.rpgcombat;

import static org.junit.Assert.*;

import org.junit.Test;

public class FirstIteration {

	@Test
	public void test1() {
		Character missFortune = new RangedFighter(1,1);
		assertEquals(1000, missFortune.getHealth(), 0);
		assertEquals(1, missFortune.getLevel());
		assertTrue(missFortune.isAlive());
	}

	@Test
	public void test2() {
		Character missFortune = new RangedFighter(1,1);
		Character teemo = new RangedFighter(2,1);
		missFortune.dealDamages(teemo, 200);
		assertEquals(800, teemo.getHealth(), 0);
		teemo.dealDamages(missFortune, 50000);
		assertEquals(0, missFortune.getHealth(), 0);
		assertFalse(missFortune.isAlive());
	}

	@Test
	public void test3() {
		Character missFortune = new RangedFighter(1,1);
		Character teemo = new RangedFighter(1,1);
		assertEquals(1000, missFortune.getHealth(), 0);
		teemo.dealDamages(missFortune, 200);
		assertEquals(800, missFortune.getHealth(), 0);
		missFortune.heal(missFortune, 100);
		assertEquals(900, missFortune.getHealth(), 0);
	}

}
