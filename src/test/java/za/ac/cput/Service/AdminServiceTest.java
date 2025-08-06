package za.ac.cput.Service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import za.ac.cput.Domain.User.Admin;

@SpringBootTest
public class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    @Test
    @Commit  // Ensures the transaction commits, data will be saved
    public void testCreateAdmin() {
        Admin admin = new Admin.Builder()
                .setUserName("Real")
                .setUserSurname("Database")
                .build();

        Admin saved = adminService.create(admin);

        assertNotNull(saved);
        assertTrue(saved.getUserId() > 0);
        System.out.println("Saved Admin ID: " + saved.getUserId());
    }
}
