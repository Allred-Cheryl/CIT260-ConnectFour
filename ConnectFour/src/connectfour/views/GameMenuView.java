/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour.views;


import connectfour.ConnectFourError;
import connectfour.Game;
import connectfour.controls.GameMenuControl;
import connectfour.Menu;
import java.util.Scanner;
/**
 *
 * @author Erin
 * Updated for Cohesion and Serialization by Kevin 03/07/15
 */
public class GameMenuView extends Menu {
    
private Game game;
    private GameMenuControl gameMenuControl; 
    
    private final static String[][] menuItems = {
        {"T", "Take your turn"},
        {"D", "Display the board"},
        {"N", "New Game"},
        {"R", "Report stastics"},
        {"P", "Change game preferences"},
        {"H", "Help"},
        {"Q", "QUIT"}
    };

    public GameMenuView(Game game) {
        this.game = game;
        this.gameMenuControl = new GameMenuControl(game);
        
    }
    @Override
    public void getInput() {
   
        String command;
        Scanner inFile = new Scanner(System.in);

        do {    
            this.display(); // display the menu

            // get command entered
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
            switch (command) {
                case "T":
                    this.gameMenuControl.takeTurn();
                    break;
                case "D":
                    gameMenuControl.displayBoard();
                    break;
                case "N":
                    gameMenuControl.startNewGame();
                    break;
                case "R":
                    this.displayStatistics();
                    break;
                case "P":
                    gameMenuControl.displayPreferencesMenu();
                case "H":
                    gameMenuControl.displayHelpMenu();
                    break;
                case "Q":                   
                    break;
                default: 
                    new ConnectFourError().displayError("Invalid command. Please enter a valid command.");
                                                  
            }
        } while (!command.equals("Q"));

        
    }

      private void displayStatistics() {
        String playerAStatistics = this.game.getPlayerA().getPlayerStastics();
        String playerBStatistics = this.game.getPlayerB().getPlayerStastics();
        System.out.println("\n\t++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("\t " + playerAStatistics);
        System.out.println("\n\t " + playerBStatistics);
        System.out.println("\t+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
