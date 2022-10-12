package org.mehmet.repository;

import org.mehmet.repository.entity.UserProfile;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface IUserProfileRepository extends ElasticsearchRepository<UserProfile,Long> {

    @Query("select COUNT(a)>0 from UserProfile a where a.authid = ?1")
    Boolean isExist(Long authid);

    Optional<UserProfile> findOptionalByAuthid(Long authid);

    List<UserProfile> findAllByUsername(String username, Pageable pageable);

    @Query("select u.email from UserProfile u")
    List<String> findAllEmailList();

    @Query("select u from UserProfile u limit 1000")
    List<UserProfile> findTop1000();
}
