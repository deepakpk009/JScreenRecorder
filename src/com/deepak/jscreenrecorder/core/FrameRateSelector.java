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

import com.deepak.jscreenrecorder.core.config.RecordConfig;
import javax.swing.JOptionPane;

/**
 *
 * @author deepak
 */
// this class provides implimentation for the frame rate selector
public class FrameRateSelector {

    // the constructor with record configuration parameter
    public FrameRateSelector(RecordConfig reConfig) {
        // the record config is not null then
        if (reConfig != null) {
            // show input dialog to get the frame rate
            Object value = JOptionPane.showInputDialog(
                    null,
                    "Enter Capture Frame Rate (fps)",
                    "Frame Rate Selector",
                    JOptionPane.OK_CANCEL_OPTION,
                    new javax.swing.ImageIcon(getClass().getResource("/com/deepak/jscreenrecorder/gui/resources/framerate.png")),
                    null,
                    reConfig.getFramesRate());
            // if the entered value is not null nad empty
            if (value != null && !value.toString().isEmpty()) {
                try {
                    // set the frame rate to the record config
                    reConfig.setFramesRate(Integer.parseInt(value.toString()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid fps! fps should be a number.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
