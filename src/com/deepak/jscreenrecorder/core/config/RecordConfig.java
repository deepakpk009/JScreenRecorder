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
package com.deepak.jscreenrecorder.core.config;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;

/**
 *
 * @author deepak
 */
// this class provides the fields for the record configuration
public class RecordConfig {

    // the video length
    private long videoLength;
    // the capture frame rate
    private int framesRate;
    // the capture area dimension
    private Rectangle frameDimension;
    // the watermark image
    private BufferedImage watermarkImage;
    // the watermark location
    private Point watermarkLocation;
    // the cursor image
    private BufferedImage cursorImage;
    // the save file 
    private File videoFile;

    // default constructor
    public RecordConfig() {
        // set the default field values
        videoLength = 0;
        // #update in v0.3 : frameRate changed from 12 to 24
        framesRate = 24;
        frameDimension = null;
        watermarkImage = null;
        watermarkLocation = null;
        cursorImage = null;
        videoFile = null;
    }

    /*
     * GETTER AND SETTER FOR THE FILEDS
     */
    public long getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(long videoLength) {
        this.videoLength = videoLength;
        propertyChangeSupport.firePropertyChange(propertyName, 0, 1);
    }

    public int getFramesRate() {
        return framesRate;
    }

    public void setFramesRate(int framesRate) {
        this.framesRate = framesRate;
        propertyChangeSupport.firePropertyChange(propertyName, 0, 1);
    }

    public Rectangle getFrameDimension() {
        return frameDimension;
    }

    public void setFrameDimension(Rectangle frameDimension) {
        this.frameDimension = frameDimension;
        propertyChangeSupport.firePropertyChange(propertyName, 0, 1);
    }

    public BufferedImage getWatermarkImage() {
        return watermarkImage;
    }

    public void setWatermarkImage(BufferedImage watermarkImage) {
        this.watermarkImage = watermarkImage;
        propertyChangeSupport.firePropertyChange(propertyName, 0, 1);
    }

    public BufferedImage getCursorImage() {
        return cursorImage;
    }

    public void setCursorImage(BufferedImage cursorImage) {
        this.cursorImage = cursorImage;
        propertyChangeSupport.firePropertyChange(propertyName, 0, 1);
    }

    public File getVideoFile() {
        return videoFile;
    }

    public void setVideoFile(File videoFile) {
        this.videoFile = videoFile;
        propertyChangeSupport.firePropertyChange(propertyName, 0, 1);
    }

    public Point getWatermarkLocation() {
        return watermarkLocation;
    }

    public void setWatermarkLocation(Point watermarkLocation) {
        this.watermarkLocation = watermarkLocation;
        propertyChangeSupport.firePropertyChange(propertyName, 0, 1);
    }
    // ------- PROPERY CHANGE SUPPORT ---------------------
    private String propertyName = "RECORD_CONFIG_CHANGE";

    /**
     * Get the value of propertyName
     *
     * @return the value of propertyName
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Set the value of propertyName
     *
     * @param propertyName new value of propertyName
     */
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    /**
     * Add PropertyChangeListener.
     *
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Remove PropertyChangeListener.
     *
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
