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
        edProblema02 = findViewById(R.id.edProblema02);
        edProblema03 = findViewById(R.id.edProblema03);


        btProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String problema1 = edProblema01.getText().toString().trim();
                //String problema2 = edProblema02.getText().toString().trim();
                //String problema3 = edProblema03.getText().toString().trim();

                //if(!problema1.isEmpty() && !problema2.isEmpty() && !problema3.isEmpty()){
                  //  String[] problemas = {problema1,problema2,problema3};

                    //Toast.makeText(Problemas_da_Cidade.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    String resposta1 = getIntent().getStringExtra("Resposta1");
                    Intent intent = new Intent(Problemas_da_Cidade.this, Cadastrar_Pessoa.class);
                    intent.putExtra("Resposta1",resposta1);
                    startActivity(intent);
                    finish();
            }
        });
    }
}