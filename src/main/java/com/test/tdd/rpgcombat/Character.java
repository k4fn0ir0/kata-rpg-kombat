package com.test.tdd.rpgcombat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Character {
	public static final int DAMAGE_THRESHOLD = 5;
	public static final int MAX_HEALTH = 1000;

	private double health;
	private int level;
	private double attackMaxRange;

	private int x;
	private int y;

	private List<Faction> factions;

	public Character(int x, int y, double attackMaxRange) {
		super();
		this.health = MAX_HEALTH;
		this.level = 1;
		this.attackMaxRange = attackMaxRange;
		this.x = x;
		this.y = y;
		this.factions = new ArrayList<Faction>();
	}

	public double getHealth() {
		return health;
	}

	public int getLevel() {
		return level;
	}

	public double getAttackMaxRange() {
		return attackMaxRange;
	}

	public boolean isAlive() {
		return this.health > 0;
	}

	public void dealDamages(Character target, int damage) {
		if (!this.equals(target) && this.isInAttackRange(target) && !this.isAnAlly(target)) {
			int levelDiff = target.getLevel() - this.getLevel();
			if (levelDiff <= -DAMAGE_THRESHOLD)
				target.subtractDamage(damage + damage / 2);
			else if (levelDiff >= DAMAGE_THRESHOLD)
				target.subtractDamage(damage - damage / 2);
			else
				target.subtractDamage(damage);
		}
	}

	private void subtractDamage(double damage) {
		this.health = this.health - damage < 0 ? 0 : this.health - damage;
	}

	public void heal(Character target, int heal) {
		if (this.equals(target) || this.isAnAlly(target))
			target.addHeal(heal);
	}

	private void addHeal(int heal) {
		if (this.isAlive()) {
			this.health = this.health + heal > MAX_HEALTH ? MAX_HEALTH : this.health + heal;
		}
	}

	public void increaseLevel() {
		this.level++;
	}

	public boolean isInAttackRange(Character target) {
		return Math.abs(this.distanceFromTarget(target)) <= attackMaxRange;
	}

	private double distanceFromTarget(Character target) {
		return Math.sqrt(Math.pow((target.x - this.x), 2) + Math.pow((target.y - this.y), 2));
	}

	public List<Faction> getFactions() {
		return factions;
	}

	public void joinFaction(Faction faction) {
		this.factions.add(faction);
		faction.addAllies(new ArrayList<Character>(Arrays.asList(this)));
	}

	public void leaveFaction(Faction faction) {
		this.factions.remove(faction);
		faction.removeAllies(new ArrayList<Character>(Arrays.asList(this)));
	}

	public boolean isAnAlly(Character target) {
		List<Character> allies = this.getFactions().stream().flatMap(faction -> faction.getAllies().stream())
				.collect(Collectors.toList());
		return allies.contains(target);
	}
}
