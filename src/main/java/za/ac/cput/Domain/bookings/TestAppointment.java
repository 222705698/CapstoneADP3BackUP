package za.ac.cput.Domain.bookings;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
@Entity
public class TestAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long TestAppointmentId;
    private String testAddress;
    private String testVenue;
    private LocalDate testDate;
    private boolean testResult;
    private String licenseCode;

    @Enumerated(EnumType.STRING)
    private TestType testype;
    private double testAmount;

    public TestAppointment() {
    }
    private TestAppointment(Builder builder) {
        this.TestAppointmentId = builder.TestAppointmentId;
        this.testAddress = builder.testAddress;
        this.testVenue = builder.testVenue;
        this.testDate = builder.testDate;
        this.testResult = builder.testResult;
        this.licenseCode = builder.licenseCode;
        this.testAmount = builder.testAmount;
        this.testype = builder.testype;
    }

    public String getLicenseCode() {
        return licenseCode;
    }

    public String getTestAddress() {
        return testAddress;
    }

    public double getTestAmount() {
        return testAmount;
    }

    public LocalDate getTestDate() {
        return testDate;
    }

    public boolean isTestResult() {
        return testResult;
    }

    public Long getTestAppointmentId() {
        return TestAppointmentId;
    }

    public String getTestVenue() {
        return testVenue;
    }

    public TestType getTestype() {
        return testype;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TestAppointment test = (TestAppointment) o;
        return testResult == test.testResult && Double.compare(testAmount, test.testAmount) == 0 && Objects.equals(TestAppointmentId, test.TestAppointmentId) && Objects.equals(testAddress, test.testAddress) && Objects.equals(testVenue, test.testVenue) && Objects.equals(testDate, test.testDate) && Objects.equals(licenseCode, test.licenseCode) && testype == test.testype;
    }

    @Override
    public int hashCode() {
        return Objects.hash(TestAppointmentId, testAddress, testVenue, testDate, testResult, licenseCode, testype, testAmount);
    }

    @Override
    public String toString() {
        return "Test{" +
                "licenseCode='" + licenseCode + '\'' +
                ", TestAppointmentId=" + TestAppointmentId +
                ", testAddress='" + testAddress + '\'' +
                ", testVenue='" + testVenue + '\'' +
                ", testDate=" + testDate +
                ", testResult=" + testResult +
                ", testype=" + testype +
                ", testAmount=" + testAmount +
                '}';
    }

    public static class Builder {
        private Long TestAppointmentId;
        private String testAddress;
        private String testVenue;
        private LocalDate testDate;
        private boolean testResult;
        private String licenseCode;
        private double testAmount;
        private TestType testype;

        public Builder setTestAppointmentId(Long TestAppointmentId) {
            this.TestAppointmentId = TestAppointmentId;
            return this;
        }

        public Builder setTestAddress(String testAddress) {
            this.testAddress = testAddress;
            return this;
        }

        public Builder setTestVenue(String testVenue) {
            this.testVenue = testVenue;
            return this;
        }

        public Builder setTestDate(LocalDate testDate) {
            this.testDate = testDate;
            return this;
        }

        public Builder setTestResult(boolean testResult) {
            this.testResult = testResult;
            return this;
        }

        public Builder setLicenseCode(String licenseCode) {
            this.licenseCode = licenseCode;
            return this;
        }

        public Builder setTestAmount(double testAmount) {
            this.testAmount = testAmount;
            return this;
        }
        public Builder setTestype(TestType testype) {
            this.testype = testype;
            return this;
        }
        public Builder copy(TestAppointment test) {
            this.TestAppointmentId = test.TestAppointmentId;
            this.testAddress = test.testAddress;
            this.testVenue = test.testVenue;
            this.testDate = test.testDate;
            this.testResult = test.testResult;
            this.licenseCode = test.licenseCode;
            this.testAmount = test.testAmount;
            this.testype = test.testype;
            return this;

        }
        public TestAppointment build() {
            return new TestAppointment(this);
        }
    }

}