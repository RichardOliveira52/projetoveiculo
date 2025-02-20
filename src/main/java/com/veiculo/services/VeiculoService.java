package com.veiculo.services;

import com.veiculo.domains.dtos.VeiculoDTO;
import com.veiculo.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepo;

    public List<VeiculoDTO> findall(){
        return veiculoRepo.findAll().stream()
                .map(obj -> new VeiculoDTO(obj))
                .collect(Collectors.toList());
    }
}
