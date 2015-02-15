/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

/**
 *
 * @author Cheryl Allred
 */
public class BoardView {
    
    
    Board board;
    
    public Object displayBoard(Object object) {
        this.board = (Board) object;
        this.printHeadRow();
        this.printDividerRow;
        for (int i = 0;i < this.board.getRowCount();i++){
            Player[] rowOfLocations = this.board.getBoardLocations()[i];
            this.PrintRow(i+1, rowOfLocations);
            this.printDividerRow();
        }
        System.out.println();
         
        return null;
    }

    

}