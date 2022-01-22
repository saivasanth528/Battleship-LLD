package com.vasanth.game.battleship;

import com.vasanth.game.battleship.exceptions.CoordinateOutOfBoundaryException;
import com.vasanth.game.battleship.io.output.IOutputPrinter;
import com.vasanth.game.battleship.model.PlayerChanceTarget;
import com.vasanth.game.battleship.model.player.Player;
import com.vasanth.game.battleship.strategy.IPlayerPickingStrategy;
import com.vasanth.game.battleship.strategy.IWinningStrategy;
import lombok.NonNull;

import java.util.List;


public class GameLoop {

    private final List<Player> players;
    private final IWinningStrategy winningStrategy;
    private final IPlayerPickingStrategy playerPickingStrategy;
    private final IOutputPrinter outputPrinter;

    public GameLoop(@NonNull final List<Player> players, @NonNull final IWinningStrategy winningStrategy,
                    @NonNull final  IPlayerPickingStrategy playerPickingStrategy, @NonNull final IOutputPrinter outputPrinter) {
        this.players = players;
        this.winningStrategy = winningStrategy;
        this.playerPickingStrategy = playerPickingStrategy;
        this.outputPrinter = outputPrinter;
    }

    public void start() {
        int currentPlayerIndex = playerPickingStrategy.firstPlayer(players);
        while(true) {
            final Player currentPlayer = players.get(currentPlayerIndex);
            outputPrinter.printMsg("\nPlayer " + currentPlayer.getId() + " chance" );
            PlayerChanceTarget playerChanceTarget = null;
            try {
                playerChanceTarget = currentPlayer.takeChance(this.players);
            } catch (Exception e) {
                outputPrinter.printMsg("Invalid input, please give valid input");
                continue;
            }
            try {
                playerChanceTarget.getTargetPlayer().takeHit(playerChanceTarget.getTarget());

            } catch (CoordinateOutOfBoundaryException exception) {
                outputPrinter.printMsg("Hit was out of bounds");
                continue;
            }

            outputPrinter.printSelfBoard(currentPlayer);
            outputPrinter.printOpponentsBoard(players, currentPlayer);

            final Player winner = winningStrategy.getWinner(players);
            if(winner != null) {
                outputPrinter.printWinner(winner);
                break;
            }
            currentPlayerIndex = playerPickingStrategy.pickNextPlayer(currentPlayerIndex, players);

        }

    }
}
