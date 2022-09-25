package view;

import java.time.LocalDate;

public interface UserIO {
    void print(String msgToPrint);

    String readString(String msgToPrint);

    int readInt(String intToRead);

    LocalDate readDate(String localDateToRead);
}
