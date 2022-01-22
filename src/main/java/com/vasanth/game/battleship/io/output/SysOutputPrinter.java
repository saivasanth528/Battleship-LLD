package com.vasanth.game.battleship.io.output;

import com.vasanth.game.battleship.model.player.Player;
import lombok.NonNull;

import java.util.List;

public class SysOutputPrinter implements  IOutputPrinter {

    @Override
    public void printMsg(String msg) {
        System.out.println(msg);
    }

    @Override
    public void printWinner(@NonNull final Player player) {
        System.out.println("Game Finished");
        System.out.println("Player :" + player.getId() + " won");
    }

    private void printPlayerInfo(@NonNull final Player player) {
        printMsg("Player: " + player.getId());
    }

    @Override
    public void printSelfBoard(@NonNull final Player player) {
        printMsg("Your status");
        printPlayerInfo(player);
        printMsg("Board boundary" + player.getBoard().getBoundary());
        printMsg("Ships: " + player.getBoard().getShips());
        printMsg("Hit Locations" + player.getBoard().hitLocations());
        printMsg("Miss Locations " + player.getBoard().missLocations());

    }

    private void printOpponentBoard(@NonNull final Player player) {
        printMsg("Opponent Board status");
        printPlayerInfo(player);
        printMsg("Board boundary" + player.getBoard().getBoundary());
        printMsg("Hit Locations" + player.getBoard().hitLocations());
        printMsg("Miss Locations" + player.getBoard().missLocations());
    }

    @Override
    public void printOpponentsBoard(@NonNull final List<Player> allPlayers, @NonNull final Player currentPlayer) {
        for(Player player: allPlayers) {
            if(player.getId() != currentPlayer.getId()) {
                printOpponentBoard(player);
            }
        }
     }
}
