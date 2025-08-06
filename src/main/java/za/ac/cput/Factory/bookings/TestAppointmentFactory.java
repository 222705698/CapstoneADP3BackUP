package za.ac.cput.Factory.bookings;

import za.ac.cput.Domain.bookings.TestAppointment;
import za.ac.cput.Domain.bookings.TestType;
import za.ac.cput.Util.Helper;

import java.time.LocalDate;

public class TestAppointmentFactory {
    public static TestAppointment createTestAppointment(Long TestAppointmentId, String testAddress, String testVenue, LocalDate testDate, boolean testResult, String licenseCode, TestType testType) {
        if (Helper.isNullOrEmpty(String.valueOf(TestAppointmentId)) || Helper.isNullOrEmpty(testAddress) || Helper.isNullOrEmpty(licenseCode) || Helper.isNullOrEmpty(testVenue) || Helper.isNullOrEmpty(testVenue)) {
            return null;
        }

        if (testDate.isBefore(LocalDate.now())) {
            return null;
        }

        return new TestAppointment.Builder()
                .setTestAppointmentId(TestAppointmentId)
                .setTestAddress(testAddress)
                .setTestVenue(testVenue)
                .setTestDate(testDate)
                .setTestResult(testResult)
                .setLicenseCode(licenseCode)
                .setTestype(testType)
                .build();


    }
}
