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
public class Decoracio extends Producte
{ public static final String[] mLListaTipusMaterial = { "FUSTA","PLASTIC"} ;
    
  public static enum TIPUS_MATERIAL { FUSTA, PLASTIC } ;

  protected TIPUS_MATERIAL tipus_material;
    
  public Decoracio(String pNom,float pPreu,TIPUS_MATERIAL pTipusMaterial)
  { super(pNom,pPreu);
    tipus_material = pTipusMaterial;
  }

  public TIPUS_MATERIAL getTipus_material() 
  { return tipus_material;
  }

  public void setTipus_material(TIPUS_MATERIAL tipus_material) 
  { this.tipus_material = tipus_material;
  }

  @Override
  public String toString() 
  { return "Decoracio { " + "nom=" + nom + ", preu=" + preu + ", tipus_material="+ tipusMaterial(tipus_material) +" }";
  }
        
  public static String tipusMaterial(TIPUS_MATERIAL pTipusMaterial)
  { switch (pTipusMaterial)
    { case FUSTA:   { return "FUSTA"; }
      case PLASTIC: { return "PLASTIC"; }
    }
    return ""; 
  }
  
  public static TIPUS_MATERIAL tipusMaterial(String pTipusMaterial) throws Exception
  { switch (pTipusMaterial)
    { case "FUSTA":   { return TIPUS_MATERIAL.FUSTA; }
      case "PLASTIC": { return TIPUS_MATERIAL.PLASTIC; }
    }
    throw new Exception("Tipus de material incorrecte"); 
  }  
  
}
