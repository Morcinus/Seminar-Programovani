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

import java.util.Scanner;

public class WrapAndAlign {
    private static final int MAX_WIDTH = 50;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ParagraphDetector pd = new ParagraphDetector(input);
        Aligner aligner = new LeftAligner();

        while (pd.hasNextParagraph()) {
            Paragraph para = pd.nextParagraph();
            LinePrinter line = new LinePrinter(System.out, MAX_WIDTH, aligner);
            while (para.hasNextWord()) {
                String word = para.nextWord();
                line.addWord(word);
            }
            line.flush();
            System.out.println();
        }
    }
}
