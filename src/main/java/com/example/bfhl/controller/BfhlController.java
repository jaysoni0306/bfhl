package com.example.bfhl.controller;

import com.example.bfhl.dto.RequestDTO;
import com.example.bfhl.dto.ResponseDTO;
import com.example.bfhl.service.BfhlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bfhl")
public class BfhlController {

    private final BfhlService bfhlService;

    public BfhlController(BfhlService bfhlService) {
        this.bfhlService = bfhlService;
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> handlePost(@RequestBody RequestDTO request) {
        return ResponseEntity.ok(bfhlService.processData(request)); 
    }
}