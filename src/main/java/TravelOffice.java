package main.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TravelOffice {

    private Set<Customer> customersSet = new HashSet<>();
    private Map<String, Trip> tripsMap = new HashMap<>();

    public Set<Customer> getCustomersSet() {
        return customersSet;
    }

    public Map<String, Trip> getTripsMap() {
        return tripsMap;
    }

    public void addCustomer(Customer customer){
        customersSet.add(customer);
    }

    public int getCustomerCount(){
        return customersSet.size();
    }

    public void showAllCustomers(){
        if(!getCustomersSet().isEmpty()) {
            getCustomersSet().forEach(customer -> System.out.println(customer.toString()));
            System.out.println();
        }else{
            System.out.println("There is no customers in the DB.\n");
        }
    }

    public void showAllTrips(){
        if(!getTripsMap().isEmpty()) {
            getTripsMap().entrySet().forEach(trip -> System.out.println(trip.getValue()));
            System.out.println();
        }else{
            System.out.println("There is no trip in the DB.\n");
        }
    }

    public void addTrip(String description, Trip trip){
        tripsMap.put(description, trip);
    }

    public void removeTrip(String description) throws NoSuchTripException{

        if(tripsMap.containsKey(description)){
            tripsMap.remove(description);
        }else{
            throw new NoSuchTripException("The trip wasn't found");
        }
    }

    public Customer findCustomerByName(String name) throws NoSuchCustomerException{

        for(Customer c : customersSet){
            if(c.getName().equals(name)){
                return c;
            }
        }
        throw new NoSuchCustomerException("The customer not found exception.");
    }

    public Customer findCustomerByTrip(Trip trip){

        for(Customer c : customersSet){
            if(c.getTrip().equals(trip)){
                return c;
            }
        }
        return null;
    }

    public Trip findTripByDescription(String tripDescription){

        for (Map.Entry<String,Trip> entry : getTripsMap().entrySet()) {

            if(entry.getKey().equals(tripDescription)){
                return entry.getValue();
            }
        }
        return null;
    }

    public void removeCustomer(Customer customer) throws NoSuchCustomerException{

        if(!customersSet.remove(customer)){
            throw new NoSuchCustomerException("The customer not found exception.");
        }
    }

}
