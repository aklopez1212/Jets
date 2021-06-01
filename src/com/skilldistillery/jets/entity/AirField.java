package com.skilldistillery.jets.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class AirField {
	Scanner userIn = new Scanner(System.in);
	private List<Jet> jets;


	public AirField() {
		// This method will read jets from file.
		jets = readFile("jets.txt");
	

	}

	private List<Jet> readFile(String fileName) {
		List<Jet> jets = new ArrayList();
		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String jetInfo;
			while ((jetInfo = bufIn.readLine()) != null) {
				String[] jetInfoArr = jetInfo.split(",");
				if (jetInfoArr[0].charAt(0) == '0') {
					FighterJet fj = new FighterJet(jetInfoArr[1], Double.parseDouble(jetInfoArr[2]),
							Integer.parseInt(jetInfoArr[3]), Long.parseLong(jetInfoArr[4]));
					jets.add(fj);
				} else if (jetInfoArr[0].charAt(0) == '1') {
					CargoCarrier cc = new CargoCarrier (jetInfoArr[1], Double.parseDouble(jetInfoArr[2]),
							Integer.parseInt(jetInfoArr[3]), Long.parseLong(jetInfoArr[4]));
					jets.add(cc);
				} else {
					PassengerJet pj = new PassengerJet (jetInfoArr[1], Double.parseDouble(jetInfoArr[2]),
							Integer.parseInt(jetInfoArr[3]), Long.parseLong(jetInfoArr[4]));
					jets.add(pj);
				}

			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return jets;
	}

	public void listFleet() {
		for (Jet jet : jets) {
			System.out.println(jet);
		} System.out.println();
	}
	public void flyJets() {
		for (Jet jet : jets) {
			jet.fly();
		} System.out.println();
	}
	public void viewFastest() {
		double highestSpeed = jets.get(0).getSpeed();
		Jet jet = jets.get(0);
		for(int i = 0; i < jets.size(); i++) {
			if(jets.get(i).getSpeed() > highestSpeed) {
				highestSpeed = jets.get(i).getSpeed();
				jet = jets.get(i);
			}
		} System.out.println(jet.toString());
		System.out.println();
		
		}
	public void longestRange() {
		double longestRange = jets.get(0).getRange();
		Jet jet = jets.get(0);
		for(int i = 0; i < jets.size(); i++) {
			if(jets.get(i).getRange() > longestRange) {
				longestRange = jets.get(i).getRange();
				jet = jets.get(i);
			}
		} System.out.println(jet.toString());
		System.out.println();
	}
	public void loadCargo() {
		ListIterator<Jet> ji = jets.listIterator();
		while(ji.hasNext()) {
			Jet inJet = ji.next();
			if(inJet instanceof CargoCarrier) {
				((CargoCarrier) inJet).loadCargo();
				System.out.println();
			}
		}
	}
	public void dogfight() {
		ListIterator<Jet> ji = jets.listIterator();
		while(ji.hasNext()) {
			Jet inJet = ji.next();
			if(inJet instanceof FighterJet) {
				((FighterJet) inJet).fight();
				System.out.println();
			}
		}
	}
	public void addJet() {
		System.out.println("What type of jet would you like to add?");
		System.out.println("0) Fighter, 1) Cargo, 2) Passenger");
		int jetSelect = userIn.nextInt();
		System.out.print("Enter a model name: ");
		String userModel = userIn.next();
		System.out.print("Enter max speed: ");
		double userSpeed = userIn.nextDouble();
		System.out.print("Enter jet range: ");
		int userRange = userIn.nextInt();
		System.out.print("Enter jet price: ");
		long userPrice = userIn.nextLong();
		System.out.println();
		if(jetSelect == 0) {
			jets.add(new FighterJet(userModel, userSpeed, userRange, userPrice));
		} else if (jetSelect == 1) {
			jets.add(new CargoCarrier(userModel, userSpeed, userRange, userPrice));
		} else if (jetSelect == 2) {
			jets.add(new PassengerJet(userModel, userSpeed, userRange, userPrice));
		} else {
			System.err.println("Invalid Selection, please try again.");
		}
		
		 
	}
	public void removeJet() {
		System.out.println("=======================================");
		System.out.println("|--Which Jet would you like removed?--|");
		System.out.println("=======================================");
		listFleet();
		System.out.print("Please choose from 1 to " + jets.size() + ": ");
		int jetDelete = userIn.nextInt();
		jets.remove(jetDelete - 1);
		System.out.println(jetDelete + " removed.");
		System.out.println();
		
	}
}
