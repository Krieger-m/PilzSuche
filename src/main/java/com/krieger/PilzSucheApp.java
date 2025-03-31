package com.krieger;

import com.krieger.PilzSucheController.PilzFeld;


public class PilzSucheApp {

    public static void main(String[] args) {
        PilzFeld pf = new PilzFeld();
        do {
            System.out.println("\n------------------");
            System.out.println("  PilzSuche v0.2  ");
            System.out.println("------------------\n");

            pf.setSize();
            pf.spielfeldFunc();

            System.out.print("\n\tDie Pilzsuche Startet\n\n");


            do {
                System.out.println("-------------------------");
                pf.zeigeSpielfeldVersteckt();
                pf.showStats();
                pf.koordinatenEingeben();
                pf.eingabeAbgleich();
                System.out.println("-------------------------");
            } while(pf.versuche>0||pf.anzahl>0);

            if(pf.anzahl==0){
                System.out.println("\n\tDu hast gewonnen!!!\n");
            } else if(pf.versuche==0){
                System.out.println("\n\tDu hast leider verloren...\n");
            }
            pf.nochEinmal();
        } while(pf.wdh=='j');

    }
}