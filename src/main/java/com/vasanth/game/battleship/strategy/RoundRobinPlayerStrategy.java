package com.vasanth.game.battleship.strategy;

import com.vasanth.game.battleship.exceptions.InvalidInputException;
import com.vasanth.game.battleship.model.player.Player;

import java.util.List;

public class RoundRobinPlayerStrategy implements IPlayerPickingStrategy{
    @Override
    public Integer firstPlayer(List<Player> players) {
        if(players.size() == 0) {
            throw new InvalidInputException();
        }
        return 0;
    }

    @Override
    public Integer pickNextPlayer(Integer currentPlayerIndex, List<Player> allPlayers) {
        return (currentPlayerIndex + 1) % allPlayers.size();
    }
}
