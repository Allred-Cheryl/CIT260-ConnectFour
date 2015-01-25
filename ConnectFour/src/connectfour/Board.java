/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

/**
 *
 * @author Erin
 */
public class Board {
    
    int rowCount = 6;
    int columnCount = 7;
    
   public Board() {
   } 
    
   public void displaySize() {
       System.out.println("\n\tThe board is " + this.rowCount + " by " + this.columnCount + " in size.");
   }
}