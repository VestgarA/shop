package ru.netology;

public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(int id) {
        super("Такой " + id + "Уже существует");
    }
}
