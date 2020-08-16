package com.company.entidades;

import com.company.controlador.Hipodromo;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.List;


public class Meta {

    public Hipodromo hipodromo ;
    private int distanPista ;
    private int q;

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public Meta() throws InterruptedException {
    }


    public  List<Caballo> podio = new ArrayList<>(){

    };


    public Meta(int distanPista) throws InterruptedException {
        this.distanPista = distanPista;
    }



    public  boolean llego(Caballo cab) {
        boolean completp = false;

            if (cab.getDistanNet() >= distanPista) {

                System.out.println("----------------------------------------------------");
                System.out.println("El Caballo " + cab.getNombre() + " Finalizo la carrera");
                System.out.println("-------------------------------------------------------");
                completp = true;
                podio.add(cab);
                verPodio();
                }

         return completp;
    }

    public int getDistanPista() {


        return distanPista;
    }
    public void verPodio() {

        int s = 0;
        for (int p = 0; p <= podio.size() - 1; p++) {
            s++;
            System.out.println(s + ": " + podio.get(p).getNombre());

        }
    }

    public void setDistanPista(int distanPista) {
        this.distanPista = distanPista;
    }
}
