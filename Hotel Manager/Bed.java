/* Harry Baldwin
 * B6042020
 * Programming 1: Assignment 2
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Bed {
	// Size of beds (single or double)
	private String size;

	public Bed(String size) {
		setSize(size);
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		//Validation
		String lower = size.toLowerCase();
		//Error exception
		if (lower.contains("single")) {
			this.size = size;
		}

		else if (lower.contains("double")) {
			this.size = size;
		} else {
			throw new IllegalArgumentException("Size can only be single or double");
		}

	}
}
