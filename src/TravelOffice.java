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

    public String showAllCustomers(){

        String allCustomersInfo = new String();

        for(Customer c : customersSet){
            allCustomersInfo += c.toString() + "\n";
        }
        return allCustomersInfo;
    }

    public String showAllTrips(){

        String allTripsInfo = new String();
        for (Map.Entry<String,Trip> entry : getTripsMap().entrySet()) {
            allTripsInfo += entry.getKey() + " " + entry.getValue().toString();
        }
        return allTripsInfo;
    }

    public void addTrip(String description, Trip trip){
        tripsMap.put(description, trip);
    }

    public boolean removeTrip(String description){
        return tripsMap.remove(description) != null;
    }

    public Customer findCustomerByName(String name){

        for(Customer c : customersSet){
            if(c.getName().equals(name)){
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

    public boolean removeCustomer(Customer customer){
        return customersSet.remove(customer);
    }

}
