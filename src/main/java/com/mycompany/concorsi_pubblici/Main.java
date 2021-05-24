/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.concorsi_pubblici;

import file.FileExeption;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author STUDENTE
 */
public class Main 
{
    public static void main(String[] args) 
    {
        String[] vociMenu= new String[8];
        Scanner tastiera= new Scanner(System.in);
        int sceltaUtente=-1;
        Concorso concorso;
        ElencoProva ArrayConcorsi= new ElencoProva();
        int codiceIdentificativo=1;
        int anno, mese, giorno;
        String codiceFiscale, tipologia;
        String nomeFileBinario="elencoProva.bin";
        String nomeFileTesto="elencoProva.txt";
        
     
              
        ElencoProva e1= new ElencoProva();
        

       
        
        
        vociMenu[0] = "Esci";
        vociMenu[1] = "Aggiungi una prova";
        vociMenu[2] = "Rimuovi prova";
        vociMenu[3] = "Visualizza elenco prove svolte";
        vociMenu[4] = "Visualizza il numero di partecipanti per ogni concorso";
        vociMenu[5] = "Visualizza i risultati di una prova in una determinata prova";
        vociMenu[6] = "Salva dati";
        vociMenu[7] = "Esporta dati";
        
        Menu menu= new Menu(vociMenu);
        
        
        //deserializzazione
        
        try 
        {
            
            e1=e1.caricaProva(nomeFileBinario);
            System.out.println("Dati caricati correttamente");
        }
        catch (IOException ex) 
        {
            System.out.println("Impossibile accedere al file. I dati non sono stati caricati");
        }
        catch (FileExeption ex) 
        {
            System.out.println("Errore di lettura dal file. I dati non sono stati caricati");
        }
        
        
        do
        {
            try
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
                  tastiera.nextLine();
                  concorso= new Concorso();
                  
                  System.out.println("INSERICI I DATI RICHIESTI: ");
                  System.out.println("Nome: ");
                  concorso.setNome(tastiera.nextLine());
                  
                  System.out.println("Cognome: ");
                  concorso.setCognome(tastiera.nextLine());
                  
                  System.out.println("Codice Fiscale: ");
                  concorso.setCodiceFiscale(tastiera.nextLine());
                  
                  System.out.println("Tipologia di concorso: ");
                  concorso.setTipologiaConcorso(tastiera.nextLine());
                  
                  System.out.println("Inserisci il punteggio: ");
                  concorso.setPunteggioConcorso(tastiera.nextInt());
                  
                  System.out.println("Inserisci l'anno: ");
                  anno=tastiera.nextInt();
                  
                  
                  System.out.println("Inserisci il mese: ");
                  mese=tastiera.nextInt();
                  
                  System.out.println("Inserisci il giorno: ");
                  giorno=tastiera.nextInt();
                  concorso.setDataProva(anno, mese, giorno);
                  
                  System.out.println("Il tuo codice identificativo è "+codiceIdentificativo);
                  concorso.setCodiceIdentificativo(codiceIdentificativo);
                  
                  codiceIdentificativo++;
                  
                  e1.aggiungiConcorso(concorso);
                  
                  
                  break;
                          
                  
                 
                 
              }
              case 2:
              {
                  tastiera.nextLine();
                  System.out.println("ELIMINA UN CONCORSO "); 
                  
                  System.out.println("Inserisci il codice fiscale del candidato: ");
                  codiceFiscale=tastiera.nextLine();
                  
                  Concorso[] c1;
                  c1=e1.visualizzaConcorsi(codiceFiscale);
                  
                  for(int i=0; i<c1.length; i++)
                  {
                      if (c1[i]!=null)
                        System.out.println(c1[i]);
                  }
                  
                  System.out.println("Inserisci il codice identificativo della prova da eliminare: ");
                  codiceIdentificativo=tastiera.nextInt();
                  e1.eliminaConcorsi(codiceIdentificativo);
                  
                  
                  System.out.println("QUESTE SONO LE PROVE AGGIORNATE");
                  c1=e1.visualizzaConcorsi();
                  for(int i=0; i<c1.length; i++)
                  {
                      if (c1[i]!=null)
                        System.out.println(c1[i]);
                  }
                  break;    
              }
              case 3:
              {
                  tastiera.nextLine();
                  System.out.println("VISUALIZZA I CONCORSI DI UNA PERSONA ");
                  
                  System.out.println("Inserisci il codice fiscale del candidato: ");
                  codiceFiscale=tastiera.nextLine();
                  
                  Concorso[] c1;
                  c1=e1.visualizzaConcorsi(codiceFiscale);
                  
                  for(int i=0; i<c1.length; i++)
                  {
                      if(c1[i]!=null)
                          System.out.println(c1[i]);
                  }
                  System.out.println("Premi un tasto per continuare... ");
                  tastiera.nextLine();
                  
                  break;
              }
              case 4:
              {
                  tastiera.nextLine();
                  System.out.println("VISUALIZZA L'ELENCO DELLE PROVE DI UNA TIPOLOGIA");
                  
                  System.out.println("Inserisci la tipologia: ");
                  tipologia=tastiera.nextLine();
                  
                  
                  
                  Concorso c1;
                  System.out.println("Per la tipologia inserita ci sono: "+e1.visualizzaNumPartecipantiPerTipologia(tipologia)+" partecipanti");
                  break;
                  
              }
              case 5:
              {
                  Concorso[] elencoOrdinato;
                  tastiera.nextLine();
                  System.out.println("Visualizza i risultati di un concorso tenutosi in una determinata data"); 
                  
                  System.out.println("Inserisci la tipologia: ");
                  tipologia=tastiera.nextLine();
                  
                  System.out.println("Inserisci l'anno: ");
                  anno=tastiera.nextInt();
                  
                  System.out.println("Inserisci il mese: ");
                  mese=tastiera.nextInt();
                  
                  System.out.println("Inserisci il giorno: ");
                  giorno=tastiera.nextInt();
                  
                  elencoOrdinato=e1.visualizzaOrdineAlfabetico(anno, mese, giorno, tipologia);
                  
                  for (int i=0; i<elencoOrdinato.length; i++)
                  {
                      if (elencoOrdinato[i]!=null)
                      {
                          System.out.println(elencoOrdinato[i]); 
                      }
                  }
                  
                  break;
                  
                  
              }
              
              case 6:
              {
                try 
                {
                    e1.salvaProva(nomeFileBinario);
                    System.out.println("Dati salvati correttamente");

                } catch (IOException ex) 
                {

                    System.out.println("Impossibile accedere al file. I dati non sono stati salvati");
                }
                break;
                
                
                 
                  
                  
              }
              case 7:
              {
                  
                  try
                     {
                        e1.esportaConcorsoCsv(nomeFileTesto);
                         System.out.println("esportazione avvenuta correttamente!");
                     }
                     catch(IOException e0)
                     {
                         System.out.println("Impossibile accedere al file, i libri non sono stati salvati.");
                     }
                     catch( FileExeption  e2)
                     {
                         System.out.println(e2.toString());
                     }
                 
                     break;

              }

              
              
          }
          }
          catch(InputMismatchException | NumberFormatException ex)
                {
                    tastiera.nextLine();
                    System.out.println("Input non corretto");
                }
        }while(sceltaUtente!=0);
            
        
    }
    
}
