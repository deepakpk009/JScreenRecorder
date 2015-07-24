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
import com.deepak.jscreenrecorder.core.constants.Directory;
import com.deepak.jscreenrecorder.core.constants.Extension;
import com.deepak.jscreenrecorder.core.filters.ImageFileNameFilter;
import com.deepak.jscreenrecorder.util.AddImage;
import com.deepak.jscreenrecorder.util.RandomNumberGenerator;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author deepak
 */
// this class impliments the cursor selector for selecting the cursor type
public class CursorSelector extends javax.swing.JFrame {

    // the local record config refernce object
    private RecordConfig recConfig = null;
    // the cursors image array
    private BufferedImage cursors[] = null;
    // the current cursor image index
    private int cursorIndex = 0;
    // the highlighter color
    private Color highlighterColor = null;

    // method to load the cursor images from the cursors database directory
    private void loadCursors() {
        // get the reference to the cursor directory
        File cursorDir = new File(Directory.CURSOR_DB);
        // list the cursor image files
        File cursorFiles[] = cursorDir.listFiles(new ImageFileNameFilter());
        // if the cursor image files list is not null and cursors are present then
        if (cursorFiles != null && cursorFiles.length > 0) {
            // create the cursor image array
            cursors = new BufferedImage[cursorFiles.length];
            // load the cursor images on to the image array
            int i = 0;
            for (File f : cursorFiles) {
                try {
                    cursors[i] = ImageIO.read(f);
                    i++;
                } catch (IOException ex) {
                    // no need to notify user
                    ex.printStackTrace();
                }
            }
        } // else if no cursor images are found in the cursors directory then
        else {
            // create a cursor image array of size one
            cursors = new BufferedImage[1];
            try {
                // load and set the default cursor image from the jar package resource
                cursors[0] = ImageIO.read(getClass().getResource("/com/deepak/jscreenrecorder/gui/resources/cursor.png"));
            } catch (IOException ex) {
                // no need to notify user
                ex.printStackTrace();
            }
        }

    }

    // method to save the cursor image into the cursor directory
    private void saveCursors(BufferedImage cursorImage) {
        if (cursorImage != null) {
            try {
                // save the cursor image with a random number file name and predefined cursor file extension
                ImageIO.write(cursorImage, "png", new File(Directory.CURSOR_DB + RandomNumberGenerator.getRandomNumber() + Extension.CURSOR_EXTENSION));
                JOptionPane.showMessageDialog(rootPane, "Cursor Saved to Database Successfully.", "Cursor Save", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, "Cursor Save Failed !", "Cursor Save", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // the calss constructor with the record config parameter
    public CursorSelector(RecordConfig rc) {
        // intilise the visual components
        initComponents();
        // load all the cursors
        loadCursors();
        // set the local record config reference
        recConfig = rc;
        // set the cusor selection as false
        hideCursorRadioButton.setSelected(true);
        // disable the the cursor panel
        cursorPanelEnable(false);
        // display the first cursor image on the cursor display panel
        cursorDisplayPanel.setCursorImage(cursors[0]);
        // disable the highlighter panel
        highlighterPanelEnable(false);
        // set the highlighter selection as false
        highlighterCheckBox.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cursorOptionGroup = new javax.swing.ButtonGroup();
        cursorTypePanel = new javax.swing.JPanel();
        nextButton = new javax.swing.JButton();
        previousButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        cursorDisplayPanel = new com.deepak.jscreenrecorder.gui.CursorDisplayPanel();
        saveButton = new javax.swing.JButton();
        cursorOptionPanel = new javax.swing.JPanel();
        showCursorRadioButton = new javax.swing.JRadioButton();
        hideCursorRadioButton = new javax.swing.JRadioButton();
        highlighterCheckBox = new javax.swing.JCheckBox();
        highlighterOptionPanel = new javax.swing.JPanel();
        colorButton = new javax.swing.JButton();
        sizeSpinner = new javax.swing.JSpinner();
        alphaSpinner = new javax.swing.JSpinner();

        cursorOptionGroup.add(hideCursorRadioButton);
        cursorOptionGroup.add(showCursorRadioButton);
        cursorOptionGroup.setSelected(hideCursorRadioButton.getModel(), true);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cursor Selection");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                CursorSelector.this.windowClosing(evt);
            }
        });

        cursorTypePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Cursor Type"));

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        previousButton.setText("Previous");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cursorDisplayPanelLayout = new javax.swing.GroupLayout(cursorDisplayPanel);
        cursorDisplayPanel.setLayout(cursorDisplayPanelLayout);
        cursorDisplayPanelLayout.setHorizontalGroup(
            cursorDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );
        cursorDisplayPanelLayout.setVerticalGroup(
            cursorDisplayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cursorTypePanelLayout = new javax.swing.GroupLayout(cursorTypePanel);
        cursorTypePanel.setLayout(cursorTypePanelLayout);
        cursorTypePanelLayout.setHorizontalGroup(
            cursorTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cursorTypePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cursorTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(previousButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cursorDisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        cursorTypePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addButton, nextButton, previousButton});

        cursorTypePanelLayout.setVerticalGroup(
            cursorTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cursorTypePanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(cursorTypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cursorTypePanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(cursorDisplayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(cursorTypePanelLayout.createSequentialGroup()
                        .addComponent(nextButton)
                        .addGap(18, 18, 18)
                        .addComponent(previousButton)
                        .addGap(18, 18, 18)
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(saveButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );

        cursorOptionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Cursor Option"));

        showCursorRadioButton.setText("Show Cursor");
        showCursorRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCursorRadioButtonActionPerformed(evt);
            }
        });

        hideCursorRadioButton.setText("Hide Cursor");
        hideCursorRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideCursorRadioButtonActionPerformed(evt);
            }
        });

        highlighterCheckBox.setText("Use Highlighter");
        highlighterCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highlighterCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cursorOptionPanelLayout = new javax.swing.GroupLayout(cursorOptionPanel);
        cursorOptionPanel.setLayout(cursorOptionPanelLayout);
        cursorOptionPanelLayout.setHorizontalGroup(
            cursorOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cursorOptionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cursorOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hideCursorRadioButton)
                    .addComponent(showCursorRadioButton)
                    .addComponent(highlighterCheckBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cursorOptionPanelLayout.setVerticalGroup(
            cursorOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cursorOptionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hideCursorRadioButton)
                .addGap(18, 18, 18)
                .addComponent(showCursorRadioButton)
                .addGap(18, 18, 18)
                .addComponent(highlighterCheckBox)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        highlighterOptionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Highlighter Option"));

        colorButton.setText("Color");
        colorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorButtonActionPerformed(evt);
            }
        });

        sizeSpinner.setModel(new javax.swing.SpinnerNumberModel(27, 5, 128, 1));
        sizeSpinner.setBorder(javax.swing.BorderFactory.createTitledBorder("Size"));
        sizeSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sizeSpinner_StateChangedEvent(evt);
            }
        });

        alphaSpinner.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.5f), Float.valueOf(0.0f), Float.valueOf(1.0f), Float.valueOf(0.1f)));
        alphaSpinner.setBorder(javax.swing.BorderFactory.createTitledBorder("Alpha"));
        alphaSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                alphaSpinner_StateChangedEvent(evt);
            }
        });

        javax.swing.GroupLayout highlighterOptionPanelLayout = new javax.swing.GroupLayout(highlighterOptionPanel);
        highlighterOptionPanel.setLayout(highlighterOptionPanelLayout);
        highlighterOptionPanelLayout.setHorizontalGroup(
            highlighterOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(highlighterOptionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(highlighterOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(colorButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sizeSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(alphaSpinner))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        highlighterOptionPanelLayout.setVerticalGroup(
            highlighterOptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(highlighterOptionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(colorButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alphaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(highlighterOptionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cursorOptionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(cursorTypePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cursorOptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(highlighterOptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addComponent(cursorTypePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-597)/2, (screenSize.height-484)/2, 597, 484);
    }// </editor-fold>//GEN-END:initComponents

    // method called when the window is closing
    private void windowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowClosing
        // TODO add your handling code here:
        // if the record config is not null and show cursor radio button is selected then
        if (recConfig != null && showCursorRadioButton.isSelected()) {
            // set the cursor image to the record config
            recConfig.setCursorImage(cursorDisplayPanel.getFinalCursorImage());
        } else {
            // if cursor is hidden then set the cursor image as null
            recConfig.setCursorImage(null);
        }
    }//GEN-LAST:event_windowClosing

    // method called when the highlighter size value changes
    private void sizeSpinner_StateChangedEvent(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sizeSpinner_StateChangedEvent
        // TODO add your handling code here:
        // set the cursor display panel highlighter size
        cursorDisplayPanel.setHighlighterSize(Integer.parseInt(sizeSpinner.getValue().toString()));
    }//GEN-LAST:event_sizeSpinner_StateChangedEvent

    // method called when the highlighter alpha value changes
    private void alphaSpinner_StateChangedEvent(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_alphaSpinner_StateChangedEvent
        // TODO add your handling code here:
        // set the cursor display panel highlighter alpha value
        cursorDisplayPanel.setHighlighterAlpha(Float.parseFloat(alphaSpinner.getValue().toString()));
    }//GEN-LAST:event_alphaSpinner_StateChangedEvent

    // method called when the hide cursor radio buttion is selected
    private void hideCursorRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideCursorRadioButtonActionPerformed
        // TODO add your handling code here:
        // disable the cursor panel
        cursorPanelEnable(false);
        // disable the highlighter checkbox
        highlighterCheckBox.setEnabled(false);
        // disable the highlighter panel
        highlighterPanelEnable(false);
    }//GEN-LAST:event_hideCursorRadioButtonActionPerformed

    // method called when show cursor radio button is pressed
    private void showCursorRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showCursorRadioButtonActionPerformed
        // TODO add your handling code here:
        // enable the cursor panel
        cursorPanelEnable(true);
        // enable the highlighter checkbox
        highlighterCheckBox.setEnabled(true);
        // if the highlighter check box is selected then enable the highlighter panel
        if (highlighterCheckBox.isSelected()) {
            highlighterPanelEnable(true);
        }
    }//GEN-LAST:event_showCursorRadioButtonActionPerformed

    // method called when the highlighter check box is pressed
    private void highlighterCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highlighterCheckBoxActionPerformed
        // TODO add your handling code here:
        // if the highlighter check box is selected then
        if (highlighterCheckBox.isSelected()) {
            // enable the highlighter panel
            highlighterPanelEnable(true);
            // set the highlighter enable in the cursor diaplay panel object
            cursorDisplayPanel.setHighlighterEnable(true);
        } // if the highlighter check box is not selected then
        else {
            // disable the highlighter panel 
            highlighterPanelEnable(false);
            // set the highlighter disable in the cursor diaplay panel object
            cursorDisplayPanel.setHighlighterEnable(false);
        }
    }//GEN-LAST:event_highlighterCheckBoxActionPerformed

    // method called when the highlighter color button is pressed
    private void colorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorButtonActionPerformed
        // TODO add your handling code here:
        // get the color from the color chooser
        highlighterColor = JColorChooser.showDialog(rootPane, "Highlighter Color", Color.yellow);
        // set the highlighter color to the cursor display panel
        cursorDisplayPanel.setHighlighterColor(highlighterColor);
    }//GEN-LAST:event_colorButtonActionPerformed

    // method called when the next cursor button is pressed
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        // if cursor are present then
        if (cursors != null && cursors.length > 0) {
            // increment the cursor index
            cursorIndex = (cursorIndex + 1) % cursors.length;
            // load the cursor image at the cursor index onto the cursor display panel
            cursorDisplayPanel.setCursorImage(cursors[cursorIndex]);
        }
    }//GEN-LAST:event_nextButtonActionPerformed

    // method called when the previous button is pressed
    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
        // TODO add your handling code here:
        // if the cursor images are present then 
        if (cursors != null && cursors.length > 0) {
            // decrement the cursor index
            --cursorIndex;
            // if the cursor index is less then zero then set it to the last accessible index 
            if (cursorIndex < 0) {
                cursorIndex = cursors.length - 1;
            }
            // set the cursor display panel cursor image
            cursorDisplayPanel.setCursorImage(cursors[cursorIndex]);
        }
    }//GEN-LAST:event_previousButtonActionPerformed

    // method called when the add cursor button is pressed
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        // call the add image class object and add image 
        // to the cursors directory with the predefined cursor file extension
        int cursorCount = new AddImage().add(Directory.CURSOR_DB, Extension.CURSOR_EXTENSION);
        // if cursor have been added then 
        if (cursorCount > 0) {
            //reload cursor files list
            loadCursors();
            // notify the user 
            JOptionPane.showMessageDialog(rootPane, cursorCount + " Cursors Added to Database Successfully.", "Cursor Add", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // if error occurs then notify the user
            JOptionPane.showMessageDialog(rootPane, "No Cursor Added to Database!", "Cursor Add", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    // method called when the save button is pressed
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        // save the current cursor image into the cursors directory
        saveCursors(cursorDisplayPanel.getFinalCursorImage());
    }//GEN-LAST:event_saveButtonActionPerformed

    // method to enable/ disable the cursor panel
    private void cursorPanelEnable(boolean b) {
        cursorTypePanel.setEnabled(b);
        nextButton.setEnabled(b);
        previousButton.setEnabled(b);
        addButton.setEnabled(b);
        saveButton.setEnabled(b);
    }

    // method to enable/ disable the highlighter panel    
    private void highlighterPanelEnable(boolean b) {
        highlighterOptionPanel.setEnabled(b);
        colorButton.setEnabled(b);
        sizeSpinner.setEnabled(b);
        alphaSpinner.setEnabled(b);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JSpinner alphaSpinner;
    private javax.swing.JButton colorButton;
    private com.deepak.jscreenrecorder.gui.CursorDisplayPanel cursorDisplayPanel;
    private javax.swing.ButtonGroup cursorOptionGroup;
    private javax.swing.JPanel cursorOptionPanel;
    private javax.swing.JPanel cursorTypePanel;
    private javax.swing.JRadioButton hideCursorRadioButton;
    private javax.swing.JCheckBox highlighterCheckBox;
    private javax.swing.JPanel highlighterOptionPanel;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JRadioButton showCursorRadioButton;
    private javax.swing.JSpinner sizeSpinner;
    // End of variables declaration//GEN-END:variables
}
