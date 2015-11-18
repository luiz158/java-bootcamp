package exercise02;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestWordWrapper {

	@Test
	public void test60RowLengthInput30() {
		List<String> rows = Arrays.asList("012345678901234567890123456789");
		WordWrapper wordWrapper = new WordWrapper();
		assertEquals(rows, wordWrapper.inputString("012345678901234567890123456789", 60));
	}

	@Test
	public void test7RowLengthInputHelloWord() {
		List<String> rows = Arrays.asList("Hello", "Word!");
		WordWrapper wordWrapper = new WordWrapper();
		assertEquals(rows, wordWrapper.inputString("Hello Word!", 7));
	}

	@Test
	public void test3RowLengthInputABCDEF() {
		List<String> rows = Arrays.asList("a b", "c d", "e f");
		WordWrapper wordWrapper = new WordWrapper();
		assertEquals(rows, wordWrapper.inputString("a b c d e f", 3));
	}

	@Test
	public void test5RowLengthInputExcelent() {
		List<String> rows = Arrays.asList("Excel", "ent");
		WordWrapper wordWrapper = new WordWrapper();
		assertEquals(rows, wordWrapper.inputString("Excelent", 5));
	}

}
