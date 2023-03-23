package view;

import java.util.concurrent.Semaphore;

import Controller.Avião;


public class MainAvião {

	public static void main(String[] args) {
		Semaphore s1 = new Semaphore (1);
		Semaphore s2 = new Semaphore (1);
		for (int Av =1; Av <= 6; Av ++) {
			Thread c = new Avião( s1,s2);
			c.start();

		}
	}
}
