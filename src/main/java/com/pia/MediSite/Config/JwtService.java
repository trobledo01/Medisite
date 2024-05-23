package com.pia.MediSite.Config;

import com.pia.MediSite.Entity.paciente.Paciente;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {
    private final String secret;
    private final long expiration;

    public JwtService(JwtConfig jwtConfig) {
        this.secret = jwtConfig.getSecret();
        this.expiration = jwtConfig.getExpiration();
    }

    public String generateToken(Paciente paciente) {
        return Jwts.builder()
                .setSubject(paciente.getId().toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getIdFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}