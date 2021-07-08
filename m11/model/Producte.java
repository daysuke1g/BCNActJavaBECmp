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
public class Producte 
{ protected String nom;
  protected float preu;
 
  public Producte(String pNom,float pPreu)
  { nom = pNom.trim();
    preu = pPreu;
  }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }
    
  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

 @Override
 public String toString() 
 { return "Producte { " + "nom=" + nom + ", preu=" + preu + " }";
 }
    
  
  
}
