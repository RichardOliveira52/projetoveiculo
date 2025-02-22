package com.veiculo.services;

import com.veiculo.domains.Veiculo;
import com.veiculo.domains.dtos.VeiculoDTO;
import com.veiculo.repositories.VeiculoRepository;
import com.veiculo.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public Veiculo findbyId(long id){
        Optional<Veiculo> obj = veiculoRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Veiculo não encontrado! Id: "+id));
    }
    public Veiculo findbycpfProprietario(String cpfProprietario){
        Optional<Veiculo> obj = veiculoRepo.findBycpfProprietario(cpfProprietario);
        return obj.orElseThrow(() -> new ObjectNotFoundException("CPF não encontrado! CPF: "+cpfProprietario));
    }
    public Veiculo create(VeiculoDTO dto) {
        dto.setId(null);
        validaVeiculo(dto);
        Veiculo obj = new Veiculo(dto);
        return veiculoRepo.save(obj);
    }
    private void validaVeiculo(VeiculoDTO dto) {
        Optional<Veiculo> obj = veiculoRepo.findBycpfProprietario(dto.getCpfProprietario());
        if (obj.isPresent() && obj.get().getId() != dto.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado");
        }
    }
    public Veiculo update(Long id, VeiculoDTO objDto){
        objDto.setId(id);
        Veiculo oldObj = findbyId(id);
        oldObj = new Veiculo(objDto);
        return veiculoRepo.save(oldObj);
    }
    public void delete(Long id){
        Veiculo obj = findbyId(id);
        veiculoRepo.deleteById(id);
    }
}
