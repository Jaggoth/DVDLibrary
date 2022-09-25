package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import dto.DVD;


public class DVDLibraryDAOFileImpl implements DVDLibraryDAO {
	 private Map<String, DVD> dvds = new HashMap<>();
	 
	 private final String LIBRARY_FILE;
	 
	 public DVDLibraryDAOFileImpl () {
		 LIBRARY_FILE = "DVDLibrary.txt";
	 }
	 
	 public DVDLibraryDAOFileImpl (String textFile) {
		 LIBRARY_FILE = textFile;
	 }


	@Override
	public DVD addDVD(String title, DVD dvd) {
		loadDVDsFromFile();
		
		DVD addedDVD = dvds.put(title, dvd);
		
		writeDVDsToFile();
		
		return addedDVD;
	}

	@Override
	public DVD removeDVD(String title) {
		loadDVDsFromFile();
		
		DVD removedDvd = dvds.remove(title);
		
		writeDVDsToFile();
		
		return removedDvd;
	}

	@Override
	public DVD changeReleaseDate(String title, LocalDate releaseDate) {
		loadDVDsFromFile();
		
		DVD dvdToEdit = dvds.get(title);
        dvdToEdit.setReleaseDate(releaseDate);
        
		writeDVDsToFile();
		
		return dvdToEdit;
	}

	@Override
	public DVD changeMpaaRating(String title, String mpaaRating) {
		loadDVDsFromFile();
		
		DVD dvdToEdit = dvds.get(title);
        dvdToEdit.setMpaaRating(mpaaRating);
        
		writeDVDsToFile();
		
		return dvdToEdit;
	}

	@Override
	public DVD changeDirectorName(String title, String directorName) {
		loadDVDsFromFile();
		
		DVD dvdToEdit = dvds.get(title);
        dvdToEdit.setDirectorName(directorName);
        
		writeDVDsToFile();
		
		return dvdToEdit;
	}

	@Override
	public DVD changeStudioName(String title, String studio) {
		loadDVDsFromFile();
		
		DVD dvdToEdit = dvds.get(title);
        dvdToEdit.setStudio(studio);
        
		writeDVDsToFile();
		
		return dvdToEdit;
	}

	@Override
	public DVD changeUserNote(String title, String newUserNote) {
		loadDVDsFromFile();
		
		DVD dvdToEdit = dvds.get(title);
        dvdToEdit.setUserNote(newUserNote);
        
		writeDVDsToFile();
		
		return dvdToEdit;
	}

	@Override
	public List<DVD> getAllDVDs() {
		loadDVDsFromFile();
		return new ArrayList<DVD>(dvds.values());
	}

	@Override
	public DVD getDVD(String title) {
		loadDVDsFromFile();
		return dvds.get(title);
	}
	
	//Helper methods used by this class
	private void loadDVDsFromFile() {
		Scanner sc = null;

        try {
            // Create scanner
            sc = new Scanner(
                    new BufferedReader(new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        }

        String currentLine;
        DVD dvd;

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            dvd = unmarshalDVD(currentLine);

            dvds.put(dvd.getTitle(), dvd);
        }

        sc.close();
		
	}
	
	private void writeDVDsToFile() {
        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String dvdAsString;
        Collection<DVD> dvdList = dvds.values();
        for (DVD dvd : dvdList) {
        	dvdAsString = marshalDVD(dvd);
            out.println(dvdAsString);
            out.flush();
        }
        //Clean up
        out.close();
	}

	private String marshalDVD(DVD dvd) {
		ObjectWriter ow = new ObjectMapper().writer();
		String dvdStr = null;
		try {
			dvdStr = ow.writeValueAsString(dvd);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dvdStr;
	}
	
	private DVD unmarshalDVD(String dvdJSON) {
		ObjectMapper mapper = new ObjectMapper();
		DVD dvd = null;
		try {
			dvd = mapper.readValue(dvdJSON, DVD.class);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dvd;
	}
}
