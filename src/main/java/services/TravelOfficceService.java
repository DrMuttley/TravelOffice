package main.java.services;

import main.java.*;

import java.util.Set;

public class TravelOfficceService {

    private TravelOffice travelOffice = new TravelOffice();

    public void addCustomer(Customer customer){
        travelOffice.addCustomer(customer);
    }

    public void addTrip(String tripDescription, Trip trip){
        travelOffice.addTrip(tripDescription, trip);
    }

    public Trip findTripByDescription(String tripDescription){
        return travelOffice.findTripByDescription(tripDescription);
    }

    public Customer findCustomerByName(String userName) throws NoSuchCustomerException {
        return travelOffice.findCustomerByName(userName);
    }

    public Set<Customer> getCustomersSet(){
        return travelOffice.getCustomersSet();
    }

    public Customer findCustomerByTrip(Trip trip){
        return travelOffice.findCustomerByTrip(trip);
    }

    public void removeTrip(String tripDescription) throws NoSuchTripException {
        travelOffice.removeTrip(tripDescription);
    }

    public void showAllTrips(){
        travelOffice.showAllTrips();
    }

    public void showAllCustomers(){
        travelOffice.showAllCustomers();
    }
}
