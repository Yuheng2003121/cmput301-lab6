package com.ualberta.lab6;

public class City implements Comparable<City> {
    private String city;
    private String province;

    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getprovince() {
        return province;
    }

    public void setprovince(String province) {
        this.province = province;
    }

    /**
     * This methods compares City objects based on their city field
     * @param o the object to be compared.
     * @return 0, <1 or >1 if two values are equal, a<b, or a>b
     */
    @Override
    public int compareTo(City o) {
      return this.city.compareTo(o.getCity());
    }

    /**
     * Checks if this city is equal to another object.
     * Two cities are considered equal if they have the same city name
     * (case-sensitive comparison).
     *
     * @param obj the object to compare with, should be a City instance
     * @return true if the cities have the same name, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        City otherCity = (City) obj;
        return city.equals(otherCity.city);
    }

    /**
     * Returns a hash code value for the city based on the city name.
     * This ensures that equal cities have equal hash codes.
     *
     * @return a hash code value for this city
     */
    @Override
    public int hashCode() {
        return city.hashCode();
    }

    /**
     * Returns a string representation of the city in the format:
     * "City{city='Edmonton', province='Alberta'}".
     *
     * @return a string representation of the city
     */
    @Override
    public String toString() {
        return "City{city='" + city + "', province='" + province + "'}";
    }
}
