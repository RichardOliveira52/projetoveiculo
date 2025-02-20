package com.veiculo.services;

import com.veiculo.domains.Veiculo;
import com.veiculo.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class DBService {
    @Autowired
    private VeiculoRepository veiculoRepo;

    public void initDB(){

        Veiculo veiculo01 = new Veiculo(null,"Mustang",LocalDate.now(),530000.00,"Richard","52501125878");
        Veiculo veiculo02 = new Veiculo(null,"Astra",LocalDate.now(),530000.00,"PopJoy","98563258741");
        Veiculo veiculo03 = new Veiculo(null,"Skyline",LocalDate.now(),530000.00,"Marcela","9865231455225");

        veiculoRepo.save(veiculo01);
        veiculoRepo.save(veiculo02);
        veiculoRepo.save(veiculo03);
    }
}
