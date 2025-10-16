package com.ualberta.lab6;

import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit tests for the CityList class.
 * Comprehensive testing of all methods including normal cases, edge cases, and exception handling.
 *
 * @author Your Name
 * @version 1.0
 */
public class CityListTest {
    private CityList cityList;
    private City edmonton;
    private City calgary;
    private City redDeer;

    /**
     * Sets up test fixtures before each test method.
     * Creates a new CityList instance and sample City objects.
     */
    @Before
    public void setUp() {
        cityList = new CityList();
        edmonton = new City("Edmonton", "Alberta");
        calgary = new City("Calgary", "Alberta");
        redDeer = new City("Red Deer", "Alberta");
    }

    // Tests for hasCity method

    /**
     * Tests that hasCity returns true when the city exists in the list.
     */
    @Test
    public void testHasCityWhenCityExists() {
        cityList.add(edmonton);
        assertTrue("hasCity should return true when city exists in list",
                cityList.hasCity(edmonton));
    }

    /**
     * Tests that hasCity returns false when the city does not exist in the list.
     */
    @Test
    public void testHasCityWhenCityDoesNotExist() {
        cityList.add(edmonton);
        assertFalse("hasCity should return false when city does not exist in list",
                cityList.hasCity(calgary));
    }

    /**
     * Tests that hasCity throws IllegalArgumentException when given a null parameter.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testHasCityWithNull() {
        cityList.hasCity(null);
    }

    /**
     * Tests that hasCity uses equals method properly for comparison.
     * Two different City objects with the same name should be considered equal.
     */
    @Test
    public void testHasCityUsesEqualsMethod() {
        City edmontonCopy = new City("Edmonton", "Alberta");
        cityList.add(edmonton);

        assertTrue("hasCity should return true for equal cities (same city name)",
                cityList.hasCity(edmontonCopy));
    }

    // Tests for delete method

    /**
     * Tests that delete successfully removes an existing city from the list.
     */
    @Test
    public void testDeleteExistingCity() {
        // Setup
        cityList.add(edmonton);
        cityList.add(calgary);
        int initialCount = cityList.countCities();

        // Execution
        cityList.delete(edmonton);

        // Verification
        assertEquals("City count should decrease by 1 after deletion",
                initialCount - 1, cityList.countCities());
        assertFalse("Deleted city should no longer exist in the list",
                cityList.hasCity(edmonton));
        assertTrue("Other cities should remain in the list after deletion",
                cityList.hasCity(calgary));
    }

    /**
     * Tests that delete throws IllegalArgumentException when trying to delete
     * a city that doesn't exist in the list.
     */
    @Test
    public void testDeleteNonExistingCity() {
        cityList.add(edmonton);
        assertThrows(IllegalArgumentException.class, ()-> {
            cityList.delete(calgary);
        });

    }

    /**
     * Tests that delete throws IllegalArgumentException when given a null parameter.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDeleteWithNull() {
        cityList.delete(null);
    }

    // Tests for countCities method

    /**
     * Tests that countCities returns 0 for an empty list.
     */
    @Test
    public void testCountCitiesEmptyList() {
        assertEquals("countCities should return 0 for empty list",
                0, cityList.countCities());
    }

    /**
     * Tests that countCities correctly counts cities after multiple additions.
     */
    @Test
    public void testCountCitiesAfterAdditions() {
        assertEquals("Initial count should be 0", 0, cityList.countCities());

        cityList.add(edmonton);
        assertEquals("Count should be 1 after adding one city",
                1, cityList.countCities());

        cityList.add(calgary);
        assertEquals("Count should be 2 after adding two cities",
                2, cityList.countCities());

        cityList.add(redDeer);
        assertEquals("Count should be 3 after adding three cities",
                3, cityList.countCities());
    }

    /**
     * Tests that countCities correctly updates after deletions.
     */
    @Test
    public void testCountCitiesAfterDeletion() {
        // Setup
        cityList.add(edmonton);
        cityList.add(calgary);
        cityList.add(redDeer);
        assertEquals("Initial count should be 3", 3, cityList.countCities());

        // Delete one city
        cityList.delete(edmonton);
        assertEquals("Count should be 2 after deleting one city from three",
                2, cityList.countCities());

        // Delete another city
        cityList.delete(calgary);
        assertEquals("Count should be 1 after deleting two cities from three",
                1, cityList.countCities());
    }

    // Additional comprehensive tests

    /**
     * Tests that City equality works correctly based on city name.
     */
    @Test
    public void testCityEquality() {
        City edmontonCopy = new City("Edmonton", "Alberta");
        City differentCity = new City("Calgary", "Alberta");

        // Test equals method
        assertEquals("Cities with same name should be equal regardless of province",
                edmonton, edmontonCopy);
        assertNotEquals("Cities with different names should not be equal",
                edmonton, differentCity);

        // Test hashCode consistency
        assertEquals("Equal cities should have same hash code",
                edmonton.hashCode(), edmontonCopy.hashCode());
    }

    /**
     * Tests that getCities returns a properly sorted list.
     */
    @Test
    public void testGetCitiesReturnsSortedList() {
        // Add cities in non-alphabetical order
        cityList.add(edmonton);
        cityList.add(calgary);
        cityList.add(redDeer);

        List<City> sortedCities = cityList.getCities();
        // Verify alphabetical order: Calgary, Edmonton, Red Deer
        assertEquals("First city should be Calgary",
                "Calgary", sortedCities.get(0).getCity());
        assertEquals("Second city should be Edmonton",
                "Edmonton", sortedCities.get(1).getCity());
        assertEquals("Third city should be Red Deer",
                "Red Deer", sortedCities.get(2).getCity());
    }

    /**
     * Tests that adding a duplicate city throws an exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateCityThrowsException() {
        cityList.add(edmonton);
        cityList.add(edmonton);
    }

    /**
     * Tests that adding a null city throws an exception.
     */
    @Test
    public void testAddNullCityThrowsException() {
        assertThrows(IllegalArgumentException.class, ()-> {
            cityList.add(null);
        });
    }

    /**
     * Comprehensive test: add, check existence, count, delete, and count again.
     */
    @Test
    public void testCompleteWorkflow() {
        // Initial state
        assertEquals(0, cityList.countCities());
        assertFalse(cityList.hasCity(edmonton));

        // Add cities
        cityList.add(edmonton);
        cityList.add(calgary);

        // Verify additions
        assertEquals(2, cityList.countCities());
        assertTrue(cityList.hasCity(edmonton));
        assertTrue(cityList.hasCity(calgary));

        // Delete one city
        cityList.delete(edmonton);

        // Verify deletion
        assertEquals(1, cityList.countCities());
        assertFalse(cityList.hasCity(edmonton));
        assertTrue(cityList.hasCity(calgary));
    }
}