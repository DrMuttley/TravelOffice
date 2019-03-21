import javafx.scene.input.DataFormat;

import java.util.Scanner;

public class MainHandler implements UserInterface {

    private TravelOffice travelOffice = new TravelOffice();
    private Scanner scan = new Scanner(System.in);
    private boolean communiactionWithUserEnd = false;

    @Override
    public Customer addCustomer() {

        showAnswerFromSystem("Provide customer data (example: John Doe Opolska 40-710 Katowice):");

        String[] customerData = splitInputData(getAnswerFromUser());

        if (customerData.length == 5) {

            Customer customer = new Customer(customerData[0] + " " + customerData[1]);
            customer.setAddress(new Address(customerData[2], customerData[3], customerData[4]));

            travelOffice.addCustomer(customer);
            return customer;
        } else {
            showAnswerFromSystem("Wrong data, back and try again.\n");
            return null;
        }
    }

    @Override
    public Trip addTrip() {

        showAnswerFromSystem("Provide type of trip (DOMESTIC/ABROAD):");

        while (true) {

            switch (getAnswerFromUser()) {

                case "DOMESTIC": {
                    showAnswerFromSystem("Provide domestic trip details (example: 2019-12-01 2019-12-20 France 4000 ");

                    String[] tripData = splitInputData(getAnswerFromUser());

                    DomesticTrip domesticTrip = new DomesticTrip(Date.of(tripData[0]),
                            Date.of(tripData[1]), tripData[2], Integer.parseInt(tripData[3]));

                    showAnswerFromSystem("Provide description:");
                    travelOffice.addTrip(getAnswerFromUser(), domesticTrip);
                    return domesticTrip;
                }
                case "ABROAD": {
                    showAnswerFromSystem("Provide abroad trip details (example: 2019-12-01 2019-12-20 France 4000 ");

                    String[] tripData = splitInputData(getAnswerFromUser());

                    AbroadTrip abroadTrip = new AbroadTrip(Date.of(tripData[0]),
                            Date.of(tripData[1]), tripData[2], Integer.parseInt(tripData[3]));

                    showAnswerFromSystem("Provide description:");
                    travelOffice.addTrip(getAnswerFromUser(), abroadTrip);
                    return abroadTrip;
                }
                default: {
                    showAnswerFromSystem("Wrong type of trip try again:");
                }
            }
        }
    }

    @Override
    public void assign() {
        showAnswerFromSystem("Provide customer name:");
        String userName = getAnswerFromUser();

        showAnswerFromSystem("Provide trip description:");
        String tripDescription = getAnswerFromUser();

        try {
            if (travelOffice.findTripByDescription(tripDescription) != null) {
                travelOffice.findCustomerByName(userName).assignTrip(travelOffice.findTripByDescription(tripDescription));
            } else {
                showAnswerFromSystem("The trip wasn't found.\n");
            }
        } catch (NoSuchCustomerException e) {
            System.err.println(e.getMessage());
            showAnswerFromSystem("The customer wasn't found.\n");
        }
    }

    @Override
    public boolean removeCustomer() {

        showAnswerFromSystem("Provide name of customer:");
        try {
            travelOffice.removeCustomer(travelOffice.findCustomerByName(getAnswerFromUser()));
            showAnswerFromSystem("The customer was removed.\n");
            return true;
        } catch (NoSuchCustomerException e) {
            System.err.println(e.getMessage());
            showAnswerFromSystem("The customer wasn't found.\n");
            return false;
        }
    }

    @Override
    public boolean removeTrip() {
        showAnswerFromSystem("Provide trip description:");

        String description = getAnswerFromUser();

        try {
            Customer customer = travelOffice.findCustomerByTrip(travelOffice.findTripByDescription(description));
            travelOffice.removeTrip(description);

            if (customer != null) {
                customer.setTrip(null);
            }
            showAnswerFromSystem("The trip was removed.");
            return true;

        } catch (NoSuchTripException e) {

            System.err.println(e.getMessage());
            showAnswerFromSystem("Trip wasn't found.\n");
            return false;
        }
    }

    @Override
    public void showTrips() {
        showAnswerFromSystem(travelOffice.showAllTrips());
    }

    @Override
    public void showCustomers() {
        showAnswerFromSystem(travelOffice.showAllCustomers());
    }

    private void showAnswerFromSystem(String answerFromSystem) {
        System.out.println(answerFromSystem);
    }

    public void showMenu() {
        System.out.println("Provide shortcut for option and press enter (example: -AC): \n"
                + "\tAdd customer -AC \n"
                + "\tAdd trip -AT \n"
                + "\tAssign trip to customer -TC \n"
                + "\tRemove customer -RC \n"
                + "\tRemove trip -RT \n"
                + "\tShow customers -SC \n"
                + "\tShow trips -ST \n"
                + "\tEXIT -E\n\n"
                + "Shortcut: ");
    }

    public String getAnswerFromUser() {
        return scan.nextLine();
    }

    public void setCommuniactionWithUserEnd(boolean communiactionWithUserEnd) {
        this.communiactionWithUserEnd = communiactionWithUserEnd;
    }

    public boolean reactForAnswerFromUser(String answerFromUser) {

        switch (answerFromUser) {
            case "-AC": {
                addCustomer();
                break;
            }
            case "-AT": {
                addTrip();
                break;
            }
            case "-TC": {
                assign();
                break;
            }
            case "-RC": {
                removeCustomer();
                break;
            }
            case "-RT": {
                removeTrip();
                break;
            }
            case "-SC": {
                showCustomers();
                break;
            }
            case "-ST": {
                showTrips();
                break;
            }
            case "-E": {
                setCommuniactionWithUserEnd(true);
                break;
            }
            default: {
                showAnswerFromSystem("Wrong short cut, check CapsLock button and try again\n");
                break;
            }
        }
        return communiactionWithUserEnd;
    }

    private String[] splitInputData(String inputData) {
        return inputData.split(" ");
    }
}

