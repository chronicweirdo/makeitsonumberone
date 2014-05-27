package org.chronicweirdo.tdd;

/**
 * Created by scacoveanu on 5/27/2014.
 */
public class ServiceUser {

    private RandomService randomService;

    public boolean doWork() {
        int number = randomService.randomInt();
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
