package com.example.sstretencion.controller;

import com.example.sstretencion.model.Incident;
import com.example.sstretencion.repository.IncidentRepository;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.StringWriter;
import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentController {

    @Autowired
    private IncidentRepository incidentRepository;

    @GetMapping
    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    @PostMapping
    public Incident createIncident(@RequestBody Incident incident) {
        return incidentRepository.save(incident);
    }

    @GetMapping("/{id}")
    public Incident getIncidentById(@PathVariable Long id) {
        return incidentRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Incident updateIncident(@PathVariable Long id, @RequestBody Incident incidentDetails) {
        Incident incident = incidentRepository.findById(id).orElse(null);
        if (incident != null) {
            incident.setDescription(incidentDetails.getDescription());
            incident.setDate(incidentDetails.getDate());
            incident.setStatus(incidentDetails.getStatus());
            incident.setInvestigationNotes(incidentDetails.getInvestigationNotes());
            return incidentRepository.save(incident);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteIncident(@PathVariable Long id) {
        incidentRepository.deleteById(id);
    }

    @GetMapping("/export/csv")
    public ResponseEntity<String> exportIncidentsToCsv() {
        List<Incident> incidents = incidentRepository.findAll();
        StringWriter writer = new StringWriter();
        CSVWriter csvWriter = new CSVWriter(writer);
        csvWriter.writeNext(new String[]{"ID", "Employee ID", "Description", "Date", "Status", "Investigation Notes"});
        for (Incident incident : incidents) {
            csvWriter.writeNext(new String[]{
                incident.getId().toString(),
                incident.getEmployee().getId().toString(),
                incident.getDescription(),
                incident.getDate().toString(),
                incident.getStatus(),
                incident.getInvestigationNotes()
            });
        }
        csvWriter.close();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        headers.setContentDispositionFormData("attachment", "incidents.csv");
        return ResponseEntity.ok().headers(headers).body(writer.toString());
    }
}