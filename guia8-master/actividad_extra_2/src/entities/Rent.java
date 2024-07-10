package entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class Rent {
    private String renterName;
    private ArrayList<Movie> rentedMovies;
    private LocalDate startRentingDate;
    private LocalDate returnDate;

    public Rent() {
    }

    public Rent(String renterName, ArrayList<Movie> rentedMovies, LocalDate startRentingDate, LocalDate returnDate) {
        this.renterName = renterName;
        this.rentedMovies = rentedMovies;
        this.startRentingDate = startRentingDate;
        this.returnDate = returnDate;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }

    public ArrayList<Movie> getRentedMovies() {
        return rentedMovies;
    }

    public void setRentedMovies(ArrayList<Movie> rentedMovies) {
        this.rentedMovies = rentedMovies;
    }

    public LocalDate getStartRentingDate() {
        return startRentingDate;
    }

    public void setStartRentingDate(LocalDate startRentingDate) {
        this.startRentingDate = startRentingDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
