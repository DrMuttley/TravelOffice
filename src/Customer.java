public class Customer {

    private String name;
    private Address address;
    private Trip trip;

    public String getName() {
        return name;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Customer(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void assignTrip(Trip trip) {
        this.trip = trip;
    }

    @Override
    public String toString(){

        String customerData = name;

        if(address != null){
            customerData += " " + address.toString();
        }
        if(trip != null){
            customerData += " " + trip.toString();
        }
        return customerData;
    }
}
