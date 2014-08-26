package org.chronicweirdo.playa;

import org.junit.Test;

/**
 * Created by scacoveanu on 8/26/2014.
 */
public class PlayerEngineTest {

    @Test
    public void testPlayerEngine() throws Exception {
        // play song
        String song = "Taekwondo_Princess.mp3";
        PlayerEngine engine = new PlayerEngine();
        engine.play(song);

        // pause song
        Thread.sleep(10000);
        engine.pause();

        // unpause song
        engine.play();
    }
}
