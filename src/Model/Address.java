package Model;

public class Address {
    private int     addressID;
    private String  addressLine1;
    private String  addressLine2;
    private String  zipcode;

    private Country country;
    private State state;
    private City city;

    public Address() {
        this.city = new City();
        this.state = new State();
        this.country = new Country();
    }
    public void setCity(String cityName){
        city.setName(cityName);
        city.setCityID(cityName.hashCode());
    }
    public void setState(String stateName){
        state.setName(stateName);
        state.setId(stateName.hashCode());
        state.setAbv(stateName.substring(0,3));
    }
    public void setCountry(String countryName){
        country.setName(countryName);
        country.setId(countryName.hashCode());
        country.setAbv(countryName.substring(0,3));
    }
    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.setAddressID(addressLine1.hashCode());
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
