/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;
import java.awt.Point;
import java.util.Scanner;
import java.io.Serializable;


    
/**
 *
 * @author Cheryl Allred
 */
public class GetLocationView {
    private Game game;
    
    public GetLocationView(Game game) {
        this.game = game;
    }
    public Point getInput(){
        Scanner inFile = new Scanner(System.in); // get input file 

        String[] coordinates;
        Point location = null;
        
        boolean valid = false;
        
        while(!valid){
            System.out.println("\n\n\t" + this.game.currentPlayer.name + " it is your turn."
                + " Enter a row and column number (For example: 1 3)");
        
            String strRowColumn = inFile.nextLine(); // read in row and column
            strRowColumn = strRowColumn.trim(); // trim all blanks from front and end 
                
            strRowColumn = strRowColumn.replace(',', ' '); // replace commas with a blank
            coordinates = strRowColumn.split("\\s"); // tokenize the string

            if (coordinates.length < 1) { // no coordinates specified
                new ConnectFourError().displayError(
                        "You must enter two numbers, a row and the column, "
                        + "or a \"Q\" to quit. Try again.");
                continue;
            }    

            else if (coordinates.length == 1) { // only one coordinate
                if (coordinates[0].toUpperCase().equals("Q")) { // Quit?
                    return null;
                } else { // wrong number of values entered.
                    new ConnectFourError().displayError(
                        "You must enter two numbers, a row and the column, "
                        + "or a \"Q\" to quit. Try again.");
                    continue;
                }
            }

            // user java regular expression to check for valid integer number?
            String regExpressionPattern = ".*\\d.*";
            if (!coordinates[0].matches(regExpressionPattern) ||
                !coordinates[1].matches(regExpressionPattern)) {
                new ConnectFourError().displayError(
                        "You must enter two numbers, the number rows and columns, "
                        + "or a \"Q\" to quit. Try again.");
                continue;
            }
            
            // convert each of the cordinates from a String type to 
            // an integer type
            int row = Integer.parseInt(coordinates[0]);
            int column = Integer.parseInt(coordinates[1]);
                     
            Board board = this.game.board; // get the game board
            
            // Check for invalid row and column entered
            if (row < 1   ||  row > board.getRowCount() ||
                column < 1  ||  column > board.getColumnCount()) {
                new ConnectFourError().displayError(
                        "Enter a valid number of rows and columns from 3 to 10. Try again.");
                continue;
            }
            
            // create a Point object to store the row and column coordinates in
            location = new Point(row-1, column-1);
            
            // check to see if the location entered is already occupied
            if (board.locationOccupied(location)) {
                new ConnectFourError().displayError(
                    "The current location is taken. Select another location");
                continue;
            }

            valid = true; // a valid location was entered

        } 
        
        return location;
            
    }

}
