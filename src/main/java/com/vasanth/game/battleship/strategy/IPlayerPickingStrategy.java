package com.vasanth.game.battleship.strategy;

import com.vasanth.game.battleship.model.player.Player;

import java.util.List;

public interface IPlayerPickingStrategy {
    Integer firstPlayer(List<Player> players);
    Integer pickNextPlayer(Integer currentPlayerIndex, List<Player> allPlayers);
}
