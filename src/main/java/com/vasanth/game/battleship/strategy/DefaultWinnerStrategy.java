package com.vasanth.game.battleship.strategy;

import com.vasanth.game.battleship.model.player.Player;

import java.util.ArrayList;
import java.util.List;

public class DefaultWinnerStrategy implements IWinningStrategy {

    @Override
    public Player getWinner(List<Player> allPlayers) {
        final List<Player> alivePlayers = new ArrayList<>();
        for(Player player: allPlayers) {
            if(!player.areAllShipsKilled()) {
                alivePlayers.add(player);
            }
        }
        if(alivePlayers.size() == 1) {
            return alivePlayers.get(0);
        }
        return null;
    }
}
