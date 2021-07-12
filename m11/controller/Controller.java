/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m11.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import m11.model.Arbre;
import m11.model.DTOArbre;
import m11.model.DTODecoracio;
import m11.model.DTOFlor;
import m11.model.DTOStock;
import m11.model.Decoracio;
import m11.model.Flor;
import m11.model.Floristeria;
import m11.model.Producte;
import m11.model.Ticket;
import m11.repository.*;

/**
 *
 * @author JoseLuis.Canivano
 */
public class Controller 
{
  protected BaseDades baseDades;	
  //protected HashMap<String,Floristeria> mHTFloristeria;      // Lista de Floristeries que controla el programa
  //protected HashMap<String,List<Arbre>> mHTFloristeriaArbre; // LLista o stock d'arbres de la floristeria 'key'
  //protected HashMap<String,List<Flor>>  mHTFloristeriaFlor;  // LLista o stock de flors de la floristeria 'key'
 // protected HashMap<String,List<Decoracio>> mHTFloristeriaDecoracio; // LLista o stock de decoracio de la floristeria 'key'
  //protected HashMap<String,HashMap<Integer,Ticket>>     mHTTicketsOberts;  // LLista de tickets que s'esta gestionant la venda actualment;
 // protected HashMap<String,HashMap<Integer,Ticket>>     mHTTicketsTancats; // LLista de tickets que ja s'ha gestionant la venda;  
  
  public Controller()
  { 
	baseDades = new BaseDades();  
	//mHTFloristeria      = new HashMap<>();
   // mHTFloristeriaArbre = new HashMap<>();
    //mHTFloristeriaFlor  = new HashMap<>();
    //mHTFloristeriaDecoracio = new HashMap<>();
    //mHTTicketsOberts    = new HashMap<>();
    //mHTTicketsTancats   = new HashMap<>();
  }

  /**
   * Crea una floristeria amb un nom determinat
   * @param szNomFloristeria ... Nom de la floristeria
   * @return
   * @throws Exception 
   */
  public Floristeria crearFloristeria(String szNomFloristeria) throws Exception 
  {
    Floristeria f = baseDades.getmHTFloristeria().get(szNomFloristeria);
    if(f!=null) throw new Exception("Floristeria ja existent");

    f = new Floristeria(szNomFloristeria);
    baseDades.getmHTFloristeria().put(szNomFloristeria,f);
    
    baseDades.getmHTTicketsOberts().put(szNomFloristeria,new HashMap<>());
    baseDades.getmHTTicketsTancats().put(szNomFloristeria,new HashMap<>());     
    
    return f;
  }

  /**
   * Obte un llista amb els noms de les floristeries
   * @return 
   */
  public String[] getLListaFloristeries() 
  { String[] poLLista = null;
    
    Object o = null;
    Collection<String> colFloristeries = baseDades.getmHTFloristeria().keySet();
    if(colFloristeries!=null)
    { if(colFloristeries.size()>0)
      { poLLista =colFloristeries.stream()
                                 .sorted()
                                 .toArray(String[]::new);
      }
    }
    return poLLista;
  }

  /**
   * Afegeix un arbre a la hashtable d'arbres de la floristeria actual. En una aplicacio real hauria d'interactuar amb la BBDD
   * @param mCurrFloristeria
   * @param objDTO
   * @return 
   */
    public DTOArbre afegirArbre(String mCurrFloristeria, DTOArbre objDTO) 
    { Arbre a = new Arbre(objDTO.getNom(),objDTO.getPreu(),objDTO.getAlcada_cm());
      List<Arbre> lArbresFloristeria = baseDades.getmHTFloristeriaArbre().get(mCurrFloristeria);       
      if(lArbresFloristeria==null)
      { lArbresFloristeria = new ArrayList<>();
      }
      boolean bAdded = lArbresFloristeria.add(a);
      baseDades.getmHTFloristeriaArbre().put(mCurrFloristeria, lArbresFloristeria);
      return objDTO;  
    }

    /**
     * Afegeix una flor a la hashtable de flors de la floristeria actual. En una aplicacio real hauria d'interactuar amb la BBDD
     * @param mCurrFloristeria
     * @param objDTO
     * @return 
     */            
    public DTOFlor afegirFlor(String mCurrFloristeria, DTOFlor objDTO) 
    { Flor f = new Flor(objDTO.getNom(),objDTO.getPreu(),objDTO.getColor());
      List<Flor> lFlorsFloristeria = baseDades.getmHTFloristeriaFlor().get(mCurrFloristeria);       
      if(lFlorsFloristeria==null) 
      { lFlorsFloristeria = new ArrayList<>();
      }
      boolean bAdded = lFlorsFloristeria.add(f);
      baseDades.getmHTFloristeriaFlor().put(mCurrFloristeria, lFlorsFloristeria);
      return objDTO;  
    }

    /**
     * Retorna la llista de tipus de material de les decoracions (FUSTA, PLASTIC)
     * @return 
     */
    public String[] getLListaTipusMaterialDecoracio()
    { return Decoracio.mLListaTipusMaterial;  
    }

    /**
     * Afegeix una decoracio a la hashtable de decoracions de la floristeria actual. En una aplicacio real hauria d'interactuar amb la BBDD
     * @param mCurrFloristeria
     * @param objDTO
     * @return
     * @throws Exception 
     */
    public DTODecoracio afegirDecoracio(String mCurrFloristeria, DTODecoracio objDTO) throws Exception
    { Decoracio d = new Decoracio(objDTO.getNom(),objDTO.getPreu(),Decoracio.tipusMaterial(objDTO.getTipus_decoracio()));
      List<Decoracio> lDecoracioFloristeria = baseDades.getmHTFloristeriaDecoracio().get(mCurrFloristeria);       
      if(lDecoracioFloristeria==null) 
      { lDecoracioFloristeria = new ArrayList<>();
      }
      boolean bAdded = lDecoracioFloristeria.add(d);
      baseDades.getmHTFloristeriaDecoracio().put(mCurrFloristeria, lDecoracioFloristeria);
      return objDTO;         
    }

    /**
     * Genera un objecte DTO que conte dos arrays. Un per a les capçaleres i un altre amb les dades
     * per a ser mostrat en el jtable del panell central com a resultat de l'stock gestionat per la aplicacio
     * @param pFloristeria
     * @return 
     */
    public DTOStock getStock(String pFloristeria) 
    { DTOStock objDTO = new DTOStock();
      
      objDTO.mHeaders = new String [] { "Producte", "Descripcio" };
      objDTO.mData    = new Object[][] { { " "," " } , { " "," " } } ;
      
      String[][] arrData =  null;
      
      List<Arbre>     lArbres = null;
      List<Flor>      lFlors  = null;
      List<Decoracio> lDecoracio = null;
      int dNumArbres = 0;
      int dNumFlors  = 0;
      int dNumDecoracio = 0 ; 

      lArbres = baseDades.getmHTFloristeriaArbre().get(pFloristeria);
      if(lArbres!=null) { dNumArbres = lArbres.size();  }
      lFlors = baseDades.getmHTFloristeriaFlor().get(pFloristeria);
      if(lFlors!=null)  { dNumFlors = lFlors.size();    }
      lDecoracio = baseDades.getmHTFloristeriaDecoracio().get(pFloristeria);
      if(lDecoracio!=null) { dNumDecoracio = lDecoracio.size(); }
          
      int dItems = dNumArbres + dNumFlors + dNumDecoracio;
      if(dItems>0)
      { int dIdy = 0;
        arrData =  new String[dItems][2];
        if(dNumArbres>0)
        { for(Arbre a : lArbres)
          { arrData[dIdy][0] = "Arbre";
            arrData[dIdy][1] = a.toString();  
            dIdy++;
          }
        }
        if(dNumFlors>0)
        { for(Flor f : lFlors)
          { arrData[dIdy][0] = "Flor";
            arrData[dIdy][1] = f.toString();  
            dIdy++;
          }
        }        
        if(dNumDecoracio>0)
        { for(Decoracio d : lDecoracio)
          { arrData[dIdy][0] = "Decoracio";
            arrData[dIdy][1] = d.toString();  
            dIdy++;
          }
        }
        objDTO.mData = arrData;
      }      
      return objDTO;
    }
    
    /**
     * Operacio del Nivell2 que retorna el nombre d'elements de cada item amb el valor agrupat, el nombre 
     * total d'items amb el valor.
     * @param pFloristeria
     * @return 
     */    
    public DTOStock getStockValor(String pFloristeria) 
    { DTOStock objDTO = new DTOStock();
      
      objDTO.mHeaders = new String [] { "Producte", "Descripcio" };
      objDTO.mData    = new Object[][] { { " "," " } , { " "," " } } ;
      
      String[][] arrData =  null;

      int dNumArbres = 0;  float fValorArbres = 0;
      int dNumFlors  = 0;  float fValorFlors = 0;
      int dNumDecoracio = 0 ; float fValorDecoracio = 0;
      
      List<Arbre> lArbres = baseDades.getmHTFloristeriaArbre().get(pFloristeria);
      if(lArbres!=null)
      { dNumArbres = lArbres.size();  
        for(Arbre a : lArbres) { fValorArbres += a.getPreu(); }
      }     
      
      List<Flor> lFlors = baseDades.getmHTFloristeriaFlor().get(pFloristeria);
      if(lFlors!=null)
      { dNumFlors = lFlors.size();  
        for(Flor f : lFlors) { fValorFlors += f.getPreu(); }
      }  

      List<Decoracio> lDecoracio = baseDades.getmHTFloristeriaDecoracio().get(pFloristeria);
      if(lDecoracio!=null)
      { dNumDecoracio = lDecoracio.size();  
        for(Decoracio d : lDecoracio) { fValorDecoracio += d.getPreu(); }
      }  
      
      int   dTotal = dNumArbres + dNumFlors + dNumDecoracio;
      float fTotal = fValorArbres + fValorFlors + fValorDecoracio;
      
      arrData =  new String[4][2];
      arrData[0][0] =  String.format("%d Arbres", dNumArbres);         arrData[0][1] = String.format("Valor %.2f ", fValorArbres); 
      arrData[1][0] =  String.format("%d Flors",  dNumFlors);          arrData[1][1] = String.format("Valor %.2f ", fValorFlors); 
      arrData[2][0] =  String.format("%d Decoracions", dNumDecoracio); arrData[2][1] = String.format("Valor %.2f ", fValorDecoracio); 
      arrData[3][0] =  String.format("%d Items",  dTotal);             arrData[3][1] = String.format("Valor %.2f ", fTotal); 
      
      objDTO.mData = arrData;
      
      return objDTO;
    }

    /**
     * Retira un arbre de l'stock
     * @param pFloristeria
     * @param pNomArbre
     * @return
     * @throws Exception 
     */
    public boolean retirarArbre(String pFloristeria, String pNomArbre) throws Exception 
    { /*             
      Floristeria floristeria = mHTFloristeria.get(pFloristeria);
      if(floristeria==null) { throw new Exception ("Floristeria inexistent"); }      
      List<Arbre> lArbresFloristeria = mHTFloristeriaArbre.get(pFloristeria);
      if(lArbresFloristeria!=null)
      { if(lArbresFloristeria.size()>0)
        { for(int dIdx=0;dIdx<lArbresFloristeria.size();dIdx++)
          { if(lArbresFloristeria.get(dIdx).getNom().equals(pNomArbre)) 
            { Arbre a = lArbresFloristeria.remove(dIdx);
              if(a!=null)
              { mHTFloristeriaArbre.put(pFloristeria,lArbresFloristeria); 
                return true;
              }
            }
          }
        }
      }                
      return false;  
      */
      return retirarProducte(pFloristeria,pNomArbre,Arbre.class);
    }

    /**
     * Retira una flor de l'stock
     * @param pFloristeria
     * @param pNomFlor
     * @return
     * @throws Exception 
     */
    public boolean retirarFlor(String pFloristeria, String pNomFlor) throws Exception 
    { /*
      Floristeria floristeria = mHTFloristeria.get(pFloristeria);
      if(floristeria==null) { throw new Exception ("Floristeria inexistent"); }      
      List<Flor> lFlorsFloristeria = mHTFloristeriaFlor.get(pFloristeria);
      if(lFlorsFloristeria!=null)
      { if(lFlorsFloristeria.size()>0)
        { for(int dIdx=0;dIdx<lFlorsFloristeria.size();dIdx++)
          { if(lFlorsFloristeria.get(dIdx).getNom().equals(pNomFlor)) 
            { Flor f = lFlorsFloristeria.remove(dIdx);
              if(f!=null)
              { mHTFloristeriaFlor.put(pFloristeria,lFlorsFloristeria); 
                return true;
              }
            }
          }
        }
      }                
      return false;  
      */
      return retirarProducte(pFloristeria,pNomFlor,Flor.class);
    }

    /**
     * Retira una decoració de l'stock
     * @param pFloristeria
     * @param pNomDecoracio
     * @return
     * @throws Exception 
     */
    public boolean retiraDecoracio(String pFloristeria, String pNomDecoracio) throws Exception 
    { /*Floristeria floristeria = mHTFloristeria.get(pFloristeria);
      if(floristeria==null) { throw new Exception ("Floristeria inexistent"); }      
      List<Decoracio> lDecoracioFloristeria = mHTFloristeriaDecoracio.get(pFloristeria);
      if(lDecoracioFloristeria!=null)
      { if(lDecoracioFloristeria.size()>0)
        { for(int dIdx=0;dIdx<lDecoracioFloristeria.size();dIdx++)
          { if(lDecoracioFloristeria.get(dIdx).getNom().equals(pNomDecoracio)) 
            { Decoracio f = lDecoracioFloristeria.remove(dIdx);
              if(f!=null)
              { mHTFloristeriaDecoracio.put(pFloristeria,lDecoracioFloristeria); 
                return true;
              }
            }
          }
        }
      }                
      return false;*/      
      return retirarProducte(pFloristeria,pNomDecoracio,Decoracio.class);  
    }
    
    /**
     * Retira un producte concret ... Arbre, Flor o Decoracio
     *
     */
    public boolean retirarProducte(String pFloristeria, String pNom,Class pClass) throws Exception 
    { Floristeria floristeria = baseDades.getmHTFloristeria().get(pFloristeria);
      if(floristeria==null) { throw new Exception ("Floristeria inexistent"); }
      
      HashMap pHashTable=null; 
      List<Producte> lProducte = null;
      switch (pClass.getName()) 
      { case "m11.model.Arbre": 
        { lProducte = (List<Producte>)(List<? extends Producte>)baseDades.getmHTFloristeriaArbre().get(pFloristeria); 
          pHashTable = baseDades.getmHTFloristeriaArbre();
          break; 
        }
        case "m11.model.Flor":  
        { lProducte = (List<Producte>)(List<? extends Producte>)baseDades.getmHTFloristeriaFlor().get(pFloristeria); 
          pHashTable = baseDades.getmHTFloristeriaFlor() ;
          break; 
        }
        case "m11.model.Decoracio": 
        { lProducte = (List<Producte>)(List<? extends Producte>)baseDades.getmHTFloristeriaDecoracio().get(pFloristeria); 
          pHashTable = baseDades.getmHTFloristeriaDecoracio();
          break; 
        }
        default: { break; }
      }
      if(lProducte!=null)
      { if(lProducte.size()>0)
        { for(int dIdx=0;dIdx<lProducte.size();dIdx++)
          { if(lProducte.get(dIdx).getNom().equals(pNom)) 
            { Producte p = lProducte.remove(dIdx);
              if(p!=null)
              { pHashTable.put(pFloristeria,lProducte); 
                return true;
              }
            }
          }
        }
      }
      return false;      
    }

    
    public Producte getProducte(String pFloristeria, String pNom,Class pClass) throws Exception 
    { Floristeria floristeria = baseDades.getmHTFloristeria().get(pFloristeria);
      if(floristeria==null) { throw new Exception ("Floristeria inexistent"); }
      
      HashMap pHashTable=null; 
      List<Producte> lProducte = null;
      switch (pClass.getName()) 
      { case "m11.model.Arbre": 
        { lProducte = (List<Producte>)(List<? extends Producte>)baseDades.getmHTFloristeriaArbre().get(pFloristeria); 
          pHashTable = baseDades.getmHTFloristeriaArbre();
          break; 
        }
        case "m11.model.Flor":  
        { lProducte = (List<Producte>)(List<? extends Producte>)baseDades.getmHTFloristeriaFlor().get(pFloristeria); 
          pHashTable = baseDades.getmHTFloristeriaFlor() ;
          break; 
        }
        case "m11.model.Decoracio": 
        { lProducte = (List<Producte>)(List<? extends Producte>)baseDades.getmHTFloristeriaDecoracio().get(pFloristeria); 
          pHashTable = baseDades.getmHTFloristeriaDecoracio();
          break; 
        }
        default: { break; }
      }
      if(lProducte!=null)
      { if(lProducte.size()>0)
        { for(int dIdx=0;dIdx<lProducte.size();dIdx++)
          { Producte p = lProducte.get(dIdx);
            if(p.getNom().equals(pNom)) 
            { return p;
            }
          }
        }
      }
      return null;      
    }    
    
    
    
    /**
     * Operacio de nivell3 Obre un nom ticket per gestionar la venda i el possa al
     * hashtable de tickets gestionats com a oberts i que s'esta realitzant la venda  
     * @return 
     */
    public int getNewTicket(String pFloristeria) throws Exception
    { Floristeria floristeria = baseDades.getmHTFloristeria().get(pFloristeria);
      if(floristeria==null) { throw new Exception ("Floristeria inexistent"); }
      
      Ticket t = new Ticket();
      int tickedId = t.getTicketId();
      
      HashMap<Integer,Ticket> hm = baseDades.getmHTTicketsOberts().get(pFloristeria); // Obtenir hashtable de tickets per la floristeria
      if(hm==null) { throw new Exception ("Hash table de tickets oberts inexistent per la floristeria."); }               
      hm.put(tickedId, t); //Afegir el ticket a gestionar
      
      return tickedId;
    }
    
    /**
     * Afegir un producte a un ticket obert en una floristeria. Ticket obert = s'esta fent la compra
     * @param pFloristeria
     * @param idTicket
     * @param pItem
     * @param pNom
     * @return
     * @throws Exception 
     */
    public boolean afegirProducteTicket(String pFloristeria,int idTicket, String pItem, String pNom) throws Exception
    { Floristeria floristeria = baseDades.getmHTFloristeria().get(pFloristeria);
      if(floristeria==null) { throw new Exception ("Floristeria inexistent"); }
      
      HashMap<Integer,Ticket> hm = baseDades.getmHTTicketsOberts().get(pFloristeria); // Obtenir estructura de la floristeria
      if(hm==null) { throw new Exception ("Hash table de tickets oberts inexistent per la floristeria."); }         
      
      Ticket t = hm.get(idTicket); // obtenir el ticket
      if(t==null) { throw new Exception("No s'ha trobat el ticket."); }
      
      Class c = Class.forName("m11.model."+pItem); 
      Producte p = getProducte(pFloristeria,pNom,c); // obtenir el producte by nom
      if(p!=null)
      { return t.afegirProducte(p); // afegir el producte al ticket
      }
      return false;
    }
        

    /**
     * Pasar un ticket de la llista d'oberts a tancats (venuts)
     * @param pFloristeria
     * @param idTicket
     * @return
     * @throws Exception 
     */
    public boolean confirmarTicket(String pFloristeria, int idTicket) throws Exception 
    { Floristeria floristeria = baseDades.getmHTFloristeria().get(pFloristeria);
      if(floristeria==null) { throw new Exception ("Floristeria inexistent"); }
        
      HashMap<Integer,Ticket> hmOberts = baseDades.getmHTTicketsOberts().get(pFloristeria); // Obtenir estructura de la floristeria
      if(hmOberts==null) { throw new Exception ("Hash table de tickets oberts inexistent per la floristeria."); }   

      HashMap<Integer,Ticket> hmTancats = baseDades.getmHTTicketsTancats().get(pFloristeria); // Obtenir estructura de la floristeria Tickets ja venuts
      if(hmTancats==null) { throw new Exception ("Hash table de tickets tancats inexistent per la floristeria."); }   

      Ticket t = hmOberts.get(idTicket); // Obtenir el ticket de la llista(hashtable) d'oberts
      if(t==null) { throw new Exception("No s'ha trobat el ticket."); }
      
      if(t.finalitzar()); // finalitzar el ticket
      { if(t.getProductes().size()==0)
        { throw new Exception("No es pot finalitzar un ticket que no te productes assignats.");
        }        
      }
      hmTancats.put(idTicket, t); // Possar el ticket a la hm de finalitzats 
      hmOberts.remove(idTicket); // Treure el ticket d'oberts
 
      return true;
    }

    /**
     * Recorrer la hash table de tickets tancats i per cada ticket anar construint una posible visualitzacio 
     * @param pFloristeria
     * @return
     * @throws Exception 
     */
    public DTOStock mostrarVendes(String pFloristeria) throws Exception 
    { DTOStock objDTOVendes = new DTOStock();
      Floristeria floristeria = baseDades.getmHTFloristeria().get(pFloristeria);
      if(floristeria==null) { throw new Exception ("Floristeria inexistent"); }
        
      HashMap<Integer,Ticket> hmTancats = baseDades.getmHTTicketsTancats().get(pFloristeria); // Tockets tancats
      if(hmTancats==null) { throw new Exception ("Hash table de tickets tancats inexistent per la floristeria."); }  
        
      objDTOVendes.mHeaders = new String [] { "Ticket", "Descripcio" }; 
      objDTOVendes.mData    = new Object[][] { { " "," " } , { " "," " } } ;
      
      ArrayList<String[]> alRows = new ArrayList(); // Estructura de rows
      
      int   dNumTickets=0;
      float fTotal = 0;
      Collection<Ticket> colTickets = hmTancats.values();
      for(Ticket t : colTickets )
      { dNumTickets+=1;
        fTotal += t.totalPreu();
        String[] arrRow = { "Ticket " + t.getTicketId() , " Total preu = " + t.totalPreu() } ;
        alRows.add(arrRow);
        List<Producte> lProductes = t.getProductes();
        for(Producte p:lProductes)
        { String[] arrRow1 = { " " , " Producte = " + p.toString() } ;
          alRows.add(arrRow1);
        }
      }
      if(dNumTickets>0)
      { String[] arrRow3 = { "Total Tickets = " + dNumTickets, " Total preu = " + fTotal } ;
        alRows.add(arrRow3);
        
        Object[] pObj = alRows.toArray();
        
        String[][] arrData = new String[pObj.length][]; 
        System.arraycopy(pObj,0,arrData, 0, pObj.length);
                 
        objDTOVendes.mData = arrData;
      }
      return objDTOVendes;  
    }
  
}
