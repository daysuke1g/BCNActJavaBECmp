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
public class DTOFlor extends DTOProducte
{
  public String color;
        
  public DTOFlor(String pNom,float pPreu,String pColor)
  { super(pNom,pPreu);
    color = pColor;
  }
  
    
}
