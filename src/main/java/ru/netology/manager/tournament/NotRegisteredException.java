package ru.netology.manager.tournament;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String s) {
        super(s);
    }
}
