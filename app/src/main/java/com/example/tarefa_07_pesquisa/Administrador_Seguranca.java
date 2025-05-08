package com.example.tarefa_07_pesquisa;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Administrador_Seguranca extends AppCompatActivity {

    EditText txtUsuario, txtSenha;
    Button btnEntrar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_administrador_seguranca);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tvGado), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtUsuario = findViewById(R.id.txtUsuario);
        txtSenha = findViewById(R.id.txtSenha);
        btnEntrar = findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usuarioDigitado = txtUsuario.getText().toString().trim();
                String senhaDigitada = txtSenha.getText().toString().trim();

                if (usuarioDigitado.isEmpty() || senhaDigitada.isEmpty()) {
                    if(usuarioDigitado.isEmpty()){
                        txtUsuario.setError("Digite o usuário!");
                    }
                    if (senhaDigitada.isEmpty()) {
                        txtSenha.setError("Digite o usuário!");
                    }
                    return; // Impede continuar se algum campo estiver vazio
                }

                try {
                    int senhaDigitadaa = Integer.parseInt(senhaDigitada);

                    if(usuarioDigitado.equals("Samuel") && senhaDigitadaa == 1234){

                        String resposta1 = getIntent().getStringExtra("Resposta1");
                        Intent intent = new Intent(Administrador_Seguranca.this, Exibir_Totais.class);
                        intent.putExtra("Resposta1", resposta1);
                        startActivity(intent);
                        finish();

                        //Intent intent = new Intent(Administrador_Seguranca.this, Exibir_Totais.class);
                        //finish(); // Opcional: remove a tela de login do histórico
                    } else {
                        Toast.makeText(Administrador_Seguranca.this, "Usuário ou senha incorretos!", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    txtSenha.setError("Senha deve ser numérica!");
                    Toast.makeText(Administrador_Seguranca.this, "Senha deve ser numérica", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(Administrador_Seguranca.this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e("LOGIN_ERROR", "Erro no login", e);
                }
            }
        });
    }
}