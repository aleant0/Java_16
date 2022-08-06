import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player[] players = new Player[0];

    public void register(Player player) {
        Player[] tmp = new Player[players.length + 1];
        for (int i = 0; i < players.length; i++) {
            tmp[i] = players[i];
        }
        tmp[tmp.length - 1] = player;
        players = tmp;
    }

    public int round(String playerName1, String playerName2) {
        int player1 = 0;
        int player2 = 0;
        int reg = 0;

        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player.getStrength();
                reg++;
                break;
            }
        }
        for (Player player : players) {
            if (player.getName().equals(playerName2)) {
                player2 = player.getStrength();
                reg++;
                break;
            }
        }
        if (reg < 2) {
            throw new NotRegisteredException(
                    "Player not registered"
            );
        }

        if (player1 > player2) {
            return 1;
        } else if (player1 < player2) {
            return 2;
        } else {
            return 0;
        }
    }
}


