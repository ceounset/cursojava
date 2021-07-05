package br.com.unset.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unset.app.domain.Cliente;
import br.com.unset.app.repositories.ClienteRepository;
import br.com.unset.app.services.exceptions.ObjectNotFoundException;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;
    
    public Cliente buscar(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! id = "+id+", Tipo = "+Cliente.class.getName()));
    }

}
