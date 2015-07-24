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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author deepak
 */

// this class provides a static method to copy a file from one location to another
public class FileCopier {

    // method to copy a file from the source to the destination 
    public static void copy(File sourceFile, File targetFile) throws IOException {

        // open the input stream to read from the source file
        InputStream in = new FileInputStream(sourceFile);
        // open the output stream to write to the destination file
        OutputStream out = new FileOutputStream(targetFile);

        // Copy the bits from input stream to output stream
        // byte array size set to 1kb
        byte[] buf = new byte[1024];
        int len;
        // read bytes and write them 
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        
        // close all streams
        in.close();
        out.close();

    }
}
