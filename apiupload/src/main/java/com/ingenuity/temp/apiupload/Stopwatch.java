package com.ingenuity.temp.apiupload;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by scacoveanu on 9/11/2014.
 */
public class Stopwatch {

    public static final String ERROR_MESSAGE = "Stopwatch must be started before recording!";
    public static final String NO_LAPS_ERROR_MESSSAGE = "No laps recorded!";
    private String nameSeparator = " > ";
    private String open = "(";
    private String close = ")";
    private String defaultName = "lap ";
    private String noData = "";

    private Long startTime = null;
    private List<Long> laps = new ArrayList<Long>();
    private List<String> lapNames = new ArrayList<String>();

    public void setNameSeparator(String nameSeparator) {
        this.nameSeparator = nameSeparator;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    public void setNoData(String noData) {
        this.noData = noData;
    }

    public void start() {
        this.startTime = System.nanoTime();
    }

    public void lap(String name) {
        if (startTime == null) {
            throw new RuntimeException(ERROR_MESSAGE);
        }
        long lapTime = System.nanoTime();
        this.laps.add(lapTime);
        this.lapNames.add(name);
    }

    public void lap() {
        String name = defaultName + laps.size();
        lap(name);
    }

    public Long lapTime(int index) {
        if (index == 0) {
            return laps.get(0) - startTime;
        } else if (index < laps.size()) {
            return laps.get(index) - laps.get(index - 1);
        } else {
            return null;
        }
    }

    public Long totalTime() {
        if (startTime == null) {
            throw new RuntimeException(ERROR_MESSAGE);
        }
        if (laps.size() == 0) {
            throw new RuntimeException(NO_LAPS_ERROR_MESSSAGE);
        }
        return laps.get(laps.size() - 1) - startTime;
    }

    public String formattedLapTime(int index) {
        return formatNanoTime(lapTime(index));
    }

    public String lapString(int index) {
        if (0 <= index && index < laps.size()) {
            return lapNames.get(index) + nameSeparator + formattedLapTime(index);
        } else {
            return noData;
        }
    }

    public String totalTimeString() {
        return formatNanoTime(totalTime());
    }

    public String lastLapString() {
        return lapString(laps.size() - 1);
    }

    public static String formatNanoTime(Long time) {
        if (time != null) {
            long hours = TimeUnit.HOURS.convert(time, TimeUnit.NANOSECONDS);
            long minutes = TimeUnit.MINUTES.convert(time, TimeUnit.NANOSECONDS) % 60L;
            long seconds = TimeUnit.SECONDS.convert(time, TimeUnit.NANOSECONDS) % 60L;
            long milliseconds = TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) % 1000L;
            long nanoseconds = time % 1000000L;
            return hours + ":" + minutes + ":" + seconds + "." + milliseconds + "." + nanoseconds;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < laps.size(); i++) {
            builder.append(open).append(lapString(i)).append(close);
        }
        return builder.toString();
    }
}
