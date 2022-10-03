package org.mehmet.repository;

import org.mehmet.repository.entity.Goruntulenme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGoruntulenmeRepository extends JpaRepository<Goruntulenme, Long> {

}
