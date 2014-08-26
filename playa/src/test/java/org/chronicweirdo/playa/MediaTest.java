package org.chronicweirdo.playa;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.junit.Test;

/**
 * Created by scacoveanu on 8/26/2014.
 */
public class MediaTest {

    @Test
    public void playMp3() throws Exception {
        Media file = new Media("Taekwondo_Princess.mp3");
        MediaPlayer mediaPlayer = new MediaPlayer(file);
        mediaPlayer.play();
    }
}
