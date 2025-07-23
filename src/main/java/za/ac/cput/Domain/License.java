//Emihle Thole
//221755349
package za.ac.cput.Domain;

public class License {

    private int licenseId;
    private String licenseType;
    private String issueDate;
    private String expiryDate;

    public License() {
    }
    public License (Builder builder){

        this.licenseId = builder.licenseId;
        this.licenseType = builder.licenseType;
        this.issueDate = builder.issueDate;
        this.expiryDate = builder.expiryDate;


    }

    public int getLicenseId() {
        return licenseId;
    }

    public String getLicenseType() {
        return licenseType;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "License{" +
                "licenseId=" + licenseId +
                ", licenseType='" + licenseType + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                '}';
    }
    public static class Builder{
        private int licenseId;
        private String licenseType;
        private String issueDate;
        private String expiryDate;

        public Builder setLicenseId(int licenseId) {
            this.licenseId = licenseId;
            return this;
        }

        public Builder setLicenseType(String licenseType) {
            this.licenseType = licenseType;
            return this;
        }

        public Builder setIssueDate(String issueDate) {
            this.issueDate = issueDate;
            return this;
        }

        public Builder setExpiryDate(String expiryDate) {
            this.expiryDate = expiryDate;
            return this;
        }
        
        public Builder copy(License license){

           this.licenseId = license.licenseId;
           this.licenseType = license.licenseType;
           this.issueDate = license.issueDate;
           this.expiryDate = license.expiryDate;
           return this;

        }
        public License build(){return new License(this);}
    }
}
