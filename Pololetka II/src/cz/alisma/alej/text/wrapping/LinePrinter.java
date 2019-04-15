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

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/** Wraps printed lines. */
public class LinePrinter {
    private int width;
    private PrintStream output;
    private Aligner aligner;
    private List<String> words;

    /** Constructor.
     * 
     * @param out Where to send the output to.
     * @param w Maximum output width.
     * @param align Aligner to use.
     */
    public LinePrinter(PrintStream out, int w, Aligner align) {
        output = out;
        width = w;
        aligner = align;
        words = new ArrayList<>();
    }

    /** Add a word to be printed. */
    public void addWord(String word) {
        words.add(word);
    }

    /** Flush the content to the output.
     * 
     * Prints all remaining words, aligning the lines properly.
     */
    public void flush() {
        int lengthSoFar = -1;
        List<String> line = new ArrayList<>();
        
        for (String word : words) {
            if (lengthSoFar + 1 + word.length() > width) {
                output.println(aligner.format(line));
                line.clear();
                lengthSoFar = -1;
            } else {
                lengthSoFar++;
            }
            line.add(word);
            lengthSoFar += word.length();
        }
        
        if (!line.isEmpty()) {
            output.println(aligner.format(line));
        }
    }

}
