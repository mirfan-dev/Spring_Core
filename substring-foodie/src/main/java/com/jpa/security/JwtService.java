package com.jpa.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private static final long EXPIRATION_TIME= 15*60*1000;

    private static final String SECRET="KDFSDLKLMDFMVDKVNFBDNDVFNFMDVDFJDFLDK";

    // Generate Token
   public String generateToken(String username) {
       String token = Jwts.builder()
               .subject(username)
               .issuedAt(new Date())
               .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
               .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()), SignatureAlgorithm.HS256)
               .compact();
       return token;
   }

   // Get username from token

    public String getUsername(String token){

       String username=Jwts.parser()
               .setSigningKey(SECRET.getBytes()).build()
               .parseClaimsJws(token).getBody().getSubject();
       return username;

    }

    // validate Token

    public boolean validateToken(String token){

       if(this.isTokenExpired(token)){
           return false;
       }

       try {
           Jwts.parser().setSigningKey(SECRET.getBytes()).build().parseSignedClaims(token);
           return true;
       } catch(Exception e) {
           e.printStackTrace();
           return false;
       }

    }

    public boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser()
                .setSigningKey(SECRET.getBytes()).build()
                .parseClaimsJws(token).getBody().getExpiration();
        return expiration.before(new Date());

    }


}
