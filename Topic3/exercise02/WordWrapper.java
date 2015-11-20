package exercise02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.WordUtils;

public class WordWrapper {

	public List<String> inputString(String string, int rowLength) {
		List<String> rows = new ArrayList<String>();	

		if (string.length() < rowLength)
			rows.add(string);

		if(!string.contains(" ")) {
			String[] words = string.split(" ");
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
		} else {		
			String newString = WordUtils.wrap(string, rowLength);
			rows = Arrays.asList(newString.split("\n"));
		}
	
		return rows;
	}

}
