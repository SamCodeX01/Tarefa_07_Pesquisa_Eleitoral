package com.example.tarefa_07_pesquisa;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class Problemas_da_Cidade extends AppCompatActivity {

    Button btProximo;
    EditText edProblema01,edProblema02,edProblema03;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_problemas_da_cidade);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvGado), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btProximo = findViewById(R.id.btProximo);
        edProblema01 = findViewById(R.id.edProblema01);

        btProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pega o último objeto adicionado (que veio da tela Pesquisa Espontanea)
                Pessoa pessoa = Pessoa.getListaEleitor().get(Pessoa.getListaEleitor().size()-1);

                // Atualiza apenas o nome da tela 2
                pessoa.setProblemasDaCidade(edProblema01.getText().toString());

                //Toast.makeText(Problemas_da_Cidade.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Problemas_da_Cidade.this, Exibir_Totais.class);
                    startActivity(intent);
                    finish();
            }
        });
    }
}