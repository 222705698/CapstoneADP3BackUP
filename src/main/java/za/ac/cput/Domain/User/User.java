package za.ac.cput.Domain.User;

import jakarta.persistence.*;
import za.ac.cput.Domain.bookings.Bookings;
import za.ac.cput.Domain.contact.Contact;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int UserId;

    protected String FirstName;
    protected String LastName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    protected Contact Contact;
protected String Password;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Bookings_id")
    protected Bookings UserBooks;
;

    @Enumerated(EnumType.STRING)
    protected Role Role;

    public enum Role {
        ADMIN,
        APPLICANT
    }

    public User() {
    }

    // Getters and setters
    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Contact getContact() {
        return Contact;
    }

    public void setContact(Contact contact) {
        Contact = contact;
    }

    public Bookings getUserBooks() {
        return UserBooks;
    }

    public void setUserBooks(Bookings userBooks) {
        UserBooks = userBooks;
    }

    public String getPassword() {
        return Password;
    }
    @Column(nullable = false)
    public void setPassword(String password) {
        Password = password;
    }

    public Role getRole() {
        return Role;
    }

    public void setRole(Role role) {
        Role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId=" + UserId +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Contact=" + Contact +
                ", Password='" + Password + '\'' +
                ", UserBooks=" + UserBooks +
                ", Role=" + Role +
                '}';
    }
}
