package dao;

import java.time.LocalDate;
import java.util.List;

import dto.DVD;

public interface DVDLibraryDAO {

    DVD addDVD(String title, DVD dvd);

    DVD removeDVD(String title);

    DVD changeReleaseDate(String title, LocalDate releaseDate);

    DVD changeMpaaRating(String title, String mpaaRating);

    DVD changeDirectorName(String title, String directorName);

    DVD changeStudioName(String title, String studioName);
    
    DVD changeUserNote(String title, String newUserNote);

    List<DVD> getAllDVDs ();

    DVD getDVD(String title);
}
