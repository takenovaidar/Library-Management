package itsphere.dev.bookswap.config;

import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;

public class GenerateKey {
    public static void main(String[] args) {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
        String base64Key = Encoders.BASE64.encode(key.getEncoded());
        System.out.println("Generated JWT secret: " + base64Key);
    }
}

