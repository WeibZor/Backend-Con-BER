package com.example.sstretencion.controller;

import com.example.sstretencion.model.Absenteeism;
import com.example.sstretencion.repository.AbsenteeismRepository;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.StringWriter;
import java.util.List;

@RestController
@RequestMapping("/api/absenteeism")
public class AbsenteeismController {

    @Autowired
    private AbsenteeismRepository absenteeismRepository;

    @GetMapping
    public List<Absenteeism> getAllAbsenteeism() {
        return absenteeismRepository.findAll();
    }

    @PostMapping
    public Absenteeism createAbsenteeism(@RequestBody Absenteeism absenteeism) {
        return absenteeismRepository.save(absenteeism);
    }

    @GetMapping("/{id}")
    public Absenteeism getAbsenteeismById(@PathVariable Long id) {
        return absenteeismRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Absenteeism updateAbsenteeism(@PathVariable Long id, @RequestBody Absenteeism absenteeismDetails) {
        Absenteeism absenteeism = absenteeismRepository.findById(id).orElse(null);
        if (absenteeism != null) {
            absenteeism.setStartDate(absenteeismDetails.getStartDate());
            absenteeism.setEndDate(absenteeismDetails.getEndDate());
            absenteeism.setReason(absenteeismDetails.getReason());
            return absenteeismRepository.save(absenteeism);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteAbsenteeism(@PathVariable Long id) {
        absenteeismRepository.deleteById(id);
    }

    @GetMapping("/export/csv")
    public ResponseEntity<String> exportAbsenteeismToCsv() {
        List<Absenteeism> absenteeisms = absenteeismRepository.findAll();
        StringWriter writer = new StringWriter();
        CSVWriter csvWriter = new CSVWriter(writer);
        csvWriter.writeNext(new String[]{"ID", "Employee ID", "Start Date", "End Date", "Reason"});
        for (Absenteeism absenteeism : absenteeisms) {
            csvWriter.writeNext(new String[]{
                absenteeism.getId().toString(),
                absenteeism.getEmployee().getId().toString(),
                absenteeism.getStartDate().toString(),
                absenteeism.getEndDate().toString(),
                absenteeism.getReason()
            });
        }
        csvWriter.close();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        headers.setContentDispositionFormData("attachment", "absenteeism.csv");
        return ResponseEntity.ok().headers(headers).body(writer.toString());
    }
}