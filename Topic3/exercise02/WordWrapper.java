package exercise02;

import java.util.ArrayList;
import java.util.List;

public class WordWrapper {

	public List<String> inputString(String string, int rowLength) {
		List<String> rows = new ArrayList<String>();
		String[] words = string.split(" ");

		if (string.length() < rowLength)
			rows.add(string);

		for (String word : words) {
			if (word.length() > rowLength) {
				int count = (int) Math.floor((word.length() / (double) rowLength));
				int begin = 0;
				int end = rowLength;
				for (int i = 0; i < count; i++) {
					rows.add(word.substring(begin, end));
					begin = end;
					end += rowLength;
				}
				rows.add(word.substring(begin));
			}
		}
		return rows;
	}

}
