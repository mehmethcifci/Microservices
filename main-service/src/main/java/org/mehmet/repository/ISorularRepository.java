package org.mehmet.repository;

import org.mehmet.repository.entity.Sorular;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISorularRepository extends JpaRepository<Sorular, Long> {

}
