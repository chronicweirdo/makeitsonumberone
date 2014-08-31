package org.chronicweirdo.javapuzzlers.chapter5.puzzle_43;

/**
 * Created by Silviu on 8/31/14.
 */
public class TigerThrower<T extends Throwable> {
    public static void sneakyThrow(Throwable t) {
        new TigerThrower<Error>().sneakyThrow2(t);
    }

    public void sneakyThrow2(Throwable t) throws T {
        throw (T) t;
    }

    public static void main(String[] args) {
        sneakyThrow(new Exception("this is a checked exception"));
    }
}
