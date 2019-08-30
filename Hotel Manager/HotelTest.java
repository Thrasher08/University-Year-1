/* Harry Baldwin
 * B6042020
 * Programming 1: Assignment 2
 */

import java.util.ArrayList;
import java.util.List;

public class HotelTest {
	public static void main(String[] args) {
		Bed aBed = new Bed("Single");
		Bed bBed = new Bed("Double");

		//Creating two rooms to test system
		
		List<Bed> listBedRoom1 = new ArrayList<Bed>();
		listBedRoom1.add(aBed);
		listBedRoom1.add(bBed);

		Room room1 = new Room(listBedRoom1);

		List<Bed> listBedRoom2 = new ArrayList<Bed>();
		listBedRoom2.add(aBed);
		listBedRoom2.add(aBed);

		Room room2 = new Room(listBedRoom2);

		List<Room> listRooms = new ArrayList<Room>();

		listRooms.add(room1);
		listRooms.add(room2);

		Hotel aHotel = new Hotel("aHotel", listRooms);
		HotelReport.report(aHotel);

	}

}
