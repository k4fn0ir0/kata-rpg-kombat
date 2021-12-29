package com.test.tdd.rpgcombat;

import java.util.ArrayList;
import java.util.List;

public class Faction {
	private String name;
	private List<Character> allies;

	public Faction(String name) {
		this.name = name;
		this.allies = new ArrayList<Character>();
	}

	public String getName() {
		return name;
	}

	public List<Character> getAllies() {
		return allies;
	}

	public boolean addAllies(List<Character> allies) {
		return this.allies.addAll(allies);
	}

	public boolean removeAllies(List<Character> allies) {
		return this.allies.removeAll(allies);
	}

}
