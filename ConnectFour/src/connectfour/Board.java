/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;
import java.awt.Point;
/**
 *
 * @author Erin
 */
public class Board {
    
    int rowCount = 6;
    int columnCount = 7;
    
    private String name;
    private Point boardDimensions = new Point();
    private Player[][] boardLocations;
    
   public Board() {
   } 

    public Board(int noRows, int noColumns) {
        this.boardDimensions.setLocation(noRows, noRows);
        this.boardLocations = new Player[noRows][noColumns];
    }
    public void clearTheBoard() {
        for (int i = 0; i< this.boardLocations.length; i++) {
                Player[] rowlocations = this.boardLocations[i];
                for (int j = 0; j < rowlocations.length; j++){
                    rowlocations[j]=null;
                }
        }
    }

       public void occupyLocation(Player player, int row, int column) {
        Player playerAtLocation = this.boardLocations[row][column];

        if (playerAtLocation != null) { // location already occupied
            new ConnectFourError().displayError("This location is already occupied. "
                    + "Try a different location.");
        }
        this.boardLocations[row][column] = player;
    }

    public class Location {

        public int row;
        public int column;
        public Player player;

        Location() {
        }
    }

   public void displaySize() {
       System.out.println("\n\tThe board is " + this.rowCount + " by " + this.columnCount + " in size.");
   }
}