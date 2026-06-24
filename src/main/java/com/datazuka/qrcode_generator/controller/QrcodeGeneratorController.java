package com.datazuka.qrcode_generator.controller;

import com.datazuka.qrcode_generator.dto.QrcodeGeneratorRequest;
import com.datazuka.qrcode_generator.dto.QrcodeGeneratorResponse;
import com.datazuka.qrcode_generator.service.QrcodeGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrcodeGeneratorController {

    @Autowired
    private QrcodeGeneratorService service;

    @PostMapping()
    public ResponseEntity<QrcodeGeneratorResponse> generate(@RequestBody QrcodeGeneratorRequest request){
        try{
            QrcodeGeneratorResponse response = service.generateUpload(request.text());
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }

}