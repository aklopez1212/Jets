package com.skilldistillery.jets.entity;

public class CargoCarrier extends Jet implements CargoPlane {


	public CargoCarrier(String model, double speed, int range, long price) {
		super(model, speed, range, price);

	}

	@Override
	public void loadCargo() {
		System.out.println("Loading up 75,000 lbs of cargo!");
		
	}

	@Override
	public void fly() {
	//Determine flight time based off range and speed.
	double flightTime = this.getRange() / this.getSpeed();
	System.out.println("The " + this.getModel() + " can fly at a max speed of " +
	this.getSpeed() + " mph for a range of roughly " + this.getRange() + " miles.");
	System.out.println("Which equates to a flight time of roughly " + flightTime + " hours.");
		
	}

}
