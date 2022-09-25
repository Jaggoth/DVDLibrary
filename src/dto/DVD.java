package dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class DVD implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
    private String title;
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate releaseDate;
    private String mpaaRating;
    private String directorName;
    private String userNote;
    private String studio;
    
	public DVD() {}
    
	public DVD(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "DVD {title=" + title + ", releaseDate=" + releaseDate + ", mpaaRating=" + mpaaRating
				+ ", directorName=" + directorName + ", userNote=" + userNote + ", studio=" + studio + "}";
	}

	@Override
	public int hashCode() {
		return Objects.hash(directorName, mpaaRating, releaseDate, studio, title, userNote);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DVD other = (DVD) obj;
		return Objects.equals(directorName, other.directorName)
				&& Objects.equals(mpaaRating, other.mpaaRating) && Objects.equals(releaseDate, other.releaseDate)
				&& Objects.equals(studio, other.studio) && Objects.equals(title, other.title)
				&& Objects.equals(userNote, other.userNote);
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the releaseDate
	 */
	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate the releaseDate to set
	 */
	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * @return the mpaaRating
	 */
	public String getMpaaRating() {
		return mpaaRating;
	}

	/**
	 * @param mpaaRating the mpaaRating to set
	 */
	public void setMpaaRating(String mpaaRating) {
		this.mpaaRating = mpaaRating;
	}

	/**
	 * @return the directorName
	 */
	public String getDirectorName() {
		return directorName;
	}

	/**
	 * @param directorName the directorName to set
	 */
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	/**
	 * @return the userNote
	 */
	public String getUserNote() {
		return userNote;
	}

	/**
	 * @param userNote the userNote to set
	 */
	public void setUserNote(String userNote) {
		this.userNote = userNote;
	}

	/**
	 * @return the studio
	 */
	public String getStudio() {
		return studio;
	}

	/**
	 * @param studio the studio to set
	 */
	public void setStudio(String studio) {
		this.studio = studio;
	}
    
    
}
