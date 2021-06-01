package com.skilldistillery.jets.entity;

public class FighterJet extends Jet implements CombatReady {


	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fight() {
		System.out.println("Go in close, and when you think you are too close, go in closer.");
		System.out.println("- Major Thomas McGuire, USAAF");
		
	}

	@Override
	public void fly() {
		double flightTime = this.getRange() / this.getSpeed();
		System.out.println("The " + this.getModel() + " can fly at a max speed of " +
		this.getSpeed() + " mph for a range of roughly " + this.getRange() + " miles.");
		System.out.println("Which equates to a flight time of roughly " + flightTime + " hours.");
	}

}
