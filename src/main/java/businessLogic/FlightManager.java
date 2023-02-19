package businessLogic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Vector;

import dataAccess.Fligth_objectdbAccess;
import domain.ConcreteFlight;
import domain.Flight;

public class FlightManager implements FlightManagerInterface{
	Fligth_objectdbAccess flightsDB= new Fligth_objectdbAccess();
	
	

	
	private Date newDate(int year,int month,int day) {

	     Calendar calendar = Calendar.getInstance();
	     calendar.set(year, month, day,0,0,0);
	     calendar.set(Calendar.MILLISECOND, 0);

	     return calendar.getTime();
	}		

		public FlightManager () {
			
			Flight f1 = new Flight("F1","Donostia","Bilbo");
			f1.addConcreteFlight("CF1-1",newDate(2023,1,23),0,2,3,"12:00");
			f1.addConcreteFlight("CF1-2",newDate(2023,1,23),3,0,3,"12:30");
			f1.addConcreteFlight("CF1-3",newDate(2023,1,23),1,2,2,"13:00");
			f1.addConcreteFlight("CF1-4",newDate(2023,1,23),3,3,0,"14:00");
			f1.addConcreteFlight("CF1-5",newDate(2023,1,23),3,3,0,"15:00");
			f1.addConcreteFlight("CF1-6",newDate(2023,1,23),3,3,0,"16:00");
			f1.addConcreteFlight("CF1-7",newDate(2023,1,23),3,3,0,"17:00");
			
			Flight f2 = new Flight("F2","Donostia","Madrid");
			f2.addConcreteFlight("CF2-1",newDate(2023,1,23),1,2,3,"12:00");
			f2.addConcreteFlight("CF2-2",newDate(2023,1,23),3,0,3,"12:30");
			f2.addConcreteFlight("CF2-3",newDate(2023,1,23),1,2,2,"13:00");
			f2.addConcreteFlight("CF2-4",newDate(2023,1,23),3,3,0,"14:00");
			f2.addConcreteFlight("CF2-5",newDate(2023,1,23),3,3,0,"15:00");
			f2.addConcreteFlight("CF2-6",newDate(2023,1,23),3,3,0,"16:00");
			f2.addConcreteFlight("CF2-7",newDate(2023,1,23),3,3,0,"17:00");
					
			Flight f3 = new Flight("F3","Barcelona","Donostia");
			f3.addConcreteFlight("CF3-1",newDate(2023,1,23),1,2,3,"10:00");
			f3.addConcreteFlight("CF3-2",newDate(2023,1,23),3,0,3,"11:00");
			f3.addConcreteFlight("CF3-3",newDate(2023,1,23),1,2,2,"12:00");
			f3.addConcreteFlight("CF3-4",newDate(2023,1,23),3,3,0,"13:00");
			f3.addConcreteFlight("CF3-5",newDate(2023,1,23),3,3,0,"15:00");
			f3.addConcreteFlight("CF3-6",newDate(2023,1,23),3,3,0,"19:00");
			f3.addConcreteFlight("CF3-7",newDate(2023,1,23),3,3,0,"21:00");
			
			Flight f4 = new Flight("F4","Barcelona","Malaga");
			f4.addConcreteFlight("CF4-1",newDate(2023,1,22),1,2,3,"9:00");
			f4.addConcreteFlight("CF4-2",newDate(2023,1,23),3,0,3,"11:00");
			f4.addConcreteFlight("CF4-3",newDate(2023,1,23),1,2,2,"13:00");
			f4.addConcreteFlight("CF4-4",newDate(2023,1,23),3,3,0,"15:00");
			f4.addConcreteFlight("CF4-5",newDate(2023,1,23),3,3,0,"17:00");
			f4.addConcreteFlight("CF4-6",newDate(2023,1,23),3,3,0,"19:00");
			f4.addConcreteFlight("CF4-7",newDate(2023,1,23),3,3,0,"21:00");
			
			Flight f5 = new Flight("F5","Sevilla","Madrid");
			f5.addConcreteFlight("CF5-1",newDate(2023,1,22),1,2,3,"8:00");
			f5.addConcreteFlight("CF5-2",newDate(2023,1,23),3,0,3,"10:00");
			f5.addConcreteFlight("CF5-3",newDate(2023,1,23),1,2,2,"12:00");
			f5.addConcreteFlight("CF5-4",newDate(2023,1,23),3,3,0,"14:00");
			f5.addConcreteFlight("CF5-5",newDate(2023,1,23),3,3,0,"16:00");
			f5.addConcreteFlight("CF5-6",newDate(2023,1,23),3,3,0,"18:00");
			f5.addConcreteFlight("CF5-7",newDate(2023,1,23),3,3,0,"20:00");
			
			
			Flight f6 = new Flight("F6","Sevilla","Santander");
			f6.addConcreteFlight("CF6-1",newDate(2023,1,22),1,2,3,"8:30");
			f6.addConcreteFlight("CF6-2",newDate(2023,1,23),3,0,3,"10:30");
			f6.addConcreteFlight("CF6-3",newDate(2023,1,23),1,2,2,"12:30");
			f6.addConcreteFlight("CF6-4",newDate(2023,1,23),3,3,0,"14:30");
			f6.addConcreteFlight("CF6-5",newDate(2023,1,23),3,3,0,"16:30");
			f6.addConcreteFlight("CF6-6",newDate(2023,1,23),3,3,0,"18:30");
			f6.addConcreteFlight("CF6-7",newDate(2023,1,23),3,3,0,"20:30");
			
			Flight f7 = new Flight("F7","Sevilla","Granada");

			flightsDB.storeFlight(f1);
			flightsDB.storeFlight(f2);
			flightsDB.storeFlight(f3);
			flightsDB.storeFlight(f4);
			flightsDB.storeFlight(f5);
			flightsDB.storeFlight(f6);
			flightsDB.storeFlight(f7);

			
		}
		public List<String> getAllDepartingCities(){
			
			
			return flightsDB.getDepartingCities();
			
			
			/*			
				LEHENENGO MARROIAREN KODEA
			
			if (flightsDB.isEmpty()) return new ArrayList<String>();
			//A set is used to avoid duplicates
			SortedSet<String> setDepartingCities = new TreeSet<String>();
			Iterator<Flight> i=flightsDB.iterator();
			while (i.hasNext())
				setDepartingCities.add(i.next().getDepartingCity());
			return new ArrayList<String>(setDepartingCities);			
			*/
		}
		
		public List<String> getArrivalCitiesFrom(String departingCity){

			return flightsDB.getArrivals(departingCity);
			
			/*
	 				LEHENENGO MARROIAREN KODEA
			
			List<String> arrivalCities = new ArrayList<String>();
			Iterator<Flight> i=flightsDB.iterator();
			Flight f;
			while (i.hasNext()) {
				f=i.next();
				if (f.getDepartingCity().compareTo(departingCity)==0)
					arrivalCities.add(f.getArrivingCity());
			}
			Collections.sort(arrivalCities);
			return arrivalCities;
			*/			
		}
		
		public Collection<ConcreteFlight> getConcreteFlights(String departingCity, String arrivingCity, Date date) {
			
			return flightsDB.getFlights(departingCity, arrivingCity, date);
			
			/*
				LEHENENGO MARROIAREN KODEA
			
			ArrayList<ConcreteFlight> res = new ArrayList<ConcreteFlight>();
			for (Flight a : flightsDB) {
				if ((a.getArrivingCity().equals(arrivingCity))&&(a.getDepartingCity().equals(departingCity)))
					for (ConcreteFlight c : a.getConcreteFlights())
						if (c.getDate().equals(date)) res.add(c);
						
			}
			return res;
			*/				
		}
		
		
		public void bookSeat(ConcreteFlight cFlight , String ticket) 
		{
			flightsDB.bookSeat(cFlight, ticket);
		}
}
