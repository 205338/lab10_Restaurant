package it.polito.tdb.restaurant.simulation;

public class Table implements Comparable<Table> {

	/* ----------------- VARIABLES ----------------- */

	int seats;
	int eventId;
	int tableId;

	/* ----------------- CONSTRUCTOR AND METHODS ----------------- */

	public Table(int seats, int tableId) {
		super();
		this.seats = seats;
		this.tableId = tableId;
	}
	
	public boolean tableIsAssignable(int nPerson) {
		return nPerson >= seats/2;
	}

	@Override
	public int compareTo(Table o) {
		return this.seats - o.getSeats();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + seats;
		result = prime * result + tableId;
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
		Table other = (Table) obj;
		if (seats != other.seats)
			return false;
		if (tableId != other.tableId)
			return false;
		return true;
	}
	
	/* ----------------- GETTERS AND SETTERS ----------------- */

	public int getSeats() {
		return seats;
	}

	public int getEventId() {
		return eventId;
	}

	public int getTableId() {
		return tableId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	
}
