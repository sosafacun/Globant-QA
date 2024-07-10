package services;

import entities.Movie;
import entities.Rent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class RentService {
    Scanner read = new Scanner(System.in);
    MovieService mService = new MovieService();

    /* This is for normal input.
    Change the rentMenu > switch > case1 to
    rentList.add(rService.rentMovies(movieList)) */

//    public Rent rentMovies(ArrayList<Movie> movies) {
//        Rent rent = new Rent();
//        ArrayList<Movie> bufferMovieList = new ArrayList<>();
//
//        System.out.println("Enter your name: ");
//        rent.setRenterName(read.nextLine());
//
//        System.out.println("=*=*=*=*=LIST OF AVAILABLE MOVIES*=*=*=*=");
//        mService.listAvailableMovies(movies);
//        System.out.println("-----------------------------------------");
//        System.out.println("Enter the movie codes to select a movie for rent");
//        System.out.println("When you're done, press 'Q' to exit.");
//        System.out.println("-----------------------------------------");
//
//        String opt = read.nextLine();
//        int i = Integer.parseInt(opt);
//        while (!opt.equalsIgnoreCase("Q") &&
//                i>=0 &&
//                i < movies.size()){
//
//            if (!movies.get(i).isRented()) {
//                System.out.println(movies.get(i).getTitle() + " has been added to your rent list!");
//                movies.get(i).setRented(true);
//                bufferMovieList.add(movies.get(i));
//            } else {
//                System.out.println("The code is incorrect or the movie is not available!");
//                System.out.println("Please, try again.");
//            }
//            opt = read.nextLine();
//            i = Integer.parseInt(opt);
//        }
//
//        rent.setRentedMovies(bufferMovieList);
//        LocalDate now = LocalDate.now();
//        rent.setStartRentingDate(now);
//
//        return rent;
//    }

    /*Testing only*/
    public ArrayList<Rent> createRents (ArrayList<Movie> movieList){
        ArrayList<Rent> rentList = new ArrayList<>();
        ArrayList<Movie> rentedMovieList1 = new ArrayList<>();
        ArrayList<Movie> rentedMovieList2 = new ArrayList<>();
        ArrayList<Movie> rentedMovieList3 = new ArrayList<>();


        rentedMovieList1.add(movieList.get(0));
        rentedMovieList1.add(movieList.get(3));
        rentedMovieList1.add(movieList.get(6));
        movieList.get(0).setRented(true);
        movieList.get(3).setRented(true);
        movieList.get(6).setRented(true);
        Rent rent1 = new Rent("Kiwi", rentedMovieList1, LocalDate.parse("2023-07-06"), LocalDate.parse("2023-10-06"));
        rentList.add(rent1);

        rentedMovieList2.add(movieList.get(1));
        rentedMovieList2.add(movieList.get(8));
        movieList.get(1).setRented(true);
        movieList.get(8).setRented(true);
        Rent rent2 = new Rent("Facundo", rentedMovieList2, LocalDate.parse("2023-05-06"), LocalDate.parse("2023-05-08"));
        rentList.add(rent2);

        rentedMovieList3.add(movieList.get(2));
        rentedMovieList3.add(movieList.get(7));
        rentedMovieList3.add(movieList.get(4));
        movieList.get(2).setRented(true);
        movieList.get(7).setRented(true);
        movieList.get(4).setRented(true);
        Rent rent3 = new Rent("Felicitas", rentedMovieList3, LocalDate.parse("2023-06-06"), LocalDate.parse("2023-06-10"));
        rentList.add(rent3);

        return rentList;
    }
    public void listRents(ArrayList<Rent> rentList){
        System.out.println("-----------------------------------------");
        System.out.println("=*=*=*=*=*=*=*=*=RESULTS=*=*=*=*=*=*=*=*=");

        for(int i = 0; i < rentList.size(); i++){
            System.out.println("- Rent Code-|-----------Renter Name------");
            System.out.println("\t"+i +"\t\t| " + rentList.get(i).getRenterName());
            System.out.println("--------------RENTED MOVIE(S)------------");
            for(int j = 0 ; j < rentList.get(i).getRentedMovies().size(); j++){
                System.out.println("=> "+ rentList.get(i).getRentedMovies().get(j).getTitle());
            }
            System.out.println("-----------------------------------------");
            System.out.println("Starting Date: " + rentList.get(i).getStartRentingDate() + "\t|\t Return Date: " + rentList.get(i).getReturnDate());
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
        }
    }

}