package org.chronicweirdo.playa;

import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;
import org.junit.Test;

import java.io.FileInputStream;

/**
 * http://www.javazoom.net/javalayer/javalayer.html
 *
 * Created by scacoveanu on 8/26/2014.
 */
public class JLayerTest {

    private int pausedOnFrame;

    @Test
    public void playSong() throws Exception {
        FileInputStream inputStream = new FileInputStream("Taekwondo_Princess.mp3");
        Player player = new Player(inputStream);
        player.play();
    }

    @Test
    public void playSomePart() throws Exception {
        FileInputStream inputStream = new FileInputStream("Taekwondo_Princess.mp3");
        AdvancedPlayer player = new AdvancedPlayer(inputStream);
        player.play(10, 100);
    }

    @Test
    public void playPauseSongBroken() throws Exception {
        pausedOnFrame = 0;

        FileInputStream inputStream = new FileInputStream("Taekwondo_Princess.mp3");
        AdvancedPlayer player = new AdvancedPlayer(inputStream);
        player.setPlayBackListener(new PlaybackListener() {
            @Override
            public void playbackFinished(PlaybackEvent evt) {
                pausedOnFrame = evt.getFrame();
            }
        });

        player.play();
        Thread.sleep(1000);
        player.stop();
        System.out.println(pausedOnFrame);
        Thread.sleep(1000);
        player.play(pausedOnFrame);
    }
}
