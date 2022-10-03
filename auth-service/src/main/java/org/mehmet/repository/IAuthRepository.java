package org.mehmet.repository;

import org.mehmet.repository.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAuthRepository extends JpaRepository<Auth, Long> {
    /**
     * Kullanıcı adı büyük küçük harf duyarlı olmamalı. (muhammed,Muhammed,MUHAMMED)
     * Şifre büyük küçük harf fuyarlı olmalı (asdf12, Asdf12)
     */


    Optional<Auth> findOptionalByUsernameIgnoreCaseAndPassword(String username, String password);

    @Query("select COUNT(a)>0 from Auth a where UPPER(a.username) = UPPER(?1) and a.password= ?2")
    Boolean isExist(String username, String password);
}
