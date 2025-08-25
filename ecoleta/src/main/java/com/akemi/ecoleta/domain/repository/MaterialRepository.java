package com.akemi.ecoleta.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akemi.ecoleta.domain.model.Material;

@Repository
public interface MaterialRepository extends JpaRepository<Material,Long> {

}
