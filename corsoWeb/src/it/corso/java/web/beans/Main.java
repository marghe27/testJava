package it.corso.java.web.beans;

import java.io.*;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.Collections;

import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.lang.IndexOutOfBoundsException;




public class Main {

        public static void main(String[] args)  throws FileNotFoundException {


            System.out.println("Hello World!");

            ReadFile r = new ReadFile();

            r.setDay(new ArrayList<>());
            r.setMaxT(new ArrayList<>());
            r.setMinT(new ArrayList<>());
            //ArrayList vuoto per mettere i valori ottenuti dalla differenza delle temperature
            r.setDiff(new ArrayList<>());


            try {
                
                r.setFile(new File("src/weather.dat"));

                Scanner scan = new Scanner(r.getFile());
                boolean inputFile = scan.hasNextLine();
                while (inputFile) {
                    String line = scan.nextLine();
                    System.out.println(line);
                    //inserisco i dati dentro un ArrayList
                    r.getDay().add(scan.nextInt());
                    r.getMaxT().add(scan.nextInt());
                    r.getMinT().add(scan.nextInt());

                }

                scan.close();



            } catch (NoSuchElementException e) {
                System.out.println("Si è verificato un errore NoSuchElement!");
                System.out.println(e);
            }
            catch (IndexOutOfBoundsException ex) {
                System.out.println("Si è verificato un errore IndexOutOfBounds!");
                System.out.println(ex);
            }




            Integer[] array = new Integer[r.calculateRange(r.getMaxT(), r.getMinT()).size()];
            array = r.getDiff().toArray(array);
            System.out.println("Il contenuto di array è  ");
            for (Integer z : array){
                System.out.println(" "+z);
            }


             // escursione minima
            int min = Collections.min(r.getDiff());
            System.out.println("La escursione minima è: "+ min);

            r.dayWithMin(min);

         }


}

