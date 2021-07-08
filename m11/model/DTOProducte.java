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
public class DTOProducte 
{ public String nom;
  public float preu;    

@SuppressWarnings("empty-statement")
  public DTOProducte() { ; }
          
  public DTOProducte(String nom, float preu) 
  { this.nom = nom;
    this.preu = preu;
  }
  
}
