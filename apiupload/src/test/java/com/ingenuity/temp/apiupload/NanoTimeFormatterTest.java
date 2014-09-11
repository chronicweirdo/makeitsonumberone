package com.ingenuity.temp.apiupload;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.*;
import org.junit.Test;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by scacoveanu on 9/11/2014.
 */
public class NanoTimeFormatterTest {

    //@org.junit.Test
    public void formatNanoTime1() throws Exception {
        System.out.println("formatNanoTime1");
        long startTime = System.nanoTime();
        Thread.sleep(3 * 1000);
        long endTime = System.nanoTime();
        long time = endTime - startTime;

        long milliseconds = time / 1000000;
        long seconds = time / 1000000000;
        System.out.println(time);
        System.out.println(milliseconds);
        System.out.println(seconds);
    }

    //@Test
    public void formatNanoTime2() throws Exception {
        System.out.println("formatNanoTime2");

        // two minutes, 5 seconds and 514 milliseconds
        long time = ((2 * 60 + 5) * 1000 + 514) * 1000000;

        long milliseconds = time / 1000000;
        long seconds = time / 1000000000;
        System.out.println(time);
        System.out.println(milliseconds);
        System.out.println(seconds);
    }

    //@Test
    public void formatNanoTime3() throws Exception {
        System.out.println("formatNanoTime3");

        // two minutes, 5 seconds and 514 milliseconds
        long time =
                1 * 60 * 60 * 1000000000L
                + 2 * 60 * 1000000000L
                + 5 * 1000000000L
                + 200 * 1000000L;

        long hours = TimeUnit.HOURS.convert(time, TimeUnit.NANOSECONDS);
        long minutes = TimeUnit.MINUTES.convert(time, TimeUnit.NANOSECONDS);
        long seconds = TimeUnit.SECONDS.convert(time, TimeUnit.NANOSECONDS);
        long milliseconds = TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS);
        System.out.println("nanos: " + time);
        System.out.println("millis: " + milliseconds);
        System.out.println("seconds: " + seconds);
        System.out.println("minutes: " + minutes);
        System.out.println("hours: " + hours);
    }

    //@Test
    public void formatNanoTime4() throws Exception {
        System.out.println("formatNanoTime4");

        // two minutes, 5 seconds and 514 milliseconds
        long time =
                1 * 60 * 60 * 1000000000L
                + 2 * 60 * 1000000000L
                + 5 * 1000000000L
                + 200 * 1000000L;

        long hours = TimeUnit.HOURS.convert(time, TimeUnit.NANOSECONDS);
        long minutes = TimeUnit.MINUTES.convert(time, TimeUnit.NANOSECONDS) - TimeUnit.MINUTES.convert(hours, TimeUnit.HOURS);
        long seconds = TimeUnit.SECONDS.convert(time, TimeUnit.NANOSECONDS) - TimeUnit.SECONDS.convert(minutes, TimeUnit.MINUTES);
        long milliseconds = TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) - TimeUnit.MILLISECONDS.convert(seconds, TimeUnit.HOURS.SECONDS);
        long nanoseconds = time - TimeUnit.NANOSECONDS.convert(milliseconds, TimeUnit.MILLISECONDS);
        System.out.println("time: " + time);
        System.out.println("nanos: " + nanoseconds);
        System.out.println("millis: " + milliseconds);
        System.out.println("seconds: " + seconds);
        System.out.println("minutes: " + minutes);
        System.out.println("hours: " + hours);
    }

    //@Test
    public void formatNanoTime5() throws Exception {
        System.out.println("formatNanoTime5");

        // two minutes, 5 seconds and 514 milliseconds
        long time =
                1 * 60 * 60 * 1000000000L
                + 2 * 60 * 1000000000L
                + 5 * 1000000000L
                + 200 * 1000000L;

        long hours = TimeUnit.HOURS.convert(time, TimeUnit.NANOSECONDS);
        long minutes = TimeUnit.MINUTES.convert(time, TimeUnit.NANOSECONDS) % 60L;
        long seconds = TimeUnit.SECONDS.convert(time, TimeUnit.NANOSECONDS) % 60L;
        long milliseconds = TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) % 1000L;
        long nanoseconds = time % 1000000L;
        System.out.println("time: " + time);
        System.out.println("nanos: " + nanoseconds);
        System.out.println("millis: " + milliseconds);
        System.out.println("seconds: " + seconds);
        System.out.println("minutes: " + minutes);
        System.out.println("hours: " + hours);
    }

    @Test
    public void stopwatchTest() throws Exception {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.setNameSeparator(" > ");

        stopwatch.start();
        Thread.sleep(1000);
        stopwatch.lap("my lap");
        System.out.println(stopwatch.toString());
        Thread.sleep(1230);
        stopwatch.lap("your lap");
        Thread.sleep(400);
        stopwatch.lap();

        System.out.println(stopwatch.toString());
        System.out.println(stopwatch.lastLapString());
    }

    @Test
    public void stopwatchErrorTest() throws Exception {
        Stopwatch stopwatch = new Stopwatch();
        try {
            stopwatch.lap();
            Assert.fail("stopwatch should have thrown error");
        } catch (RuntimeException expected) {

        }
        System.out.println(stopwatch.lapString(0));
    }
}
