package dataAccess;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Flight;

public class Fligth_objectdbAccess {
	
	private EntityManager db;
	private EntityManagerFactory emf;
	private boolean local = false;
	private String DBName = "flightManager.odb";
	
	public Fligth_objectdbAccess()
	{
		emf = Persistence.createEntityManagerFactory(DBName);
		db = emf.createEntityManager();
		System.out.println("Database Open");
	}
	
	public void close() {
		db.close();
		System.out.println("Databse Closed");
	}
	
	
	public void storeFlight(Flight f) 
	{
		emf = Persistence.createEntityManagerFactory(DBName);
		db = emf.createEntityManager();
		System.out.println("Database ON");
		db.getTransaction().begin();
		// insert the flight 
		if(db.find(Flight.class, f.getFlightCode()) == null) db.persist(f); // persist adds the flight to the database
		else System.out.println("Sartu nahi duzun hegaldia datu basean zegoen");
		db.getTransaction().commit();
		close();
	}
	
	public List<String> getDepartingCities()
	{
		emf = Persistence.createEntityManagerFactory(DBName);
		db = emf.createEntityManager();
		System.out.println("Database ON");
	}

}
