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
public class DTOArbre extends DTOProducte
{
  public int alcada_cm;
        
  public DTOArbre(String pNom,float pPreu,int pAlcadaCm)
  { super(pNom,pPreu);
    alcada_cm = pAlcadaCm;
  }
  
    
}
