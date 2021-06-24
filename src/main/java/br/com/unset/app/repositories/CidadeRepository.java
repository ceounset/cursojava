package br.com.unset.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unset.app.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
    
}
