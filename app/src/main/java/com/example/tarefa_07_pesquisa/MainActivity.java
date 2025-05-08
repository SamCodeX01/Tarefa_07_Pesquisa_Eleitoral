package com.example.tarefa_07_pesquisa;

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

public class MainActivity extends AppCompatActivity {

    EditText txtUsuario, txtSenha;
    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
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
                    txtSenha.setError("Digite a senha!");
                }
                return; // Impede continuar se algum campo estiver vazio
            }

                try {
                    int senhaDigitadaa = Integer.parseInt(senhaDigitada);

                    if(usuarioDigitado.equals("Samuel") && senhaDigitadaa == 1234){
                        Intent intent = new Intent(MainActivity.this, Pesquisa_Espontanea.class);
                        startActivity(intent);
                        finish(); // Opcional: remove a tela de login do histórico
                    } else {
                        Toast.makeText(MainActivity.this, "Usuário ou senha incorretos!", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    txtSenha.setError("Senha deve ser numérica!");
                    Toast.makeText(MainActivity.this, "Senha deve ser numérica", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e("LOGIN_ERROR", "Erro no login", e);
                }
            }
        });
    }



    /*private boolean validarLogin(String usuario, int senha){
        String usuarioCorreto = "Samuel";
        int senhaCorreta = 1234;
        return usuario.equals(usuarioCorreto) && senha == senhaCorreta;
        //Para String, use equals() em vez de ==
        //Para int, use == para comparação
    }*/

}

