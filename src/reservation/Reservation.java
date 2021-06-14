package reservation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import rating.Rating;

public class Reservation implements Serializable {
	
	private static final long serialVersionUID = 6392332274060936021L;
	
	private double totalCost;
	private ArrayList<Activity> activities;
	private Rating rating = null;
	public HashMap<Activity,Integer> act;
	private String paymentMethod;
	private Date date;
	public static int numberOfReservations;
	private int id;
	

	public Reservation () 
	{
		activities = new ArrayList<Activity>();
		act = new HashMap<>();
		initializeHashMap();
	}

	public void addActivity(Activity activity) {
		if(!activities.contains(activity)) {
			activities.add(activity);
		}
		act.put(activity, act.get(activity)+1);
	}
	
	public void clearReservation()
	{
		activities = new ArrayList<>();
		initializeHashMap();
	}
	
	public void removeActivity(Activity activity) {
		if(act.get(activity) ==1) {
			activities.remove(activity);
			act.put(activity, act.get(activity) -1 );
		}
		else {
			act.put(activity, act.get(activity) - 1 );
		}
	}
	
	public double calcCost() 
	{	
		totalCost = 0;
		
		for(Activity activity : activities) {
			totalCost += act.get(activity) * activity.getPrice();
		}

		return totalCost;
	}
	
	public double getTotalCost() {
		return totalCost;
	}

	public ArrayList<Activity> getActivities() {
		return activities;
	}
	
	public HashMap<Activity, Integer> getAct(){
		return act;
	}
	
	public void initializeHashMap() {
		for(Activity a: ActivityReader.getActivitiesList()) {
			act.put(a, 0);
		}
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	
	public void setPaymentMethod(String payment) {
		paymentMethod  = payment;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

}
