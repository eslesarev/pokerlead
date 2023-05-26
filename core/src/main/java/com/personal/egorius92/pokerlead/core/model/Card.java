package com.personal.egorius92.pokerlead.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Card {

    @Getter
    @AllArgsConstructor
    public enum Rank {
        ACE("A"),
        KING("K"),
        QUEEN("Q"),
        JACK("J"),
        TEN("T"),
        NINE("9"),
        EIGHT("8"),
        SEVEN("7"),
        SIX("6"),
        FIVE("5"),
        FOUR("4"),
        THREE("3"),
        TWO("2");

        private String display;

        public static Rank of(String value) {
            for (Rank rank : Rank.values()) {
                if (rank.getDisplay().equals(value)) {
                    return rank;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    @Getter
    @AllArgsConstructor
    public enum Suit {
        HEARTS("H"),
        DIAMONDS("D"),
        CLUBS("C"),
        SPADES("S");

        private String display;

        public static Suit of(String value) {
            for (Suit suit : Suit.values()) {
                if (suit.getDisplay().equals(value)) {
                    return suit;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    private Rank rank;
    private Suit suit;

    public static Card of(String cardDisplay) {
        if (cardDisplay.length() != 2) {
            throw new RuntimeException();
        }
        Rank rank = Rank.of(cardDisplay.substring(0, 1));
        Suit suit = Suit.of(cardDisplay.substring(1, 2));
        return new Card(rank, suit);
    }

    @Override
    public String toString() {
        return rank.getDisplay() + suit.getDisplay();
    }
}
