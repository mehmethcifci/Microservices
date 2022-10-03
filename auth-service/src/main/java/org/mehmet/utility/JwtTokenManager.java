package org.mehmet.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class JwtTokenManager {

    /**
     * 1- Create JWT
     * 2- Validate JWT
     * */
    public Optional<String> createToken(Long id){
        String token = null;

        //qAh~md_iJL-w?:5j3$CDgpT8l)Ze&%4\(~4RG#ruvE`cP%dX53e/$<K,=i1Z@4Z şifre anahtarı böyle olmalı
        String sifreAnahtari = "1234";

        try{
            /**
             * JWT içerisine hassas bilgilerinizi koymayınız. Örneğin şifre gibi
             * */
        token = JWT.create()
                .withAudience()
                .withClaim("id", id)
                .withIssuer("mehmet")
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000* 60))
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256(sifreAnahtari));
        return Optional.of(token);

        }catch(Exception e){
            return Optional.empty();
        }
    }
}
