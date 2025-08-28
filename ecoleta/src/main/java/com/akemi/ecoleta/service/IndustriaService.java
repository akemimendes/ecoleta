package com.akemi.ecoleta.service;

import java.util.List;

import com.akemi.ecoleta.model.Industria;
import com.akemi.ecoleta.model.dto.IndustriaDTO;

public interface IndustriaService {

    List<Industria> getIndustria();

    Industria getIndustriaById(long id);

    Industria createIndustria(IndustriaDTO industria);

    Industria updateIndustria(Long id, IndustriaDTO industria);

    void deleteIndustria(long id);

    boolean existsByCpfCnpj(String cnpj);

}
