package com.vasanth.game.battleship.model;

import com.vasanth.game.battleship.model.boundary.IBoundary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class BoardItem {

    private final String name;
    private final IBoundary boundary;

    public boolean isKilled(@NonNull final List<Coordinate> hitLocations) {
        final List<Coordinate> shipCoordinates = boundary.allCoordinates();
        for(Coordinate shipCoordinate: shipCoordinates) {
            if(!hitLocations.contains(shipCoordinate)) {
                return false;
            }
        }
        return true;
    }

    public boolean containsCoordinate(Coordinate coordinate) {
        return this.boundary.contains(coordinate);
    }

}
