package za.ac.cput.Domain.User;

import jakarta.persistence.*;
import za.ac.cput.Domain.bookings.Bookings;
import za.ac.cput.Domain.contact.Contact;

/*Masibuve Sikhulume
221807144
 */
@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int UserId;
    protected String UserName;
    protected String UserSurname;


    @OneToOne
    @JoinColumn(name = "contact_id")
    protected Contact Contact;

    @ManyToOne
    @JoinColumn(name = "user_books_booking_id")
    protected Bookings UserBooks;

    @Enumerated(EnumType.STRING)
    protected Role Role;

    // Enum for user roles
    public enum Role {
        ADMIN,
        APPLICANT
    }

    public User() {
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserSurname() {
        return UserSurname;
    }

    public void setUserSurname(String userSurname) {
        UserSurname = userSurname;
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
                ", UserName='" + UserName + '\'' +
                ", UserSurname='" + UserSurname + '\'' +
                ", Contact=" + Contact +
                ", UserBooks=" + UserBooks +
                ", Role=" + Role +
                '}';
    }
}