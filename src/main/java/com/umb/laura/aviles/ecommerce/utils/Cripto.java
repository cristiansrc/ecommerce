package com.umb.laura.aviles.ecommerce.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import jakarta.xml.bind.DatatypeConverter;

public class Cripto {

    public static String encript(String str) throws Exception {
        String clave = "FooBar1234567890";
        byte[] iv = new byte[16];
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        SecretKeySpec sks = new SecretKeySpec(clave.getBytes("UTF-8"), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, sks, new IvParameterSpec(iv));
        byte[] encriptado = cipher.doFinal(str.getBytes());
        return DatatypeConverter.printBase64Binary(encriptado);
    }
}
