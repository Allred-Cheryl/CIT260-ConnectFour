/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour.views;
import connectfour.controls.ConnectFourError;
import connectfour.models.Game;
import java.awt.Dimension;
import java.util.Scanner;
import java.io.Serializable;
        

/**
 *
 * @author Luis
 * Updated for Cohesion and Serialization by Kevin 03/07/15
 */
public class GetDimensionsView implements Serializable {
    
    private Game game;
    
    public GetDimensionsView(Game game) {
       this.game = game;
    }
        
    public Dimension getInput() {
       Scanner inFile = new Scanner(System.in);

       // prompt for the row and column numbers
       System.out.println("\n\tEnter the number of rows and columns in the board (For example: 3 3)");

       // read the row and column coordinates
       String[] valuesEntered;
       Dimension dimension = null;
       do {
           String strNoRowsColumns = inFile.nextLine(); // read in row and column
           strNoRowsColumns = strNoRowsColumns.trim(); // trim all blanks from front and end 
           strNoRowsColumns = strNoRowsColumns.replace(',', ' '); // replace commas with a blank
           valuesEntered = strNoRowsColumns.split("\\s"); // tokenize the string

           if (valuesEntered.length < 1) {
               new ConnectFourError().displayError(
                       "You must enter two numbers, the number rows and columns, "
                       + "or a \"Q\" to quit. Try again.");
               continue;
           } else if (valuesEntered.length == 1) {
               if (valuesEntered[0].toUpperCase().equals("Q")) { // Quit?
                   return null;
               }  // wrong number of values entered.

               // wrong number of values entered.
               new ConnectFourError().displayError(
                      "You must enter two numbers, the number rows and columns, "
                      + "or a \"Q\" to quit. Try again.");
               continue;
           }

           // user java regular expression to check for valid integer number 
           // for both numbers
           String regExpressionPattern = ".*\\d.*";
           if (!valuesEntered[0].matches(regExpressionPattern) ||
               !valuesEntered[1].matches(regExpressionPattern)) {
               new ConnectFourError().displayError(
                       "You must enter two numbers, the number rows and columns, "
                       + "or a \"Q\" to quit. Try again.");
               continue;
           }

           int rowsEntered = Integer.parseInt(valuesEntered[0]);
           int columnsEntered = Integer.parseInt(valuesEntered[1]);

           if (rowsEntered < 3 || rowsEntered > 10) {
           new ConnectFourError().displayError(
                   "The number of rows must be between 3 - 10 and the "
                   + "number of columns must be between 3 - 10 ");
           continue;
           }

           if (columnsEntered < 3 || columnsEntered > 10) {
               new ConnectFourError().displayError(
                       "The number of rows must be between 3 - 10 and the "
                       + "number of columns must be between 3 - 10 ");
               continue;
           }



           dimension = new Dimension(rowsEntered, columnsEntered);

       } while (dimension == null);

       return dimension;
    }
    
}

