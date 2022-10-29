package com.module4.gdstruc;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlayerQueue playerQueue = new PlayerQueue(14);

        Scanner scanner = new Scanner(System.in);

        //Initialize the random number generators
        Random playersEnqueueing = new Random();
        Random playerIdentificationNumber = new Random();

        int playersJoining;
        int gamesStarted = 0;

        while(gamesStarted < 10)
        {
            playersJoining = playersEnqueueing.nextInt(7) + 1;  //This chooses a random number between 1 and 7

            for (int i = 0; i < playersJoining; i++)
            {
                //Creates a new player and assigns them a random ID number
                //We add the current value of i to the random ID number to make it even more random
                Player player = new Player("Player_" + (playerIdentificationNumber.nextInt(100) + i));
                playerQueue.enqueue(player);
            }

            System.out.println("Number of players who joined the queue: " + playersJoining);
            System.out.println("\nPlayers currently in queue:");
            playerQueue.printQueue();

            //Checks if there are at least 5 players in the queue
            if(playerQueue.size() >= 5)
            {
                System.out.println("\nPlayers who have now entered a game:");

                for(int i = 0; i < 5; i++)
                {
                    Player dequeuedPlayer = playerQueue.dequeue();
                    System.out.println(dequeuedPlayer);
                }

                if(playerQueue.size() == 0)     //Checks if the queue is empty after the dequeue
                {
                    System.out.println("\nThe queue is empty.");
                }
                else {
                    System.out.println("\nPlayer now first in queue: " + playerQueue.peek());
                }
                gamesStarted++;
            }

            System.out.println("\nGames started: " + gamesStarted);
            System.out.println("\nType anything or just press ENTER to continue to enqueue the next set of players");
            scanner.nextLine();     //Allows user input and scans the character/s that the user entered
        }
    }
}