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

import java.util.List;
import java.util.Scanner;

/** Paragraph of text. */
public class Paragraph {
    private Scanner words;
    private String content;

    /** Constructs the paragraph from list of lines.
     * 
     * @param lines Lines composing the paragraph.
     */
    public Paragraph(List<String> lines) {
        StringBuilder builder = new StringBuilder();
        for (String line : lines) {
            builder.append(line);
            builder.append("\n");
        }
        content = builder.toString();
        words = new Scanner(content);
    }

    /** Tells whether there is another word not yet read in the paragraph. */
    public boolean hasNextWord() {
        return words.hasNext();
    }

    /** Get the next word from the paragraph.
     * 
     * @return Next word.
     */
    public String nextWord() {
        return words.next();
    }

    /** Debugging only: get content as a string.
     *
     * @return Whole paragraph content.
     */
    public String getContent() {
        return content;
    }
}
