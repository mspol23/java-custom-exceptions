package main;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Scanner;

import model.entities.Reservation;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Room number: ");
		int room = sc.nextInt();
		sc.nextLine();
		System.out.print("Check-in date (DD/MM/YYYY): ");
		LocalDate checkInDate = LocalDate.parse(sc.nextLine(), Reservation.DTF);
		System.out.print("Check-out date (DD/MM/YYYY): ");
		LocalDate checkOutDate = LocalDate.parse(sc.nextLine(), Reservation.DTF);
		
		if (!checkInDate.isBefore(checkOutDate)) {
			System.out.println("Error: Check-in date must be before check-out date.");
		} else if(checkInDate.isBefore(LocalDate.now(ZoneId.systemDefault()))) {
			System.out.println("Error: Check-in date must be a future date.");			
		} else {
			Reservation r1 = new Reservation(room, checkInDate, checkOutDate);
			System.out.println(r1.toString());
			
			System.out.println("Enter date to update the reservation");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			LocalDate checkInUpdate = LocalDate.parse(sc.nextLine(), Reservation.DTF);
			System.out.print("Check-out date (DD/MM/YYYY): ");
			LocalDate checkOutUpdate = LocalDate.parse(sc.nextLine(), Reservation.DTF);
			
			if (!checkInUpdate.isBefore(checkOutUpdate)) {
				System.out.println("Error: Check-in date must be before check-out date.");
			} else if(checkInUpdate.isBefore(LocalDate.now(ZoneId.systemDefault()))) {
				System.out.println("Error: Check-in date must be a future date.");			
			} else {
				r1.updateDates(checkInUpdate, checkOutUpdate);
				System.out.println(r1.toString());
			}
			
		}		
		
		sc.close();
	}

}
