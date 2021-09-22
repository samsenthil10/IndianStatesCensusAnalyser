package com.bridgelabz.indianstatescensusanalyser;

@SuppressWarnings("serial")
public class StateCensusAnalyserException extends Exception {
	enum CensusException {
		CENSUS_FILE_PROBLEM, INCORRECT_TYPE_ISSUE, DELIMITER_ISSUE, INCORRECT_HEADER_PROBLEM
	}

	CensusException exceptionType ;

	public StateCensusAnalyserException(CensusException exceptionType, String message) {
		super(message);
		this.exceptionType = exceptionType;
	}
}