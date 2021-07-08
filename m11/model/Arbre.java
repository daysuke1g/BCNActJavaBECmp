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
public class Arbre extends Producte
{ protected int alcada_cm;
        
  public Arbre(String pNom,float pPreu,int pAlcadaCm)
  { super(pNom,pPreu);
    alcada_cm = pAlcadaCm;
  }

    public int getAlcada_cm() {
        return alcada_cm;
    }

    public void setAlcada_cm(int alcada_cm) {
        this.alcada_cm = alcada_cm;
    }

 
  @Override
  public String toString() 
  { return "Arbre { " + "nom=" + nom + ", preu=" + preu + ", alcada_cm="+alcada_cm+" }";
  }
  
}
