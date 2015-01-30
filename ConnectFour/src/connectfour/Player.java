/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

/**
 *
 * @author Luis Peck
 */
public class Player {
    String name;
    String playerType;
    long wins = 0;
    long losses = 0;
    String marker;
    
    
    public Player(){
    }
    
    
    public void displayName(){
        System.out.println("I have " + wins + "wins and " + losses + "losses.\r\n");
    }
    public String getWinningStatistics(long wins, long losses, long ties){
        
        char oneHundred = 100;
        
        if (wins < 0){
            System.out.println("The number of wins must be "
                    + "greater than or equal to zero.\r\n");
            return "-1";
        }
        
        if (losses < 0){
            System.out.println("The number of losses must be "
                    + "greater than or equal to zero.\r\n");
            return "-1";
        }
 
        if (ties < 0){
            System.out.println("The number of ties must be "
                    + "greater than or equal to zero.\r\n");
            return "-1";
        } 
        
        double totalScore = wins + losses + ties;
        
        if (totalScore==0){
            return "0";
        }
        
        double winRatio = wins/totalScore * oneHundred;
        
        String playerStatistics = "You have" + wins + "wins, "+ losses+" losses"
                    + " and " + ties + "ties. Your win ratio is " + winRatio + "r\n";
        
        return playerStatistics;
        }
    
    }
   
