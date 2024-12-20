package com.bridgelabz.indianstatescensusanalyser;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StatesCodeAnalyserTest {
	public static final String CSV_FILE_WITHOUT_HEADER = "StatesCodeDataWithoutHeader.csv";
	public static final String CSV_FILE_WITH_WRONG_DELIMITER = "StatesCodeDataWithWrongDelimiter.csv";
	public static final String NOT_A_CSV_FILE = "new.txt";
	public static final String FILE_NOT_EXIST = "incorrectFilePath.csv";
	public static final String CORRECT_CSV_FILE = "StatesCodeData.csv";
	StatesCodeAnalyser analyser;

	@Before
	public void initialize() {
		analyser = new StatesCodeAnalyser();
	}
	@Test
	public void givenStatesCodeDataFile_ShouldReturnCorrectRecords() throws StateCensusAnalyserException {
		int count = analyser.loadIndianStateCodeData(CORRECT_CSV_FILE);
		assertEquals(37, count);
	}

	@Test
	public void givenCSVFile_ReturnException_ifFileNotPresent() {
		try {
			analyser.loadIndianStateCodeData(FILE_NOT_EXIST);
		} catch (StateCensusAnalyserException e) {
			assertEquals(StateCensusAnalyserException.CensusException.CENSUS_FILE_PROBLEM, e.exceptionType);
		}
	}

	@Test
	public void givenNonCSVFile_ThrowIncorrectTypeIssueException() {
		try {
			analyser.loadIndianStateCodeData(NOT_A_CSV_FILE);
		} catch (StateCensusAnalyserException e) {
			assertEquals(StateCensusAnalyserException.CensusException.INCORRECT_TYPE_ISSUE, e.exceptionType);
		}
	}
	@Test
	public void givenCorrectCSVFile_WhenDelimiterInvalid_ThrowDelimiterIssueException() {
		try {
			analyser.loadIndianStateCodeData(CSV_FILE_WITH_WRONG_DELIMITER);
		} catch (StateCensusAnalyserException e) {
			assertEquals(StateCensusAnalyserException.CensusException.DELIMITER_ISSUE, e.exceptionType);
		}
	}
	@Test
	public void givenCorrectCSVFile_WhenHeaderAbsent_ThrowIncorrectHeaderException() {
		try {
			analyser.loadIndianStateCodeData(CSV_FILE_WITHOUT_HEADER);
		} catch (StateCensusAnalyserException e) {
			assertEquals(StateCensusAnalyserException.CensusException.INCORRECT_HEADER_PROBLEM, e.exceptionType);
		}
	}
}