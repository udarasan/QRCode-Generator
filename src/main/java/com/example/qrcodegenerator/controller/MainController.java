package com.example.qrcodegenerator.controller;

import com.example.qrcodegenerator.config.QRCodeGenerator;
import com.example.qrcodegenerator.dto.QRDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;

@RestController
@CrossOrigin
@RequestMapping("api/v1/qr")
public class MainController {

    @PostMapping(path = "/getQR",produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> qrcode(@RequestBody QRDTO qrdto)throws Exception{
        return successResponse(QRCodeGenerator.generateQRCodeImage(qrdto));
    }

    private ResponseEntity<BufferedImage> successResponse(BufferedImage generateQRCodeImage) {
        return new ResponseEntity<>(generateQRCodeImage, HttpStatus.OK);
    }
}
