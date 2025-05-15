package com.example.tarefa_07_pesquisa;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Exibir_Totais extends AppCompatActivity {

    Button btFinalizar, btExibirTotais;
    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exibir_totais);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvGado), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btFinalizar = findViewById(R.id.btFinalizar);
        btExibirTotais = findViewById(R.id.btExibirTotais);
        textView = findViewById(R.id.textView);


        btExibirTotais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder texto = new StringBuilder();

                for (Pessoa p: Pessoa.getListaEleitor()) {
                    texto.append("Pesquisa Espontânea: ").append(p.getRespostaEspontanea()).append("\nProblemas da Ciadade: ").append(p.getProblemasDaCidade()).append("\n");
                }

                textView.setText(texto.toString());

            }
        });

        btFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
                Intent intent = new Intent(Exibir_Totais.this, SplashActivity.class);
                startActivity(intent);
            }
        });
    }

}