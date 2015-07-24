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
package com.deepak.jscreenrecorder.gui;

import com.deepak.jscreenrecorder.core.config.RecordConfig;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author deepak
 */
// this class impliments the record configuration info panel
public class RecordConfigInfoPanel extends javax.swing.JPanel implements PropertyChangeListener {
    // the record config refernce object

    private RecordConfig recConfig = null;

    // the default constructor
    public RecordConfigInfoPanel() {
        // initilise the visual components
        initComponents();
        // create new record config  
        recConfig = new RecordConfig();
        // add the current class a listner to the record config
        recConfig.addPropertyChangeListener(this);
        // load config info onto the panel
        loadConfigInfo();
    }

    // constructor with record config as parameter
    public RecordConfigInfoPanel(RecordConfig rc) {
        // initilise visual components
        initComponents();
        // set the local record config reference
        recConfig = rc;
        // add the current panel as a listner to the record config
        recConfig.addPropertyChangeListener(this);
        // load config info onto the panel
        loadConfigInfo();
    }

    // method to load the record config info onto the panel
    public final void loadConfigInfo() {
        // display the video file size
        try {
            sizeValue.setForeground(Color.blue);
            sizeValue.setText(humanReadableByteCount(new FileInputStream(recConfig.getVideoFile()).available(), true));
        } catch (Exception ex) {
            sizeValue.setForeground(Color.red);
            sizeValue.setText("Unknown File Size!");
        }

        // display whether curser is shown or not
        if (recConfig.getCursorImage() != null) {
            cursorValue.setForeground(new Color(0, 125, 0));
            cursorValue.setText("Yes");
        } else {
            cursorValue.setForeground(Color.red);
            cursorValue.setText("No");
        }

        // display whether watermark is used or not
        if (recConfig.getWatermarkImage() != null) {
            watermarkValue.setForeground(new Color(0, 125, 0));
            watermarkValue.setText("Yes");
        } else {
            watermarkValue.setForeground(Color.red);
            watermarkValue.setText("No");
        }

        // display the capture area dimension
        if (recConfig.getFrameDimension() != null) {
            frameDimensionValue.setForeground(Color.blue);
            frameDimensionValue.setText("("
                    + recConfig.getFrameDimension().x
                    + ", "
                    + recConfig.getFrameDimension().y
                    + ", "
                    + recConfig.getFrameDimension().width
                    + ", "
                    + recConfig.getFrameDimension().height
                    + ")");
        } else {
            frameDimensionValue.setForeground(Color.red);
            frameDimensionValue.setText("Unknown Dimension!");
        }

        // display the save file name
        if (recConfig.getVideoFile() != null && !recConfig.getVideoFile().getName().isEmpty()) {
            saveFileValue.setForeground(Color.blue);
            saveFileValue.setText(recConfig.getVideoFile().getName());
        } else {
            saveFileValue.setForeground(Color.red);
            saveFileValue.setText("Unknown File!");
        }

        // display the frame rate value
        frameRateValue.setText(recConfig.getFramesRate() + "fps");
        try {
            lengthValue.setForeground(Color.blue);
            lengthValue.setText(humanReadableTime(recConfig.getVideoLength()));
        } catch (ParseException ex) {
            lengthValue.setForeground(Color.red);
            lengthValue.setText("Unknown Length!");
        }

        // diaplay the watermark location
        if (recConfig.getWatermarkLocation() != null) {
            watermarkLocationValue.setForeground(Color.blue);
            watermarkLocationValue.setText("(" + recConfig.getWatermarkLocation().x + ", " + recConfig.getWatermarkLocation().y + ")");
        } else {
            watermarkLocationValue.setForeground(Color.red);
            watermarkLocationValue.setText("Unknown Location!");
        }

    }

    /*
     * method to convert the time in milliseconds to human readable form
     */
    public static String humanReadableTime(long millis) throws ParseException {
        String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
        return hms;
    }

    /*
     * method to convert the byte count to human readable form
     */
    public static String humanReadableByteCount(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < unit) {
            return bytes + " B";
        }
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        watermarkLabel = new javax.swing.JLabel();
        sizeLabel = new javax.swing.JLabel();
        watermarkValue = new javax.swing.JLabel();
        cursorValue = new javax.swing.JLabel();
        saveFileValue = new javax.swing.JLabel();
        frameRateLabel = new javax.swing.JLabel();
        frameRateValue = new javax.swing.JLabel();
        frameDimensionValue = new javax.swing.JLabel();
        lengthLabel = new javax.swing.JLabel();
        lengthValue = new javax.swing.JLabel();
        frameDimensionLabel = new javax.swing.JLabel();
        sizeValue = new javax.swing.JLabel();
        saveFileLabel = new javax.swing.JLabel();
        cursorLabel = new javax.swing.JLabel();
        watermarkLocationLabel = new javax.swing.JLabel();
        watermarkLocationValue = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Record Config Info"));

        watermarkLabel.setText("Watermark :");

        sizeLabel.setText("Size :");

        watermarkValue.setText("jLabel13");

        cursorValue.setText("jLabel14");

        saveFileValue.setText("jLabel16");

        frameRateLabel.setText("Frame Rate :");

        frameRateValue.setText("jLabel11");

        frameDimensionValue.setText("jLabel12");

        lengthLabel.setText("Length :");

        lengthValue.setText("jLabel9");

        frameDimensionLabel.setText("Frame Dimension (x,y,w,h) :");

        sizeValue.setText("jLabel10");

        saveFileLabel.setText("Save File :");

        cursorLabel.setText("Cursor :");

        watermarkLocationLabel.setText("Watermark Location:");

        watermarkLocationValue.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveFileLabel)
                    .addComponent(cursorLabel)
                    .addComponent(watermarkLabel)
                    .addComponent(sizeLabel)
                    .addComponent(lengthLabel)
                    .addComponent(frameDimensionLabel)
                    .addComponent(frameRateLabel)
                    .addComponent(watermarkLocationLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(watermarkLocationValue)
                    .addComponent(lengthValue)
                    .addComponent(sizeValue)
                    .addComponent(frameRateValue)
                    .addComponent(frameDimensionValue)
                    .addComponent(watermarkValue)
                    .addComponent(cursorValue)
                    .addComponent(saveFileValue))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lengthLabel)
                    .addComponent(lengthValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sizeLabel)
                    .addComponent(sizeValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(frameRateLabel)
                    .addComponent(frameRateValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(frameDimensionLabel)
                    .addComponent(frameDimensionValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(watermarkLabel)
                    .addComponent(watermarkValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(watermarkLocationLabel)
                    .addComponent(watermarkLocationValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cursorLabel)
                    .addComponent(cursorValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveFileLabel)
                    .addComponent(saveFileValue))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cursorLabel;
    private javax.swing.JLabel cursorValue;
    private javax.swing.JLabel frameDimensionLabel;
    private javax.swing.JLabel frameDimensionValue;
    private javax.swing.JLabel frameRateLabel;
    private javax.swing.JLabel frameRateValue;
    private javax.swing.JLabel lengthLabel;
    private javax.swing.JLabel lengthValue;
    private javax.swing.JLabel saveFileLabel;
    private javax.swing.JLabel saveFileValue;
    private javax.swing.JLabel sizeLabel;
    private javax.swing.JLabel sizeValue;
    private javax.swing.JLabel watermarkLabel;
    private javax.swing.JLabel watermarkLocationLabel;
    private javax.swing.JLabel watermarkLocationValue;
    private javax.swing.JLabel watermarkValue;
    // End of variables declaration//GEN-END:variables

    // GETTER AND SETTER FOR RECORD CONFIG
    public RecordConfig getRecConfig() {
        return recConfig;
    }

    public void setRecConfig(RecordConfig recConfig) {
        this.recConfig = recConfig;
    }

    // on record config property change call refresh all values
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        loadConfigInfo();
    }
}
