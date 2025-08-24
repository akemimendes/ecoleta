package com.akemi.ecoleta.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.akemi.ecoleta.domain.model.Material;

public interface MaterialRepository extends JpaRepository<Material,Long> {

}
