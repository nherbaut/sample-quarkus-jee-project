package fr.pantheonsorbonne.ufr27.miage.service;

import fr.pantheonsorbonne.ufr27.miage.exception.TokenGenerationException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.smallrye.jwt.algorithm.SignatureAlgorithm;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@ApplicationScoped
public class TokenServiceImpl implements TokenService {
    private final String secretKey = "YourVeryLongSecretKeyForJWTGeneration"; // Replace with a secure key

    @Override
    public String generateToken(String email) throws TokenGenerationException {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            return JWT.create()
                    .withSubject(email)
                    .withIssuedAt(new Date())
                    .sign(algorithm);
        } catch (Exception e) {
            throw new TokenGenerationException();
        }
    }
}
