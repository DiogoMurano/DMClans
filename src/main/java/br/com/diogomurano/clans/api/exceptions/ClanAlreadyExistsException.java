package br.com.diogomurano.clans.api.exceptions;

public class ClanAlreadyExistsException extends Exception {

    public ClanAlreadyExistsException(String message) {
        super(message);
    }
}
