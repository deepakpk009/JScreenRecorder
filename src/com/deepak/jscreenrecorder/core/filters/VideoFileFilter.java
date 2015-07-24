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
package com.deepak.jscreenrecorder.core.filters;

import com.deepak.jscreenrecorder.core.constants.Extension;
import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author deepak
 */
// this class provides implimentaion for the video file filter
public class VideoFileFilter extends FileFilter {

    @Override
    public boolean accept(File f) {

        String name = f.getName().toLowerCase();
        // accept only the specified formated video files and directories
        return f.isDirectory()
                || name.endsWith(Extension.VIDEO_EXTENSION);

    }

    @Override
    public String getDescription() {
        return "Video Files";
    }
}
