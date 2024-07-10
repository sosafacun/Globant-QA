import java.util.ArrayList;

class Letters{
    private String letter;
    private boolean found;

    public Letters() {
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public ArrayList<Letters> fillLetters(String word){
        ArrayList<Letters> letters = new ArrayList<>();

        for(int i = 0; i<word.length(); i++){
            Letters l = new Letters();

            l.setLetter(String.valueOf(word.charAt(i)));
            l.setFound(false);

            letters.add(l);
        }

        return letters;
    }
}