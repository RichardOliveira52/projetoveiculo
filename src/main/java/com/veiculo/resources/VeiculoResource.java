package com.veiculo.resources;

import com.veiculo.domains.Veiculo;
import com.veiculo.domains.dtos.VeiculoDTO;
import com.veiculo.services.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/veiculo")
public class VeiculoResource {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>>findAll(){
        return ResponseEntity.ok().body(veiculoService.findall());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable Long id){
        Veiculo obj = this.veiculoService.findbyId(id);
        return ResponseEntity.ok().body(new VeiculoDTO(obj));

    }
    @GetMapping(value = "/cpfproprietario/{cpfProprietario}")
    public ResponseEntity<VeiculoDTO> findById(@PathVariable String cpfProprietario){
        Veiculo obj = this.veiculoService.findbycpfProprietario(cpfProprietario);
        return ResponseEntity.ok().body(new VeiculoDTO(obj));
    }
    @PostMapping
    public ResponseEntity<VeiculoDTO> create(@Valid @RequestBody VeiculoDTO dto){
        Veiculo veiculo = veiculoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(veiculo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> update(@PathVariable Long id, @Valid @RequestBody VeiculoDTO objDto){
        Veiculo Obj = veiculoService.update(id, objDto);
        return ResponseEntity.ok().body(new VeiculoDTO(Obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<VeiculoDTO> delete(@PathVariable Long id){
        veiculoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
