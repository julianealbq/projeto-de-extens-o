package com.exemplo.controlevendas;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editProduto;
    private EditText editQuantidade;
    private Button btnAdicionar;
    private Estoque estoque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editProduto = findViewById(R.id.editProduto);
        editQuantidade = findViewById(R.id.editQuantidade);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        estoque = new Estoque();

        btnAdicionar.setOnClickListener(v -> {
            String produto = editProduto.getText().toString();
            int quantidade = Integer.parseInt(editQuantidade.getText().toString());

            if (estoque.adicionarProduto(produto, quantidade)) {
                Toast.makeText(this, "Produto adicionado ao estoque", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Erro ao adicionar produto", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
