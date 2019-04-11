/*
 * MIT License
 * Copyright (c) 2018 Gymnazium Nad Aleji
 * Copyright (c) 2018 Vojtech Horky
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

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Scanner;

public class ParagraphDetectorTest {
	@Test
	public void emptyLines() {
		Scanner inp = new Scanner("\n\n\n\n");
		ParagraphDetector det = new ParagraphDetector(inp);
		
		assertFalse(det.hasNextParagraph());
	}
	
	@Test
	public void startsWithEmptyLines() {
		Scanner inp = new Scanner("\n\nFirst paragraph.\n");
		ParagraphDetector det = new ParagraphDetector(inp);
		
		assertTrue(det.hasNextParagraph());
		Paragraph para = det.nextParagraph();
		assertEquals("First paragraph.\n", para.getContent());
		
		assertFalse(det.hasNextParagraph());
	}
	
	@Test
	public void endsWithEmptyLines() {
		Scanner inp = new Scanner("First paragraph.\n\n\n\n");
		ParagraphDetector det = new ParagraphDetector(inp);
		
		assertTrue(det.hasNextParagraph());
		Paragraph para = det.nextParagraph();
		assertEquals("First paragraph.\n", para.getContent());
		
		assertFalse(det.hasNextParagraph());
	}
	
	@Test
	public void twoParagraphs() {
		Scanner inp = new Scanner(
				"First paragraph.\nSecond line.\n\n\n"
				+ "Second paragraph.\nSecond line.\nThird line.\n");
		ParagraphDetector det = new ParagraphDetector(inp);
		
		assertTrue(det.hasNextParagraph());
		Paragraph para = det.nextParagraph();
		assertEquals("First paragraph.\nSecond line.\n", para.getContent());
		
		assertTrue(det.hasNextParagraph());
		para = det.nextParagraph();
		assertEquals("Second paragraph.\nSecond line.\nThird line.\n", para.getContent());
		
		
		assertFalse(det.hasNextParagraph());
	}
}
