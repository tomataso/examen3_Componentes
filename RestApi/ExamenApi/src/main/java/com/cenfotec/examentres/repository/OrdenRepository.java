package com.cenfotec.examentres.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cenfotec.examentres.model.Orden;


@Repository
public interface OrdenRepository extends JpaRepository<Orden, Long> {
	 public List<Orden> findByIdContaining(String word);

}
