package com.example.prova_leo;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtNome, edtCodigo, edtPreco, edtQuantidade;
    private Button btnSalvar, btnListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        edtCodigo = findViewById(R.id.edtCodigo);
        edtPreco = findViewById(R.id.edtPreco);
        edtQuantidade = findViewById(R.id.edtQuantidade);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnListar = findViewById(R.id.btnListar);

        // Botão salvar
        btnSalvar.setOnClickListener(v -> salvar());

        // Botão listar
        btnListar.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ListaProdutoActivity.class))
        );

        // 🔥 Limita o preço a 2 casas decimais enquanto digita
        edtPreco.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            public void afterTextChanged(Editable s) {
                String input = s.toString();
                if (input.contains(".")) {
                    int index = input.indexOf(".");
                    if (input.length() - index - 1 > 2) {
                        s.delete(s.length() - 1, s.length());
                    }
                }
            }
        });
    }

    private void salvar() {
        String nome = edtNome.getText().toString().trim();
        String codigo = edtCodigo.getText().toString().trim();
        String precoTxt = edtPreco.getText().toString().trim();
        String qtdTxt = edtQuantidade.getText().toString().trim();

        // 🔴 Validação de campos vazios
        if (nome.isEmpty() || codigo.isEmpty() || precoTxt.isEmpty() || qtdTxt.isEmpty()) {
            Toast.makeText(this, "Nenhum campo pode ficar em branco!", Toast.LENGTH_SHORT).show();
            return;
        }

        // 🔴 Validação do preço (até 2 casas decimais)
        if (!precoTxt.matches("^\\d+(\\.\\d{1,2})?$")) {
            Toast.makeText(this,
                    "Preço inválido! Use número positivo com até 2 casas decimais.",
                    Toast.LENGTH_LONG).show();
            return;
        }

        // 🔴 Validação da quantidade (inteiro positivo)
        if (!qtdTxt.matches("^\\d+$")) {
            Toast.makeText(this,
                    "Quantidade inválida! Use apenas números inteiros positivos.",
                    Toast.LENGTH_LONG).show();
            return;
        }

        double preco = Double.parseDouble(precoTxt);
        int quantidade = Integer.parseInt(qtdTxt);

        // 🔴 Validação de valores positivos
        if (preco <= 0) {
            Toast.makeText(this, "O preço deve ser maior que zero!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (quantidade <= 0) {
            Toast.makeText(this, "A quantidade deve ser maior que zero!", Toast.LENGTH_SHORT).show();
            return;
        }

        // ✅ Salvar no banco
        Produto produto = new Produto(nome, codigo, preco, quantidade);
        ProdutoDatabase.getInstance(this).produtoDao().inserir(produto);

        Toast.makeText(this, "Produto cadastrado com sucesso!", Toast.LENGTH_SHORT).show();

        limparCampos();
    }

    private void limparCampos() {
        edtNome.setText("");
        edtCodigo.setText("");
        edtPreco.setText("");
        edtQuantidade.setText("");
        edtNome.requestFocus();
    }
}