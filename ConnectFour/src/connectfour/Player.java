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
    
    
    public static void main(String[] args) {
        
        testGetWinningStatistics();
        
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
    
    
    public static void testGetWinningStatistics() {
        
        // test 1
        System.out.println("getWinningStatistics - Test 1");
        long wins = 2;
        long losses = 7;
        long ties = 11;
        double expResult = 10;
        Player instance = new Player();
        String result = instance.getWinningStatistics(wins, losses, ties);
        //assertEquals(expResult, result, 0.0);
        
        // test 2
        System.out.println("getWinningStatistics - Test 2");
        wins = -1;
        losses = 5;
        ties = 11;
        expResult = -999;
        result = instance.getWinningStatistics(wins, losses, ties);
        //assertEquals(expResult, result, 0.0);
        
        // test 3
        System.out.println("getWinningStatistics - Test 3");
        wins = 5;
        losses = -1;
        ties = 11;
        expResult = -999;
        result = instance.getWinningStatistics(wins, losses, ties);
        //assertEquals(expResult, result, 0.0);
        
        // test 4
        System.out.println("getWinningStatistics - Test 4");
        wins = 5;
        losses = 6;
        ties = -1;
        expResult = -999;
        result = instance.getWinningStatistics(wins, losses, ties);
        //assertEquals(expResult, result, 0.0);
        
        // test 5
        System.out.println("getWinningStatistics - Test 5");
        wins = 0;
        losses = 0;
        ties = 0;
        expResult = 0;
        result = instance.getWinningStatistics(wins, losses, ties);
        //assertEquals(expResult, result, 0.0);
        
    }
    
    }


   
