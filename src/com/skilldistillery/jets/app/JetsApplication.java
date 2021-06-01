package com.skilldistillery.jets.app;

import java.util.Scanner;
import com.skilldistillery.jets.entity.AirField;

public class JetsApplication {
	Scanner userIn = new Scanner(System.in);
	private AirField airField = new AirField();

	public static void main(String[] args) {
		JetsApplication ja = new JetsApplication();
		ja.launch();
	}

	public void launch() {
		while (true) {
			System.out.println("====================================");
			System.out.println("|-----Welcome to the Jets App------|");
			System.out.println("|---1) List Fleet------------------|");
			System.out.println("|---2) Fly All Jets----------------|");
			System.out.println("|---3) View Fastest Jet------------|");
			System.out.println("|---4) View Longest Range----------|");
			System.out.println("|---5) Load Cargo Jets-------------|");
			System.out.println("|---6) Dogfight!-------------------|");
			System.out.println("|---7) Add a Jet-------------------|");
			System.out.println("|---8) Remove a Jet----------------|");
			System.out.println("|---9) Quit Program----------------|");
			System.out.println("====================================");
			System.out.println();
			System.out.print("Make your selection: ");
			int selection = userIn.nextInt();
			switch (selection) {
			case 1:
				airField.listFleet();
				break;
			case 2:
				airField.flyJets();
				break;
			case 3:
				airField.viewFastest();
				break;
			case 4:
				airField.longestRange();
				break;
			case 5:
				airField.loadCargo();
				break;
			case 6:
				airField.dogfight();
				break;
			case 7:
				airField.addJet();
				break;
			case 8:
				airField.removeJet();
				break;
			case 9:
				System.out.println("Goodbye!");
				System.exit(0);
				break;
			}
		}

	}
}
