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


public class ElencoProva 
{
    //attributi
    private Concorso[] insiemeConcorsi;
    private static int N_MAX_CONCORSI=100;
    private int nConcorsiPresenti;
    
    
    
    public ElencoProva()
    {
        insiemeConcorsi= new Concorso[N_MAX_CONCORSI];
        nConcorsiPresenti=0;
    }
    
    public ElencoProva(ElencoProva e1)
    {
       insiemeConcorsi=e1.getInsiemeConcorsi(); 
       nConcorsiPresenti=0;
    }
    
    public int aggiungiConcorso(Concorso c1)
    {
       for(int i=0; i<insiemeConcorsi.length; i++)
       {
           if(insiemeConcorsi[i]==null)
           {
               insiemeConcorsi[i]= new Concorso(c1);
               nConcorsiPresenti++;
               return 0;
           }
       
       }
       return -1;
    }
    
    public Concorso[] visualizzaConcorsi(String codiceFiscale)
    {
        Concorso[] elencoConcorsi=new Concorso[insiemeConcorsi.length];
        int c=0;
       for(int i=0; i<insiemeConcorsi.length; i++)
       {
           if(insiemeConcorsi[i]!=null)
           {
              if (insiemeConcorsi[i].getCodiceFiscale().compareToIgnoreCase(codiceFiscale)==0)
              {
                 elencoConcorsi[c]=insiemeConcorsi[i];
                 c++;
              }
                  
                  
           }
       
       }
       return elencoConcorsi;
       
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
        nConcorsiPresenti--;
    }
    
    
    
    
    public Concorso[] visualizzaConcorsi()
    {
       Concorso[] elencoConcorsi=new Concorso[insiemeConcorsi.length];
       for(int i=0; i<insiemeConcorsi.length; i++)
       {
           if(insiemeConcorsi[i]!=null)
           {
               System.out.println(insiemeConcorsi[i].toString());
           }
       
       }
       return elencoConcorsi;
       
    }
    
   public int visualizzaNumPartecipantiPerTipologia(String tipologia)
   {
       int contatore=0;
       for (int i=0; i<insiemeConcorsi.length; i++)
       {
           if (insiemeConcorsi[i]!=null)
           {
               if (insiemeConcorsi[i].getTipologiaConcorso().compareToIgnoreCase(tipologia)==0)
               {
                  contatore++; 
               }
           }
       }
       return contatore;
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
