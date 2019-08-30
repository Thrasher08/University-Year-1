/* Harry Baldwin
 * B6042020
 * Programming 1: Assignment 2
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HotelReport {
	public static void report(Hotel hotel) {
		System.out.println("Hotel Name: " + hotel.getHName());
		System.out.println("Number of Rooms: " + hotel.getListRooms().size());
		Room r = hotel.getListRooms().get(0);

		for (int i = 0; i < hotel.getListRooms().size(); i++) {
			System.out.println("For room " + i);
			r = hotel.getListRooms().get(i);
			System.out.println("Number of beds: " + r.getListBed().size());

			for (Bed b : r.getListBed()) {
				System.out.println(b.getSize() + " ");
				r.setRoomOccupancy(b.getSize());
			}
			hotel.setTotalOccupancy(r.getRoomOccupancy());
		}
		System.out.println("Has Vacancy: " + hotel.getHasVacancies());
		System.out.println("Total Occupancy: " + hotel.getTotalOccupancy());

	}
}
// }
