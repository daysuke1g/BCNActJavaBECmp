/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m11.model;

/**
 *
 * @author JoseLuis.Canivano
 */
public class DTODecoracio extends DTOProducte
{
  private String tipus_decoracio;
        
  public String getTipus_decoracio() {
	return tipus_decoracio;
}

public DTODecoracio(String pNom,float pPreu,String pTipusDecoracio)
  { super(pNom,pPreu);
    tipus_decoracio = pTipusDecoracio;
  }  
    
}
