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
import file.TextFile;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import Ordinatore.*;



public class ElencoProva implements Serializable
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

    public int getnConcorsiPresenti() 
    {
        return nConcorsiPresenti;
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

    public Concorso[] getInsiemeConcorsi() 
    {
        return insiemeConcorsi;
    }
    
    
    public void salvaProva(String nomeFile) throws FileNotFoundException, IOException
  {
      FileOutputStream f1=new FileOutputStream(nomeFile);
      ObjectOutputStream outputStream=new ObjectOutputStream(f1);
      outputStream.writeObject(this);
      outputStream.flush();
      outputStream.close();
  }
  
  public ElencoProva caricaProva(String nomeFile) throws FileNotFoundException, IOException, FileExeption 
  {
      FileInputStream f1=new FileInputStream(nomeFile);
      ObjectInputStream inputStream=new ObjectInputStream(f1);
      ElencoProva e1;
       try 
       {
           e1=(ElencoProva)inputStream.readObject();
           inputStream.close();
            return e1;
       } 
       catch (ClassNotFoundException ex) 
       {
          inputStream.close();
          throw new FileExeption("Errore nella lettura del file");
       }
       
  }
  public Concorso getConcorso(int n)
  {
      try
      {
          return new Concorso(insiemeConcorsi[n]);
      }
      catch (NullPointerException e0)
              {
                 return null;
              }
  }
  
  public Concorso[] visualizzaOrdineAlfabetico(int anno, int mese, int giorno, String tipologia)
  {
      LocalDate dataConfronto=null;
      dataConfronto= dataConfronto.of(anno, mese, giorno);
      int n=0;
      for(int i=0; i<nConcorsiPresenti; i++)
      {
          if(insiemeConcorsi[i]!=null && dataConfronto.isEqual(insiemeConcorsi[i].getDataProva()) && tipologia.compareToIgnoreCase(insiemeConcorsi[i].getTipologiaConcorso())==0)
          {
             n++;
          }
      }
      Concorso[] elenco=new Concorso[n];
      int c=0;
      
      for(int i=0; i<nConcorsiPresenti; i++)
      {
          if(insiemeConcorsi[i]!=null && dataConfronto.isEqual(insiemeConcorsi[i].getDataProva()) && tipologia.compareToIgnoreCase(insiemeConcorsi[i].getTipologiaConcorso())==0)
          {
             elenco[c] = insiemeConcorsi[i];
             c++;
          }
      }
      elenco= Ordinatore.selectionSortAfabetico(elenco);
      return elenco;
      
      
      
      
  }
 
  public void esportaConcorsoCsv(String nomeFile) throws IOException, FileExeption
  {
      TextFile f1= new TextFile(nomeFile, 'W');
      
      Concorso c=null;
      
          for(int i=0;i<getnConcorsiPresenti();i++)
          {
              c=getConcorso(i);
              if(c!=null)
              {
                 
                  f1.toFile(c.getCodiceIdentificativo()+";"+c.getNome()+";"+c.getCognome()+";"+c.getCodiceFiscale()+";"+c.getTipologiaConcorso()+";"+c.getPunteggioConcorso()+";"+c.getDataProva()+";");
                  
                 
              }
          }
      
      f1.close();
      
  }

}
