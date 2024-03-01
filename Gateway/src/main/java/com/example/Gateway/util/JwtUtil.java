package com.example.Gateway.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.function.Function;

@Component
public class JwtUtil {


    public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";


    public void validateToken(final String token) {
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }
   public String extractUserName(String token){
       return extactClams(token ,Claims :: getSubject);
   }

    public <T> T  extactClams(String token, Function<Claims,T> claimsTFonction ){
        final Claims claims = extactAllClams(token);
        return claimsTFonction.apply(claims);
    }


    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims extactAllClams(String token){
        return Jwts
                .parserBuilder()
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
