package com.pia.MediSite.Config;

import com.pia.MediSite.Entity.paciente.Paciente;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.persistence.GeneratedValue;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY="a65ca7a8d8bfc52de14054735faaf8def3250e5052e45375689a496ac0887a42";


    //Extraer correo de Token
    public String extraerCorreoPaciente(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    //Generar Token con solo paciente
    public String generateToken(UserDetails userDetails)
    {
        return generateToken(new HashMap<>(), userDetails);
    }

    //Generar el Token con claim
    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails)
    {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    //Extraer claim de token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver)
    {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //Validar Token
    public boolean isTokenValid(String token, UserDetails userDetails)
    {
        final String correoPaciente = extraerCorreoPaciente(token);
        return (correoPaciente.equals(userDetails.getUsername())) && isTokenExpired(token);
    }

    //Validar expiracion de Token
    private boolean isTokenExpired(String token)
    {
        return extractExpiration(token).before(new Date());
    }

    //Extraer expiracion de token
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    //Extraer Claims del token
    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}