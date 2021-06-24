package br.com.unset.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unset.app.domain.Categoria;
import br.com.unset.app.repositories.CategoriaRepository;
import br.com.unset.app.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;
    
    public Categoria buscar(Integer id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não encontrado! id = "+id+", Tipo = "+Categoria.class.getName()));
    }

}
