package it.polito.tdb.restaurant.simulation;

import java.util.PriorityQueue;

import java.util.Queue;

public class Core {

	/* ----------------- VARIABLES ----------------- */
	
	int totalClients;
	int happyClients;
	int unhappyClients;
	
	Queue<Event> eventList = new PriorityQueue<Event>();
	
	/* ----------------- CONSTRUCTOR AND METHODS ----------------- */

	public void simulate() {
		
		while (!eventList.isEmpty()) {
			step();
		}
	}

	private void step() {

		Event e = eventList.remove();
		
		

	}
	
	/* ----------------- GETTERS AND SETTERS ----------------- */

	
}
