package com.example.prova_leo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ViewHolder> {
    private List<Produto> lista;

    public ProdutoAdapter(List<Produto> lista) { this.lista = lista; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Produto p = lista.get(position);
        holder.nome.setText(p.getNome());
        holder.codigo.setText("Cód: " + p.getCodigo());
        holder.preco.setText(String.format("R$ %.2f", p.getPreco()));
    }

    @Override
    public int getItemCount() { return lista.size(); }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nome, codigo, preco;
        public ViewHolder(View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.txtNome);
            codigo = itemView.findViewById(R.id.txtCodigo);
            preco = itemView.findViewById(R.id.txtPreco);
        }
    }
}