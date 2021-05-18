/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.concorsi_pubblici;

/**
 *
 * @author RamziNabil
 */
public class Concorso 
{
    private int codiceIdentificativo;
    private String tipologiaConcorso;
    private String cognome;
    private String nome;
    private String codiceFiscale;
    private String dataProva;
    private int punteggioConcorso;
    
  
    
    
    
    public Concorso(int codiceIdentificativo, String tipologiaConcorso, String cognome, String nome, String codiceFiscale, String dataProva, int punteggioConcorso)
    {
        this.codiceFiscale=codiceFiscale;
        this.codiceIdentificativo=codiceIdentificativo;
        this.tipologiaConcorso=tipologiaConcorso;
        this.cognome=cognome;
        this.nome=nome;
        this.dataProva=dataProva;
        this.punteggioConcorso=punteggioConcorso;
    }
    

    public int getCodiceIdentificativo() 
    {
        return codiceIdentificativo;
    }

    public String getTipologiaConcorso() 
    {
        return tipologiaConcorso;
    }

    public String getCognome() 
    {
        return cognome;
    }
    public String getNome()
    {
        return nome;
    }

    public String getCodiceFiscale() 
    {
        return codiceFiscale;
    }

    public String getDataProva() 
    {
        return dataProva;
    }

    public int getPunteggioConcorso() 
    {
        return punteggioConcorso;
    }

    public void setTipologiaConcorso(String tipologiaConcorso) 
    {
        this.tipologiaConcorso = tipologiaConcorso;
    }

    public void setCognome(String cognome) 
    {
        this.cognome = cognome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public void setCodiceFiscale(String codiceFiscale) 
    {
        this.codiceFiscale = codiceFiscale;
    }

    public void setDataProva(String dataProva) 
    {
        this.dataProva = dataProva;
    }

    public void setPunteggioConcorso(int punteggioConcorso) 
    {
        this.punteggioConcorso = punteggioConcorso;
    }
    
    public String toString()
   {
       String s;
       s="Codice Identificativo: "+getCodiceIdentificativo()+"; Tipologia Concorso: "+getTipologiaConcorso()+"; Cognome: "+getCognome()+"; Nome: "+getNome()+"; Codice Fiscale: "+getCodiceFiscale()+"; Punteggio Concorso: "+getPunteggioConcorso();
       return s;
   }
}
    
    
   
   
    
    
    
 
