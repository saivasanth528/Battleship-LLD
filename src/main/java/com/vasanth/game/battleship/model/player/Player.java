package com.vasanth.game.battleship.model.player;


import com.vasanth.game.battleship.model.Board;
import com.vasanth.game.battleship.model.Coordinate;
import com.vasanth.game.battleship.model.PlayerChanceTarget;
import com.vasanth.game.battleship.strategy.IChanceGenerationStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Player {
    private final Board board;
    private final int id;

    private final IChanceGenerationStrategy chanceGenerationStrategy;

    public PlayerChanceTarget takeChance(List<Player> allPlayers) {
        List<Player> opponents = new ArrayList<>();

        for(Player player: allPlayers) {
            if(player.getId() != this.getId()) {
                opponents.add(player);
            }
        }
        return chanceGenerationStrategy.getPlayerChanceTarget(opponents);
    }

    public boolean areAllShipsKilled() {
        return board.areAllShipsKilled();
    }

    public void takeHit(@NonNull final Coordinate coordinate) {
        board.takeHit(coordinate);
    }


}
