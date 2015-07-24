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

import com.deepak.jscreenrecorder.core.constants.Directory;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author deepak
 */
// this class impliments the project initiliser
public class ProjectInitiliser {

    // method to initilise the project
    public void initilise() throws IOException {

        // if the database directories are not present then create them
        File f;

        f = new File(Directory.CURSOR_DB);
        if (!f.exists()) {
            f.mkdir();
        }

        f = new File(Directory.VIDEO_DB);
        if (!f.exists()) {
            f.mkdir();
        }

        f = new File(Directory.WATERMARK_DB);
        if (!f.exists()) {
            f.mkdir();
        }

    }
}
