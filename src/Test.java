
public class Test {

    public static void main(String[] args) {

        MainHandler mainHandler = new MainHandler();
        mainHandler.showMenu();
        while(!mainHandler.reactForAnswerFromUser(mainHandler.getAnswerFromUser())){
            mainHandler.showMenu();
        }
    }
}
