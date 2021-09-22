package com.bridgelabz.indianstatescensusanalyser;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.StreamSupport;
public class StateCensusAnalyser {

	public int loadIndianStateCensusData(String filePath) throws StateCensusAnalyserException {
		try(Reader reader = Files.newBufferedReader(Paths.get(filePath))) {

			CsvToBeanBuilder<CSVStateCensus> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(CSVStateCensus.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<CSVStateCensus> csvToBean = csvToBeanBuilder.build();
			Iterator<CSVStateCensus> censusCSVIterator = csvToBean.iterator();
			Iterable<CSVStateCensus>  csvIterable = () -> censusCSVIterator;
			int numberOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(),false).count();
			return numberOfEntries;
		} catch (RuntimeException e){
			String[] s = filePath.split("[.]");
			System.out.println(s[1]);
			if(!Objects.equals(s[1], "csv")){
				throw new StateCensusAnalyserException(StateCensusAnalyserException.CensusException.INCORRECT_TYPE_ISSUE,
						"Incorrect File extension");
			}
			if (e.getMessage().equalsIgnoreCase("Error capturing CSV header!")) {
				throw new StateCensusAnalyserException(
						StateCensusAnalyserException.CensusException.INCORRECT_HEADER_PROBLEM, "Incorrect Header");
			} else {
				throw new StateCensusAnalyserException(
						StateCensusAnalyserException.CensusException.DELIMITER_ISSUE, "Incorrect Delimiter Issue");
			}
		}

		catch (IOException e) {
			throw new StateCensusAnalyserException(StateCensusAnalyserException.CensusException.CENSUS_FILE_PROBLEM,
					"Incorrect File path");

		} 
	}
}