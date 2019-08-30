/* Harry Baldwin
 * B6042020
 * Programming 1: Assignment 2
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelConfigure {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		
		//Input for the user
		System.out.println("Please enter name of Hotel: ");
		String name = s.nextLine();
		List<Room> listRooms = new ArrayList<Room>();

		Hotel nHotel = new Hotel(name, listRooms);

		System.out.println("Please enter number of rooms: ");
		int numRooms = s.nextInt();

		for (int i = 0; i < numRooms; i++) {

			System.out.println("Please enter number of beds: ");
			int numBeds = s.nextInt();
			List<Bed> listBed = new ArrayList<Bed>();

			s.nextLine();

			for (int j = 0; j < numBeds; j++) {
				boolean check1 = true;
				//While check1 is true, repeat error message
				while (check1) {
					System.out.println("Please size of bed(s): ");
					String sizeBed = s.nextLine();
					//Catch any illegal inputs
					try {
						Bed b = new Bed(sizeBed);
						listBed.add(b);
						check1 = false;
					} catch (IllegalArgumentException iae) {
						System.out.println("Size can only be single or double");
					}
				}

			}

			Room r = new Room(listBed);
			listRooms.add(r);
		}
		HotelReport.report(nHotel);
	}
}
