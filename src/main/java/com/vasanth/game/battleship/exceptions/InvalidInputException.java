package com.vasanth.game.battleship.exceptions;

public class InvalidInputException extends RuntimeException{

    public InvalidInputException() {

    }

    public InvalidInputException(NumberFormatException exception) {
        super(exception);
    }
}
