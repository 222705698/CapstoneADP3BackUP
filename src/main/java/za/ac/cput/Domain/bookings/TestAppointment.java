package za.ac.cput.Domain.bookings;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class TestAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testAppointmentId;  // lowercase

    private String testAddress;
    private String testVenue;
    private LocalDate testDate;
    private Boolean testResult;
    private String licenseCode;

    @Enumerated(EnumType.STRING)
    private TestType testype;

    private double testAmount;

    public TestAppointment() {
    }

    private TestAppointment(Builder builder) {
        this.testAppointmentId = builder.testAppointmentId;
        this.testAddress = builder.testAddress;
        this.testVenue = builder.testVenue;
        this.testDate = builder.testDate;
        this.testResult = builder.testResult;
        this.licenseCode = builder.licenseCode;
        this.testAmount = builder.testAmount;
        this.testype = builder.testype;
    }

    public Long getTestAppointmentId() {
        return testAppointmentId;
    }

    public String getTestAddress() {
        return testAddress;
    }

    public String getTestVenue() {
        return testVenue;
    }

    public LocalDate getTestDate() {
        return testDate;
    }

    public boolean getTestResult() {
        return testResult;
    }

    public String getLicenseCode() {
        return licenseCode;
    }

    public TestType getTestype() {
        return testype;
    }

    public double getTestAmount() {
        return testAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TestAppointment)) return false;
        TestAppointment test = (TestAppointment) o;
        return testResult == test.testResult &&
                Double.compare(test.testAmount, testAmount) == 0 &&
                Objects.equals(testAppointmentId, test.testAppointmentId) &&
                Objects.equals(testAddress, test.testAddress) &&
                Objects.equals(testVenue, test.testVenue) &&
                Objects.equals(testDate, test.testDate) &&
                Objects.equals(licenseCode, test.licenseCode) &&
                testype == test.testype;
    }

    @Override
    public int hashCode() {
        return Objects.hash(testAppointmentId, testAddress, testVenue, testDate, testResult, licenseCode, testype, testAmount);
    }

    @Override
    public String toString() {
        return "TestAppointment{" +
                "testAppointmentId=" + testAppointmentId +
                ", testAddress='" + testAddress + '\'' +
                ", testVenue='" + testVenue + '\'' +
                ", testDate=" + testDate +
                ", testResult=" + testResult +
                ", licenseCode='" + licenseCode + '\'' +
                ", testype=" + testype +
                ", testAmount=" + testAmount +
                '}';
    }

    public static class Builder {
        private Long testAppointmentId;
        private String testAddress;
        private String testVenue;
        private LocalDate testDate;
        private boolean testResult;
        private String licenseCode;
        private TestType testype;
        private double testAmount;

        public Builder setTestAppointmentId(Long testAppointmentId) {
            this.testAppointmentId = testAppointmentId;
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

        public Builder setTestype(TestType testype) {
            this.testype = testype;
            return this;
        }

        public Builder setTestAmount(double testAmount) {
            this.testAmount = testAmount;
            return this;
        }

        public Builder copy(TestAppointment test) {
            this.testAppointmentId = test.testAppointmentId;
            this.testAddress = test.testAddress;
            this.testVenue = test.testVenue;
            this.testDate = test.testDate;
            this.testResult = test.testResult;
            this.licenseCode = test.licenseCode;
            this.testype = test.testype;
            this.testAmount = test.testAmount;
            return this;
        }

        public TestAppointment build() {
            return new TestAppointment(this);
        }
    }
}
