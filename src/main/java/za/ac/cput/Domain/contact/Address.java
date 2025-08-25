package za.ac.cput.Domain.contact;
/*Masibuve Sikhulume
221807144
 */
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Address {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    private String street;
    private String city;
    private String province;
    private String country;

    public Address() {
    }
    private Address(Builder builder) {
        this.addressId = builder.addressId;
        this.street = builder.street;
        this.city = builder.city;
        this.province = builder.province;
        this.country = builder.country;
    }
    public int getAddressId() {
        return addressId;
    }
    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public String getProvince() {
        return province;
    }
    public String getCountry() {
        return country;
    }
    @Override

    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
    public static class Builder{
        private int addressId;
        private String street;
        private String city;
        private String province;
        private String country;

        public Builder setAddressId(int addressId) {
            this.addressId = addressId;
            return this;
        }
        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }
        public Builder setCity(String city) {
            this.city = city;
            return this;
        }
        public Builder setProvince(String province) {
            this.province = province;
            return this;
        }
        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }
        public Builder copy(Address address) {
            this.addressId = address.addressId;
            this.street = address.street;
            this.city = address.city;
            this.province = address.province;
            this.country = address.country;
            return this;
        }
        public Address build() {
            return new Address(this);
        }
    }
}
