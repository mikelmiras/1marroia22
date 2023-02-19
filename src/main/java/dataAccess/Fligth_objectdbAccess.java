package dataAccess;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;
import javax.persistence.TypedQuery;

import domain.ConcreteFlight;
import domain.Flight;

public class Fligth_objectdbAccess {
	
	private EntityManager db;
	private EntityManagerFactory emf;
	private boolean local = false;
	private String fileName = "flightManager.odb";
	
	public Fligth_objectdbAccess()
	{
		emf = Persistence.createEntityManagerFactory(fileName);
		db = emf.createEntityManager();
		System.out.println("Database Open");
	}
	
	public void close() {
		db.close();
		System.out.println("Databse Closed");
	}
	
	
	public void storeFlight(Flight f) 
	{
		emf = Persistence.createEntityManagerFactory(fileName);
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
		emf = Persistence.createEntityManagerFactory(fileName);
		db = emf.createEntityManager();
		System.out.println("Database ON");
		
		TypedQuery<String> query = db.createQuery("SELECT DISTINCT f.departingCity FROM Flight f", String.class);
		List<String> result = query.getResultList();
		close();
		return result;
	}
	
	public List<String> getArrivals(String city) {
		
		emf = Persistence.createEntityManagerFactory(fileName);
		db = emf.createEntityManager();
		System.out.println("Database ON");
		
		TypedQuery<String> query = db.createQuery("SELECT DISTINCT f.arrivingCity FROM Flight f WHERE f.departingCity=?1", String.class);
		query.setParameter (1, city);
		List<String> result = query.getResultList();
		close();
		return result;
	}
	
	public Collection<ConcreteFlight> getFlights(String dCity, String aCity, java.util.Date date)
	{
		emf = Persistence.createEntityManagerFactory(fileName);
		db = emf.createEntityManager();
		System.out.println("Database ON");
		// 
		TypedQuery<ConcreteFlight> query = db.createQuery("SELECT p FROM ConcreteFlight p WHERE  p.flight.departingCity =? 1 AND p.flight.arrivingCity =? 2 AND p.date =? 3", ConcreteFlight.class);
		db.getTransaction().begin();
		query.setParameter(1, dCity);
		query.setParameter(2, aCity);
		query.setParameter(3,date);
		List<ConcreteFlight> result = query.getResultList();
		close();
		return result;
	}
	
	public void  bookSeat(ConcreteFlight cFlight , String ticket) 
	{
		emf = Persistence.createEntityManagerFactory(fileName);
		db = emf.createEntityManager();
		System.out.println("Database ON");
		
		int num = 0;
		db.getTransaction().begin();
		ConcreteFlight currentConcreteFlight = db.find(ConcreteFlight.class, cFlight.getConcreteFlightCode()); // concreteFlight code-ren gakoa dakigunez find metodoa erabili dezakegu
		// depending on the ticket type we set a different numtypes just if the given number is not negative 
		if(ticket == "business") 
		{
			num = cFlight.getBusinessNumber();
			if(num > 0) currentConcreteFlight.setBusinessNumber(num - 1);
		}else if (ticket == "first") 
		{
			num = cFlight.getFirstNumber();
			if(num > 0) currentConcreteFlight.setFirstNumber(num - 1);
		}else if (ticket == "tourist") 
		{
			num = cFlight.getTouristNumber();
			if(num > 0) currentConcreteFlight.setTouristNumber(num - 1);
		}
		
		db.getTransaction().commit();
		close();
	}
	

}
