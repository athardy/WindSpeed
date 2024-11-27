package com.example.WindSpeed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WindSpeedApplication {
	public static void main(String[] args) {
<<<<<<< HEAD
		SpringApplication.run(WindSpeedApplication.class, args);
		System.out.println(" _      _______  _____  _______  ___________");
		System.out.println("| | /| / /  _/ \\/ / _ \\/ __/ _ \\/ __/ __/ _ \\");
		System.out.println("| |/ |/ // //    / // /\\ \\/ ___/ _// _// // /");
		System.out.println("|__/|__/___/_/|_/____/___/_/  /___/___/____/");
		System.out.println("                                     (v1.2)");
		System.out.println("Windspeed API is running at http://localhost:8080");
=======
		//SpringApplication.run(WindSpeedApplication.class, args);

		WindSpeedApplication windSpeedApplication = new WindSpeedApplication();
		windSpeedApplication.run();
	}

	private void run() {
		//Display main menu and prompt for input
		int menuSelection = -1;
		while (menuSelection !=0) {
			consoleService.displayBanner();
			String zipCode = "";
			while (zipCode.length() != 5) {
				zipCode = consoleService.getChoice("Enter Zipcode: ");
				if (zipCode.length() != 5) {
					System.out.println();
					System.out.println("** Please enter a valid zipcode (5 digits) **");
					consoleService.blankSpace();
					consoleService.displayBanner();
				}
			}

			//get latitude and longitude from zipcode input via API
			Geocode newGeocode = geocodeService.getLatAndLonFromZipCode(zipCode);

			//get wind data via API
			if (newGeocode != null) {
				Report newReport = reportService.getReportByLonAndLat(newGeocode.getLat(), newGeocode.getLon());

				//print report with fields based on is gust data present
				if (newReport.getWind().getGust() == 0.00 || newReport.getWind().getSpeed() == newReport.getWind().getGust()) {
					consoleService.printReportNoGusts(newGeocode.getName(), newReport.getWind().getSpeed());
				} else {
					consoleService.printReport(newGeocode.getName(), newReport.getWind().getSpeed(), newReport.getWind().getGust());
				}

				//prompt user for choice
				menuSelection = Integer.parseInt(consoleService.getChoice("1: Another Report \n0: Exit\n-> "));
			} else {
				System.out.println("** Please enter a valid zipcode (5 digits) **");
			}

			//add blank space in between requests
			consoleService.blankSpace();
		}
	}
	//possible future method for zipcode
	public String reportByZipcode() {
		return "";
	}

	//possible future method for city/state
	public String reportByCityByState() {
		return "";
>>>>>>> 81546b63913452f4289c0b07147b63f2d4fc5010
	}
}

