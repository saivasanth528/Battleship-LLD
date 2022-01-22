package com.vasanth.game.battleship.strategy;

import com.vasanth.game.battleship.exceptions.InvalidInputException;
import com.vasanth.game.battleship.io.input.IInputProvider;
import com.vasanth.game.battleship.io.input.PlayerInput;
import com.vasanth.game.battleship.io.input.SysInputProvider;
import com.vasanth.game.battleship.model.Coordinate;
import com.vasanth.game.battleship.model.PlayerChanceTarget;
import com.vasanth.game.battleship.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;

@AllArgsConstructor
public class LocalChanceGenerationStrategy implements IChanceGenerationStrategy{

    private final IInputProvider inputProvider;

    @Override
    public PlayerChanceTarget getPlayerChanceTarget(@NonNull  List<Player> opponents) {
        final PlayerInput playerInput = inputProvider.takeInput();
        Player targetPlayer = null;
        for(Player player: opponents) {
            if(player.getId() == playerInput.getPlayerNum()) {
                targetPlayer = player;
                break;
            }
        }
        if(targetPlayer == null) {
            throw new InvalidInputException();
        }
        return new PlayerChanceTarget(targetPlayer, new Coordinate(playerInput.getTargetX(), playerInput.getTargetY()));
    }
}
