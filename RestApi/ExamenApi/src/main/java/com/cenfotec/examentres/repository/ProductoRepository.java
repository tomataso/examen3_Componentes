package com.cenfotec.examentres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cenfotec.examentres.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
