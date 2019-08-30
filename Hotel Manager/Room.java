/* Harry Baldwin
 * B6042020
 * Programming 1: Assignment 2
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Room {
	// Number of beds in a room
	private List<Bed> listBed = new ArrayList<Bed>();
	private int occupancy;
	public final int[] OCCUPANTNUM = { 1, 2 };

	public Room(List<Bed> listBed) {
		setListBed(listBed);
	}

	public List<Bed> getListBed() {
		return listBed;
	}

	public void setListBed(List<Bed> listBed) {
		this.listBed = listBed;
	}

	// calculate occupancy of room according to the number and size of beds
	public void setRoomOccupancy(String size) {
		//Calculating the value of occupancy for the number of beds in each room
		for (int i = 0; i < this.listBed.size(); i++) {
			String lower = size.toLowerCase();
			if (lower.contains("single")) {
				this.occupancy = occupancy + OCCUPANTNUM[0];
			} else if (lower.contains("double")) {
				this.occupancy = occupancy + OCCUPANTNUM[1];
			}
		}
	}

	public int getRoomOccupancy() {

		return occupancy;
	}
}