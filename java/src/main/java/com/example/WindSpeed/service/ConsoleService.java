package com.example.WindSpeed.service;

import java.util.Scanner;

public class ConsoleService {

    public final Scanner scanner = new Scanner(System.in);

    public void displayBanner(){
        System.out.println(" _      _______  _____  _______  ___________");
        System.out.println("| | /| / /  _/ \\/ / _ \\/ __/ _ \\/ __/ __/ _ \\");
        System.out.println("| |/ |/ // //    / // /\\ \\/ ___/ _// _// // /");
        System.out.println("|__/|__/___/_/|_/____/___/_/  /___/___/____/");
        System.out.println("                                     (v1.1)");
    }

    public String getChoice(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        return input;
    }

    public void printMainMenu() {
        System.out.println("1: Enter Zipcode");
        System.out.println("2: Enter City/State");
        System.out.println("0: Exit");
    }
    public void printReport(String city, double speed, double gusts) {
        System.out.println();
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("*                                           *");
        System.out.printf("*    Location: %-11s                  *\n", city);
        System.out.println("*                                           *");
        System.out.printf("*    Wind Speed: %-11s                *\n", speed + "mph");
        System.out.printf("*    Wind Gusts: %-11s                *\n", gusts + "mph");
        System.out.println("*                                           *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println();
    }

    public void printReportNoGusts(String city, double speed) {
        System.out.println();
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("*                                           *");
        System.out.printf("*    Location: %-11s                  *\n", city);
        System.out.println("*                                           *");
        System.out.printf("*    Wind Speed: %-11s                *\n", speed + "mph");
        System.out.println("*                                           *");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * *");
        System.out.println();
    }

    public void blankSpace(){
        System.out.println();
        System.out.println();
        System.out.println("*********************************************");
        System.out.println();
        System.out.println();
    }
}
