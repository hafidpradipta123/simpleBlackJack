package org.example;

import java.util.ArrayList;
import java.util.Scanner;

import static org.example.HelperFunction.*;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Do you want to play a game of BlackJack Type 'y' to play and 'n' to pass");
            String playAgainInput = scanner.nextLine();
            if (playAgainInput.equals("y")) {
                game();
            } else {
                break;
            }
        }

    }

    public static void game() {
        Scanner scanner = new Scanner(System.in);
        ArrayList userCards = new ArrayList();
        ArrayList computerCards = new ArrayList();
        boolean endOfGame = false;


        for (int i = 0; i < 2; i++) {
            userCards.add(dealCard());
            computerCards.add(dealCard());
        }
        int userScore = 0, computerScore = 0;

        while (!endOfGame) {
             computerScore = calculateScore(computerCards);
             userScore = calculateScore(userCards);
            System.out.println("Your cards " + userCards + ", your score is " + userScore);
            System.out.printf("Computer cards is " + computerCards.get(0) + "\n");

            if (computerScore == 0 || userScore == 0 || userScore > 21) {
                endOfGame = true;
            } else{
                System.out.println("Type 'y' to get another cards and type 'n' to pass");
                String drawCard = scanner.nextLine();

                if (drawCard.equals("y")) {
                    userCards.add(dealCard());
                } else {
                    endOfGame = true;
                }
            }

        }
        while (computerScore != 0 && computerScore < 17) {
            computerCards.add(dealCard());
            computerScore = calculateScore(computerCards);

        }
        System.out.printf("YOur final hand" + userCards + ", your final score is  : " + userScore+ "\n");
        System.out.println("Computer final hand: " + computerCards + "Computer final score is :" + computerScore+ "\n");
        System.out.printf(compare(computerScore, userScore) +"\n");


    }
}