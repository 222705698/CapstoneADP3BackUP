package za.ac.cput.Domain.User;

import jakarta.persistence.*;
import za.ac.cput.Domain.bookings.Bookings;
import za.ac.cput.Domain.contact.Contact;
import za.ac.cput.Domain.payment.Payment;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {

    @OneToMany(mappedBy = "admin", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    protected Status status;

    private String reason;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public enum Status {
        PENDING,
        ACCEPTED,
        REJECTED
    }

    public Admin() {
    }

    private Admin(Builder builder) {
        this.UserId = builder.UserId;
        this.UserName = builder.UserName;
        this.UserSurname = builder.UserSurname;
        this.Contact = builder.Contact;
        this.UserBooks = builder.UserBooks;
        this.Role = builder.Role;
        this.payments = builder.payments != null ? builder.payments : new ArrayList<>();
        this.status = builder.status;
        this.reason = builder.reason;

        // Set admin on each payment for bi-directional consistency
        for (Payment p : this.payments) {
            p.setAdmin(this);
        }
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public Status getStatus() {
        return status;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "UserId=" + UserId +
                ", payments=" + payments +
                ", status=" + status +
                ", reason='" + reason + '\'' +
                ", UserName='" + UserName + '\'' +
                ", UserSurname='" + UserSurname + '\'' +
                ", Contact=" + Contact +
                ", UserBooks=" + UserBooks +
                ", Role=" + Role +
                '}';
    }

    public static class Builder {
        private int UserId;
        private String UserName;
        private String UserSurname;
        private Contact Contact;
        private Bookings UserBooks;
        private Role Role;
        private List<Payment> payments;
        private Status status;
        private String reason;

        public Builder setUserId(int userId) {
            this.UserId = userId;
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

        public Builder setPayments(List<Payment> payments) {
            this.payments = payments;
            return this;
        }

        public Builder setStatus(Status status) {
            this.status = status;
            return this;
        }

        public Builder setReason(String reason) {
            this.reason = reason;
            return this;
        }

        public Builder copy(Admin admin) {
            this.UserId = admin.UserId;
            this.UserName = admin.UserName;
            this.UserSurname = admin.UserSurname;
            this.Contact = admin.Contact;
            this.UserBooks = admin.UserBooks;
            this.Role = admin.Role;
            this.payments = admin.payments;
            this.status = admin.status;
            this.reason = admin.reason;
            return this;
        }

        public Admin build() {
            return new Admin(this);
        }
    }
}
