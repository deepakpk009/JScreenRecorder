/*
 This file is part of JScreenRecorder v0.3

 JScreenRecorder is free software: you can redistribute it and/or modify
 it under the terms of the GNU Lesser General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 JScreenRecorder is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Lesser General Public License for more details.

 You should have received a copy of the GNU Lesser General Public License
 along with JScreenRecorder.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.deepak.jscreenrecorder.core;

/**
 *
 * @author deepak
 */
// this class impliments a recording timer
public class RecordTimer {

    // the starting time 
    private static long startTime;
    // the stopping time
    private static long stopTime;

    // method to reset the time values
    public static void reset() {
        startTime = 0;
        stopTime = 0;
    }

    // method to start the timer
    public static void start() {
        startTime = System.currentTimeMillis();
    }

    // method to stop the timer
    public static void stop() {
        stopTime = System.currentTimeMillis();
    }

    // method to get the timer duration in miliseconds
    public static long getTimeInMilliSec() {
        return stopTime - startTime;
    }
}
