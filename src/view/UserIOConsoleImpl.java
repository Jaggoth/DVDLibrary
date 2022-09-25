package view;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
	
	final private Scanner in = new Scanner(System.in);

	@Override
	public void print(String msgToPrint) {
		System.out.println(msgToPrint);
		
	}

	@Override
	public String readString(String msgToPrint) {
        System.out.println(msgToPrint);
        return in.nextLine();
	}

	@Override
	public int readInt(String intToRead) {
        boolean inputIsValid = false;
        int num = 0;

        while(!(inputIsValid)) {
            try {
                String numAsString = this.readString(intToRead);

                num = Integer.parseInt(numAsString);
                inputIsValid = true;
            } catch (NumberFormatException e) {
                this.print("Error: Please enter an integer(42)");
            }
        }

        return num;
	}

	@Override
	public LocalDate readDate(String localDateToRead) {
        LocalDate date = null;
        boolean inputIsValid = false;
        
        String dateAsString = this.readString(localDateToRead + "/nPlease input date in the format 'YYYY-MM-DD'");
        
        while(!(inputIsValid)) {
        	
        	 try {
             	date = LocalDate.parse(dateAsString);
            	inputIsValid = true;
             } catch (DateTimeException e) {
                 this.print("Error: Please input date in the format 'YYYY-MM-DD'");
             }
  

        }
        return date;
	}
}
