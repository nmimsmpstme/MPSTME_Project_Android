package com.example.aashya.thereadingroom;

/**
 * Created by aashya on 27/03/15.
 */
public class wishlistdoesnotexist extends RuntimeException {
        public wishlistdoesnotexist(String message, Throwable cause) {
            super(message, cause);
        }

        public wishlistdoesnotexist(String message) {
            super(message);
        }

        public wishlistdoesnotexist() {
            super();
        }
    }

