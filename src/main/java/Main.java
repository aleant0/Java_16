public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Player player1 = new Player(1, "A", 5);
        Player player2 = new Player(2, "B", 6);

        game.register(player1);
        game.register(player2);

        System.out.println(game.round("A", "B"));
    }
}
