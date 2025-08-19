import java.util.Scanner;
public class CardDeck {
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    public static int getNumberOfCards() { return SUITS.length * RANKS.length; }
    public static String[] initializeDeck() {
        int numOfCards = getNumberOfCards();
        String[] deck = new String[numOfCards];
        int index = 0;
        for (String suit : SUITS) for (String rank : RANKS) deck[index++] = rank + " of " + suit;
        return deck;
    }
    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;
        String[] shuffledDeck = deck.clone();
        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            String temp = shuffledDeck[i];
            shuffledDeck[i] = shuffledDeck[randomCardNumber];
            shuffledDeck[randomCardNumber] = temp;
        }
        return shuffledDeck;
    }
    public static String[][] distributeCards(String[] deck, int numPlayers, int cardsPerPlayer) {
        if (numPlayers * cardsPerPlayer > deck.length) {
            System.out.println("Cannot distribute " + cardsPerPlayer + " cards to " + numPlayers + " players.");
            System.out.println("Maximum cards per player: " + (deck.length / numPlayers));
            return null;
        }
        String[][] players = new String[numPlayers][cardsPerPlayer];
        int cardIndex = 0;
        for (int player = 0; player < numPlayers; player++) for (int card = 0; card < cardsPerPlayer; card++) players[player][card] = deck[cardIndex++];
        return players;
    }
    public static void printPlayersAndCards(String[][] players) {
        if (players == null) return;
        System.out.println("\nCards distributed to players:");
        System.out.println("=============================");
        for (int i = 0; i < players.length; i++) {
            System.out.println("Player " + (i + 1) + ":");
            for (int j = 0; j < players[i].length; j++) System.out.println("  " + (j + 1) + ". " + players[i][j]);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Card Deck Management System");
        System.out.println("Creating deck of cards...");
        String[] deck = initializeDeck();
        System.out.println("Deck created with " + getNumberOfCards() + " cards.");
        System.out.println("Shuffling deck...");
        String[] shuffledDeck = shuffleDeck(deck);
        System.out.println("Deck shuffled successfully.");
        System.out.print("Enter number of players: ");
        int numPlayers = scanner.nextInt();
        System.out.print("Enter number of cards per player: ");
        int cardsPerPlayer = scanner.nextInt();
        String[][] players = distributeCards(shuffledDeck, numPlayers, cardsPerPlayer);
        printPlayersAndCards(players);
        scanner.close();
    }
}
