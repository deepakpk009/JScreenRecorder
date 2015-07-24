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
package com.deepak.jscreenrecorder.core.recorder;

import com.deepak.jscreenrecorder.core.config.RecordConfig;
import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.TimerTask;

// this class impliments a LiveStream that takes snapshots 
// and feeds it to the sequenceEncoder to encode them
public class ScreenLiveStream extends TimerTask {

    private Robot robot = null;
    // the capture area bound
    private Rectangle captureAreaBounds = null;
    // the local record config reference object
    private RecordConfig recConfig = null;
    // the captured buffered image object 
    private BufferedImage image = null;
    // the captured image graphics reference object
    private Graphics imageGraphics = null;
    // the watermark image
    private BufferedImage watermarkImage = null;
    // the watermark location fields
    private int watermarkLocationX = 0;
    private int watermarkLocationY = 0;
    // the cursor image
    private BufferedImage cursorImage = null;
    // the current cursor point location reference
    private Point cursorLocation = null;
    // use cursor flag
    private boolean useCursor = false;
    // user watermark flag
    private boolean useWatermark = false;
    // the sequence encoder object
    private SequenceEncoder sequenceEncoder = null;

    // class constructor with the record config as parameter
    public ScreenLiveStream(RecordConfig recordConfig, SequenceEncoder sequenceEncoder) throws IOException {
        // set the local record config reference
        this.recConfig = recordConfig;
        // set the sequence encoder refernce
        this.sequenceEncoder = sequenceEncoder;
        // get and set the capture area bounds
        this.captureAreaBounds = this.recConfig.getFrameDimension();
        // initially set use cursor flag as false
        this.useCursor = false;
        // if cursor image is present then set the use cursor flag as true
        // get and set the cursor image
        if ((this.cursorImage = this.recConfig.getCursorImage()) != null) {
            this.useCursor = true;
        }
        // if watermark image is present then set the use watermark flag as true
        // get and set the wateramrk image and location 
        this.useWatermark = false;
        if ((this.watermarkImage = this.recConfig.getWatermarkImage()) != null) {
            this.watermarkLocationX = this.recConfig.getWatermarkLocation().x;
            this.watermarkLocationY = this.recConfig.getWatermarkLocation().y;
            this.useWatermark = true;
        }
        // create a robot object to capture screen area
        try {
            robot = new Robot();
        } catch (AWTException awe) {
            throw new RuntimeException("Cannot create robot for screencapture!");
        }
    }

    @Override
    public void run() {
        //capture screen using the robot object
        image = robot.createScreenCapture(captureAreaBounds);
        // if use cursor or use watermark is set then
        if (useCursor || useWatermark) {
            // get the image graphics reference
            imageGraphics = image.getGraphics();
            // if use watermark is set then 
            if (useWatermark) {
                // draw watermark
                imageGraphics.drawImage(watermarkImage, watermarkLocationX, watermarkLocationY, null);
            }
            // if use cursor is set then
            if (useCursor) {
                // get the mouse location 
                cursorLocation = MouseInfo.getPointerInfo().getLocation();
                // draw cursor
                imageGraphics.drawImage(cursorImage, cursorLocation.x, cursorLocation.y, null);
            }
        }
        try {
            // encode the image using the sequence encoder
            sequenceEncoder.encodeImage(image);
        } catch (Exception ex) {
            // do noting in case of any exception
            // mostly caused due to call to "add frame" after finishing
            // this might become a problem in the future for code debugging
//            Logger.getLogger(ScreenLiveStream.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
