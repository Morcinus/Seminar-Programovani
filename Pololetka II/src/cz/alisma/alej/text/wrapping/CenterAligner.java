package cz.alisma.alej.text.wrapping;

import java.util.List;

public class CenterAligner implements Aligner {
	private int width;

	@Override
	public String format(List<String> words) {
		StringBuilder result = new StringBuilder();

		// Prida mezery mezi slova
		boolean first = true;
		for (String w : words) {
			if (!first) {
				result.append(" ");
			} else {
				first = false;
			}
			result.append(w);
		}

		int stringLength = result.length();

		// Zarovna text mezerama
		for (int i = 0; i <= width - stringLength; i++) {
			if ((i % 2) == 0) {
				result.append(" ");
			} else {
				result.insert(0, " ");
			}
		}

		return result.toString();
	}

	public CenterAligner(int w) {
		width = w;
	}
}
