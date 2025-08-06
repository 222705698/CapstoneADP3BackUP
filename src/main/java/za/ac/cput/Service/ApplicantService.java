package za.ac.cput.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.User.Applicant;
import za.ac.cput.Repository.ApplicantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService implements IApplicantService {

    private final ApplicantRepository applicantRepository;

    @Autowired
    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @Override
    public Applicant create(Object o) {
        if (o instanceof Applicant applicant) {
            return applicantRepository.save(applicant);
        }
        return null;
    }

    @Override
    public Applicant read(Object o) {
        if (o instanceof Integer id) {
            Optional<Applicant> applicant = applicantRepository.findById(id);
            return applicant.orElse(null);
        }
        return null;
    }

    @Override
    public Applicant update(Object o) {
        if (o instanceof Applicant applicant && applicantRepository.existsById(applicant.getUserId())) {
            return applicantRepository.save(applicant);
        }
        return null;
    }

    @Override
    public List<Applicant> getAll() {
        return applicantRepository.findAll();
    }
}
