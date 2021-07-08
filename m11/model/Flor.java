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
public class Flor extends Producte
{ protected String color;

  public Flor(String nom,float pPreu,String pColor)
  { super(nom,pPreu);
    color = pColor;      
  }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
  @Override
  public String toString() 
  { return "Flor { " + "nom=" + nom + ", preu=" + preu + ", color="+ color +" }";
  }  
    
}
