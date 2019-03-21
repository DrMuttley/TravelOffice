import java.io.IOException;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.LogManager;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Test {

    public static void main(String[] args) {

        //disable the default console handler
        LogManager.getLogManager().reset();

        Logger logger = Logger.getLogger("mod12.ex01.to");


        try {
            FileHandler fileHandler = new FileHandler("log.txt");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

        } catch (IOException e) {
            e.printStackTrace();
        }


        MainHandler mainHandler = new MainHandler();
        mainHandler.showMenu();
        while(!mainHandler.reactForAnswerFromUser(mainHandler.getAnswerFromUser())){
            mainHandler.showMenu();
        }
    }
}
