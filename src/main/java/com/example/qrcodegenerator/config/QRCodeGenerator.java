package com.example.qrcodegenerator.config;

import com.example.qrcodegenerator.dto.QRDTO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class QRCodeGenerator {

    public static BufferedImage generateQRCodeImage(QRDTO qrdto)throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(qrdto.getUrl(), BarcodeFormat.QR_CODE, qrdto.getWidth(), qrdto.getHeight());
        return MatrixToImageWriter.toBufferedImage(bitMatrix);

    }


}