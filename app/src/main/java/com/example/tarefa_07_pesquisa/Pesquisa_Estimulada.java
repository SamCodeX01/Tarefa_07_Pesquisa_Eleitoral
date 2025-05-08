package com.example.tarefa_07_pesquisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class Pesquisa_Estimulada extends AppCompatActivity {

    Button botaoAvancar;
    ImageView imgAnta, imgGado, imgJumento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pesquisa_estimulada);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvGado), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botaoAvancar = findViewById(R.id.botaoAvancar);
        imgAnta = findViewById(R.id.imgAnta);
        imgGado = findViewById(R.id.imgGado);
        imgJumento = findViewById(R.id.imgJumento);

        botaoAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String resposta = edRespostaEspontanea.getText().toString().trim();

                //pessoa.setRespostaEspontanea(resposta);


               // String anta = imgAnta.getText().toString().trim();




                Intent intent = new Intent(Pesquisa_Estimulada.this, Problemas_da_Cidade.class);
                startActivity(intent);
                //edRespostaEspontanea.setText(""); // Limpa o campo para o próximo entrevistado
                finish();

                //Toast.makeText(Pesquisa_Estimulada.this,"Seleciona um candidato antes de avançar!",
                            //Toast.LENGTH_SHORT).show();
            }
        });
    }
}