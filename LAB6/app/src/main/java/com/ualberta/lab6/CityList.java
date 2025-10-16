package com.ualberta.lab6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class holds the City type objects in a list
 */
public class CityList {
    private List<City> cities = new ArrayList<>();


    /**
     * This method add a city object to the cities list
     * @param city
     *         This is a City object we want to add to the list
     * @throws  IllegalArgumentException if the city already exists in the list
     */
    public void add(City city) {
        if (city == null) {
            throw new IllegalArgumentException("City cannot be null");
        }

        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists in the list");
        }

        cities.add(city);
    }

    /**
     * Deletes the specified city from the list.
     * If the city is not found in the list, an exception is thrown.
     *
     * @param city the city to delete from the list
     * @throws IllegalArgumentException if the city is null or not found in the list
     */
    public void delete(City city) {
        if (city == null) {
            throw new IllegalArgumentException("City cannot be null");
        }
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not found in the list");
        }
        cities.remove(city);
    }

    /**
     * Checks whether the specified city exists in the list.
     * Uses the equals method for comparison, which compares cities by name.
     *
     * @param city the City object to check for existence, cannot be null
     * @return true if the city exists in the list, false otherwise
     * @throws IllegalArgumentException if the city parameter is null
     */
    public boolean hasCity(City city) {
        if (city == null) {
            throw new IllegalArgumentException("City cannot be null");
        }
        return cities.contains(city);
    }

    /**
     * Returns the number of cities in the list.
     *
     * @return the count of cities in the list
     */
    public int countCities() {
        return cities.size();
    }

    /**
     * This methdos sorts the list of cities
     * @return
     *          a sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }



}
