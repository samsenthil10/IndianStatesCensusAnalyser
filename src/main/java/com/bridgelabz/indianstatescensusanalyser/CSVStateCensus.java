package com.bridgelabz.indianstatescensusanalyser;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus {
	
	@CsvBindByName(column = "State")
	String state;

	@CsvBindByName(column = "Population", required = true)
	float population;

	@CsvBindByName(column = "AreaInSqKm")
	float areaInSqKm;

	@CsvBindByName(column = "DensityPerSqKm", required = true)
	float densityPerSqKm;

	public CSVStateCensus(String state, float population, float areaInSqKm, float densityPerSqKm) {
		super();
		this.state = state;
		this.population = population;
		this.areaInSqKm = areaInSqKm;
		this.densityPerSqKm = densityPerSqKm;
	}

	public CSVStateCensus() {
		super();
	}
}