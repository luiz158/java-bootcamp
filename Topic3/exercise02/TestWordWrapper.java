package exercise02;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestWordWrapper {

	// If the row-length is 60 and the input string is 30, the result is just the input string.
	@Test
	public void test60RowLengthInput30() {
		List<String> rows = Arrays.asList("012345678901234567890123456789");
		WordWrapper wordWrapper = new WordWrapper();
		wordWrapper.setStringAndRowLenght("012345678901234567890123456789", 60);
		assertEquals(rows, wordWrapper.inputString());
	}
	
    // If the row-length is 7 and the input string is "Hello Word!", the result should be: "Hello", "Word!".
	@Test
	public void test7RowLengthInputHelloWord() {
		List<String> rows = Arrays.asList("Hello", "Word!");
		WordWrapper wordWrapper = new WordWrapper();
		wordWrapper.setStringAndRowLenght("Hello Word!", 60);
		assertEquals(rows, wordWrapper.inputString());
	}
	
	// If the row-length is 3 and the input string is "a b c d e f", the result should be "a b", "c d", "e f".
	@Test
	public void test3RowLengthInputABCDEF() {
		List<String> rows = Arrays.asList("a b", "c d", "e f");
		WordWrapper wordWrapper = new WordWrapper();
		wordWrapper.setStringAndRowLenght("a b c d e f", 3);
		assertEquals(rows, wordWrapper.inputString());
	}
	
	// If the row-length is 5 and the input string is "Excelent", the result should be "Excel", "ent".
	@Test
	public void test5RowLengthInputExcelent() {
		List<String> rows = Arrays.asList("Excel", "ent");
		WordWrapper wordWrapper = new WordWrapper();
		wordWrapper.setStringAndRowLenght("Excelent", 3);
		assertEquals(rows, wordWrapper.inputString());
	}
}
