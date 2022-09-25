package controller;

import java.time.LocalDate;
import java.util.List;

import dao.DVDLibraryDAOFileImpl;
import dto.DVD;
import view.DVDLibraryView;

public class DVDLibraryController {

	private DVDLibraryView view;
	private DVDLibraryDAOFileImpl dao;
	
	public DVDLibraryController(DVDLibraryView view, DVDLibraryDAOFileImpl dao) {
		this.view = view;
		this.dao = dao;
	}
	
	public void run() {
	    boolean continueUsing = true;
	    int menuSelection = 0;
	    
		while(continueUsing) {
	        menuSelection = getMenuSelection();
	
	        switch (menuSelection) {
	            case 1:
	                createDvd();
	                break;
	            case 2:
	                removeDvd();
	                break;
	            case 3:
	                editDvd();
	                break;
	            case 4:
	                listDvds();
	                break;
	            case 5:
	                getDvd();
	                break;
	            case 6:
	                continueUsing = false;
	                break;
	            default:
	                unknownCommand();
	        }
	    }
	    exitMessage();
    }
	
    private int getMenuSelection() {
        return view.printMenu();
    }
    
    private void createDvd() {

        int addingTimes = view.getActionNum();
        view.printCreateDVDHeader();
        for (int i = 0; i < addingTimes; i++) {
            DVD newDvd = view.createDVDFromInput();
            dao.addDVD(newDvd.getTitle(), newDvd);
        view.printCreateDVDFooter();
        }
    }
    
    private void removeDvd() {
        int removeTimes = view.getActionNum();
        view.printRemoveDVDHeader();

        for (int i = 0; i < removeTimes; i++) {
            String title = view.getTitle();
            DVD removedDvd = dao.removeDVD(title);
            view.printRemovedResult(removedDvd);
            if ( i < removeTimes - 1) {
              view.nextActionFooter();
            }
        }
    }
    
    private void editDvd() {
        int editingTimes = view.getActionNum();

        view.printEditDVDHeader();
        String title = view.getTitle();
        DVD dvdToEdit = dao.getDVD(title);
        if (dvdToEdit == null) {
            view.printNullDvd();
        } else {
            view.printDvd(dvdToEdit);
            for (int i = 0; i < editingTimes; i++) {
                int editMenuSelection = 0;
                boolean continueUsing = true;

                while (continueUsing) {
                    editMenuSelection = view.printEditMenu();

                    switch (editMenuSelection) {
                        case 1:
                            editReleaseDate(title);
                            break;
                        case 2:
                            editMpaaRating(title);
                        case 3:
                            editDirectorName(title);
                            break;
                        case 4:
                        	editUserNote(title);
                            break;
                        case 5:
                            editStudioName(title);
                            break;
                        case 6:
                            continueUsing = false;
                            break;
                        default:
                            unknownCommand();
                    }
                    if (continueUsing == false) {
                        break;
                    }
                }
                if (i < editingTimes - 1) {
                    view.nextActionFooter();
                }
            }
        }
    }
    
    private void editReleaseDate(String title) {
        view.printEditReleaseDateHeader();
        LocalDate newReleaseDate = view.getReleaseDate();
        dao.changeReleaseDate(title, newReleaseDate);
        view.printEditSuccess();
    }

    private void editMpaaRating(String title) {
        view.printEditMpaaRatingHeader();
        String newMpaaRating = view.getMpaaRating();
        dao.changeMpaaRating(title, newMpaaRating);
        view.printEditSuccess();
    }

    private void editDirectorName(String title) {
        view.printDirectorNameHeader();
        String newDirectorName = view.getDirectorName();
        dao.changeDirectorName(title, newDirectorName);
        view.printEditSuccess();
    }
    private void editUserNote(String title) {
    	view.printUserNoteHeader();
        String newUserNote = view.getUserNote();
        dao.changeUserNote(title, newUserNote);
        view.printEditSuccess();
    }
    private void editStudioName(String title) {
    	view.printStudioNameHeader();
        String newStudioName = view.getStudioName();
        dao.changeStudioName(title, newStudioName);
        view.printEditSuccess();
    }
    
    private void listDvds() {
        view.printDVDLibraryHeader();
        view.printDVDLibrary(dao.getAllDVDs());
    }
    
    private void getDvd() {
        view.printDVDHeader();
        String title = view.getTitle();
        DVD dvd = dao.getDVD(title);
        view.printDvd(dvd);
    }

    private void exitMessage() {
        view.printExitMessage();
    }
    
    private void unknownCommand() {
        view.printUnknownCommandMessage();
    }
}
