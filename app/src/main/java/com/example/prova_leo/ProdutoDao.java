package com.example.prova_leo;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProdutoDao {

    @Insert
    void inserir(Produto produto);

    @Query("SELECT * FROM Produto ORDER BY id DESC")
    List<Produto> listar();
}