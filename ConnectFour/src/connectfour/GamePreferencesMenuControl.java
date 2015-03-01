/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

import java.awt.Dimension;


/**
 *
 * @author Luis
 */
public class GamePreferencesMenuControl {
    private Game game;
    
    public GamePreferencesMenuControl(Game game){
            this.game = game;
    
    }
    public Game getGame(){
        return game;
    }
    
    
    public void getMarker(Player player){
        GetMarkerView getMarkerView = new GetMarkerView(this.game);
        String marker = getMarkerView.getInput(player);
        
        if (marker == null){
            return;
        }
        
        player.marker = marker;
        
        return;
    }
    
    public void getDimensions(){
        
        if(this.game.status.equals(Game.PLAYING)){
            new ConnectFourError().displayError("You can not change "
            + "dimensions once game has started. "
            + "\nBegin new game to change dimensions. ");
            return;
        }
        
        GetDimensionsView getDimensionsView = new GetDimensionsView(this.game);
        Dimension dimension = getDimensionsView.getInput();
        if (dimension == null){
            return;
        }
        
        int boardRowCount = dimension.width;
        int boardColumnCount = dimension.height;
        
        if (boardRowCount == this.game.board.getRowCount() &&
            boardColumnCount == this.game.board.getColumnCount()){
            return;
        }
        
        Player[][] boardLocations = new Player[boardRowCount][boardColumnCount];
        this.game.board.getBoardDimensions().setLocation(boardRowCount,boardRowCount);
        this.game.board.setBoardLocations(boardLocations);
        
        return;
        
    }
}
