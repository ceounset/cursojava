package br.com.unset.app.domain;

import java.io.Serializable;

public class Categoria implements Serializable {
    //atributos
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String nome;

    //construtor vazio
    public Categoria() {}

    //construtor
    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    //Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //HashCode
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    //Equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Categoria other = (Categoria) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }



    
    
    



    
}
