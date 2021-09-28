package edu.sdse.csvprocessor;

import java.nio.file.Files;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Map.*;
import java.util.*;

public class CityCSVProcessor {
	
	public void readAndProcess(File file) {
		//Try with resource statement (as of Java 8)
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			//Discard header row
			br.readLine();
			
			String line;
            List<CityRecord> allRecords = new ArrayList<CityRecord>();
            Map<String, List<CityRecord>> recordFor = new HashMap<String, List<CityRecord>>();

			
			while ((line = br.readLine()) != null) {
				// Parse each line
				String[] rawValues = line.split(",");
				
				int id = convertToInt(rawValues[0]);
				int year = convertToInt(rawValues[1]);
				String city = convertToString(rawValues[2]);
				int population = convertToInt(rawValues[3]);
                CityRecord record = new CityRecord(id, year, city, population);

                if (!recordFor.containsKey(city)){
                    recordFor.put(city, new ArrayList<CityRecord>());
                }
                recordFor.get(city).add(record);
                allRecords.add(record);
				
				System.out.println(record);
    		}
            for (Entry<String, List<CityRecord>> entry : recordFor.entrySet()){
                int entries = 0;
                int minYear = 9999;
                int maxYear = 0;
                float avgPop = 0f;
                for (CityRecord record : entry.getValue()){
                    entries++;
                    if (record.year < minYear)
                        minYear = record.year;
                    if (record.year > maxYear)
                        maxYear = record.year;
                    avgPop += (float) record.population;
                }
                System.out.println("city: " + entry.getKey() + ", entries: " + entries + ", minYear: " + minYear +
                ", maxYear: " + maxYear + ", avgPop: " + avgPop/entries);
            }
		} catch (Exception e) {
			System.err.println("An error occurred:");
			e.printStackTrace();
		}
	}
	
	private String cleanRawValue(String rawValue) {
		return rawValue.trim();
	}
	
	private int convertToInt(String rawValue) {
		rawValue = cleanRawValue(rawValue);
		return Integer.parseInt(rawValue);
	}
	
	private String convertToString(String rawValue) {
		rawValue = cleanRawValue(rawValue);
		
		if (rawValue.startsWith("\"") && rawValue.endsWith("\"")) {
			return rawValue.substring(1, rawValue.length() - 1);
		}
		
		return rawValue;
	}
	
public static final void main(String[] args) throws IOException {

		CityCSVProcessor reader = new CityCSVProcessor();
		
		File dataDirectory = new File("../data");
		File csvFile = new File(dataDirectory, "Cities.csv");
		
		reader.readAndProcess(csvFile);
	}
}
