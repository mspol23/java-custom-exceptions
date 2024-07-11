package main;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import model.entities.Reservation;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Room number: ");
			int room = sc.nextInt();
			sc.nextLine();
			System.out.print("Check-in date (DD/MM/YYYY): ");
			LocalDate checkInDate = LocalDate.parse(sc.nextLine(), Reservation.DTF);
			System.out.print("Check-out date (DD/MM/YYYY): ");
			LocalDate checkOutDate = LocalDate.parse(sc.nextLine(), Reservation.DTF);

			Reservation r1 = new Reservation(room, checkInDate, checkOutDate);
			System.out.println(r1.toString());

			System.out.println("Enter date to update the reservation");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			LocalDate checkInUpdate = LocalDate.parse(sc.nextLine(), Reservation.DTF);
			System.out.print("Check-out date (DD/MM/YYYY): ");
			LocalDate checkOutUpdate = LocalDate.parse(sc.nextLine(), Reservation.DTF);

			r1.updateDates(checkInUpdate, checkOutUpdate);
			System.out.println(r1.toString());				
		} 
		catch (DateTimeParseException e) {
			System.out.println("Invalid date");
			System.out.println(e.getStackTrace());
		}
		catch (IllegalArgumentException e) {
			System.out.println("Reservation error: " + e.getMessage());
		}
		
		sc.close();
	}
}


