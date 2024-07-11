package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import model.exceptions.DomainException;

public class Reservation {

	public static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Integer roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	public Reservation() {}

	public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) throws DomainException {
		if (!checkIn.isBefore(checkOut)) {
			throw new DomainException("Check-in date must be before check-out date.");
		} 
		if (checkIn.isBefore(LocalDate.now(ZoneId.systemDefault())) || 
				checkOut.isBefore(LocalDate.now(ZoneId.systemDefault()))) {
				throw new DomainException("Check-in date must be a future date.");
		} 
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;

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
	
	public void updateDates(LocalDate checkIn, LocalDate checkOut) throws DomainException {
		
		if (!checkIn.isBefore(checkOut)) {
			throw new DomainException("Check-in date must be before check-out date.");
		} 
		
		if (checkIn.isBefore(LocalDate.now(ZoneId.systemDefault())) || 
			checkOut.isBefore(LocalDate.now(ZoneId.systemDefault()))) {
			throw new DomainException("Check-in date must be a future date.");
		} 
		
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
