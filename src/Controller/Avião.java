package Controller;

import java.util.concurrent.Semaphore;

public class Avião extends Thread {
	int manobra1;
	int taxiar1;
	int decolagem1;
	int afastamento;
	private Semaphore s1;
	private Semaphore s2;
	String nome1;
	String nome2;
	String nome;
	public Avião(Semaphore s1, Semaphore s2) {
		this.s1= s1;
		this.s2=s2;
		
	}
	public void run() {
		try {
			s1.acquire();
			norte();
			ma(nome1);
			tax(nome1);
			dec(nome1);
			afast(nome1);
			s2.acquire();
			sul();
			ma(nome2);
			tax(nome2);
			dec(nome2);
			afast(nome2);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}finally {
			s1.release();
			s2.release();
		}
		
		
	}


	private void afast(String nome) {
		afastamento= (int)((Math.random()*5000)+ 3000)/1000;
		System.out.println("Na Pista "+ nome + " O avião está se afastando em  "+ decolagem1);
		System.out.println(" ");
	}
	private void dec(String nome ) {
		decolagem1 = (int)((Math.random()*1000)+ 4000)/1000;
		System.out.println("Na Pista "+ nome + " Está na fase de decolagem em  "+ decolagem1);
	}
	private void tax(String nome) {
		taxiar1 = (int)((Math.random()*5000)+ 5000)/ 1000;
		System.out.println("Na Pista "+ nome + " está taxiando por "+ taxiar1);
	}
	private void ma(String nome) {
		manobra1 = (int)((Math.random()*4000)+ 3000)/1000;
		System.out.println("Na Pista "+ nome +" fazendo Manobra "+ manobra1);
	}
	private void sul() {
		nome2 =" sul";
	
		
	}
	private void norte() {
		nome1 =" Norte";
		
	
}
}