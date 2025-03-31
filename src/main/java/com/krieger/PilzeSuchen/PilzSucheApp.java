package com.krieger.PilzeSuchen;

import com.krieger.PilzeSuchen.PilzSucheController.PilzFeld;


public class PilzSucheApp {

    public static void main(String[] args) {
        PilzFeld pf = new PilzFeld();
        do {
            System.out.println("\n------------------");
            System.out.println("  PilzSuche v0.2  ");
            System.out.println("------------------\n");

            pf.versuche = pf.setSize();


            System.out.print("\n\tDie Pilzsuche Startet\n\n");

            pf.spielfeldFunc();

            do {
                System.out.println("-------------------------");
                pf.zeigeSpielfeldVersteckt();
                pf.showStats();
                pf.koordinatenEingeben();
                pf.eingabeAbgleich();
                System.out.println("-------------------------");
                if(pf.anzahl==0){
                    System.out.println("\n\tDu hast gewonnen!!!\n"); break;
                } else if(pf.versuche==0){
                    System.out.println("\n\tDu hast leider verloren...\n"); break;
                }
            } while(true);


            pf.nochEinmal();
            while(pf.wdh!='j'&&pf.wdh!='n'){
                System.err.println("Ungültige Eingabe. \nErneut eingeben:");
                pf.nochEinmal();
            }
        } while(pf.wdh=='j');

    }
}