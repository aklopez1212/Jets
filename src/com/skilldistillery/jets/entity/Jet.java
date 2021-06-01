package com.skilldistillery.jets.entity;

public abstract class Jet {
	// private int jetType;
	private String model;
	private double speed;
	private int range;
	private long price;

	public Jet(String model, double speed, int range, long price) {
		super();
		// this.jetType = jetType;
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	abstract public void fly();
//This method will sysout different 'sounds' based on the type of jet.	


	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

//	public int getJetType() {
//		return jetType;
//	}
//
//	public void setJetType(int jetType) {
//		this.jetType = jetType;
//	}
	@Override
	public String toString() {
		return "Jet Model: " + model + ", Speed: " + speed + ", Range: " + range + ", Price: " + price;
	}

}
