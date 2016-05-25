package it.polito.tdb.restaurant.simulation;

import java.util.Random;

public class Event implements Comparable<Event> {
	/* ----------------- VARIABLES ----------------- */

	protected enum EventType {
		CLIENTS_GROUP_ARRIVE, CLIENTS_GROUP_LEAVE_TABLE
	}

	long time;
	int numbPerson;
	long timeToEat;
	float tollerance;
	EventType type;
	int id;
	boolean okAtBar;

	Table assignedTable;
	
	/* ----------------- CONSTRUCTOR AND METHODS ----------------- */

	public Event(long time, EventType type, int id) {
		super();
		this.type = type;
		Random r = new Random();
		this.time = time + r.nextInt(10) + 1;
		this.numbPerson = r.nextInt(10) + 1;
		this.timeToEat = (long) r.nextInt(61) + 1;
		this.tollerance = r.nextFloat() * (0.9f);
		this.id = id;
		this.okAtBar = Math.random() < tollerance;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + numbPerson;
		result = prime * result + (okAtBar ? 1231 : 1237);
		result = prime * result + (int) (time ^ (time >>> 32));
		result = prime * result + (int) (timeToEat ^ (timeToEat >>> 32));
		result = prime * result + Float.floatToIntBits(tollerance);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (id != other.id)
			return false;
		if (numbPerson != other.numbPerson)
			return false;
		if (okAtBar != other.okAtBar)
			return false;
		if (time != other.time)
			return false;
		if (timeToEat != other.timeToEat)
			return false;
		if (Float.floatToIntBits(tollerance) != Float.floatToIntBits(other.tollerance))
			return false;
		return true;
	}

	/* ----------------- GETTERS AND SETTERS ----------------- */

	public EventType getType() {
		return type;
	}

	public boolean isOkAtBar() {
		return okAtBar;
	}

	public int getId() {
		return id;
	}

	public long getTime() {
		return time;
	}

	public int getNumbPerson() {
		return numbPerson;
	}

	public long getTimeToEat() {
		return timeToEat;
	}

	public float getTollerance() {
		return tollerance;
	}

	@Override
	public int compareTo(Event o) {
		return Long.compare(this.time, o.getTime());
	}


	public Table getAssignedTable() {
		return assignedTable;
	}


	public void setAssignedTable(Table assignedTable) {
		this.assignedTable = assignedTable;
	}


	@Override
	public String toString() {
		return "[time=" + time + ", numbPerson=" + numbPerson + ", timeToEat=" + timeToEat + ", type=" + type
				+ ", id=" + id + ", okAtBar=" + okAtBar + "]";
	}

	
	
}