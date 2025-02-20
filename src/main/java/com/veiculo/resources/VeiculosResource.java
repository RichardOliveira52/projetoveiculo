package com.veiculo.resources;

import com.veiculo.domains.dtos.VeiculoDTO;
import com.veiculo.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/veiculo")
public class VeiculosResource {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>>findAll(){
        return ResponseEntity.ok().body(veiculoService.findall());
    }
}
