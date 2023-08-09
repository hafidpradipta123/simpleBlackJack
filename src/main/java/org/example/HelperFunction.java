package org.example;

import java.util.ArrayList;
import java.util.Random;

public class HelperFunction {
    public static int dealCard() {
        int[] cards = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        Random random = new Random();
        int randomIndex = random.nextInt(cards.length);
        return cards[randomIndex];
    }

    public static int calculateScore(ArrayList<Integer> cards){
        int sum = cards.stream().mapToInt(Integer:: intValue).sum();



        if (sum == 21 && cards.size() == 2){
            return 0;
        }

        if (cards.contains(11) && sum > 21){
            cards.remove(Integer.valueOf(11));
            cards.add(1);
        }
        return sum;

    }

    public static String compare(int computerScore, int userScore){
        if (userScore > 21 && computerScore > 21) {
            return "You went over. You lose 😤";
        }
        if (userScore == computerScore) {
            return "Draw 🙃";
        } else if (computerScore == 0) {
            return "Lose, opponent has Blackjack 😱";
        } else if (userScore == 0) {
            return "Win with a Blackjack 😎";
        } else if (userScore > 21) {
            return "You went over. You lose 😭";
        } else if (computerScore > 21) {
            return "Opponent went over. You win 😁";
        } else if (userScore > computerScore) {
            return "You win 😃";
        } else {
            return "You lose 😤";
        }
    }
}
