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

import java.awt.Color;

/**
 *
 * @author deepak
 */

// this class provides a static method which calcualtes 
// the contrast color for the input color
public class ContrastColor {
   
    // method to get the contrast color
    public static Color getContrastColor(Color color) {
        // Counting the perceptive luminance - human eye favors green color... 
        double a = 1 - (0.299 * color.getRed() + 0.587 * color.getGreen() + 0.114 * color.getBlue()) / 255;

        if (a < 0.5) {
            return Color.BLACK; // for bright colors - black contrast color
        } else {
            return Color.WHITE; // for dark colors - white contrast color
        }
    }

}
