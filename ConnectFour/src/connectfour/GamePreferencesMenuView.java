/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import java.util.Scanner;
import java.io.Serializable;

/**
 *
 * @author Luis
 * Updated for Cohesion and Serialization by Kevin 03/07/15
 */
public class GamePreferencesMenuView extends Menu {
    Game game;
    private GamePreferencesMenuControl gamePreferenceControl = new GamePreferencesMenuControl(game);
    
        private final static String[][] menuItems = {
        {"1", "Change Marker of the first Player"},
        {"2", "Change Marker of the second Player"},
        {"D", "Change the dimensions of the board"},
        {"Q", "Return to game menu"}
    };

    public GamePreferencesMenuView(Game game) {
        this.game = game;
        gamePreferenceControl = new GamePreferencesMenuControl(game);
    }
    @Override
    public void getInput() {       
        String command;
        Scanner inFile = new Scanner(System.in);
        
        do {
            this.display();

            // get commaned entered
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
            switch (command) {
                case "1":
                    this.gamePreferenceControl.getMarker(this.game.playerA);
                    break;
                case "2":
                    this.gamePreferenceControl.getMarker(this.game.playerB);
                    break;
                case "D":
                    this.gamePreferenceControl.getDimensions();
                    break;
                case "Q":
                    break;
                default: 
                    new ConnectFourError().displayError("Invalid command. Please enter a valid command.");
                    continue;
            }
        } while (!command.equals("Q"));

    }
           
}
