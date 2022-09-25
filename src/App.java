import controller.DVDLibraryController;
import dao.DVDLibraryDAOFileImpl;
import view.DVDLibraryView;
import view.UserIOConsoleImpl;

public class App {

	public static void main(String[] args) {
        UserIOConsoleImpl io = new UserIOConsoleImpl();
        DVDLibraryView view = new DVDLibraryView(io);
        DVDLibraryDAOFileImpl dao = new DVDLibraryDAOFileImpl();
        DVDLibraryController controller = new DVDLibraryController(view, dao);

        controller.run();
	}

}
