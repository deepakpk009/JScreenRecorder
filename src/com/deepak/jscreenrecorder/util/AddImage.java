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

import com.deepak.jscreenrecorder.core.filters.ImageFileFilter;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author deepak
 */

// this class provides methos to add images to a directory
public class AddImage {

    // method to add images to the specified directory
    // parameters: the input directory path and the file save extension
    public int add(String toDir, String fileExtension) {
        // create a file chooser
        JFileChooser jfc = new JFileChooser();
        // set the image file filter
        jfc.setFileFilter(new ImageFileFilter());
        // set the selection mode to files and directories
        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        // enable multiple selection
        jfc.setMultiSelectionEnabled(true);
        // show the file chooser and get the result
        int result = jfc.showDialog(jfc, "Add");
        // on selection
        if (result == JFileChooser.APPROVE_OPTION) {
            // get the selected image files
            File images[] = jfc.getSelectedFiles();
            
            int imageCount = 0;
            // for a ll image files
            for (File image : images) {
                try {
                    // copy it to the specified directory with a random number file name
                    // and with the specified extension
                    FileCopier.copy(image, new File(toDir + RandomNumberGenerator.getRandomNumber() + fileExtension));
                    imageCount++;
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(jfc, "Error Adding Image: " + image.getName(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            // return the count of images copyied onto the directory
            return imageCount;
        }
        // on fail return zero
        return 0;
    }
}
