package com.algaworks.algamoney.api;

import com.algaworks.algamoney.api.model.Categoria;

import java.util.*;

public class HashSetMainTest {

    public static void main(String[] args) {
        exemploComMap();
        exemploComSet();
        exemploComList();
    }

    private static void exemploComMap() {
        System.out.println("---------------- Exemplo com Map");
        Map<Long, Categoria> mapa = new HashMap<>();
        Categoria casa = new Categoria(1L, "Casa");

        mapa.put(1L, casa);

        Categoria categoria = mapa.get(1L);
        System.out.println(categoria.getNome());
    }

    private static void exemploComSet() {
        System.out.println("---------------- Exemplo com Set");
        Set<Categoria> categorias = new LinkedHashSet<>();
        Categoria casa = new Categoria(1L, "Casa");
        Categoria casa2 = new Categoria(2L, "Casa");
        Categoria alimentacao = new Categoria(2L, "Alimentação");
        Categoria lazer = new Categoria(32L, "Lazer");

        categorias.add(casa);
        categorias.add(casa2);
        categorias.add(alimentacao);
        categorias.add(lazer);

        for (Categoria categoria : categorias) {
            System.out.println(categoria.getNome());
        }
    }

    private static void exemploComList() {
        System.out.println("---------------- Exemplo com List");
        List<Categoria> categorias = new ArrayList<>();
        Categoria casa = new Categoria(1L, "Casa");
        Categoria casa2 = new Categoria(1L, "Casa");
        Categoria alimentacao = new Categoria(2L, "Alimentação");
        Categoria lazer = new Categoria(3L, "Lazer");

        categorias.add(casa);
        categorias.add(casa2);
        categorias.add(alimentacao);
        categorias.add(lazer);

        for (Categoria categoria : categorias) {
            System.out.println(categoria.getNome());
        }
    }

}

