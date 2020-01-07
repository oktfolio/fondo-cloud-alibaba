package com.oktobro.fondo.utils.rsa;

import java.security.*;
import java.util.Base64;

/**
 * @author oktfolio oktfolio@gmail.com
 * @date 2019/12/17
 */
public class RSAKeyPairGenerator {
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public RSAKeyPairGenerator() throws NoSuchAlgorithmException {
        // KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA",
        //         new BouncyCastleProvider());
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        final int keySize = 1024;
        keyPairGen.initialize(keySize, new SecureRandom());
        KeyPair pair = keyPairGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public String getBase64PrivateKey() {
        return Base64.getEncoder().encodeToString(privateKey.getEncoded());
    }

    public String getBase64PublicKey() {
        return Base64.getEncoder().encodeToString(publicKey.getEncoded());
    }

}
