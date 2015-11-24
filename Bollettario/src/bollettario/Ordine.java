/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bollettario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author DiegoCarlo
 */
public class Ordine implements Serializable
{
    long id;
    String codiceCliente;
    Calendar dataDiConsegna;
    Calendar dataDiCompletamento;
    ArrayList<Prodotto> lista;
    StatoContabileOrdine statoContabile;
    StatoFisicoOrdine statoFisico;
    public Ordine(long id,String codiceCliente, Calendar dataDiConsegna)
    {
        this.id = id;
        this.codiceCliente = codiceCliente;
        this.dataDiConsegna = dataDiConsegna;
        this.lista = new ArrayList<Prodotto>();
        this.statoContabile = StatoContabileOrdine.PENDENTE;
        this.statoFisico = StatoFisicoOrdine.DA_FARE;
    }
    public int size()
    {
        return lista.size();
    }
    public Prodotto get(int i)
    {
        return lista.get(i);
    }
    void test()
    {
        int tot = (int)(Math.random()*5);
        System.out.println(tot+"pesata");
        for(int i=0; i<tot; i++)
        {
            UnitaDiMisura unitaDiMisura = UnitaDiMisura.NUMERO;
            double random = Math.random();
            double quantita = 1+(int)(random*20);
            if(0.5 > Math.random())
            {
                unitaDiMisura = UnitaDiMisura.KILOGRAMMI;
                quantita = random;
            }
            Quantita q = new Quantita((float)quantita, unitaDiMisura);
                    
            lista.add(new Prodotto("prodotto"+i, q)); 
        }
    }
}
class OrdineDataComparator implements Comparator<Ordine> {
        public int compare(Ordine ordine1, Ordine ordine2) {
            if(ordine1.dataDiConsegna.getTimeInMillis() - ordine2.dataDiConsegna.getTimeInMillis()>=0)
            {
                return 1;
            }
            else
            {
                return -1;
            }
        }
    }