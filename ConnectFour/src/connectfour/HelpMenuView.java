/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connectFour;

import java.util.Scanner;



/**
 *
 * @author Cheryl Allred
 */
public class HelpMenuView  {
        
    private final static String[][] menuItems = {
        // menu items
        {"B", "The board"},
        {"C", "A computer player"}, 
        {"G", "Connect 4 game"},
        {"L", "A location"},
        {"M", "A marker"},
        {"R", "A regular player"},        
        {"Q", "Quit Help"}        
    };
    
    // Create instance of the HelpMenuControl (action) class
    private HelpMenuControl helpMenuControl = new HelpMenuControl();
    
    // default constructor
    public HelpMenuView() {
        
    } 
    
    // A function to get the player's input selection
    public void getInput() {       
              
        String command;
        Scanner inFile = new Scanner(System.in);
        
        do {
            
            this.display(); // display the menu
            
            // get commaned entered
            command = inFile.nextLine();
            command = command.trim().toUpperCase();
            //A function to validate that the selection entered was valid
            switch (command) {
                case "B":
                    this.helpMenuControl.displayBoardHelp();
                    break;
                case "C":
                    this.helpMenuControl.displayComputerPlayerHelp();
                    break;
                case "G":
                    this.helpMenuControl.displayGameHelp();
                    break;                  
                case "L":
                    this.helpMenuControl.displayLocationHelp();
                    break;
                case "M":
                    this.helpMenuControl.displayMarkerHelp();
                    break;
                 case "R":
                    this.helpMenuControl.displayRealPlayerHelp();
                    break; 
                case "Q": 
                    break;
                default: 
                    new ConnectFourError().displayError("Invalid command. Please enter a valid command.");
                    continue;
            }
        } while (!command.equals("Q"));  
        
         return;
    }

        // A function to display the help menu
    public final void display() {
        System.out.println("\n\t===============================================================");
        System.out.println("\tEnter the letter associated with one of the following commands:");

        for (String[] menuItem : HelpMenuView.menuItems) {
            System.out.println("\t   " + menuItem[0] + "\t" + menuItem[1]);
        }
        System.out.println("\t===============================================================\n");
    }
  
}

