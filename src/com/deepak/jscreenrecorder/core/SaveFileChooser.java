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
import com.deepak.jscreenrecorder.core.constants.Directory;
import com.deepak.jscreenrecorder.core.constants.Extension;
import com.deepak.jscreenrecorder.core.filters.VideoFileFilter;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author deepak
 */
// this class impliments the video file save chooser
public class SaveFileChooser {

    // the constructor with the record config as parameter
    public SaveFileChooser(RecordConfig reConfig) {
        // create a file chooser
        JFileChooser jfc = new JFileChooser(Directory.VIDEO_DB);
        // dissable multi file selection
        jfc.setMultiSelectionEnabled(false);
        // set video file filter
        jfc.setFileFilter(new VideoFileFilter());

        // if already selected a save file then set is as the default selection
        if (reConfig != null && reConfig.getVideoFile() != null) {
            jfc.setSelectedFile(reConfig.getVideoFile());
        }

        // show the chooser dialog
        int result = jfc.showSaveDialog(jfc);
        // on user selection
        if (result == JFileChooser.APPROVE_OPTION) {
            // if the selected file doesnot ends with the video file extension 
            // then add the extension to it and set the save video file
            if (jfc.getSelectedFile().getName().toLowerCase().endsWith(Extension.VIDEO_EXTENSION)) {
                reConfig.setVideoFile(jfc.getSelectedFile());
            } else {
                reConfig.setVideoFile(new File(jfc.getSelectedFile().getAbsolutePath() + Extension.VIDEO_EXTENSION));
            }
        }
    }
}
