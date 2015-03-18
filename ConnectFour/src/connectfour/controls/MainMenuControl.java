/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour.controls;

import connectfour.Game;
import connectfour.Player;

/**
 *
 * @author Cheryl Allred
 */
public class MainMenuControl {
    
    private static final String PLAYER_A_DEFAULT_MARKER = "R";
    private static final String PLAYER_B_DEFAULT_MARKER = "B";
    
    public Game create(String gameType){
        Game game = null;
        Player player1 = null;
        Player player2 = null;
        
        if (gameType == null){
            throw new IllegalArgumentException ("MainCommands - create: gameType is null");
        }
        
        if (gameType.equals(Game.ONE_PLAYER)){
            game = new Game(Game.ONE_PLAYER);
            player1 = new Player(Player.REGULAR_PLAYER, PLAYER_A_DEFAULT_MARKER);
            player2 = new Player(Player.COMPUTER_PLAYER, PLAYER_B_DEFAULT_MARKER);
        }
        else if (gameType.equals(Game.TWO_PLAYER)){
            game = new Game(Game.TWO_PLAYER);
            player1 = new Player(Player.REGULAR_PLAYER, PLAYER_A_DEFAULT_MARKER);
            player2 = new Player(Player.REGULAR_PLAYER, PLAYER_B_DEFAULT_MARKER);
        }
        
        game.setPlayerA(player1);
        game.setPlayerB(player2);
        
        game.setStatus(Game.CONTINUE);
        
        return game;
    }
}