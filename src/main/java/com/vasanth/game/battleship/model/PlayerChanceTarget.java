package com.vasanth.game.battleship.model;

import com.vasanth.game.battleship.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PlayerChanceTarget {
    final Player targetPlayer;
    final Coordinate target;

}
