package com.krieger.PilzeSuchen;

import java.util.Scanner;

import static java.lang.Math.random;

public class PilzSucheController {

    public static class PilzFeld{

            // Variablen etc
        Scanner scanner = new Scanner(System.in);
        int size=25;
        int[] platz = new int[size+1];
        int anzahl = 0;
        int total;

        char wdh;
        int[] koordinaten = {0,0};
        char[][] spielfeld = new char[size+1][size+1];
        int versuche;

        // Größe festlegen \\
        // || \\
        public int setSize(){
            //
            System.out.print("Spielfeld Größe eingeben: (2-24) ");
            //TODO wieder aktivieren !! -> //
            size = scanner.nextInt();
            while(size<2||size>24) {
                System.err.println("Eingabe liegt nicht im gültigen Bereich. \nErneut eingeben:");
                size = scanner.nextInt();
            }
            System.out.println("\nGewählte Größe : "+size);
            return size;
        }

            // Zeige Stats
        void showStats(){
            System.out.printf("\n\t\tAnzahl Pilze: %2d/%2d\n",anzahl,total);
            System.out.printf("\t\tVersuche: %2d/%2d \n",versuche,size);
        }
            // Neues Spiel
        void nochEinmal(){
            System.out.println("Noch ein Spiel? (j/n): ");
            String wdhTemp=scanner.next().toLowerCase();

            wdh = wdhTemp.charAt(0);
        }

        void pilzPlatz(){
                // Random Platzauswahl für die Pilze, im Array hier im Objekt abgespeichert
            for(int x=1;x<=size;x++){
                platz[x]= (int)(random()*(size+1));
                // Plätze anzeigen -> //TODO hier u.u. aktivieren! //System.out.println("  - Platz["+x+"] "+platz[x]);
                if(platz[x]>0){
                    anzahl++;
                }
            }
            total=anzahl;
            System.out.printf("Anzahl der Pilze im Feld: %2d\n",total);
        }

        void spielfeldFunc(){

                // Spielfeld erstellen und füllen \\
            int n=49;
            for (int y=1;y<=size;y++){
               spielfeld[y][0]=(char)(n);
                n++;

                for(int x=1;x<=size;x++){
                    spielfeld[y][x]=48;

                }
            }
            pilzPlatz();
            feldFüllen();
        }

        void feldFüllen(){
            for(int y=1;y<=size;y++){
                if(platz[y]>0){
                    spielfeld[y][platz[y]]=49;
                }
            }
        }

            // Buchstaben für die x-Koordinaten
        void buchstabenXAchse(){
            System.out.println();
            System.out.printf("%2d ",0);
            char[] a= new char[size];

            for (int i=0;i<size;i++) {
                a[i]= (char)(65+i); // ASCII values für 'a', etc.
                System.out.printf(a[i]+" ");
            } System.out.println();
        }

            // Spielfeld wird angezeigt mit platzierung, nur zur kontrolle
        void zeigeSpielfeld(){
            buchstabenXAchse();
            for (int y=1;y<=size;y++){
                System.out.printf("%2d",y);

                for(int x=1;x<=size;x++){
                    System.out.printf("%2c",spielfeld[y][x]);
                }
                System.out.println();
            }
        }
        void zeigeSpielfeldVersteckt(){
            buchstabenXAchse();
            int[][] spielfeldVerst=new int[size+1][size+1];
            for (int y=1;y<=size;y++){
                System.out.printf("%2d",y);

                for(int x=1;x<=size;x++){
                    spielfeldVerst[y][x] = spielfeld[y][x];
                    switch (spielfeldVerst[y][x]) {
                    case 48, 49:spielfeldVerst[y][x]=120;break;
                    case 51:spielfeldVerst[y][x]=80;break;
                    case 50:spielfeldVerst[y][x]=48;break;
                }
                    System.out.printf("%2c",spielfeldVerst[y][x]);

                }
                System.out.println();
            }
        }

        // Usereingabe Koordinaten
        public void koordinatenEingeben(){

                // TODO Schreibe Methode für Usereingabe Pilzposition
            Scanner s = new Scanner(System.in);


            System.out.print("\nX Koordinate eingeben: ");
            int xPos = 0;
            String xTemp = s.next().toLowerCase();

            // Koordinaten werden umgewandelt
            char xChar = xTemp.charAt(0);
            xPos=xChar;

            System.out.print("Y Koordinate eingeben: ");
            koordinaten[0] = s.nextInt();
            koordinaten[1]=xPos-96;

            // TODO Koordinaten werden als Zahlen zurückgegeben
            //System.out.println("X: " + koordinaten[0]);
            //System.out.println("Y: " + koordinaten[1]);
        }

        public void eingabeAbgleich() {

            if (spielfeld[koordinaten[0]][koordinaten[1]]==49){
                System.out.println("\nGlückwunsch!!! Treffer!\n\tEin Pilz wurde gefunden.");
                anzahl--;
                versuche--;
                spielfeld[koordinaten[0]][koordinaten[1]]=51;
            } else if(spielfeld[koordinaten[0]][koordinaten[1]]==48){
                System.out.println("\nDas war leider nichts... Schade!\n\tNächster Versuch.");
                versuche--;
                spielfeld[koordinaten[0]][koordinaten[1]]=50;
            } else{
                System.err.println("Eingabe liegt nicht im gültigen Bereich. \nErneut eingeben:");
            }
            showStats();
        }

    }


}
