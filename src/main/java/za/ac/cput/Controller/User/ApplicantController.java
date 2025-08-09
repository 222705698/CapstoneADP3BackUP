package za.ac.cput.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.User.Applicant;
import za.ac.cput.Service.impl.ApplicantService;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PostMapping("/create")
    public ResponseEntity<Applicant> create(@RequestBody Applicant applicant) {
        Applicant created = applicantService.create(applicant);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Applicant> read(@PathVariable Integer id) {
        Applicant applicant = applicantService.read(id);
        return ResponseEntity.ok(applicant);
    }

    @PutMapping("/update")
    public ResponseEntity<Applicant> update(@RequestBody Applicant applicant) {
        Applicant updated = applicantService.update(applicant);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        applicantService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Applicant>> getAll() {
        return ResponseEntity.ok(applicantService.getAll());
    }
}
