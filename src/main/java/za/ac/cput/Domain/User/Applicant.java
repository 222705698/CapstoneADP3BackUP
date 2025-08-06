package za.ac.cput.Domain.User;

import jakarta.persistence.*;
import za.ac.cput.Domain.bookings.Bookings;
import za.ac.cput.Domain.contact.Address;
import za.ac.cput.Domain.contact.Contact;

import java.time.LocalDate;


@Entity
@DiscriminatorValue("APPLICANT")
public class Applicant extends User {

    private String IdNumber;
    private LocalDate BirthDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "license_id")
    private License license;

    public Applicant() {
    }

    private Applicant(Builder builder) {
        this.UserId = builder.UserId;
        this.IdNumber = builder.IdNumber;
        this.BirthDate = builder.BirthDate;
        this.address = builder.address;
        this.license = builder.license;
        this.UserName = builder.UserName;
        this.UserSurname = builder.UserSurname;
        this.Contact = builder.Contact;
        this.UserBooks = builder.UserBooks;
        this.Role = builder.Role;
    }

    public String getIdNumber() {
        return IdNumber;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public Address getAddress() {
        return address;
    }

    public License getLicense() {
        return license;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "UserId=" + UserId +
                ", IdNumber='" + IdNumber + '\'' +
                ", BirthDate=" + BirthDate +
                ", address=" + address +
                ", license=" + license +
                ", UserName='" + UserName + '\'' +
                ", UserSurname='" + UserSurname + '\'' +
                ", Contact=" + Contact +
                ", UserBooks=" + UserBooks +
                ", Role=" + Role +
                '}';
    }

    public static class Builder {
        private int UserId;
        private String IdNumber;
        private LocalDate BirthDate;
        private Address address;
        private License license;
        private String UserName;
        private String UserSurname;
        private Contact Contact;
        private Bookings UserBooks;
        private Role Role;

        public Builder setUserId(int userId) {
            this.UserId = userId;
            return this;
        }

        public Builder setIdNumber(String idNumber) {
            this.IdNumber = idNumber;
            return this;
        }

        public Builder setBirthDate(LocalDate birthDate) {
            this.BirthDate = birthDate;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder setLicense(License license) {
            this.license = license;
            return this;
        }

        public Builder setUserName(String userName) {
            this.UserName = userName;
            return this;
        }

        public Builder setUserSurname(String userSurname) {
            this.UserSurname = userSurname;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.Contact = contact;
            return this;
        }

        public Builder setUserBooks(Bookings userBooks) {
            this.UserBooks = userBooks;
            return this;
        }

        public Builder setRole(Role role) {
            this.Role = role;
            return this;
        }

        public Builder copy(Applicant applicant) {
            this.UserId = applicant.UserId;
            this.IdNumber = applicant.IdNumber;
            this.BirthDate = applicant.BirthDate;
            this.address = applicant.address;
            this.license = applicant.license;
            this.UserName = applicant.UserName;
            this.UserSurname = applicant.UserSurname;
            this.Contact = applicant.Contact;
            this.UserBooks = applicant.UserBooks;
            this.Role = applicant.Role;
            return this;
        }

        public Applicant build() {
            return new Applicant(this);
        }
    }
}
