package com.example.tarefa_07_pesquisa;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


public class Pesquisa_Espontanea extends AppCompatActivity {
    Button btAvancar;
    EditText edRespostaEspontanea;
    ArrayList<Pessoa> listaEleitores = new ArrayList<Pessoa>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pesquisa_espontanea);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvGado), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btAvancar = findViewById(R.id.botaoAvancar);
        edRespostaEspontanea = findViewById(R.id.edRespostaEspontanea);

        btAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pessoa p = new Pessoa();// Cria uma NOVA instância a cada clique

                // 1. Pega o texto digitado (ainda só está no EditText)
               // String resposta = edRespostaEspontanea.getText().toString().trim();

                p.setRespostaEspontanea(edRespostaEspontanea.getText().toString());//pega o texto digitado
                listaEleitores.add(p);


                //Toast.makeText(Pesquisa_Espontanea.this,pessoa.getRespostaEspontanea(),
                  //      Toast.LENGTH_SHORT).show();
    Intent intent = new Intent(Pesquisa_Espontanea.this, Pesquisa_Estimulada.class);
                intent.putExtra("lista_eleitores",listaEleitores);
                startActivity(intent);
                finish();
                //edRespostaEspontanea.setText(""); // Limpa o campo para o próximo entrevistado
            }
        });

    }
}