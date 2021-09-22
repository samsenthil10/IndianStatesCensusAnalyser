package com.bridgelabz.indianstatescensusanalyser;

public class StatesCodeAnalyser {
    public int loadIndianStateCodeData(String filePath) throws StateCensusAnalyserException {
        final Class<CsvStates> csvStatesClass = CsvStates.class;
        CsvLoader loader = new CsvLoader<CsvStates>();
        return loader.loadCSVFile(filePath, csvStatesClass);
    }
}