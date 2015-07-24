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
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author deepak
 */
// this class impliments the screen recorder
public class ScreenRecorder {

    // the timer delay value
    private long timerDelay = 0;
    private int encodingRate = 0;
    private TimerTask streamer = null;
    private Timer timer = null;
    private SequenceEncoder sequenceEncoder = null;

    // method to start recording the video     
    public void startRecording(RecordConfig recConfig) throws IOException {
        /*
         the normal frame rate is 24 fps
         so 24 frames per 1000 milli sec
        
         24       1
         ----  =  ----
         1000     x
        
         so x = 1000/24 = 41.6 ~ 42 milli sec
        
         so the equation is timerDelay = 1000 / frameRate
         */
        timerDelay = 1000 / recConfig.getFramesRate();
        // set the encoding rate
        // *** note this equation is set on the basis of trial and error ***
        // *** the reason for dividing by 8 is unknown ***
        encodingRate = recConfig.getFramesRate() / 8;
        // if the encoding rate is 0 on division then reset it to 12
        encodingRate = (encodingRate < 1) ? 12 : encodingRate;
        // initilize the sequence encoder
        sequenceEncoder = new SequenceEncoder(recConfig.getVideoFile(), encodingRate);
        // creater the screen live streamer
        streamer = new ScreenLiveStream(recConfig, sequenceEncoder);
        // create a timer object
        timer = new Timer();
        // schedule the screen streamer task with the timer delay
        timer.scheduleAtFixedRate(streamer, 0, timerDelay);

    }

    /**
     * method to stop the recording process
     */
    public void stopRecording() throws IOException {
        // if the timer is not null
        if (timer != null) {
            // then cancel all scheduled task - recording
            timer.cancel();
            // finish the sequence encoder
            sequenceEncoder.finish();
        }
    }

}
