package za.ac.cput.Factory.User;

import za.ac.cput.Domain.User.License;
import za.ac.cput.Util.Helper;

import java.time.LocalDate;

public class LicenseFactory {

public static License createLicense(String licenseCode, LocalDate issueDate, LocalDate expiryDate){

    int licenseId = Helper.generateUniqueId();
    if (Helper.isNullOrEmpty(licenseCode) || issueDate == null || expiryDate == null) {
        return null;
    }

    return new License.Builder()
            .setLicenseId(licenseId)
            .setlicenseCode(licenseCode)
            .setIssueDate(issueDate)
            .setExpiryDate(expiryDate)
            .build();
}
}
