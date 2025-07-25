package za.ac.cput.Factory;

import za.ac.cput.Domain.License;
import za.ac.cput.Util.Helper;

public class LicenseFactory {

public static License createLicense(String licenseType, String issueDate, String expiryDate){

    int licenseId = Helper.generateUniqueId();
    if (Helper.isNullOrEmpty(licenseType) || Helper.isNullOrEmpty(issueDate) || Helper.isNullOrEmpty(expiryDate))
        return null;

    return new License.Builder()
            .setLicenseId(licenseId)
            .setLicenseType(licenseType)
            .setIssueDate(issueDate)
            .setExpiryDate(expiryDate)
            .build();
}
}
