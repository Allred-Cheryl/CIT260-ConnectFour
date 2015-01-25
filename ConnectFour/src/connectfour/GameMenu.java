// @author Kevin Powell

package connectfour;

class GameMenu {
        
    public static void main(String[] args) {
        String textIntro = "Please choose an option";
        String textNewGame = "Start New Game";
        String textExit = "Exit Game";
        
        displayMenuText(textIntro);
        displayMenuText(textNewGame);
        displayMenuText(textExit);
    }
    
    public static void displayMenuText(String text) {
        System.out.println(text);
    }
}
