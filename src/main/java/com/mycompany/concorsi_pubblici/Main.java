/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.concorsi_pubblici;

import java.util.Scanner;

/**
 *
 * @author STUDENTE
 */
public class Main 
{
    public static void main(String[] args) 
    {
        String[] vociMenu= new String[9];
        Scanner tastiera= new Scanner(System.in);
        int sceltaUtente;

        Concorso c1= new Concorso(1, "Pompiere", "Sam", "Manuel", "RMZ", "21|10", 10);
        System.out.println(c1.toString());
        
        vociMenu[0] = "Esci";
        vociMenu[1] = "Aggiungi una prova";
        vociMenu[2] = "Rimuovi prova";
        vociMenu[3] = "Visualizza elenco prove svolte";
        vociMenu[4] = "Visualizza il numero di partecipanti per ognu concorso";
        vociMenu[5] = "Visualizza i risultati di una prova in una determinata prova";
        vociMenu[6] = "Salva dati";
        vociMenu[7] = "Esporta dati";
        
        Menu menu= new Menu(vociMenu);
        
        do
        {
          sceltaUtente=menu.sceltaMenu();
          switch (sceltaUtente)
          {
              case 0:
              {
                  System.out.println("L'applicazione terminerà");
                  break;
              }
              case 1:
              {
                  
              }
              
          }
        }while(sceltaUtente!=0);
            
        
    }
    
}
