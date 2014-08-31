package org.chronicweirdo.javapuzzlers.chapter5.puzzle_38;

public class UnwelcomeGuest {
    public static final long GUEST_USER_ID = -1;

    private static final long USER_ID = getUserId();
    private static long getUserId() {
        try {
            return getUserIdFromEnvironment();
        } catch (IdUnavailableException e) {
            System.out.println("Logging in as guest");
            return GUEST_USER_ID;
        }
    }
    /*static {
        try {
            USER_ID = getUserIdFromEnvironment();
        } catch (IdUnavailableException e) {
            // USER_ID = GUEST_USER_ID; // blank final, will not compile
            System.out.println("Logging in as guest");
        }
    }*/

    private static long getUserIdFromEnvironment() 
            throws IdUnavailableException { 
        throw new IdUnavailableException(); // Simulate an error
    }

    public static void main(String[] args) {
        System.out.println("User ID: " + USER_ID);
    }
}

class IdUnavailableException extends Exception { 
}
