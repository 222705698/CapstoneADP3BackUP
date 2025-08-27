package za.ac.cput.Domain.bookings;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class TestAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testAppointmentId;  // lowercase

    private String testAddress;
    private String testVenue;
    private LocalDate testDate;
    private LocalTime testTime;
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
        this.testTime = getTestTime();
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

    public LocalTime getTestTime() {
        return testTime != null ? testTime : LocalTime.of(9, 0);
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
        if (o == null || getClass() != o.getClass()) return false;
        TestAppointment that = (TestAppointment) o;
        return Double.compare(testAmount, that.testAmount) == 0 && Objects.equals(testAppointmentId, that.testAppointmentId) && Objects.equals(testAddress, that.testAddress) && Objects.equals(testVenue, that.testVenue) && Objects.equals(testDate, that.testDate) && Objects.equals(testTime, that.testTime) && Objects.equals(testResult, that.testResult) && Objects.equals(licenseCode, that.licenseCode) && testype == that.testype;
    }

    @Override
    public int hashCode() {
        return Objects.hash(testAppointmentId, testAddress, testVenue, testDate, testTime, testResult, licenseCode, testype, testAmount);
    }

    @Override
    public String toString() {
        return "TestAppointment{" +
                "licenseCode='" + licenseCode + '\'' +
                ", testAppointmentId=" + testAppointmentId +
                ", testAddress='" + testAddress + '\'' +
                ", testVenue='" + testVenue + '\'' +
                ", testDate=" + testDate +
                ", testTime=" + testTime +
                ", testResult=" + testResult +
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
        private LocalTime testTime;

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
        public Builder setTestTime(LocalTime testTime) {
            this.testTime = testTime;
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
            this.testTime = test.testTime;
            return this;
        }

        public TestAppointment build() {
            return new TestAppointment(this);
 }
}
}
