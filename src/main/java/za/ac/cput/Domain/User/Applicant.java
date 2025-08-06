package za.ac.cput.Domain.User;

import jakarta.persistence.*;
import za.ac.cput.Domain.bookings.Bookings;
import za.ac.cput.Domain.contact.Address;
import za.ac.cput.Domain.contact.Contact;

import java.time.LocalDate;
@Entity
public class Applicant extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserId;
    private String IdNumber;
    private LocalDate BirthDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "license_id")
    private License license;

    public Applicant() {
    }
    public Applicant(Builder builder) {

        this.IdNumber = builder.IdNumber;
        this.BirthDate = builder.BirthDate;
        this.address = builder.address;
        this.license = builder.license;
        this.UserId = builder.UserId;
        this.UserName = builder.UserName;
        this.UserSurname = builder.UserSurname;
        this.Contact = builder.Contact;
        this.UserBooks = builder.UserBooks;
        this.Role = builder.Role;
    }

    @Override
    public int getUserId() {
        return UserId;
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
                ", UserId=" + UserId +
                ", UserName='" + UserName + '\'' +
                ", UserSurname='" + UserSurname + '\'' +
                ", Contact=" + Contact +
                ", UserBooks=" + UserBooks +
                ", Role=" + Role +
                '}';
    }

    public static class Builder{
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

        public Builder setIdNumber(String idNumber) {
            IdNumber = idNumber;
            return this;
        }
        public Builder setBirthDate(LocalDate birthDate) {
            BirthDate = birthDate;
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
        public Builder setUserId(int userId) {
            UserId = userId;
            return this;
        }
        public Builder setUserName(String userName) {
            UserName = userName;
            return this;
        }
        public Builder setUserSurname(String userSurname) {
            UserSurname = userSurname;
            return this;
        }
        public Builder setContact(Contact contact) {
            Contact = contact;
            return this;
        }
        public Builder setUserBooks(Bookings userBooks) {
            UserBooks = userBooks;
            return this;
        }
        public Builder setRole(Role role) {
            Role = role;
            return this;
        }
        public Builder copy(Applicant applicant) {
            this.IdNumber = applicant.IdNumber;
            this.BirthDate = applicant.BirthDate;
            this.address = applicant.address;
            this.license = applicant.license;
            this.UserId = applicant.UserId;
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
