package com.vasanth.game.battleship.io.output;

import com.vasanth.game.battleship.model.player.Player;

import java.util.List;

public interface IOutputPrinter {
    void printMsg(String msg);
    void printWinner(Player player);
    void printSelfBoard(Player player);
    void printOpponentsBoard(List<Player> allPlayers, Player currentPlayer);
}
