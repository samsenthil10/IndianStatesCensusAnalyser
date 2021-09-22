package com.bridgelabz.indianstatescensusanalyser;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StateCensusAnalyserTest {
	public static final String CSV_FILE_WITHOUT_HEADER = "/home/senthil/Training1/eclipse-training/IndianStatesCensusAnalyser/IndianStateCensusDataWithoutHeader.csv";
	public static final String CSV_FILE_WITH_WRONG_DELIMITER = "/home/senthil/Training1/eclipse-training/IndianStatesCensusAnalyser/IndianStateCensusDataWithWrongDelimiter.csv";
	public static final String NOT_A_CSV_FILE = "/home/senthil/Training1/eclipse-training/IndianStatesCensusAnalyser/new.txt";
	public static final String FILE_NOT_EXIST = "incorrectFilePath.csv";
	public static final String CORRECT_CSV_FILE = "/home/senthil/Training1/eclipse-training/IndianStatesCensusAnalyser/IndianStateCensusData.csv";

	@Test
	public void givenIndianCensusCSVFile_ShouldReturnCorrectRecords() throws StateCensusAnalyserException {
		StateCensusAnalyser analyser = new StateCensusAnalyser();
		int count = analyser.loadIndianStateCensusData(CORRECT_CSV_FILE);
		assertEquals(29, count);
	}
}