package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        // Verify the list returns whether it has cities properly
        assertEquals(false, cityList.hasCity(city));
        assertEquals(true, cityList.hasCity(mockCity()));
    }

    @Test
    void testRemoveCity() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        // Verify removing a non existing city is fine
        cityList.delete(city);
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // Verify removing an existing city removes it
        cityList.delete(mockCity());
        assertEquals(false, cityList.hasCity(mockCity()));
    }

    @Test
    void testThrowableRemoveCity() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        // Verify removing an existing city removes it
        cityList.assertDelete(mockCity());
        assertEquals(false, cityList.hasCity(mockCity()));
        // Verify removing a non existing city throws an exception
        assertThrows(RuntimeException.class, () -> cityList.assertDelete(city),
                "Expected assertDelete to throw, but it did not");

    }

    @Test
    void testGetSize() {
        CityList cityList = mockCityList();
        // Verify method returns correct size
        assertEquals(1, cityList.getSize());
        // Add new city to the list
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        // Verify method returns correct size after list change
        assertEquals(2, cityList.getSize());
    }
}
