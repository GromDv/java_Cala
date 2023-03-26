import controller.controller;
import view.view;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class appMain {
    public static Logger logger = Logger.getLogger(appMain.class.getName());
    public static void main(String[] args) throws IOException {

        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        Scanner sc = new Scanner(System.in);
        view mv = new view(sc);
        controller myApp = new controller(mv);

        myApp.Start();

        sc.close();
    }
}