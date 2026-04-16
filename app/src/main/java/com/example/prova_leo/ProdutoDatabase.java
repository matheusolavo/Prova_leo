package com.example.prova_leo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Produto.class}, version = 1)
public abstract class ProdutoDatabase extends RoomDatabase {

    public abstract ProdutoDao produtoDao();

    private static ProdutoDatabase instance;

    public static synchronized ProdutoDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ProdutoDatabase.class,
                    "produto_db"
            ).allowMainThreadQueries().build();
        }
        return instance;
    }
}