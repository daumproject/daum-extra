package org.lightcouch;

/**
 * Created with IntelliJ IDEA.
 * User: jed
 * Date: 17/12/12
 * Time: 17:47
 * To change this template use File | Settings | File Templates.
 */
// not thread safe
public final class StopWatch {

    private StopWatch() {}

    private static long start;
    private static long stop;

    public static void start() {
        start = System.currentTimeMillis();
        stop = 0;
    }

    public static long stop() {
        stop = System.currentTimeMillis();
        long value = stop - start;
        start = 0;
        return value;
    }
}
