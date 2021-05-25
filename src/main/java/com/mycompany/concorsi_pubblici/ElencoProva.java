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
    
    
    //costruttore
    public ElencoProva()
    {
        insiemeConcorsi= new Concorso[N_MAX_CONCORSI];
        nConcorsiPresenti=0;
    }
    
    //costruttore di copia
    public ElencoProva(ElencoProva e1)
    {
       insiemeConcorsi=e1.getInsiemeConcorsi(); 
       nConcorsiPresenti=0;
    }
    
    
    /**
     * metodo che restituisce il numero dei concorsi presenti nel array
     * @return 
     */
    public int getnConcorsiPresenti() 
    {
        return nConcorsiPresenti;
    }
    
    
  
    /**
     * metodo che aggiunge un concorso nel array
     * @param c1
     * @return 
     */
    public int aggiungiConcorso(Concorso c1)
    {
       for(int i=0; i<insiemeConcorsi.length; i++)
       {
           //se aggiunto correttamente restituisce 0 
           if(insiemeConcorsi[i]==null)
           {
               insiemeConcorsi[i]= new Concorso(c1);
               nConcorsiPresenti++;
               return 0;
           }
       
       }
       //altrimenti -1
       return -1;
    }
    
   
    /**
     * Metodo che visualizza un elenco di concorsi
     * @param codiceFiscale
     * @return 
     */
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
    
    //metodo che elimina un concorso dato un codice identificativo
    /**
     * 
     * @param codiceIdentificativo
     * @return 0 se elimina il concorso, oppure -1 se non lo elimina
     */
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
    
    /**
     * metodo che aggiorna le posizioni spostando tutti i concorsi di una posizione per far si di eliminare un concorso
     * @param posizione 
     */
    public void aggiornaPosizioniConcorsi(int posizione)
    {
        for (int i=posizione; i<insiemeConcorsi.length-1; i++)
        {
            insiemeConcorsi[posizione]=insiemeConcorsi[posizione+1];
        }
        insiemeConcorsi[getNMaxConcorsi()-1]=null;
        nConcorsiPresenti--;
    }
    
    
    
    /**
     * Metodo chd visualizza un elenco di concorsi
     * @return 
     */
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
   /**
    * Metodo che visualizza il numero di partecipanti di una singola tipologia
    * @param tipologia
    * @return contatore 
    */ 
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
   
   
 
   
   
   
   
  
   /**
    * Metodo che restituisce il valore massimo dei concorsi in un array
    * @return 
    */ 
    public static int getNMaxConcorsi()
    {
        return N_MAX_CONCORSI;
    }
    
    
    /**
     * Metodo che restituisce un insieme di concorsi
     * @return 
     */
    public Concorso[] getInsiemeConcorsi() 
    {
        return insiemeConcorsi;
    }
    
    /**
     * Metodo che salva una prova su file
     * @param nomeFile
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void salvaProva(String nomeFile) throws FileNotFoundException, IOException
  {
      FileOutputStream f1=new FileOutputStream(nomeFile);
      ObjectOutputStream outputStream=new ObjectOutputStream(f1);
      outputStream.writeObject(this);
      outputStream.flush();
      outputStream.close();
  }
  /**
   * Metodo che carica una prova su file
   * @param nomeFile
   * @return
   * @throws FileNotFoundException
   * @throws IOException
   * @throws FileExeption 
   */
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
  
  /**
   * Metodo che restituisce un concorso
   * @param n
   * @return 
   */
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
  /**
   * Metodo che visuaizza le prove svolte in ordine alfabetico
   * @param anno
   * @param mese
   * @param giorno
   * @param tipologia
   * @return 
   */
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
  /**
   * Metodo che esporta in csv
   * @param nomeFile
   * @throws IOException
   * @throws FileExeption 
   */
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
