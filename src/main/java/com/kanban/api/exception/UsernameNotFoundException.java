package com.kanban.api.exception;

public class UsernameNotFoundException extends RuntimeException {

    public UsernameNotFoundException(String user) {
        super("User -> "+ user+" not found!");
    }
}
