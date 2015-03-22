/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.connectfour.views;

import byui.cit260.connectfour.controls.ConnectFourError;
import byui.cit260.connectfour.controls.HelpMenuControl;
import java.util.Scanner;

/**
 *
 * @author Ben
 */
public class HelpMenuView extends Menu {
    
    public HelpMenuView() {
        super(HelpMenuView.menuItems);
    } 
    private final static String [][] menuItems = {
        // menu items
        {"B", "The board"},
        {"C", "A computer player"},
        {"G", "Connect 4 Game"},
        {"L", "A location"},
        {"M", "A marker"},
        {"R", "A regular player"},
        {"Q", "Quit Help"}       
    };
   
    public HelpMenuControl helpMenuControl = new HelpMenuControl();
    
    @Override
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
            }
        } while (!command.equals("Q"));  
        
    }
    }
