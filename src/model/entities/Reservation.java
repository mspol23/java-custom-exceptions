package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {

	public static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	public Reservation() {}

	public Reservation(Integer roomNumber, LocalDate checkInDate, LocalDate checkOutDate) {
		this.roomNumber = roomNumber;
		this.checkIn = checkInDate;
		this.checkOut = checkOutDate;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		return Duration.between(this.checkIn.atStartOfDay(), this.checkOut.atStartOfDay()).toDays();
	}
	
	public void updateDates(LocalDate checkIn, LocalDate checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Reservation: Room " +
				this.roomNumber +
				", check-in: " +
				dateToString(this.checkIn) + // não é necessário o Reservation, pois o método estático é desta classe.
				", check-out: " +
				dateToString(this.checkOut) + // chamada do método se a classe.
				", " +
				this.duration() +
				" nights.\n";
	}
	
//	private static final LocalDate setDate(String date) {
//		return LocalDate.parse(date, DTF);
//	}
	
	
	public static String dateToString(LocalDate date) {
		return DTF.format(date);
	}

}