package br.edu.uniritter.projetofinal.repositories;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

import br.edu.uniritter.projetofinal.DAO.AppDatabase;
import br.edu.uniritter.projetofinal.models.Todo;

public class TodoRepository {

    private static TodoRepository instance;
    private static Context context;
    private AppDatabase db;

    private List<Todo> dados;

    private TodoRepository() {
        dados = new ArrayList<>();
        db = Room.databaseBuilder(context,
                AppDatabase.class, "banco_da_app")
                .allowMainThreadQueries()
                .build();
        // retirando carga ansiosa
        //dados.addAll( db.todoDao().getAll() );
    }

    public static TodoRepository getInstance(Context ctx) {
        if (instance == null) {
            context = ctx;
            instance = new TodoRepository();
        }
        return instance;
    }
    public void insert(Todo td) {
        long id  = db.todoDao().insert(td);
        td.setId(id);
        dados.add(td);
    }
    public void delete(Todo td) {
        db.todoDao().delete(td);
        dados.remove(td);
    }
    public List<Todo> getAll() {
        if (dados.size() == 0) {
            dados.addAll( db.todoDao().getAll() );
        }
        return dados;
    }

    public Todo get(long id) {
        for (Todo td : dados) {
            if (td.getId() == id) {
                Log.d("Todo", "Retornando do cache");
                return td;
            }
        }
        Todo td = db.todoDao().getTodoById(id);
        if (td != null) {
            Log.d("Todo", "Retornando do database");

            dados.add(td);
            return td;
        }
        return null;
    }
}
