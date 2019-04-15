package cz.alisma.alej.text.wrapping;

import java.util.ArrayList;
import java.util.List;

public class JustifyAligner implements Aligner {
	private int width;

	@Override
	public String format(List<String> words) {

		// !!! ARRAY spaceIndexes TEORETICKY NEMUSI BYT, STACI POCITAT ARRAY result OD 1

		// Deklarace promennych
		List<Integer> spaceIndexes = new ArrayList<Integer>();
		String[] result = new String[words.size()];
		int stringLength = 0;
		boolean first = true;

		// Prevod listu words na string array
		// Secteni delky radku
		// Pridani mezer mezi slovy
		for (int i = 0; i < result.length; i++) {
			if (!first) {
				result[i] = " " + words.get(i);
				stringLength += 1 + words.get(i).length();
				spaceIndexes.add(i);
			} else {
				result[i] = words.get(i);
				stringLength += words.get(i).length();
				first = false;
			}
		}

		// Vyplneni mezerama
		int y = 0;
		for (int i = 0; i < width - stringLength; i++) {
			result[spaceIndexes.get(y)] = " " + result[spaceIndexes.get(y)];
			if (y < spaceIndexes.size() - 1) {
				y++;
			} else {
				y = 0;
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
