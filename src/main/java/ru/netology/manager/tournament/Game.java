package ru.netology.manager.tournament;

import java.util.ArrayList;
import java.util.Objects;

public class Game {
    ArrayList<Player> registered = new ArrayList<Player>();
    public ArrayList<Player> register(Player player) {
        registered.add(player);
        return registered;
    }
    public Player findByName(String playerName) {
        for (Player player : registered) {
            if (Objects.equals(player.getName(), playerName)) {
                return player;
            }
        }
        return null;
    }
    public int round (String playerName1, String playerName2){
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException("Player " + playerName1 + " is not registered");
        } else if (findByName(playerName2) == null) {
            throw new NotRegisteredException("Player " + playerName2 + " is not registered");
        }
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        if(player1.getStrength() == player2.getStrength()) {
            return 0;
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }
}
