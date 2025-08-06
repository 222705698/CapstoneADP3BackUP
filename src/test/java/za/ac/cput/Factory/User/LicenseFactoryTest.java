package za.ac.cput.Factory.User;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LicenseFactoryTest {

    @Test
    void createLicense_ValidInput_ReturnsLicense() {
        var license = LicenseFactory.createLicense(
                "123456789", "B", "2024-01-01", "2025-01-01");

        assertNotNull(license);
        assertEquals(123456789, license.getLicenseId());
        assertEquals("B", license.getLicenseType());
        assertEquals("2024-01-01", license.getIssueDate());
        assertEquals("2025-01-01", license.getExpiryDate());
    }

    @Test
    void createLicense_InvalidInput_ReturnsNull() {
        var result = LicenseFactory.createLicense(
                0, "", "2024-01-01", "2025-01-01");
        assertNull(result);
    }

}