public class Game {
    public static final int MAX_MISSES = 7;
    private String mAnswer;
    private String mHits;
    private String mMisses;

    public Game(String answer){
        mAnswer = answer;
        mHits = "";
        mMisses = "";
    }

    public boolean applyGuess(char letter){
        if (mMisses.indexOf(letter) != -1 || mHits.indexOf(letter) != -1){
            throw new IllegalArgumentException(letter + " has already been guessed");
        }
        boolean isHit = mAnswer.indexOf(letter) != -1;
        if (isHit){
            mHits += letter;
        } else {
            mMisses += letter;
        }
        return isHit;
    }

    public int getRemainingTries(){
        return MAX_MISSES - mMisses.length();
    }

    public String getCurrentProgress(){
        String progress = "";
        for (char letter : mAnswer.toCharArray()){
            char display = '-';
            if (mHits.indexOf(letter) != -1){
                display = letter;
            }
            progress += display;
        }
        return progress;
    }
}
