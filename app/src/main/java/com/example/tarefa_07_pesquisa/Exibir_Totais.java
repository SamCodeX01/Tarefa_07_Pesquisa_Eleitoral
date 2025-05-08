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

        // Recebe a lista da Activity anterior (mas ainda não exibe)
        ArrayList<Pessoa> listaRecebida = (ArrayList<Pessoa>) getIntent().getSerializableExtra("lista_eleitores");

        btExibirTotais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setText("");
                for (Pessoa p: listaRecebida) {
                    //textView.setText(textView.getText().toString() + pessoa.getRespostaEspontanea()+"\n"+ pessoa.getNome() + pessoa.getCelular());
                    textView.append(p.getRespostaEspontanea());
                }

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