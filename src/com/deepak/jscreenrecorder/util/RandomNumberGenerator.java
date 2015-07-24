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
package com.deepak.jscreenrecorder.util;

/**
 *
 * @author deepak
 */

// this calss provides a static method to generate random numbers
public class RandomNumberGenerator {

    // method to generate random numbers 
    // in the range of 0 to the maximun value an integer can have
    public static int getRandomNumber() {
        return (int) (Math.random() * Integer.MAX_VALUE);
    }
}
