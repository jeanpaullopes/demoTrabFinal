package br.edu.uniritter.projetofinal.repositories;

import br.edu.uniritter.projetofinal.models.Todo;

import java.util.ArrayList;
import java.util.List;

public class ItemCardapioRepository {
    private List<Todo> baseDeDados;


    //implementar o design pattern Singleton
    public ItemCardapioRepository() {
        this.baseDeDados = new ArrayList<>();
        Todo td1 = new Todo();
        baseDeDados.add(td1);

    }
    public List<Todo> getAll() {
        return this.baseDeDados;
    }
    public void add(Todo td) {
        this.baseDeDados.add(td);
    }

}
