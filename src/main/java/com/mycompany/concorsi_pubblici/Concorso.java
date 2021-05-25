/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.concorsi_pubblici;

import java.io.Serializable;
import java.time.*;

/**
 *
 * @author RamziNabil
 */
public class Concorso implements Serializable
{
    private int codiceIdentificativo;
    private String tipologiaConcorso;
    private String cognome;
    private String nome;
    private String codiceFiscale;
    private LocalDate dataProva;
    private int punteggioConcorso;
    private int numeroProve;
    
  
    
    
    /**
     * Costruttore
     * @param codiceIdentificativo
     * @param tipologiaConcorso
     * @param cognome
     * @param nome
     * @param codiceFiscale
     * @param anno
     * @param mese
     * @param giorno
     * @param punteggioConcorso 
     */
    public Concorso(int codiceIdentificativo, String tipologiaConcorso, String cognome, String nome, String codiceFiscale, int anno,int mese,int giorno, int punteggioConcorso)
    {
        this.codiceFiscale=codiceFiscale;
        this.codiceIdentificativo=codiceIdentificativo;
        this.tipologiaConcorso=tipologiaConcorso;
        this.cognome=cognome;
        this.nome=nome;
        this.dataProva=dataProva.of(anno,mese,giorno);
        this.punteggioConcorso=punteggioConcorso;
    }
   
  
    /**
     * Costruttore di copia
     * @param c 
     */
    public Concorso(Concorso c)
    {
        this.codiceFiscale=c.codiceFiscale;
        this.codiceIdentificativo=c.codiceIdentificativo;
        this.cognome=c.cognome;
        this.nome=c.nome;
        this.punteggioConcorso=c.punteggioConcorso;
        this.tipologiaConcorso=c.tipologiaConcorso;
        this.dataProva=c.dataProva;  
    }
    /**
     * Costruttore di default
     */
    public Concorso()
    {
        codiceFiscale="";
        codiceIdentificativo=-1;
        cognome="";
        nome="";
        punteggioConcorso=-1;
        tipologiaConcorso="";
        dataProva=dataProva.now();
        
    }
    /**
     * Metodo che restituisce il numero delle prove
     * @return 
     */
    public int getNumeroProve() 
    {
        return numeroProve;
    }
    
    
    /**
     * Metodo che restituisce il codice identificativo
     * @return 
     */
    public int getCodiceIdentificativo() 
    {
        return codiceIdentificativo;
    }
    /**
     * Metopo che restituisce la tipologia di concorso
     * @return 
     */
    public String getTipologiaConcorso() 
    {
        return tipologiaConcorso;
    }
    /**
     * Metodo che restituisce il cognome
     * @return 
     */
    public String getCognome() 
    {
        return cognome;
    }
    /**
     * Metodo che restituisce il nome
     * @return 
     */
    public String getNome()
    {
        return nome;
    }
    /**
     * Metodo che restituisce il codice fiscale
     * @return 
     */
    public String getCodiceFiscale() 
    {
        return codiceFiscale;
    }
    /**
     * Metodo che restituisce una data
     * @return 
     */
    public LocalDate getDataProva() 
    {
        return dataProva;
    }
    /**
     * Metodo che restituisce il punteggio del concorso
     * @return 
     */
    public int getPunteggioConcorso() 
    {
        return punteggioConcorso;
    }
    /**
     * Metodo che assegna una tipologia
     * @param tipologiaConcorso 
     */
    public void setTipologiaConcorso(String tipologiaConcorso) 
    {
        this.tipologiaConcorso = tipologiaConcorso;
    }
    /**
     * Metodo che assegna il codice identificativo
     * @param codiceIdentificativo 
     */
    public void setCodiceIdentificativo(int codiceIdentificativo) 
    {
        this.codiceIdentificativo = codiceIdentificativo;
    }
    
    /**
     * Metodo che assegna il cognome
     * @param cognome 
     */
    public void setCognome(String cognome) 
    {
        this.cognome = cognome;
    }
    /**
     * Metodo che assegna il nome
     * @param nome 
     */
    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    /**
     * Metodo che assegna il codice fiscale
     * @param codiceFiscale 
     */
    public void setCodiceFiscale(String codiceFiscale) 
    {
        this.codiceFiscale = codiceFiscale;
    }
    /**
     * Metodo che assegna il la data di una prova
     * @param anno
     * @param mese
     * @param giorno 
     */
    public void setDataProva(int anno, int mese,int giorno) 
    {
        this.dataProva = dataProva.of(anno,mese,giorno);
    }
    /**
     * Metodo che assegna il punteggio di un concorso
     * @param punteggioConcorso 
     */
    public void setPunteggioConcorso(int punteggioConcorso) 
    {
        this.punteggioConcorso = punteggioConcorso;
    }
    
    /**
     * Metodo toString che visualizza la stringa con i rispettivi attributi
     * @return 
     */
    public String toString()
   {
       String s;
       s="Codice Identificativo: "+getCodiceIdentificativo()+"; Tipologia Concorso: "+getTipologiaConcorso()+"; Cognome: "+getCognome()+"; Nome: "+getNome()+"; Codice Fiscale: "+getCodiceFiscale()+"; Punteggio Concorso: "+getPunteggioConcorso();
       return s;
   }
}
    
    
   
   
    
    
    
 
