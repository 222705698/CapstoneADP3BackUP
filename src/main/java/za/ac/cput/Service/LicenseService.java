package za.ac.cput.Service;


import za.ac.cput.Domain.User.License;

import za.ac.cput.Repository.LicenseRepository;

import java.util.List;

public class LicenseService implements ILicenseService{
    

    private LicenseRepository repository;
    public LicenseService(LicenseRepository licenseRepository) {
        this.repository = licenseRepository;
    }



    @Override
    public License create(License license) {
        return this.repository.save(license);
    }

    @Override
    public License read(Integer integer) {
        return this.repository.findById(integer)
                .orElse(null);
    }

    @Override
    public License update(License license) {
        return this.repository.save(license);
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public List<License> getall() {
        return this.repository.findAll();
    }
    @Override
    public License findById(Integer id) {
        return this.repository.findById(id)
                .orElse(null);
    }
}

