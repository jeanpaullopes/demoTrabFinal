package br.edu.uniritter.projetofinal.views;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.edu.uniritter.projetofinal.R;
import br.edu.uniritter.projetofinal.models.Todo;
import br.edu.uniritter.projetofinal.repositories.TodoRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        TodoRepository repo = TodoRepository.getInstance(this);
        //Todo novo  = new Todo();
        //novo.setDescricao("teste de insert com room sem id");
        //novo.setData("01/01/2021");
        //novo.setHora("12:00");
        //novo.setLocal("casa");
        //novo.setStatus("pendente");
        //repo.insert(novo);
        //for (Todo td : repo.getAll()) {
        //    Log.d("Todo", td.getId()+" - "+td.getDescricao());
        //}
        Todo td = repo.get(5);
        Log.d("Todo", td.getId()+" - "+td.getDescricao());

        td = repo.get(5);
        Log.d("Todo", td.getId()+" - "+td.getDescricao());

        td = repo.get(5);
        Log.d("Todo", td.getId()+" - "+td.getDescricao());



    }
}