/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour.models;
import connectfour.controls.ConnectFourError;
import java.awt.Point;
import java.io.Serializable;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Erin
 */
public class Board extends AbstractTableModel implements Serializable {
    
    public int rowCount;
    public int columnCount = 7;
    
    private String name;
    public Point boardDimensions = new Point();
    public Player[][] boardLocations;
    
   public Board() {
        this.rowCount = 6;
   } 

    public Board(int noRows, int noColumns) {
        this.rowCount = 6;
        this.boardDimensions.setLocation(noRows, noRows);
        this.boardLocations = new Player[noRows][noColumns];
    }
    
    public Point getBoardDimensions(){
        return boardDimensions;
    }
    
    public void setBoardDimensions(Point boardDimensions){
        this.boardDimensions = boardDimensions;
    }
    
    public Player[][] getBoardLocations(){
        return boardLocations;
    }
    
    public void setBoardLocations(Player[][] boardLocations){
        this.boardLocations = boardLocations;
    }
    
    @Override
    public int getRowCount(){
        return(int) this.boardDimensions.getX();
    }
    
    @Override
    public int getColumnCount(){
        return(int) this.boardDimensions.getY();
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        return boardLocations[rowIndex][columnIndex];
    }
    
    public Player getPlayerAt(int row, int column){
        return this.boardLocations[row][column];
    }
    
    
    
    public void clearTheBoard() {
        for (int i = 0; i< this.boardLocations.length; i++) {
                Player[] rowlocations = this.boardLocations[i];
                for (int j = 0; j < rowlocations.length; j++){
                    rowlocations[j]=null;
                }
        }
    }

    public boolean locationOccupied(Point location){
        int row = location.x;
        int column = location.y;
        
        if(this.boardLocations[row][column] != null){
            return true;
        }
        else {
            return false;
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
        public String value;
        public Player player;

        Location() {
        }
    
    
    int getRow(){
        return row;
    }

    void setRow(int row){
        this.row = row;
    }
    
    int getColumn(){
        return column;
    }
    
    void setColumn(int column){
        this.column = column;
    }
    
    String getValue(){
        return value;
    }
    
    void setValue(){
        this.value = value;
    }
    
    Player getPlayer(){
        return player;
    }
    
    public void setPlayer(Player player){
        this.player = player;
    }
    
    String[] getCoordinates(){
        String[] coordinates = new String[2];
        Integer intRow = this.getRow() + 1;
        Integer intColumn = this.getColumn() + 1;
        coordinates[0] = intRow.toString();
        coordinates[1] = intColumn.toString();
        return coordinates;
    }
    }
}