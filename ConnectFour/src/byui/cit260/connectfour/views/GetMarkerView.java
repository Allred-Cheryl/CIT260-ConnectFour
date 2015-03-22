/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Test Matrix at https://docs.google.com/document/d/1w9v48zJN81IyLJq5gkpEoRZmjPCXXgMBTYZF0ze99TY/edit?usp=sharing
package connectfour.views;
import connectfour.controls.ConnectFourError;
import connectfour.models.Game;
import connectfour.models.Player;
import java.util.Scanner;
import java.io.Serializable;
/**
 *
 * @author Cheryl Allred
 */
public class GetMarkerView {
    
    private Game game; 
    
    /*
     * default constructor
     */
    public GetMarkerView(Game game) {
        this.game = game;
        
    } 
    
    public String getInput(Player player) {

        String newMarker = null;
        Scanner in = new Scanner(System.in);
                
        boolean valid = false; // flag to indicate if valid character entered
        while (!valid) {
            // prompt for input
            System.out.println("\n\t" + player.name 
                    + ", enter a single character that will be used to mark "
                    + "your squares in the game.");
            
            // get input from user           
            newMarker = in.nextLine();
           
            // no marker entered?
            if (newMarker == null  || newMarker.length() < 1) {
                new ConnectFourError().displayError(
                        "Please enter a character");
                continue;
            }
            
            // grab only the first character and convert it to upper case
            newMarker = newMarker.substring(0, 1).toUpperCase();
            
            if (newMarker.equals("Q")) { // Quit?
                new ConnectFourError().displayError(
                        "Please enter a different character");
                return null;
            }
            
            // Check to see if the marker is already in use
            if (this.game.playerA.marker.equals(newMarker) ||
                this.game.playerB.marker.equals(newMarker) ) {
               new ConnectFourError().displayError(
                        "This marker is currently in use. " +
                        "Select a different character");
               continue; 
            }
            
            valid = true; // signal that a valid marker was entered
        }
        
        return newMarker;
    }
    
}
