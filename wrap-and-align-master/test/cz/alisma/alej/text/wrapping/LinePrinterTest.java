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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinePrinterTest {
	private static class TestingAligner implements Aligner {
	    private List<List<String>> expected = new LinkedList<>();
	    
	    public TestingAligner(String[][] lines) {
            for (String[] line : lines) {
                expected.add(Arrays.asList(line));
            }
        }
	    
        @Override
        public String format(List<String> words) {
            assertFalse(expected.isEmpty());
            List<String> exp = expected.remove(0);
            assertEquals(exp, words);
            return "";
        }
	}
	
	private PrintStream nullOutput;
	
	@Before
	public void setup() {
	    ByteArrayOutputStream temp = new ByteArrayOutputStream();
	    nullOutput = new PrintStream(temp);
	}
	
	@After
	public void teardown() {
	    nullOutput.close();
	}
	
	@Test
	public void exactWidth() {
	    Aligner aligner = new TestingAligner(new String[][] {
	       new String[] { "0123456789" },
	       new String[] { "1234567890" },
	       new String[] { "2345678901" },
	    });
	    LinePrinter printer = new LinePrinter(nullOutput, 10, aligner);
	    printer.addWord("0123456789");
	    printer.addWord("1234567890");
	    printer.addWord("2345678901");
	    printer.flush();
	}
	
	@Test
	public void twoWords() {
	    Aligner aligner = new TestingAligner(new String[][] {
           new String[] { "01234", "56789" },
           new String[] { "12345", "67890" },
        });
        LinePrinter printer = new LinePrinter(nullOutput, 11, aligner);
        printer.addWord("01234");
        printer.addWord("56789");
        printer.addWord("12345");
        printer.addWord("67890");
        printer.flush();
	}
	
	@Test
	public void genericCase() {
	    Aligner aligner = new TestingAligner(new String[][] {
           new String[] { "01234", "567" },
           new String[] { "12345", "6", "8" },
           new String[] { "901", "23" },
           new String[] { "456789012" },
        });
	    LinePrinter printer = new LinePrinter(nullOutput, 10, aligner);
        printer.addWord("01234");
        printer.addWord("567");
        printer.addWord("12345");
        printer.addWord("6");
        printer.addWord("8");
        printer.addWord("901");
        printer.addWord("23");
        printer.addWord("456789012");
        printer.flush();
	}
}
