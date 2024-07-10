package entities;

public class Movie {
    private String title;
    private String genre;
    private int releaseYear;
    private int runtimeInMinutes;
    private boolean isRented;

    public Movie() {
    }
    public Movie(String title, String genre, int releaseYear, int runtimeInMinutes, boolean isRented) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.runtimeInMinutes = runtimeInMinutes;
        this.isRented = isRented;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    public int getRuntimeInMinutes() {
        return runtimeInMinutes;
    }
    public void setRuntimeInMinutes(int runtimeInMinutes) {
        this.runtimeInMinutes = runtimeInMinutes;
    }
    public boolean isRented() {
        return isRented;
    }
    public void setRented(boolean rented) {
        isRented = rented;
    }
}
