package com.example.jpah2demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Cliente>> findAllClients() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
        if (clienteRepository.existsById(idClient)) {
            return ResponseEntity.ok(clienteRepository.getById(idClient));
        }
        return (ResponseEntity<Cliente>) ResponseEntity.badRequest();
    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient){
        try{
            clienteRepository.deleteById(idClient);
        }catch (Exception e){
            throw  new IllegalArgumentException("Cliente não encontrado na base de dados.");
        }


    }

    @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        Optional<Cliente> clienteSalvo = clienteRepository.findById(id);
        clienteSalvo.get().setNome(cliente.getNome());
        clienteSalvo.get().setIdade(cliente.getIdade());
        clienteSalvo.get().setEmail(cliente.getEmail());
        clienteRepository.save(clienteSalvo.get());

    }
}
