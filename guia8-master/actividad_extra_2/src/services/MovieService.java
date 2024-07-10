package services;

import entities.Movie;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieService {
    Scanner read = new Scanner(System.in);

    public ArrayList<Movie> createMovie(ArrayList<Movie> movieList){
        boolean exit = false;
        String opt;

        while (!exit){

            System.out.println("Add movie? Y = Yes / N = No");
            opt = read.nextLine();

            if (opt.equalsIgnoreCase("y")){
                Movie m = new Movie();

                System.out.println("Movie Title: ");
                m.setTitle(read.nextLine());

                System.out.println("Movie Genre: ");
                m.setGenre(read.nextLine());

                System.out.println("Movie Release Year: ");
                m.setReleaseYear(Integer.parseInt(read.nextLine()));

                System.out.println("Movie Duration (in minutes): ");
                m.setRuntimeInMinutes(Integer.parseInt(read.nextLine()));

                m.setRented(false);

                movieList.add(m);
            } else {
                exit = true;
            }

        }

        return movieList;
    }
    public ArrayList<Movie> createMovie(){

        ArrayList<Movie> movie = new ArrayList<>();
        /*  THIS IS THE REAL CODE. IT WORKS.
            This is for normal input.
            Change the movieMenu > switch > case1 to
            movieList.add(mService.createMovie(movieList)) */

//        boolean exit = false;
//        String opt;
//
//        while (!exit){
//
//            System.out.println("Add movie? Y = Yes / N = No");
//            opt = read.nextLine();
//
//            if (opt.equalsIgnoreCase("y")){
//                Movie m = new Movie();
//
//                System.out.println("Movie Title: ");
//                m.setTitle(read.nextLine());
//
//                System.out.println("Movie Genre: ");
//                m.setGenre(read.nextLine());
//
//                System.out.println("Movie Release Year: ");
//                m.setReleaseYear(Integer.parseInt(read.nextLine()));
//
//                System.out.println("Movie Duration (in minutes): ");
//                m.setRuntimeInMinutes(Integer.parseInt(read.nextLine()));
//
//                m.setRented(false);
//
//                movie.add(m);
//            } else {
//                exit = true;
//            }
//
//        }

        //THIS IS JUST FOR TESTING SO THERE ARE A BUNCH OF MOVIES LOADED

        Movie movie1 = new Movie("Harry Potter and the Philosopher's Stone",
                "Drama",
                1999,
                94,
                false);
        movie.add(movie1);

        Movie movie2 = new Movie("Harry Potter and the Chamber of Secrets",
                "Sci Fi",
                2001,
                100,
                false);
        movie.add(movie2);

        Movie movie3 = new Movie("Harry Potter and the Prisoner of Azkaban",
                "Documental",
                2003,
                120,
                false);
        movie.add(movie3);

        Movie movie4 = new Movie("The Lord of the Rings Fellowship of the Ring",
                "Fantasy",
                2000,
                150,
                false);
        movie.add(movie4);

        Movie movie5 = new Movie("The Lord of the Rings Two Towers",
                "Drama",
                2002,
                180,
                false);
        movie.add(movie5);

        Movie movie6 = new Movie("The Lord of the Rings Return of the King",
                "Adventure",
                2004,
                200,
                false);
        movie.add(movie6);

        Movie movie7 = new Movie("The Pianist",
                "Kids",
                2016,
                120,
                false);
        movie.add(movie7);

        Movie movie8 = new Movie("asdmovie",
                "Youtube",
                2004,
                23,
                false);
        movie.add(movie8);

        Movie movie9 = new Movie("Her",
                "Tragedy",
                2003,
                95,
                false);
        movie.add(movie9);

        return movie;
    }
    public void listAvailableMovies(ArrayList<Movie> mList){
        System.out.println("-----------------------------------------");
        System.out.println("=*=*=*=*=*=*=*=*=RESULTS=*=*=*=*=*=*=*=*=");
        System.out.println("-Movie Code-|----------Movie Title-------");

        for (int i = 0; i < mList.size(); i++){

            if(!mList.get(i).isRented()){
                System.out.println("\t"+i +"\t\t| " + mList.get(i).getTitle());
                System.out.println("-----------------------------------------");
            }
        }

    }
    public void searchMovieByTitle(ArrayList<Movie> mList){
        String searchQuery;

        System.out.println("What's the title you are looking for?");
        searchQuery = read.nextLine();

        System.out.println("-----------------------------------------");
        System.out.println("=*=*=*=*=*=*=*=*=RESULTS=*=*=*=*=*=*=*=*=");
        System.out.println("-Movie Code-|----------Movie Title-------");

        for (int i = 0; i < mList.size(); i++){
            if(mList.get(i).getTitle().contains(searchQuery)){
                System.out.println("\t"+i +"\t\t| " + mList.get(i).getTitle());
                System.out.println("-----------------------------------------");
            }
        }
    }
    public void searchMovieByGenre(ArrayList<Movie> mList){
        String searchQuery;

        System.out.println("What's the genre you are looking for?");
        searchQuery = read.nextLine();

        System.out.println("-----------------------------------------");
        System.out.println("=*=*=*=*=*=*=*=*=RESULTS=*=*=*=*=*=*=*=*=");
        System.out.println("-Movie Code-|----------Movie Title-------");

        for (int i = 0; i < mList.size(); i++){
            if(mList.get(i).getGenre().equalsIgnoreCase(searchQuery)){
                System.out.println("\t"+i +"\t\t| " + mList.get(i).getTitle());
                System.out.println("-----------------------------------------");
            }
        }
    }

}
