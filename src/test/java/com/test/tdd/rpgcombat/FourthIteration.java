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
		Faction pirates = new Faction("Pirates");
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
		fail();
	}

	@Test
	public void test4() {
		fail();
	}

	@Test
	public void test5() {
		fail();
	}

}
