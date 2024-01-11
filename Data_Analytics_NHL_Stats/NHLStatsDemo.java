/**
 * This class reads the stats from a txt file and then displays the NHL result summary from it.
 *
 * @author Kisha Kalra - B00911426
 */

import java.util.Scanner;
import java.io.*;
public class NHLStatsDemo{
     public static void main(String[] args) throws IOException{
         // Create a Scanner object for user input
        Scanner in = new Scanner(System.in);
        // Asking the user to enter the file name
        System.out.println("Enter the file name to read from: ");
        String fileName=in.nextLine();
        // Create a File object to represent the input file
        File file =new File(fileName);
        //Create a Scanner object to read from the input file
        Scanner inputFile = new Scanner(file);
        // Create an instance of the NHLStats class to store and analyze player records
        NHLStats stats=new NHLStats();
        // Declare variables to store data for each player record
        String playerName, position,teamName,gamesPlayed,penaltyMinutes,goalShots,winningGoal;
        String goalsScored,assists;
        PlayerRecord record=null;
        // Read data from the input file and create PlayerRecord objects
        while(inputFile.hasNext()){
            playerName=inputFile.next();
            position=inputFile.next();
            teamName=inputFile.next();
            gamesPlayed=inputFile.next();
            goalsScored=inputFile.next();
            assists=inputFile.next();
            penaltyMinutes=inputFile.next();
            goalShots=inputFile.next();
            winningGoal=inputFile.next();
            // Create a PlayerRecord object and add it to the NHLStats instance
            record=new PlayerRecord(playerName,position,teamName,gamesPlayed,goalsScored,assists,
                    penaltyMinutes,goalShots,winningGoal);
            stats.add(record);
        }
        // Close the input file
        inputFile.close();
         // Perform various analyses on the player records and print the results
         System.out.println("NHL Results Summary");
         System.out.println("Players with highest points and their teams: ");
         stats.maxPoints();
         System.out.println("Most aggressive players, their teams and their positions: ");
         stats.mostAggressivePlayer();
         System.out.println("Most valuable players and their teams: ");
         stats.mvp();
         System.out.println("Most promising players and their teams: ");
         stats.promisingPlayer();
         System.out.println("Teams that had the most number of penalty minutes: ");
         stats.teamPenaltyMinutes();
         System.out.println("Teams that had the most number of game winning goals: ");
         stats.teamWinningGoals();

    }
}
