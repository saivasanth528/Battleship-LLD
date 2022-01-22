package com.vasanth.game.battleship.strategy;

import com.vasanth.game.battleship.model.player.Player;

import java.util.List;

public interface IWinningStrategy {
    Player getWinner(List<Player> allPlayers);
}
