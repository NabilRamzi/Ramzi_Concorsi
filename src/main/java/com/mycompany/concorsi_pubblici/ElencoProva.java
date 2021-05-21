/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.concorsi_pubblici;

/**
 *
 * @author nr557
 */

import  file.FileExeption;
import  File.TextFile;

public class ElencoProva 
{
    //attributi
    private Concorso[] insiemeConcorsi;
    private static int N_MAX_CONCORSI=100;
    
    
    
    public ElencoProva()
    {
        insiemeConcorsi= new Concorso[N_MAX_CONCORSI];
    }
    
    public ElencoProva(ElencoProva e1)
    {
       insiemeConcorsi=e1.getInsiemeConcorsi();         
    }
    
    public int aggiungiConcorso(Concorso c1)
    {
       for(int i=0; i<insiemeConcorsi.length; i++)
       {
           if(insiemeConcorsi[i]==null)
           {
               insiemeConcorsi[i]= new Concorso(c1);
               return 0;
           }
       
       }
       return -1;
    }
    
    public void visualizzaConcorsi(String codiceFiscale)
    {
       for(int i=0; i<insiemeConcorsi.length; i++)
       {
           if(insiemeConcorsi[i]!=null)
           {
              if (insiemeConcorsi[i].getCodiceFiscale().compareToIgnoreCase(codiceFiscale)==0)
              {
                  System.out.println(insiemeConcorsi[i].toString());
              }
                  
                  
           }
       
       }
       
    }
    
    public int eliminaConcorsi(int codiceIdentificativo)
    {
        for(int i=0; i<insiemeConcorsi.length; i++)
        {
            if(insiemeConcorsi[i]!=null)
            {
                if(insiemeConcorsi[i].getCodiceIdentificativo()==codiceIdentificativo)
                {
                    aggiornaPosizioniConcorsi(i);
                    return 0;
                }
            }
        }
        return -1;
    }
    
    public void aggiornaPosizioniConcorsi(int posizione)
    {
        for (int i=posizione; i<insiemeConcorsi.length-1; i++)
        {
            insiemeConcorsi[posizione]=insiemeConcorsi[posizione+1];
        }
        insiemeConcorsi[getNMaxConcorsi()-1]=null;
    }
    
    
    
    
    public void visualizzaConcorsi()
    {
       for(int i=0; i<insiemeConcorsi.length; i++)
       {
           if(insiemeConcorsi[i]!=null)
           {
               System.out.println(insiemeConcorsi[i].toString());
           }
       
       }
       
    }
    
   public void visualizzaNumPartecipanti(String tipologia)
   {
       
   }
    
    public static int getNMaxConcorsi()
    {
        return N_MAX_CONCORSI;
    }

    public Concorso[] getInsiemeConcorsi() {
        return insiemeConcorsi;
    }
    
    
    public void salvaConcorsi(String nomeFile)
    {
        
        
        
    }
}
