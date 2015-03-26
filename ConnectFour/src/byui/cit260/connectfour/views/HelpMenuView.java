/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.connectfour.views;

import byui.cit260.connectfour.controls.ConnectFourError;
import byui.cit260.connectfour.controls.HelpMenuControl;
import byui.cit260.connectfour.exceptions.MenuException;
import java.util.Scanner;

/**
 *
 * @author Ben
 */
public class HelpMenuView extends Menu {
          
    public static final String BOARD = "BOARD";
    public static final String GAME = "GAME";
    public static final String REAL_PLAYER = "REAL_PLAYER";
    public static final String COMPUTER_PLAYER = "COMPUTER_PLAYER";
    public static final String LOCATION = "LOCATION";
    public static final String MARKER = "MARKER";
    
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
           try {
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
           }
            catch (ConnectFourException e) {
                    System.out.println("\n" + e.getMessage());
            }
        } while (!command.equals("Q"));  
        
    }
     private void displayHelp(String helpType) {

        String helpText = null;
        switch (helpType) {
            case HelpMenuView.BOARD: helpText = 
                "\tThe game board for Connect Four. It consist of a grid of "
                + "\n\tlocations. Players place there marker in the different columns "
                + "\n\ton the board in an effort to win the game. The default board is "
                + "\n\t6 rows by 7 columns.";
                break;
                
            case HelpMenuView.GAME: helpText = 
                "\tThe objective of the game is to be the first player to mark four "
                + "\n\tsquares vertically, horizontally or diagonally. Each player takes "
                + "\n\tturns placing their marker in one of the locations on the "
                + "\n\tboard. The first player to get \"four-in-a-row\" is the winner.";
                break; 
                
            case HelpMenuView.REAL_PLAYER: helpText = 
                "\tA real player manually takes their turn by placing their mark "
                + "\n\tin an unused location on the board.";
                break;
                
            case HelpMenuView.COMPUTER_PLAYER: helpText = 
                "\tA computer based player utomatically takes its turn "
                + "\n\timmediatly after a real player in a single player game.";
                break;
                
            case HelpMenuView.LOCATION: helpText = 
                "\tA location on the board where a player can place their marker";
                break;
                
            case HelpMenuView.MARKER: helpText = 
                "\tA symbol that \"marks\" the locations in the board that are occupied "
                + "by a player. "
                + "\n\tThe default markers are \"B\" and \"R\".";
                break;
        }   
        
        StringBuilder dividerLine = new StringBuilder(80);
        for (int i = 0; i < 80; i++) {
            dividerLine.insert(i, '~');
        }
        
        System.out.println("\t" + dividerLine.toString());
        System.out.println(helpText);
        System.out.println("\t" + dividerLine.toString());
    }
    }
