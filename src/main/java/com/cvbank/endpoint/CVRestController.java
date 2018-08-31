package com.cvbank.endpoint;

import com.cvbank.error.ResourceNotFoundException;
import com.cvbank.model.CV;
import com.cvbank.model.CVactivity;
import com.cvbank.repository.CVRepository;
import com.cvbank.repository.CVactivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CVRestController {


    @Autowired
    private CVRepository CVRepository;

    @Autowired
    private CVactivityRepository cvActivityRepository;

    @GetMapping("/cv")
    public List<CV> getAllCV() {

        return CVRepository.findAll();

    }

    @GetMapping("/cv/{id}")
    public CV getCV(@PathVariable Long id) {

        Optional<CV> cv = CVRepository.findById(id);

        if (!cv.isPresent()) {
            throw new ResourceNotFoundException(CV.class.getSimpleName() + " id not found - " + id);
        }
        return cv.get();
    }

    @PostMapping("/cv")
    @Transactional
    public ResponseEntity<?> createNewCV(@RequestBody CV cv) {
        //сохранять и cv и cvActivity
        CVRepository.save(cv);
        List<CVactivity> cvActivity = cv.getCvActivity();
        for(CVactivity cvAct: cvActivity) {
            cvAct.setCv(cv);
            cvActivityRepository.save(cvAct);
        }
        return new ResponseEntity<>("New " + CV.class.getSimpleName() + " " + cv.getId() + " has been created", HttpStatus.CREATED);
    }


    @PutMapping("/cv/{id}")
    @Transactional
    public ResponseEntity<?> updateCV(@RequestBody CV cv, @PathVariable Long id) {

        Optional<CV> tempCV = CVRepository.findById(id);

        if (!tempCV.isPresent()) {
            throw new ResourceNotFoundException(CV.class.getSimpleName() + " id not found - " + cv.getId());
        }

        cv.setId(id);
        CVRepository.save(cv);

        return new ResponseEntity<>("New " + CV.class.getSimpleName() + " with id" + cv.getId() + " has been updated", HttpStatus.OK);

    }

    @DeleteMapping("/cv/{id}")
    @Transactional
    public ResponseEntity<?> deleteCV(@PathVariable Long id) {

        Optional<CV> cv = CVRepository.findById(id);

        if (cv.isPresent()) {
            CVRepository.deleteById(id);
            return new ResponseEntity<>("Deleted " + CV.class.getSimpleName() + " id - " + id, HttpStatus.OK);
        }

        throw new ResourceNotFoundException(CV.class.getSimpleName() + " id not found - " + id);
    }


    @DeleteMapping("/cv")
    @Transactional
    public ResponseEntity<?> deleteAllCV() {
        CVRepository.deleteAll();
        return new ResponseEntity<>("All CV have been deleted ", HttpStatus.OK);
    }


}

