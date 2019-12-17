package com.example.a18262563.marvelapi.model.entity;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class AutenticacaoAPI {

    private String publicKey, privateKey, timeStamp, md5Key, hash;

    public String getMD5Key() {

        String input = getDateKey() + getPrivateKey() + getPublicKey() ;

        try {
            // Criptografa a String com MessageDiagest
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Retorna um array de caracteres da criptografia
            byte [] md5Bytes = md.digest(input.getBytes());

            // Criação de uma string dinâmica com StringBuilder
            StringBuilder md5 = new StringBuilder();
            for (int i = 0; i < md5Bytes.length; ++i) {

                // Transforma um argumento integer base hexadecimal para uma string
                // o md5Bytes[] retorna um inteiro, para ele não ter uma posição negativa utilizamos o 0xFF ou 0x100,
                // ele insere o hexadecimal em algum lugar para o cálculo como auxiliar
                // e retira após o calculo, fazendo retornar um inteiro positivo com substring de 1 a 3 para 3 digito (que é o 255 inserido para cálculo)
                md5.append(Integer.toHexString((md5Bytes[i] & 0xFF) | 0x100).substring(1, 3));
            }
            md5Key = md5.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return md5Key;
    }


    public String getDateKey(){
        Date data = new Date();
        long dataFormatada = data.getTime();
        return String.valueOf(dataFormatada);
    }

    public String getPrivateKey(){
        privateKey = "f01e0e685a583e9ce06cb944387862ead835fa8c";
        return privateKey;
    }

    public String getPublicKey(){
        publicKey = "86d8966c76c710a1407e3663391a92eb";
        return publicKey;
    }

}
