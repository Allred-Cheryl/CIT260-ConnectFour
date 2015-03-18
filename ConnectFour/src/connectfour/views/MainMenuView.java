/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour.views;
import connectfour.ConnectFourError;
import connectfour.controls.MainMenuControl;
import connectfour.Menu;
import java.util.Scanner;
/**
 *
 * @author Cheryl Allred
 */
public class MainMenuView extends Menu {
    
    
    private static final String[][] menuItems = {
        {"1", "One player game"},
        {"2", "Two player game"},
        {"H", "Help"},
        {"X", "Exit Connect Four"}
    }; 
  
    private final MainMenuControl mainMenuControl = new MainMenuControl();
    
    public MainMenuView() {
        super(MainMenuView.menuItems);
    }
 
    @Override
    public void getInput() {       

        String command;
        Scanner inFile = new Scanner(System.in);
        
        do {
            this.display(); // display the menu

            // get commaned entered
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            
            switch (command) {
                case "N":
                    this.mainMenuControl.createPlayerList();
                    break;
                case "1":
                    this.mainMenuControl.startGame(1);
                    break;
                case "2":
                    this.mainMenuControl.startGame(2);
                    break;
                case "H":
                    this.mainMenuControl.displayHelpMenu();            
                    break;
                case "X":
                    break;
                default: 
                    new ConnectFourError().displayError("Invalid command. Please enter a valid command.");
            }
        } while (!command.equals("X"));

    }

} 