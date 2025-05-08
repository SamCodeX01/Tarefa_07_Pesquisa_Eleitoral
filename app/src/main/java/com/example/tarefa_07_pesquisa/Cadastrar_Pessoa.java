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

public class Cadastrar_Pessoa extends AppCompatActivity {
    Button btParticipanteProximo, btTotaisExibir;
    EditText  edNome, edCelular, edLocal, edData, edTime;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastrar_pessoa);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvGado), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btParticipanteProximo = findViewById(R.id.btParticipanteProximo);
        btTotaisExibir = findViewById(R.id.btTotaisExibir);
        edNome = findViewById(R.id.edNome);
        edCelular = findViewById(R.id.edCelular);
        edLocal = findViewById(R.id.edLocal);
        edData = findViewById(R.id.edData);
        edTime = findViewById(R.id.edTime);

        btParticipanteProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = edNome.getText().toString().trim();
                String celular = edCelular.getText().toString().trim();
                String local = edLocal.getText().toString().trim();
                String data = edData.getText().toString().trim();
                String hora = edTime.getText().toString().trim();


                /*if (!nome.isEmpty() && !celular.isEmpty() && !local.isEmpty() && !data.isEmpty() && !hora.isEmpty()) {
                    String[] dados = {nome, celular, local, data, hora};*/

                    /*// Limpa os campos para o próximo participante
                    edNome.setText("");
                    edCelular.setText("");
                    edLocal.setText("");
                    edData.setText("");
                    edTime.setText("");*/

                /*
                    Pessoa pessoaAtual = Pesquisa_Espontanea.pessoa.clone();
                    pessoaAtual.setCadastro(nome, celular, local, data, hora);

                    Pessoa.setExibirLista(pessoaAtual);
                */

                Intent intent = new Intent(Cadastrar_Pessoa.this, Pesquisa_Espontanea.class);
                startActivity(intent);
                finish();
            }

            //Toast.makeText(Cadastrar_Pessoa.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();


        });

        btTotaisExibir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resposta1 = getIntent().getStringExtra("Resposta1");
                Intent intent = new Intent(Cadastrar_Pessoa.this, Administrador_Seguranca.class);
                intent.putExtra("Resposta1", resposta1);
                startActivity(intent);
            }
        });
    }
}