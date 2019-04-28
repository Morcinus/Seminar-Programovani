package cz.alisma.alej.text.wrapping;

import java.util.List;

public class JustifyAligner implements Aligner {
	private int width;

	@Override
	public String format(List<String> words) {

		// Deklarace promennych
		String[] result = new String[words.size()];
		int stringLength = 0;
		boolean first = true;

		// Prida mezery pred slova a prevede do result; spocita delku radku
		for (int i = 0; i < result.length; i++) {
			if (!first) {
				result[i] = " " + words.get(i);
				stringLength += 1 + words.get(i).length();
			} else {
				result[i] = words.get(i);
				stringLength += words.get(i).length();
				first = false;
			}
		}

		// Osetreni pro radky s jednim slovem
		int y = (result.length != 1) ? 1 : 0;

		// Vyplneni textu mezerama - zarovna do bloku
		for (int i = 0; i <= width - stringLength; i++) {
			result[y] = " " + result[y];
			if (y < result.length - 1) {
				y++;
			} else {
				y = (result.length != 1) ? 1 : 0;
			}
		}

		// Prevedeni arraye na string
		StringBuilder builder = new StringBuilder();
		for (String s : result) {
			builder.append(s);
		}

		return builder.toString();
	}

	public JustifyAligner(int w) {
		width = w;
	}
}
