package models;

public class Address {
    private final String street;
    private final String city;
    private final int zipCode;
    private final int postalCode;
    private final String state;
    private final String country;

    public Address(String street, String city, int zipCode, int postalCode, String state, String country) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.postalCode = postalCode;
        this.state = state;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipCode=" + zipCode +
                ", postalCode=" + postalCode +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
