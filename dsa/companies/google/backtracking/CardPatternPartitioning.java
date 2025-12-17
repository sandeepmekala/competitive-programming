import java.util.Arrays;
import java.util.List;

public class CardPatternPartitioning {

    public static boolean canFormPatterns(List<Card> cards) {
        if (cards.size() != 12) {
            return false;
        }
        boolean[] used = new boolean[12];
        return canFormPatterns(cards, used, 0, 0);
    }

    private static boolean canFormPatterns(List<Card> cards, boolean[] vis, int ind, int count) {
        if (count == 4)
            return true;

        for (int i = ind; i < cards.size(); i++) {
            if (vis[i]) continue;

            for (int j = i + 1; j < cards.size(); j++) {
                if (vis[j]) continue;

                for (int k = j + 1; k < cards.size(); k++) {
                    if (vis[k]) continue;

                    if (isValidPattern(cards.get(i), cards.get(j), cards.get(k))) {
                        vis[i] = vis[j] = vis[k] = true;
                        if (canFormPatterns(cards, vis, i + 1, count + 1)) {
                            return true;
                        }
                        vis[i] = vis[j] = vis[k] = false;
                    }
                }
            }
        }

        return false;
    }

    public static boolean isValidPattern(Card c1, Card c2, Card c3) {
        // Check if all three cards are the same
        if (c1.color.equals(c2.color) && c1.color.equals(c3.color) && c1.count == c2.count && c1.count == c3.count) {
            return true;
        }

        // Check if all three cards have the same color and incrementing order
        if (c1.color.equals(c2.color) && c1.color.equals(c3.color)) {
            int[] counts = { c1.count, c2.count, c3.count };
            Arrays.sort(counts);
            return counts[0] < counts[1] && counts[1] < counts[2];
        }

        return false;
    }

    public static void main(String[] args) {
        Card c1 = new Card("Black", 1);
        Card c2 = new Card("Black", 2);
        Card c3 = new Card("Black", 6);

        System.out.println(isValidPattern(c1, c2, c3)); // true

        Card c4 = new Card("Red", 1);
        Card c5 = new Card("Red", 1);
        Card c6 = new Card("Red", 1);

        System.out.println(isValidPattern(c4, c5, c6)); // true

        Card c7 = new Card("Green", 1);
        Card c8 = new Card("Green", 2);
        Card c9 = new Card("Black", 3);

        System.out.println(isValidPattern(c7, c8, c9)); // false

        List<Card> cards = Arrays.asList(
            new Card("Black", 1), new Card("Black", 2), new Card("Black", 3),
            new Card("Red", 1), new Card("Red", 1), new Card("Red", 1),
            new Card("Green", 1), new Card("Green", 2), new Card("Green", 3),
            new Card("Black", 4), new Card("Black", 5), new Card("Black", 6)
        );

        System.out.println(canFormPatterns(cards)); // true or false de
    }
}

class Card {
    String color; // "Red", "Green", or "Black"
    int count; // 1 to 9

    public Card(String color, int count) {
        this.color = color;
        this.count = count;
    }
}
