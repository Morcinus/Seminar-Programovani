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

public class Zarovnani {
	private static int MAX_WIDTH = 50;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ParagraphDetector pd = new ParagraphDetector(input);
		Aligner aligner = new LeftAligner();

		// Nacteni sirky
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-w")) {
				MAX_WIDTH = Integer.parseInt(args[i + 1]);
				break;
			} else if (args[i].length() > 8) {
				if (args[i].substring(0, 8).equals("--width=")) {
					String[] array = args[i].split("=");
					MAX_WIDTH = Integer.parseInt(array[1]);
					break;
				}
			}
		}

		// Nacteni aligneru
		for (int i = 0; i < args.length; i++) {
			switch (args[i]) {
			case "--right":
				aligner = new RightAligner(MAX_WIDTH);
				break;
			case "--center":
				aligner = new CenterAligner(MAX_WIDTH);
				break;
			case "--centre":
				aligner = new CenterAligner(MAX_WIDTH);
				break;
			case "--justify":
				aligner = new JustifyAligner(MAX_WIDTH);
				break;
			}
		}

		// Vypsani textu
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
