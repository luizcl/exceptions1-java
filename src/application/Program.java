package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number:");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-Out date (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		// Deveria ser feita pelo construtor, porém não tem como retornar String pelo construtor
		if(!checkOut.after(checkIn)) {
			System.out.print("Errorin reservation: Check-out date must beaftercheck-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.print("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			String error = reservation.updateDates(checkIn, checkOut); 
			if(error != null) {
				
				System.out.println("Error in reservation: " + error);
			}
			else {
				
				System.out.print("Reservation: " + reservation);
			}
			
		}

		sc.close();

	}

}
