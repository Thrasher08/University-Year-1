/* Harry Baldwin
 * B6042020
 * Programming 1: Assignment 2
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Hotel {
	// Stores all essential information (name, rooms)

	private String hName = new String();
	private int numRooms;
	private List<Room> listRooms = new ArrayList<Room>();
	private boolean hasVacancies;
	private int hOccupancy;

	public Hotel(String hName, List<Room> listRooms) {
		setHName(hName);
		setListRooms(listRooms);
		hasVacancies = true;
	}

	public void setHName(String hName) {
		this.hName = hName;
	}

	public String getHName() {
		return hName;
	}

	public List<Room> getListRooms() {
		return listRooms;
	}

	public void setListRooms(List<Room> listRooms) {
		this.listRooms = listRooms;
	}

	// Determines hotel vacancy
	public boolean getHasVacancies() {
		return hasVacancies;
	}

	// Calculates total occupancy
	public void setTotalOccupancy(int value) {
		this.hOccupancy = (hOccupancy + value) / 2;
	}

	public int getTotalOccupancy() {

		return hOccupancy;
	}
}