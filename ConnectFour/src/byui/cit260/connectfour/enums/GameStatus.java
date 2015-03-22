/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.connectfour.enums;

/**
 *
 * @author Ben
 */
public enum GameStatus {
    NEWGAME("Starting a new game"),
    CONTINUE("Continuing a previously saved game"),
    PLAYING("The game is in process..."),
    WIN("You have won the game!"),
    TIE("The game is a tie"),
    QUIT("You are quitting the game"),
    ERROR("An error ocurred"),
    EXIT("Exiting the program");
    
    String message;
    
    private GameStatus(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void display() {
        System.out.println(this.message);
    }
}
