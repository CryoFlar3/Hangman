public class Hangman {
    public static void main(String[] args) {
        Game game = new Game("treehouse");
        Prompter prompter = new Prompter(game);
        while (game.getRemaingTries() > 0){
            prompter.displayProgress();
            prompter.promptForGuess();
        }
    }
}
