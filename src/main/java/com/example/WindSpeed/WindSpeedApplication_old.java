package com.example.WindSpeed;

//@SpringBootApplication
public class WindSpeedApplication_old {

	private ConsoleService consoleService = new ConsoleService();
	private GeocodeService geocodeService = new GeocodeService();
	private ReportService reportService = new ReportService();

	public static void main(String[] args) {
		//SpringApplication.run(WindSpeedApplication.class, args);

		WindSpeedApplication_old windSpeedApplication = new WindSpeedApplication_old();
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
				if (newReport.getWind().getGust() == 0.00) {
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
	}
}
