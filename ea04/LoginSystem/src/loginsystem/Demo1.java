package loginsystem;

import loginsystem.localizer.Localizer;
import loginsystem.localizer.Messages;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class Demo1 {

    public static void main(String[] args) {
        Localizer localizer = new Localizer("hu.txt");
        try {
            TimeSheet ts = new TimeSheet(new LogParser("log.txt"), localizer);
            
            System.out.println("1. Following people are still working:");
            ts.printWhoIsPresent();
            System.out.println("=============================");
            System.out.println("2. People entered without leaving before:");
            ts.printArrivalDiscrepancies();
            System.out.println("=============================");
            System.out.println("3. System errors:");
            ts.printExitDiscrepancies();
            System.out.println("=============================");
            System.out.println("4. Erronous lines:");
            ts.printFaultyEmployees();
        } catch (FileNotFoundException ex) {
            System.err.println(localizer.getString(Messages.FILE_NOT_FOUND));
        } catch (InputMismatchException ex) {
            System.err.println(localizer.getString(Messages.INVALID_FILE_FORMAT));
        }
    }
    
}
