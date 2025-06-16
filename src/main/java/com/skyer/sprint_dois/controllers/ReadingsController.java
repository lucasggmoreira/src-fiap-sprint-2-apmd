package com.skyer.sprint_dois.controllers;

import com.skyer.sprint_dois.models.DataReadingDetailed;
import com.skyer.sprint_dois.models.DataReadingSave;
import com.skyer.sprint_dois.services.ReadingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("api/readings")

public class ReadingsController {

    @Autowired
    private ReadingService readingService;

    @PostMapping
    public ResponseEntity<DataReadingDetailed> createReading(@RequestBody @Valid DataReadingSave readingDTO, UriComponentsBuilder uriBuilder){
        var data = readingService.saveReading(readingDTO);
        var uri = uriBuilder.path("/readings/{id}").buildAndExpand(data.id()).toUri();
        return ResponseEntity.created(uri).body(data);
    }

    @GetMapping
    public ResponseEntity<List<DataReadingDetailed>> getAllReadings() {
        var readings = readingService.getAllReadings();
        return ResponseEntity.ok().body(readings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataReadingDetailed> getReadingById(@PathVariable Long id) {
        var reading = readingService.getReadingById(id);
        return ResponseEntity.ok().body(reading);
    }


}
