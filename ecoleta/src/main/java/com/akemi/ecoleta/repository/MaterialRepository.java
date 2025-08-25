package com.akemi.ecoleta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akemi.ecoleta.model.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material,Long> {

}
