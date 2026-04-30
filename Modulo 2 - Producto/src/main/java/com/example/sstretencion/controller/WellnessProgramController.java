package com.example.sstretencion.controller;

import com.example.sstretencion.model.WellnessProgram;
import com.example.sstretencion.repository.WellnessProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wellness-programs")
public class WellnessProgramController {

    @Autowired
    private WellnessProgramRepository wellnessProgramRepository;

    @GetMapping
    public List<WellnessProgram> getAllWellnessPrograms() {
        return wellnessProgramRepository.findAll();
    }

    @PostMapping
    public WellnessProgram createWellnessProgram(@RequestBody WellnessProgram program) {
        return wellnessProgramRepository.save(program);
    }

    @GetMapping("/{id}")
    public WellnessProgram getWellnessProgramById(@PathVariable Long id) {
        return wellnessProgramRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public WellnessProgram updateWellnessProgram(@PathVariable Long id, @RequestBody WellnessProgram programDetails) {
        WellnessProgram program = wellnessProgramRepository.findById(id).orElse(null);
        if (program != null) {
            program.setName(programDetails.getName());
            program.setDescription(programDetails.getDescription());
            program.setStartDate(programDetails.getStartDate());
            program.setEndDate(programDetails.getEndDate());
            return wellnessProgramRepository.save(program);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteWellnessProgram(@PathVariable Long id) {
        wellnessProgramRepository.deleteById(id);
    }
}