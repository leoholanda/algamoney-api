package com.algaworks.algamoney.api;

import java.util.ArrayList;
import java.util.List;

public class CollectionsMainTest {

    public static void main(String[] args) {

        testAno();

//        List<Integer> collection = new ArrayList<Integer>();
//        long startTime = System.currentTimeMillis();
//
//        for (int i = 0; i < 50000; i++) {
//            collection.add(i);
//        }
//
//        for (int i = 0; i < 50000; i++) {
//            System.out.println("======================= " + i);
//            collection.contains(i);
//        }
//
//        long finalTime = System.currentTimeMillis();
//        System.out.printf("%.3f seconds%n", (finalTime - startTime) / 1000d);
    }

    public static void testAno() {
        List<String> listAnos = new ArrayList<String>();
        String anoInicial = "2022";
        String anoFim = "2023";
        if (anoInicial.equals(anoFim)){
            listAnos.add(anoFim);
            System.out.println(listAnos.toArray());
        }else{
            int anoI = Integer.valueOf(anoInicial).intValue();
            int anoF = Integer.valueOf(anoFim).intValue();
            while (anoF >= anoI ) {
                listAnos.add("" + anoF);
                anoF--;
            }
            System.out.println(listAnos.toArray());
        }
    }

}
