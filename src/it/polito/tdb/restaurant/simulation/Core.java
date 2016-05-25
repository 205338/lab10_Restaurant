package it.polito.tdb.restaurant.simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import java.util.Queue;

import it.polito.tdb.restaurant.simulation.Event.EventType;

public class Core {

	final int numberOfInitialEvents = 2000;
	final long distanceBetweenEvents = 1;

	/* ----------------- VARIABLES ----------------- */

	int totalClients;
	int happyClients;
	int unhappyClients;

	Queue<Event> eventList = new PriorityQueue<Event>();
	Queue<Table> tableList = new PriorityQueue<Table>();

	Map<Integer,Table> assignedTables = new HashMap<Integer,Table>();
	
	int tableId = 0;
	
	String out = "";
	
	/* ----------------- CONSTRUCTOR AND METHODS ----------------- */

	public Core() {
		super();
	}

	private boolean assignTable(Event e) {
		List<Table> discardedTables = new ArrayList<Table>();
		Table t;
		boolean assigned = false;
		while (!tableList.isEmpty()) {
			t = tableList.remove();
			if (t.tableIsAssignable(e.getNumbPerson())) {
				assignedTables.put(e.getId(), t);
				assigned = true;
				break;
			} else {
				discardedTables.add(t);
			}
		}
		
		if (!discardedTables.isEmpty())
			tableList.addAll(discardedTables);
		
		return assigned;
	}

	private void addTables(int numberOfTables, int NumberOfSeats) {
		for (int i = 0; i < numberOfTables; i++) {
			tableId++;
			tableList.add(new Table(NumberOfSeats, tableId));
		}		
	}
	
	public void generateEvents() {
		long time = 1;
		for (int i = 0; i < numberOfInitialEvents; i++) {
			// plus a random from 1 to 10 minuts
			time += i * distanceBetweenEvents;
			eventList.add(new Event(time, EventType.CLIENTS_GROUP_ARRIVE, i + 1));
		}
	}

	public void simulate() {
		while (!eventList.isEmpty()) {
			step();
		}
	}

	private void step() {

		Event e = eventList.remove();

		switch (e.getType()) {

		case CLIENTS_GROUP_ARRIVE:
			totalClients += e.getNumbPerson();
			if (assignTable(e)) {
				out += "Clienti Arrivano: " + e +"\n";
				// table get assigned in the function
				happyClients += e.getNumbPerson();
				eventList.add(new Event(e.getTime() + e.getTimeToEat(), EventType.CLIENTS_GROUP_LEAVE_TABLE, e.getId()));
			} else {
				if (e.isOkAtBar()) {
					out += "\tClienti vanno al Bar: " + e +"\n";

					happyClients += e.getNumbPerson();
				} else {
					out += "\t\tClienti vanno via: " + e +"\n";
					unhappyClients += e.getNumbPerson();
				}
			}
			break;
		case CLIENTS_GROUP_LEAVE_TABLE:
			// free the table
			out += "\tClienti Lasciano tavolo: " + e +"\n";
			Table freeTable = assignedTables.remove(e.getId());
			tableList.add(freeTable);
			break;
		default:
			break;
		}

	}
	

	/* ----------------- GETTERS AND SETTERS ----------------- */
	
	public void setTables() {
    	this.addTables(2, 10);
    	this.addTables(4, 8);
    	this.addTables(4, 6);
    	this.addTables(5, 4);
	}

	public int getTotalClients() {
		return totalClients;
	}

	public int getHappyClients() {
		return happyClients;
	}

	public int getUnhappyClients() {
		return unhappyClients;
	}
	
	public String getStats() {
		return out + "\n Persone soddisfatte: "+ happyClients + "\n Persone insoddisfatte: "+ unhappyClients +"\n Persone totali: " + totalClients;
	}

}
