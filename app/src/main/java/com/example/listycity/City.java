package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable{
    private String city;
    private String province;
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Returns the city name
     * @return
     * String of city name
     */
    String getCityName(){
        return this.city;
    }

    /**
     * Returns the province name
     * @return
     * String of province name
     */
    String getProvinceName(){
        return this.province;
    }

    /**
     * Compares the city with the passed object
     * @param o
     * Object to compare with
     * @return
     * Positive integer if this City object's city name follows lexicographically, 0 if they are equal, negative otherwise.
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }

    /**
     * Returns whether the city is equal to the passed object
     * @param o
     * Object to compare with
     * @return
     * True if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        City city = (City) o;
        return this.city.equals(city.city) && this.province.equals(city.province);
    }

    /**
     * Returns hashcode formed from city name and province hashcodes
     * @return
     * int hashcode
     */
    @Override
    public int hashCode(){
        return city.hashCode() + province.hashCode();
    }
}