package com.vasanth.game.battleship.strategy;

import com.vasanth.game.battleship.model.PlayerChanceTarget;
import com.vasanth.game.battleship.model.player.Player;

import java.util.List;

public interface IChanceGenerationStrategy {
    PlayerChanceTarget getPlayerChanceTarget(List<Player> opponents);
}
