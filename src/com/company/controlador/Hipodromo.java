package com.company.controlador;

import com.company.entidades.Caballo;
import com.company.entidades.Meta;



import java.util.*;

public class Hipodromo {
    public List<String> caballosCarrera = new ArrayList<>(){};



    public List<String> getCaballosCarrera() {
        return caballosCarrera;
    }

    public Hipodromo() throws InterruptedException {

        int opDis = 0;
        int confirm= 0;
        boolean confimcab= false;
        boolean confirmar= false;
        Meta meta = new Meta();


        do {

            try {

            System.out.println("Indique la distancia de la carrera");
            System.out.println("1- 1000 metros");
            System.out.println("2- 2000 metros");
            System.out.println("3- 3000 metros");

            Scanner sc= new Scanner(System.in);
            opDis = sc.nextInt();
             if (opDis == 1){
                 confirmar = true;
                 meta.setDistanPista(1000);
             }else if ( opDis == 2 ){
                 confirmar = true;
                 meta.setDistanPista(2000);
             }else if (opDis == 3){
                 confirmar= true;
                 meta.setDistanPista(3000);
             }else{
                 System.out.println("Opcion Invalida, Vuelva a elegir");
                 confirmar = false;
                 System.out.println("Solo valores numericos del 1 al 3");
             }

            }catch (InputMismatchException e){
                System.out.println("Solo se admiten valores numericos ");
            }
        }while (!confirmar);


        do {
        System.out.println("favor ingresar el nombre del caballo");

        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        caballosCarrera.add(nombre);

                        try {

                        System.out.println("desea agregar otro caballo?");
                        System.out.println("1-Si");
                        System.out.println("2-No");

                        Scanner op = new Scanner(System.in);
                        confirm = op.nextInt();
                        if (confirm == 1) {
                            confimcab = true;
                        } else if (confirm== 2) {
                            confimcab = false;

                        }
                    } catch (InputMismatchException e) {
                        confimcab= false;
                        System.out.println("el valor ingresado no corresponde");
                    }
                    }while (confimcab );


        System.out.println("En esta carrera se presentan los siguientes ejemplares que correran : "+ meta.getDistanPista() + "metros");

         for(int i= 0; i <= caballosCarrera.size()-1; i++){
             System.out.println(caballosCarrera.get(i));
        }

        System.out.println("------------------------------------------------------------");

                 do {
                     System.out.println("favor escribir " + "INICIAR" + " para poder continuar ");
                     Scanner ic = new Scanner(System.in);
                     String valid = ic.nextLine();
                     String iniciar = "INICIAR";
                     if (valid.equals(iniciar)){
                         confirmar = true;
                         }else if (!valid.equals(iniciar)){
                         confirmar = false;
                         System.out.println("palabra invalida");
                     }
                 }while (!confirmar);
        for(int i= 0; i <= caballosCarrera.size()-1; i++){
            Caballo arr[] = {new Caballo(caballosCarrera.get(i), meta)};
                      for (int a= 0; a <= arr.length-1; a++){

                arr[a].start();



              //  for(int p= 0; p <= caballosCarrera.size(); p++){
                 //   System.outprintln( meta.podio.get(p)) ;

              //  }


                }

             }
        }
    }





