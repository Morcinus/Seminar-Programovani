/*
 * MIT License
 * Copyright (c) 2017 Gymnazium Nad Aleji
 * Copyright (c) 2017 Vojtech Horky
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package cz.alisma.alej.text.wrapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/** Detects paragraph breaks in the input. */
public class ParagraphDetector {
    private Scanner input;
    private Paragraph nextPara;

    /** Constructs the detector above a scanner.
     * 
     * @param inp Initialized scanner to be used for reading the input.
     */
    public ParagraphDetector(Scanner inp) {
        input = inp;
    }

    /** Tells whether there is another paragraph not yet read in the input. */
    public boolean hasNextParagraph() {
        String line = "";
        while (input.hasNextLine()) {
            line = input.nextLine();
            if (!line.isEmpty()) {
                break;
            }
        }
        if (line.isEmpty()) {
            return false;
        }

        List<String> lines = new ArrayList<>();
        lines.add(line);

        while (input.hasNextLine()) {
            line = input.nextLine();
            if (line.isEmpty()) {
                break;
            }
            lines.add(line);
        }

        nextPara = new Paragraph(lines);
        return true;
    }
    
    /** Get the next paragraph from the input. */
    public Paragraph nextParagraph() {
        return nextPara;
    }
}
