package br.edu.uniritter.projetofinal.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import br.edu.uniritter.projetofinal.models.Todo;

@Dao
public interface TodoDAO {




        @Query("SELECT * FROM todo")
        List<Todo> getAll();

        //@Query("SELECT * FROM user WHERE uid IN (:userIds)")
        //List<User> loadAllByIds(int[] userIds);

        //@Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
        //        "last_name LIKE :last LIMIT 1")
        //User findByName(String first, String last);

    @Query("SELECT * FROM todo WHERE id = :id")
    Todo getTodoById(long id);
    @Insert
    long insert(Todo todo);

    @Delete
    void delete(Todo todo);

}
