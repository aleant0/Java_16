import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    private HashMap<String, Integer> playersMap = new HashMap<>();

    public void register(Player player) {
        playersMap.put(player.getName(), player.getStrength());
    }

    public int round(String playerName1, String playerName2) {
        int reg = 0;

        if (playersMap.containsKey(playerName1)) {
            reg++;
        }
        if (playersMap.containsKey(playerName2)) {
            reg++;
        }
        if (reg < 2) {
            throw new NotRegisteredException(
                    "Player not registered"
            );
        }

        if (playersMap.get(playerName1) > playersMap.get(playerName2)) {
            return 1;
        } else if (playersMap.get(playerName1) < playersMap.get(playerName2)) {
            return 2;
        } else {
            return 0;
        }
    }
}


