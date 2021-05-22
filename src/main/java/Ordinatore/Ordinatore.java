/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ordinatore;

import com.mycompany.concorsi_pubblici.Concorso;

/**
 *
 * @author nr557
 */
public class Ordinatore 
{
       public static void scambia (Concorso v[],int posizione1,int posizione2)
    {
        Concorso c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    
    public static void scambia(int v[],int posizione1,int posizione2)
    {
        int c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    public static void scambia(String v[],int posizione1,int posizione2)
    {
        String c;
        c=v[posizione1];
        v[posizione1]=v[posizione2];
        v[posizione2]=c;
    }
    public static Concorso[] selectionSortCrescente(Concorso[] a)
    {
        Concorso[] ordinato=new Concorso[a.length];
        
        for(int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        for(int i=0;i<=ordinato.length-2;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].getCognome().compareToIgnoreCase(ordinato[i].getCognome())<0)
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
    
    public static int[] selectionSortDecrescente(int[] a)
    {
        int[] ordinato=new int[a.length];
        
        for(int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        for(int i=0;i<=ordinato.length-2;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j]>ordinato[i])
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
    
    public static String[] selectionSortCrescente(String[] a)
    {
        String[] ordinato=new String[a.length];
        
        for(int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        for(int i=0;i<=ordinato.length-2;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].compareToIgnoreCase(ordinato[i])<0)
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
    
    public static String[] selectionSortDecrescente(String[] a)
    {
        String[] ordinato=new String[a.length];
        
        for(int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        for(int i=0;i<=ordinato.length-2;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].compareToIgnoreCase(ordinato[i])>0)
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
    
    
    
    public static Concorso[] selectionSortAfabetico(Concorso[] a)
    {
        Concorso[] ordinato=new Concorso[a.length];
        
        for(int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        for(int i=0;i<=ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].getCognome().compareToIgnoreCase(ordinato[i].getCognome())<0 )
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
    
    
}
