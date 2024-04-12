package org.example;

import java.util.*;
public class HandValue {
    public Rank playerHand(List<Card> hand) {
        if (isRoyalFlush(hand)) {
            return Rank.ROYAL_FLUSH;
        } else if (isStraightFlush(hand)) {
            return Rank.STRAIGHT_FLUSH;
        } else if (isFourOfAKind(hand)) {
            return Rank.FOUR_OF_A_KIND;
        } else if (isFullHouse(hand)) {
            return Rank.FULL_HOUSE;
        } else if (isFlush(hand)) {
            return Rank.FLUSH;
        } else if (isStraight(hand)) {
            return Rank.STRAIGHT;
        } else if (isThreeOfAKind(hand)) {
            return Rank.THREE_OF_A_KIND;
        } else if (isTwoPair(hand)) {
            return Rank.TWO_PAIR;
        } else if (isPair(hand)) {
            return Rank.PAIR;
        } else {
            return Rank.HIGH_CARD;
        }
    }
    public boolean isRoyalFlush(List<Card> hand) {
        if (hand.get(0).getValue() == 10) {
            if (hand.get(1).getValue() == 11) {
                if (hand.get(2).getValue() == 12) {
                    if (hand.get(3).getValue() == 13) {
                        if (hand.get(4).getValue() == 14) {
                            if (hand.get(0).getSuit() == hand.get(1).getSuit()) {
                                if (hand.get(1).getSuit() == hand.get(2).getSuit()) {
                                    if (hand.get(2).getSuit() == hand.get(3).getSuit()) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean isStraightFlush(List<Card> hand) {
        Collections.sort(hand);
        for (int i = 0; i < hand.size() - 1; i++) {
            if (!hand.get(i).getSuit().equals(hand.get(i + 1).getSuit())) {
                return false;
            }
            if (hand.get(i).getValue() != hand.get(i + 1).getValue() - 1) {
                return false;
            }
        }
        return true;
    }
    public boolean isFourOfAKind(List<Card> hand) {
        if (hand.get(0).getValue() == hand.get(1).getValue() && hand.get(0).getValue() == hand.get(2).getValue() && hand.get(0).getValue() == hand.get(3).getValue()) {
            return true;
        }
        return hand.get(1).getValue() == hand.get(2).getValue() && hand.get(1).getValue() == hand.get(3).getValue() && hand.get(1).getValue() == hand.get(4).getValue();
    }

    public boolean isFullHouse(List<Card> hand) {
        Collections.sort(hand);
        if ((hand.get(0).getValue() == hand.get(1).getValue() &&
                hand.get(1).getValue() == hand.get(2).getValue() &&
                hand.get(3).getValue() == hand.get(4).getValue()) ||
                (hand.get(0).getValue() == hand.get(1).getValue() &&
                        hand.get(2).getValue() == hand.get(3).getValue() &&
                        hand.get(3).getValue() == hand.get(4).getValue()) ||
                (hand.get(0).getValue() == hand.get(1).getValue() &&
                        hand.get(1).getValue() == hand.get(2).getValue() &&
                        hand.get(2).getValue() == hand.get(3).getValue()) ||
                (hand.get(1).getValue() == hand.get(2).getValue() &&
                        hand.get(2).getValue() == hand.get(3).getValue() &&
                        hand.get(3).getValue() == hand.get(4).getValue())) {
            return true;
        }
        return false;
    }
    public boolean isFlush(List<Card> hand) {
        return hand.get(0).getSuit().equals(hand.get(1).getSuit()) && hand.get(0).getSuit().equals(hand.get(2).getSuit()) && hand.get(0).getSuit().equals(hand.get(3).getSuit()) && hand.get(0).getSuit().equals(hand.get(4).getSuit());
    }
    public boolean isStraight(List<Card> hand) {
        Collections.sort(hand);
        for (int i = 0; i < hand.size() - 1; i++) {
            int currentValue = hand.get(i).getValue();
            int nextValue = hand.get(i + 1).getValue();
            if (nextValue - currentValue != 1) {
                return false;
            }
        }

        return true;
    }

    public boolean isThreeOfAKind(List<Card> hand) {
        for (Card card : hand) {
            int count = 0;
            for (Card otherCard : hand) {
                if (card.getValue() == otherCard.getValue()) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean isTwoPair(List<Card> hand) {
        Set<Integer> set = new HashSet<>();
        int pairsCount = 0;

        for (int i = 0; i < hand.size() - 1; i++) {
            if (hand.get(i).getValue() == hand.get(i + 1).getValue()) {
                set.add(hand.get(i).getValue());
                pairsCount++;
            }
        }

        return pairsCount == 2;
    }

    public boolean isPair(List<Card> hand) {
        Set<Integer> values = new HashSet<>();
        for (Card card : hand) {
            if (!values.add(card.getValue())) {
                return true;
            }
        }
        return false;
    }

    public int highestCardProcessing(List<Card> player1Hand, List<Card> player2Hand) {
        int whoWins = 0;
        Collections.sort(player1Hand, Comparator.reverseOrder());
        Collections.sort(player2Hand, Comparator.reverseOrder());
        for (int i = 0; i < player1Hand.size(); i++) {
            if (player1Hand.get(i).getValue() > player2Hand.get(i).getValue()) {
                whoWins = 1;
                break;
            } else if (player1Hand.get(i).getValue() < player2Hand.get(i).getValue()) {
                whoWins = 2;
                break;
            }
        }

        return whoWins;
    }
}