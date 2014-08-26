package org.chronicweirdo.playa;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

import java.io.FileInputStream;

/**
 * Created by scacoveanu on 8/26/2014.
 */
public class PlayerEngine {

    private AdvancedPlayer internalPlayer;
    private int frame;
    private FileInputStream inputStream;
    private boolean running = false;

    public void play(String song) throws Exception {
        System.out.println("setting song");
        inputStream = new FileInputStream(song);
        frame = 0;
        play();
    }

    public void play() throws JavaLayerException {
        System.out.println("starting player");
        internalPlayer = new AdvancedPlayer(inputStream);
        internalPlayer.setPlayBackListener(new PlaybackListener() {
            @Override
            public void playbackFinished(PlaybackEvent evt) {
                frame = evt.getFrame();
            }
        });
        playInThread();
    }

    private void playInThread() {
        Thread playerThread = new Thread(new Runnable() {
            public void run() {
                try {
                    running = true;
                    internalPlayer.play(frame);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        playerThread.run();
    }

    public void pause() {
        if (running) {
            internalPlayer.stop();
            running = false;
        }
    }
}
