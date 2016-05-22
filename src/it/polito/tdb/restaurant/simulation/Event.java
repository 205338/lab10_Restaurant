package it.polito.tdb.restaurant.simulation;

import java.util.Random;

public class Event {
	/* ----------------- VARIABLES ----------------- */

	public enum EventType {
		CLIENTS_GROUP_ARRIVE, CLIENTS_FIND_TABLE, CLIENTS_FIND_PLACE_AT_BAR, CLIENTS_GROUP_LEAVE_TABLE, CLIENTS_GROUP_LEAVE_RESTAURANT
	}

	long time;
	int numbPerson;
	long timeToEat;
	float tollerance;

	/* ----------------- CONSTRUCTOR AND METHODS ----------------- */

	public Event(long time) {
		super();
		Random r = new Random();
		this.time = time + r.nextInt(10) + 1;
		this.numbPerson = r.nextInt(10) + 1;
		this.timeToEat = (long) r.nextInt(61) + 1;
		this.tollerance = r.nextFloat() * (0.9f);
	}

	/* ----------------- GETTERS AND SETTERS ----------------- */

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getNumbPerson() {
		return numbPerson;
	}

	public void setNumbPerson(int numbPerson) {
		this.numbPerson = numbPerson;
	}

	public long getTimeToEat() {
		return timeToEat;
	}

	public void setTimeToEat(long timeToEat) {
		this.timeToEat = timeToEat;
	}

	public float getTollerance() {
		return tollerance;
	}

	public void setTollerance(float tollerance) {
		this.tollerance = tollerance;
	}

}