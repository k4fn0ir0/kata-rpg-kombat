package com.test.tdd.rpgcombat;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class ThirdIteration {
	@Test
	public void test1() {
		Character missFortune = new MeleeFighter(0, 0);
		assertThat(missFortune.getAttackMaxRange(), is(instanceOf(double.class)));
	}

	@Test
	public void test2() {
		Character missFortune = new MeleeFighter(0, 0);
		assertEquals(missFortune.getAttackMaxRange(), 2.0, 0);

	}

	@Test
	public void test3() {
		Character missFortune = new RangedFighter(0, 0);
		assertEquals(missFortune.getAttackMaxRange(), 20.0, 0);

	}

	@Test
	public void test4() {
		Character missFortune = new RangedFighter(0, 0);
		Character nunu = new MeleeFighter(19, 0);
		missFortune.dealDamages(nunu, 100);
		nunu.dealDamages(missFortune, 200);
		assertEquals(missFortune.getHealth(), 1000, 0);
		assertEquals(nunu.getHealth(), 900, 0);
	}
}
