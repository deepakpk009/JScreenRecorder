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

import com.deepak.jscreenrecorder.gui.WatermarkDisplayPanel;
import com.deepak.jtextchooser.JTextChooser;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author deepak
 */
// this class implements the text watermark creator
public class TextWatermarkCreator {

    // the text watermark image object
    private BufferedImage textWatermarkImage = null;
    // the watermark display panel refernce
    private WatermarkDisplayPanel watermarkDisplayPanel = null;

    // the constructor with watermark display panel as the parameter
    public TextWatermarkCreator(WatermarkDisplayPanel wmdp) {
        watermarkDisplayPanel = wmdp;
    }

    // method to create watermark image from the text 
    public void createWatermark() {

        // create jtextchooser object 
        JTextChooser jtc = new JTextChooser("Watermark Text");

        // get the selected text with font, size and text color
        int result = jtc.showTextChooserDialog();
        // on user selection
        if (result == JTextChooser.APPROVE_OPTION) {
            Rectangle2D bounds;
            int w, h, finalW, finalH;
            float indent;

            String text = jtc.getText();
            //create the FontRenderContext object which helps us to measure the text
            FontRenderContext frc = new FontRenderContext(null, true, true);
            // get the bounds of the text image
            bounds = jtc.getSelectedFont().getStringBounds(text, frc);
            // get the initial height for the whole text
            h = (int) bounds.getHeight();
            // split the sentences based on new line
            String sentences[] = text.split(System.getProperty("line.separator"));
            // get the longest sentence
            String longestSentence = getLongestString(sentences);
            //get the widht of the longest sentence
            bounds = jtc.getSelectedFont().getStringBounds(longestSentence, frc);
            finalW = (int) bounds.getWidth();
            // setting indent as 25% of the height;
            indent = h * (50 / 100);
            // calculate the final height of the text watermark image
            finalH = (int) (h + indent) * sentences.length;
            //create the text watermark image object withe calculated size
            textWatermarkImage = new BufferedImage(finalW, finalH, BufferedImage.TYPE_INT_ARGB_PRE);
            //calling createGraphics() to get the Graphics2D
            Graphics2D g = textWatermarkImage.createGraphics();
            //set color and other parameters
            g.setColor(jtc.getSelectedTextColor());
            g.setFont(jtc.getSelectedFont());
            // draw all lines on to the image
            int sentenceNo = 1;
            for (String sentence : sentences) {
                g.drawString(sentence, (float) bounds.getX(), (((float) -bounds.getY() + indent) * sentenceNo));
                sentenceNo++;
            }
            //releasing resources
            g.dispose();
            // set the final text watermark image onto the watermark display panel
            watermarkDisplayPanel.setWatermarkImage(textWatermarkImage);
        }
    }

    // method to get the longest string out of an string array
    private String getLongestString(String[] array) {
        int maxLength = 0;
        String longestString = null;
        for (String s : array) {
            if (s.length() > maxLength) {
                maxLength = s.length();
                longestString = s;
            }
        }
        return longestString;
    }
}
