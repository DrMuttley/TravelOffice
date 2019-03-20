import java.util.Scanner;

public class MainHandler implements UserInterface {

    private TravelOffice travelOffice = new TravelOffice();
    private Scanner scan = new Scanner(System.in);
    private boolean communiactionWithUserEnd = false;

    @Override
    public Customer addCustomer() {
        showAnswerFromSystem("Provide customer data (example: John Doe):");
        Customer customer = new Customer(getAnswerFromUser());
        travelOffice.addCustomer(customer);
        return customer;
    }

    @Override
    public Trip addTrip() {

        showAnswerFromSystem("Provide type of trip (domestic/abroad):");

        while (true) {

            switch (getAnswerFromUser()) {

                case "domestic": {
                    showAnswerFromSystem("Provide domestic trip details:");
                    DomesticTrip domesticTrip = new DomesticTrip(getAnswerFromUser());
                    showAnswerFromSystem("Provide description:");
                    travelOffice.addTrip(getAnswerFromUser(), domesticTrip);
                    return domesticTrip;
                }
                case "abroad": {
                    showAnswerFromSystem("Provide abroad trip details:");
                    AbroadTrip abroadTrip = new AbroadTrip(getAnswerFromUser());
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

        travelOffice.findCustomerByName(userName).assignTrip(travelOffice.findTripByDescription(tripDescription));
    }

    @Override
    public boolean removeCustomer() {
        showAnswerFromSystem("Provide name of customer:");
        return travelOffice.removeCustomer(travelOffice.findCustomerByName(getAnswerFromUser()));
    }

    @Override
    public boolean removeTrip() {
        showAnswerFromSystem("Provide trip description:");
        return travelOffice.removeTrip(getAnswerFromUser());
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
                showAnswerFromSystem("Wrong short cut, check CapsLock button and try again: ");
                break;
            }
        }
        return communiactionWithUserEnd;
    }
}

