package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import kotlin.jvm.Throws;

/**
 * This is a class that keeps a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This returns whether the list contains the city passed
     * @param city
     * The city to check if in the list
     * @return
     * boolean True if the city is in the list, else false
     */
    public boolean hasCity(City city){
        return cities.contains(city);
    }


    /**
     * Removes the passed city from the list if present
     * @param city
     * The city to remove from the list
     */
    public void delete(City city){
        cities.remove(city);
    }

    /**
     * Removes the passed city from the list if present
     * @param city
     * The city to remove from the list
     */
    public void assertDelete(City city) throws RuntimeException{
        if (!cities.remove(city)){
            throw new RuntimeException("assertDelete called but CityList did not contain " +
                    "city(" + city.getCityName() + ", " + city.getProvinceName() + ").");  }
    }

    /**
     * Returns the number of cities in the list
     * @return
     * int containing the number of cities
     */
    public int getSize(){
        return cities.size();
    }
}
