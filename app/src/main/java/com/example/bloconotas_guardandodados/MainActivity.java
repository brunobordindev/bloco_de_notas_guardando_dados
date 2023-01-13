package com.example.bloconotas_guardandodados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;
    private AnotacaoPreferencias preferencias;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);

        editAnotacao = findViewById(R.id.editAnotacao);

        preferencias = new AnotacaoPreferencias(getApplicationContext());

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String anotacaoRecuperada = editAnotacao.getText().toString();

                if (!anotacaoRecuperada.isEmpty()){

                    preferencias.salvarAlteracao(anotacaoRecuperada);
                    Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_SHORT).show();

                }else{

                    Snackbar.make(view, "Preencha a anotação!", Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        //Recuperar anotacao
       String anotacao =  preferencias.recuperarAnotacao();
       if (!anotacao.isEmpty()){
           editAnotacao.setText(anotacao);
       }

    }
}