package za.ac.cput.Domain;

import za.ac.cput.Domain.bookings.TestType;

import java.time.LocalDate;
import java.util.Objects;

public class Test {
    private int TestId;
    private String testAddress;
    private String testVenue;
    private LocalDate testDate;
    private boolean testResult;
    private String licenseCode;
    private TestType testype;
    private double testAmount;

    public Test() {
    }
    private Test(Builder builder) {
        this.TestId = builder.TestId;
        this.testAddress = builder.testAddress;
        this.testVenue = builder.testVenue;
        this.testDate = builder.testDate;
        this.testResult = builder.testResult;
        this.licenseCode = builder.licenseCode;
        this.testAmount = builder.testAmount;
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

    public int getTestId() {
        return TestId;
    }

    public String getTestVenue() {
        return testVenue;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return testResult == test.testResult && testAmount == test.testAmount && Objects.equals(TestId, test.TestId) && Objects.equals(testAddress, test.testAddress) && Objects.equals(testVenue, test.testVenue) && Objects.equals(testDate, test.testDate) && Objects.equals(licenseCode, test.licenseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TestId, testAddress, testVenue, testDate, testResult, licenseCode, testAmount);
    }
    @Override
    public String toString() {
        return "Test{" +
                "TestId='" + TestId + '\'' +
                ", testAddress='" + testAddress + '\'' +
                ", testVenue='" + testVenue + '\'' +
                ", testDate=" + testDate +
                ", testResult=" + testResult +
                ", licenseCode='" + licenseCode + '\'' +
                ", testAmount=" + testAmount +
                '}';
    }
    public static class Builder {
        private int TestId;
        private String testAddress;
        private String testVenue;
        private LocalDate testDate;
        private boolean testResult;
        private String licenseCode;
        private double testAmount;

        public Builder setTestId(int TestId) {
            this.TestId = TestId;
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
        public Builder copy(Test test) {
            this.TestId = test.TestId;
            this.testAddress = test.testAddress;
            this.testVenue = test.testVenue;
            this.testDate = test.testDate;
            this.testResult = test.testResult;
            this.licenseCode = test.licenseCode;
            this.testAmount = test.testAmount;
            return this;

        }
        public Test build() {
            return new Test(this);
        }
    }

}