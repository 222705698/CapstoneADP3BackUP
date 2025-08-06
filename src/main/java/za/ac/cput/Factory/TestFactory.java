package za.ac.cput.Factory;

import za.ac.cput.Domain.bookings.Test;
import za.ac.cput.Domain.bookings.TestType;

import java.time.LocalDate;

public class TestFactory {
    public static Test createTest(Long TestId, String testAddress, String testVenue, LocalDate testDate, boolean testResult, String licenseCode, TestType testType) {
        if (TestId == null || testAddress == null || testVenue == null || testDate == null || licenseCode == null) {
            return null;
        }

        if (testDate.isBefore(LocalDate.now())) {
            return null;
        }

        return new Test.Builder()
                .setTestId(TestId)
                .setTestAddress(testAddress)
                .setTestVenue(testVenue)
                .setTestDate(testDate)
                .setTestResult(testResult)
                .setLicenseCode(licenseCode)
                .setTestype(testType)
                .build();


    }
}
