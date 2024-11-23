package br.edu.uniritter.projetofinal.DAO;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import br.edu.uniritter.projetofinal.models.Todo;

@Database(entities = {Todo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TodoDAO todoDao();
}
