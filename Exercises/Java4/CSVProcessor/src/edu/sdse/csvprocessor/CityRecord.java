package edu.sdse.csvprocessor;

public class CityRecord{
    int id, year, population;
    String city;

    public static void main(String[] argv){
        CityRecord cr = new CityRecord(101, 1999, "Copenhagen", 100000);
        System.out.println(cr);

    }

    public CityRecord(int id, int year, String city, int population){
        this.id = id;
        this.year = year;
        this.city = city;
        this.population = population;
    }

    public String toString(){
        return String.format("id: %d, year: %d, city: %s, population: %s", this.id, this.year, this.city, this.population);
    }
}
