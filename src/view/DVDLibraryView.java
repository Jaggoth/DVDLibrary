package view;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import dto.DVD;

public class DVDLibraryView {

	private UserIOConsoleImpl io;
	
    public DVDLibraryView(UserIOConsoleImpl io) {
        this.io = io;
    }
    
    public int printMenu() {
        io.print("Main Menu");
        io.print("1. Add new DVD");
        io.print("2. Remove a DVD");
        io.print("3. Edit a DVD");
        io.print("4. List all DVDS ");
        io.print("5. Display DVD information");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.");
    }
    
    public void printCreateDVDHeader() {
        io.print("=== Create DVD ===");
    }
    
    public DVD createDVDFromInput() {
        String title = io.readString("Enter the DVD title");
        LocalDate releaseDate = io.readDate("Enter the DVD release date");
        String MpaaRating = io.readString("Enter the MPAA rating");
        String directorName = io.readString("Enter the director's name");
        String userNote = io.readString("Enter your notes for the DVD");
        String studio = io.readString("Enter the DVD studio");

        DVD currentDVD = new DVD(null);
        currentDVD.setTitle(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMpaaRating(MpaaRating);
        currentDVD.setDirectorName(directorName);
        currentDVD.setUserNote(userNote);
        currentDVD.setStudio(studio);
        return currentDVD;
    }
    
    public void printCreateDVDFooter() {
        io.readString("DVD successfully created. Hit enter to continue");
    }
    
    public void printDVDLibraryHeader() {
    	io.print("=== Display all DVDs ===");
    }
    
    public void printDVDLibrary(List<DVD> dvdList) {
        String dvdHeadings = String.format("%25s | %25s | %10s | %25s | %25s | %10s",
                "Title",
                "Release Date",
                "MPAA",
                "Director Name",
                "Note",
                "Studio");
        io.print(dvdHeadings);
        io.print("--------------------------------------------------------------------------------------------------------------------------------------------------");

        for (DVD dvd: dvdList){
            String dvdInfo = String.format("%25s | %25s | %10s | %25s | %25s | %10s",
            		dvd.getTitle(),
            		dvd.getReleaseDate(),
                    dvd.getMpaaRating(),
                    dvd.getDirectorName(),
                    dvd.getUserNote(),
                    dvd.getStudio());
            io.print(dvdInfo);
        }
        io.readString("Press enter to continue");
    }
    
    public void printDVDHeader() {
    	io.print("=== Display a DVD ===");
    }
    
    public void printDvd(DVD dvd) {
        if (dvd != null) {
            io.print("=== "+ dvd.getTitle()+" Summary ===");
            io.print("Title: " + dvd.getTitle());
            io.print("Release date: " + dvd.getReleaseDate());
            io.print("MPAA rating: " + dvd.getMpaaRating());
            io.print("Director's name: " + dvd.getDirectorName());
            io.print("User note: " + dvd.getUserNote());
            io.print("Studio: "+ dvd.getStudio());
        } else {
        	printNullDvd();
        }
        io.print("Please hit enter to continue.");
        System.out.println();
    }
    
    public void printRemoveDVDHeader() {
        io.print("=== Remove DVD ===");
    }
    
    public void printRemovedResult(DVD dvd) {
        if (dvd != null) {
            io.print("DVD successfully removed.");
        } else {
        	printNullDvd();
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void printEditDVDHeader() {
        io.print("=== Edit DVD ===");
    }
    
    public int printEditMenu() {
        io.print("Which field do you want to change?");
        io.print("Edit DVD menu");
        io.print("1. Release date");
        io.print("2. MPAA rating");
        io.print("3. Director's name");
        io.print("4. User note");
        io.print("5. Studio name");
        io.print("6. Exit edit menu");
        return io.readInt("Please select from the above choices.");
    }
    
    public int getActionNum() {
        return io.readInt("Number of time for this action: ");
    }
    
    public void nextActionFooter() {
        System.out.println("=== Next ===");
    }
	
    public String getTitle() {
        return io.readString("Enter the DVD title.");
    }
    
    public void printEditReleaseDateHeader() {
        io.print("=== Edit DVD Release Date ===");
    }
    
	public LocalDate getReleaseDate() {
        return io.readDate("Enter the new DVD release date.");
    }
	
    public void printEditMpaaRatingHeader() {
        io.print("=== Edit DVD MPAA Rating ===");
    }

    public String getMpaaRating() {
        return io.readString("Entre the new user rating");
    }
    
    public void printDirectorNameHeader() {
        io.print("=== Edit DVD Director Name ===");
    }

    public String getDirectorName() {
        return io.readString("Enter the new director's name.");
    }

    public void printUserNoteHeader() {
        io.print("=== Edit DVD User Note ===");
    }
    
    public String getUserNote() {
        return io.readString("Enter the new user note.");
    }
    
    public void printStudioNameHeader() {
        io.print("=== Edit DVD Studio Name ===");
    }

    public String getStudioName() {
        return io.readString("Enter the studio name.");
    }
    
    public void printEditSuccess() {
        io.print("DVD Successfully edited.");
    }

    public void printErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
    
	public void printNullDvd() {
		io.print("That DVD does not exist. ");
	}
 
    public void printExitMessage() {
        io.print("Thank you for using our library.");
        io.print("Closing app now");
    }
    
    public void printUnknownCommandMessage() {
        io.print("Unknown command!");
    }
}
