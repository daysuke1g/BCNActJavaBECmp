/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m11.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JoseLuis.Canivano
 */
public class Ticket 
{ private static int ticketIdGen = 1;    //generador d'id

  public static enum ESTAT_TICKET { OBERT, TANCAT } ; //estat del ticket 
    
  private   int           ticketId = 0 ;
  private   ESTAT_TICKET  estat; //estat 
  private   float total_preu = 0; // preu total  
  protected List<Producte> lProducte = null; // llista de productes del ticket  

  public Ticket()
  { lProducte = new ArrayList();
    ticketId  = ticketIdGen++;
    estat     = ESTAT_TICKET.OBERT;
  }
  
  public boolean afegirProducte(Producte p) throws Exception
  { if(estat==ESTAT_TICKET.TANCAT) { throw new Exception("Ticket tancat. No es poden afegir productes."); }
    return lProducte.add(p);
  }
      
  public boolean finalitzar()
  { if(lProducte.size()==0) { return false; }        
    total_preu = (float)lProducte.stream().mapToDouble(p->(double)p.preu).sum();
    estat      = ESTAT_TICKET.TANCAT;
    return true;
  }
  
  public float totalPreu() { return total_preu; }
  
  public int getTicketId() { return ticketId; }
  
  public List<Producte> getProductes()
  { return lProducte;
  }
  
 
}
