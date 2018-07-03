import java.util.Random;

public class Game {
    public static final int MAX_MISSES = 7;
    private String answer;
    private String hits;
    private String misses;

    public Game(){
        answer = getWord();
        hits = "";
        misses = "";
    }

    public String getAnswer() {
        return answer;
    }

    private char normalizeGuess(char letter){
        if (!Character.isLetter(letter)){
            throw new IllegalArgumentException("A letter is required");
        }
        letter = Character.toLowerCase(letter);
        if (misses.indexOf(letter) != -1 || hits.indexOf(letter) != -1){
            throw new IllegalArgumentException(letter + " has already been guessed");
        }
        return letter;
    }

    public boolean applyGuess(char letter){
        letter = normalizeGuess(letter);
        boolean isHit = answer.indexOf(letter) != -1;
        if (isHit){
            hits += letter;
        } else {
            misses += letter;
        }
        return isHit;
    }

    public int getRemainingTries(){
        return MAX_MISSES - misses.length();
    }

    public String getCurrentProgress(){
        String progress = "";
        for (char letter : answer.toCharArray()){
            char display = '-';
            if (hits.indexOf(letter) != -1){
                display = letter;
            }
            progress += display;
        }
        return progress;
    }

    private String getWord(){
        Random random = new Random();
        String[] words = {"Awkward",
                "Bagpipes",
                "Banjo",
                "Bungler",
                "Croquet",
                "Crypt",
                "Dwarves",
                "Fervid",
                "Fishhook",
                "Fjord",
                "Gazebo",
                "Gypsy",
                "Haiku",
                "Haphazard",
                "Hyphen",
                "Ivory",
                "Jazzy",
                "Jiffy",
                "Jinx",
                "Jukebox",
                "Kayak",
                "Kiosk",
                "Klutz",
                "Memento",
                "Mystify",
                "Numbskull",
                "Ostracize",
                "Oxygen",
                "Pajama",
                "Phlegm",
                "Pixel",
                "Polka",
                "Quad",
                "Quip",
                "Rhythmic",
                "Rogue",
                "Sphinx",
                "Squawk",
                "Swivel",
                "Toady",
                "Twelfth",
                "Unzip",
                "Waxy",
                "Wildebeest",
                "Yacht",
                "Zealous",
                "Zigzag",
                "Zippy",
                "Zombie"};
        return answer = words[random.nextInt(words.length)].toLowerCase();
    }

    public boolean isWon(){
        return getCurrentProgress().indexOf('-') == -1;
    }
}
