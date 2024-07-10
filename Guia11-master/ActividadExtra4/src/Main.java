import services.CollegeService;

public class Main {
    public static CollegeService collegeService = new CollegeService();

    public static void main(String[] args) {
        //Load the lists with hardcoded data for testing and app usage.
        collegeService.loadPeople();

        //Start the app
        collegeService.mainMenu();
    }
}