import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
/*I did this in less than 30 mins. It's not as optimized as I'd like it to be.*/
public class Main {
    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        newGame();
    }
    public static void newGame() {
        int tries = 6;
        String word = pickAWord();

        Letters let = new Letters();
        ArrayList<Letters> letters = let.fillLetters(word);

        while (tries > 0) {
            showBlanksAndLetters(letters);
            if (!searchForLetter(letters)) {
                tries--;
            }
            showHangedMan(tries);
            if (winCondition(letters)) {
                break;
            }
        }
        showBlanksAndLetters(letters);
        if (tries == 0) {
            showHangedMan(tries);
            System.out.println("You've lost!");
        } else {
            System.out.println("You've won!");
        }
        System.out.println("Try again?");
        System.out.println("Y - yes");
        System.out.println("N - No");
        String opt = read.nextLine();

        if (opt.equalsIgnoreCase("Y")) {
            newGame();
        } else if (opt.equalsIgnoreCase("N")) {
            System.out.println("cya later!");
        } else {
            System.out.println("Wrong option.");
        }

    }
    public static String pickAWord() {
        ArrayList<String> wordList = new ArrayList<>();
        wordList.add("Cebra");
        wordList.add("Alcahuete");
        wordList.add("Birome");
        wordList.add("Calumnia");
        wordList.add("Indagar");
        wordList.add("Oportunidad");
        wordList.add("Guardar");
        wordList.add("Longitud");
        wordList.add("hipopotomonstrosesquipedaliofobia");

        int randomNum = ThreadLocalRandom.current().nextInt(0, 9);
        String word = wordList.get(randomNum);

        return word;
    }
    public static void showBlanksAndLetters(ArrayList<Letters> lList) {
        for (Letters letters : lList) {
            if (letters.isFound()) {
                System.out.print(letters.getLetter() + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println("");
    }
    public static boolean searchForLetter(ArrayList<Letters> lList) {
        boolean hit = false;
        System.out.println("Insert the letter you are looking for");
        String searchQuery = read.nextLine();

        for (Letters letters : lList) {
            if (letters.getLetter().equalsIgnoreCase(searchQuery)) {
                letters.setFound(true);
                hit = true;
            }
        }
        return hit;
    }
    public static void showHangedMan(int tries) {
        System.out.println("""  
                  +---+
                  |   |
                """);
        switch (tries) {
            case 6 -> System.out.println("""
                          |
                          |
                          |
                          |
                    =========
                    """);
            case 5 -> System.out.println("""
                      O   |
                          |
                          |
                          |
                    =========
                    """);
            case 4 -> System.out.println("""
                      O   |
                      |   |
                          |
                          |
                    =========
                    """);
            case 3 -> System.out.println("""
                      O   |
                     /|   |
                          |
                          |
                    =========
                    """);
            case 2 -> System.out.println("""
                      O   |
                     /|\\  |
                          |
                          |
                    =========
                    """);
            case 1 -> System.out.println("""
                      O   |
                     /|\\  |
                     /    |
                          |
                    =========
                    """);
            case 0 -> System.out.println("""
                      O   |
                     /|\\  |
                     / \\  |
                          |
                    =========
                    """);
        }
    }
    public static boolean winCondition(ArrayList<Letters> lList) {
        for (Letters letters : lList) {
            if (!letters.isFound()) {
                return false;
            }
        }
        return true;
    }
}

