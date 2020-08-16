package com.company.entidades;


import java.util.Random;

public class Caballo extends Thread{


    private String nombre ;
    private int distanRec ;
    private int velocidad = 0;
    private int distanNet = 0;
    private boolean llegadaMeta = false;
    private int posicionFinal = 0;
    private Meta meta;



    public  Caballo(String nombre, Meta meta) {
        this.nombre = nombre;
        this.meta = meta;
    }

    @Override
    public void run(){

           while (!meta.llego(this)){
               try {
                   sleep(500);

            }catch (InterruptedException e){
               }
               correr();
               if (!(distanRec <0)) {
                   System.out.println("Al caballo " + nombre + " le restan " + distanRec + " metros");
               }
           }
       }






    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Caballo() {
    }


    public String getNombre() {
        return nombre;
    }

    public String setNombre(String nombre) {
        this.nombre = nombre;
        return nombre;
    }

    public int getDistanRec()
    {
        return distanRec;
    }

    public void setDistanRec(int distanRec) {
        this.distanRec = distanRec;
    }

    public int getVelocidad() {

        return velocidad;
    }



    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public boolean isLlegadaMeta() {
        return llegadaMeta;
    }

    public void setLlegadaMeta(boolean llegadaMeta) {
        this.llegadaMeta = llegadaMeta;
    }

    public int getPosicionFinal() {
        return posicionFinal;
    }

    public void setPosicionFinal(int posicionFinal) {
        this.posicionFinal = posicionFinal;
    }

    public synchronized void correr() {

        Random rd = new Random();
        int numb = rd.nextInt(60) + 1;
        if (numb < 15) {
            numb = numb * 4;
            velocidad += numb;
            distanNet+=numb;
        } else {
            velocidad += numb * 2;
            distanNet = distanNet+ (numb*2);
        }

        int pt = meta.getDistanPista() - velocidad;
                setDistanRec(pt);

    }
    public int getDistanNet() {
        return distanNet;
    }

    public void setDistanNet(int distanNet) {
        this.distanNet = distanNet;
    }

}
