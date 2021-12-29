package com.test.tdd.rpgcombat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

public class FourthIteration {
	@Test
	public void test1() {
		Character mf = new RangedFighter(0, 0);
		assertEquals(mf.getFactions(), new ArrayList<Faction>());
	}

	@Test
	public void test2() {
		Faction pirates = new Faction("Pirates");
		Faction aboriginal = new Faction("Aboriginal");

		Character mf = new RangedFighter(0, 0);
		Character yasuo = new MeleeFighter(0, 0);

		mf.joinFaction(pirates);
		mf.joinFaction(aboriginal);
		assertTrue(pirates.getAllies().contains(mf));
		assertTrue(aboriginal.getAllies().contains(mf));

		yasuo.joinFaction(aboriginal);
		assertTrue(aboriginal.getAllies().contains(yasuo));

		yasuo.leaveFaction(aboriginal);
		assertFalse(aboriginal.getAllies().contains(yasuo));

	}

	@Test
	public void test3() {
		Faction pirates = new Faction("Pirates");
		Faction aboriginal = new Faction("Aboriginal");

		Character mf = new RangedFighter(0, 0);
		Character yasuo = new MeleeFighter(0, 0);

		mf.joinFaction(pirates);
		mf.joinFaction(aboriginal);
		yasuo.joinFaction(aboriginal);
		assertTrue(mf.isAnAlly(yasuo));
		assertTrue(yasuo.isAnAlly(mf));

		yasuo.leaveFaction(aboriginal);
		assertFalse(mf.isAnAlly(yasuo));
	}

	@Test
	public void test4() {
		Faction pirates = new Faction("Pirates");
		Faction aboriginal = new Faction("Aboriginal");

		Character mf = new RangedFighter(0, 0);
		Character yasuo = new MeleeFighter(0, 0);

		mf.joinFaction(pirates);
		mf.joinFaction(aboriginal);
		yasuo.joinFaction(aboriginal);

		mf.dealDamages(yasuo, 200);
		assertEquals(1000, yasuo.getHealth(), 0);
		
		yasuo.leaveFaction(aboriginal);
		mf.dealDamages(yasuo, 200);
		assertEquals(800, yasuo.getHealth(), 0);
	}

	@Test
	public void test5() {
		Faction pirates = new Faction("Pirates");
		Faction aboriginal = new Faction("Aboriginal");

		Character mf = new RangedFighter(0, 0);
		Character yasuo = new MeleeFighter(0, 0);

		mf.joinFaction(pirates);
		mf.joinFaction(aboriginal);

		mf.dealDamages(yasuo, 200);
		assertEquals(800, yasuo.getHealth(), 0);

		yasuo.joinFaction(aboriginal);
		mf.heal(yasuo, 200);
		assertEquals(1000, yasuo.getHealth(), 0);

	}

}
