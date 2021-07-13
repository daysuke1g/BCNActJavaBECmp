package m11.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import m11.controller.Controller;
import m11.model.DTOArbre;
import m11.model.DTODecoracio;
import m11.model.DTOFlor;
import m11.model.DTOStock;
import m11.model.Floristeria;

public class AppMainJFrame extends JFrame 
{
    JPanel                    contentPane;
    AppMainJFrameJPanelNorth  oAppMainJFrameJPanelNorth;  // panel header
    AppMainJFrameJPanelWest   oAppMainJFrameJPanelWest;   // panel menu esquerra
    AppMainJFrameJPanelCenter oAppMainJFrameJPanelCenter; //panel central display jtable
    
    Controller  oController=null;
    Floristeria mFloristeriaActual = null;
    String      mLabelCurrFloristeria="FLORISTERIA:";
    String      mCurrFloristeria=null;
      
    //LLista operacions al JTree
    String[] mMenuOperaciones = { "Selecció d'Operació", 
                                  "N1F1 - Crear Floristeria",  
                                  "N1F1 - Seleccionar Floristeria",  
                                  "N1F1 - Afegir Arbre", 
                                  "N1F1 - Afegir Flor",
                                  "N1F1 - Afegir Decoració",
                                  "N1F1 - Imprimir stock",

                                  "N2 - Retirar arbre",
                                  "N2 - Retirar flor",
                                  "N2 - Retirar decoració",                                
                                  "N2 - Imprimir stock amb qüantitats i valor",
              
                                  "N3 - Realitzar Venda",
                                  "N3 - Mostrar totes les vendes amb valor"
             
                                } ;          


    /**
     * Launch the application.
     */
    /*
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMainJFrame frame = new AppMainJFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    */    
    
    /**
     * Create the frame.
     */
    public AppMainJFrame() 
    {
    	setResizable(false); oController = new Controller(); // Referencia al controlador
        
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100,100,990,500);
      
      contentPane = new JPanel();
      contentPane.setLayout(new BorderLayout(0, 0));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
     
      oAppMainJFrameJPanelNorth  = new AppMainJFrameJPanelNorth();
      oAppMainJFrameJPanelWest   = new AppMainJFrameJPanelWest();  //this,
      
      oAppMainJFrameJPanelWest.setJFrameParent(this); 
      oAppMainJFrameJPanelWest.setMenu(mMenuOperaciones);
      oAppMainJFrameJPanelWest.postInit(); 
      
      oAppMainJFrameJPanelCenter = new AppMainJFrameJPanelCenter();
      //oAppMainJFrameJPanelSouth  = new AppMainJFrameJPanelSouth();
      getContentPane().add(oAppMainJFrameJPanelNorth,BorderLayout.NORTH);
      getContentPane().add(oAppMainJFrameJPanelWest,BorderLayout.WEST);
      getContentPane().add(oAppMainJFrameJPanelCenter,BorderLayout.CENTER);

     // Crear unas floristerias para juego de pruebas
    try
    { Floristeria oFloristeria;
      oFloristeria = oController.crearFloristeria("Floristeria1");
      oFloristeria = oController.crearFloristeria("Floristeria2");
      
      //Seleccionar floristeria
      mCurrFloristeria = "Floristeria2";
      mLabelCurrFloristeria="FLORISTERIA : "+mCurrFloristeria;
      oAppMainJFrameJPanelNorth.setLabelText(mLabelCurrFloristeria);      
      //Afegir items
      DTOArbre dtoArbre ;
      dtoArbre = oController.afegirArbre(mCurrFloristeria,new DTOArbre("a1",100,105));
      dtoArbre = oController.afegirArbre(mCurrFloristeria,new DTOArbre("a2",110,115));
      dtoArbre = oController.afegirArbre(mCurrFloristeria,new DTOArbre("a3",120,125));
      dtoArbre = oController.afegirArbre(mCurrFloristeria,new DTOArbre("a4",130,135));
      dtoArbre = oController.afegirArbre(mCurrFloristeria,new DTOArbre("a5",140,145));
      dtoArbre = oController.afegirArbre(mCurrFloristeria,new DTOArbre("a6",150,155));
      dtoArbre = oController.afegirArbre(mCurrFloristeria,new DTOArbre("a7",160,165));
      DTOFlor dtoFlor;
      dtoFlor = oController.afegirFlor(mCurrFloristeria,new DTOFlor("f1",10,"Vermella")); 
      dtoFlor = oController.afegirFlor(mCurrFloristeria,new DTOFlor("f2",11,"Blava")); 
      dtoFlor = oController.afegirFlor(mCurrFloristeria,new DTOFlor("f3",12,"Blanca")); 
      dtoFlor = oController.afegirFlor(mCurrFloristeria,new DTOFlor("f4",13,"Groga")); 
      dtoFlor = oController.afegirFlor(mCurrFloristeria,new DTOFlor("f5",14,"Verda")); 
      dtoFlor = oController.afegirFlor(mCurrFloristeria,new DTOFlor("f6",15,"Rosa")); 
      dtoFlor = oController.afegirFlor(mCurrFloristeria,new DTOFlor("f7",16,"Vermella")); 
      DTODecoracio dtoDecoracio;
      dtoDecoracio = oController.afegirDecoracio(mCurrFloristeria,new DTODecoracio("d1",200,"FUSTA"));   
      dtoDecoracio = oController.afegirDecoracio(mCurrFloristeria,new DTODecoracio("d2",210,"FUSTA"));   
      dtoDecoracio = oController.afegirDecoracio(mCurrFloristeria,new DTODecoracio("d3",220,"FUSTA"));   
      dtoDecoracio = oController.afegirDecoracio(mCurrFloristeria,new DTODecoracio("d4",230,"FUSTA"));   
      dtoDecoracio = oController.afegirDecoracio(mCurrFloristeria,new DTODecoracio("d5",240,"FUSTA"));   
      dtoDecoracio = oController.afegirDecoracio(mCurrFloristeria,new DTODecoracio("d6",150,"PLASTIC"));   
      dtoDecoracio = oController.afegirDecoracio(mCurrFloristeria,new DTODecoracio("d7",155,"PLASTIC"));   
      dtoDecoracio = oController.afegirDecoracio(mCurrFloristeria,new DTODecoracio("d8",160,"PLASTIC"));   
      dtoDecoracio = oController.afegirDecoracio(mCurrFloristeria,new DTODecoracio("d9",165,"PLASTIC"));   
      dtoDecoracio = oController.afegirDecoracio(mCurrFloristeria,new DTODecoracio("d10",170,"PLASTIC"));         
            
      //Seleccionar floristeria 
      mCurrFloristeria = "Floristeria1";
      mLabelCurrFloristeria="FLORISTERIA : "+mCurrFloristeria;
      oAppMainJFrameJPanelNorth.setLabelText(mLabelCurrFloristeria);      
      //Afegir items
      dtoArbre = oController.afegirArbre(mCurrFloristeria,new DTOArbre("a1",100,105));
      dtoArbre = oController.afegirArbre(mCurrFloristeria,new DTOArbre("a2",110,115));
      dtoArbre = oController.afegirArbre(mCurrFloristeria,new DTOArbre("a3",120,125));
      dtoArbre = oController.afegirArbre(mCurrFloristeria,new DTOArbre("a4",130,135));
      dtoArbre = oController.afegirArbre(mCurrFloristeria,new DTOArbre("a5",140,145));
      dtoArbre = oController.afegirArbre(mCurrFloristeria,new DTOArbre("a6",150,155));
      dtoArbre = oController.afegirArbre(mCurrFloristeria,new DTOArbre("a7",160,165));
      dtoFlor = oController.afegirFlor(mCurrFloristeria,new DTOFlor("f1",10,"Vermella")); 
      dtoFlor = oController.afegirFlor(mCurrFloristeria,new DTOFlor("f2",11,"Blava")); 
      dtoFlor = oController.afegirFlor(mCurrFloristeria,new DTOFlor("f3",12,"Blanca")); 
      dtoFlor = oController.afegirFlor(mCurrFloristeria,new DTOFlor("f4",13,"Groga")); 
      dtoFlor = oController.afegirFlor(mCurrFloristeria,new DTOFlor("f5",14,"Verda")); 
      dtoFlor = oController.afegirFlor(mCurrFloristeria,new DTOFlor("f6",15,"Rosa")); 
      dtoFlor = oController.afegirFlor(mCurrFloristeria,new DTOFlor("f7",16,"Vermella")); 
      dtoDecoracio = oController.afegirDecoracio(mCurrFloristeria,new DTODecoracio("d1",200,"FUSTA"));   
      dtoDecoracio = oController.afegirDecoracio(mCurrFloristeria,new DTODecoracio("d2",210,"FUSTA"));   
      dtoDecoracio = oController.afegirDecoracio(mCurrFloristeria,new DTODecoracio("d3",220,"FUSTA"));   
      dtoDecoracio = oController.afegirDecoracio(mCurrFloristeria,new DTODecoracio("d4",230,"FUSTA"));   
      dtoDecoracio = oController.afegirDecoracio(mCurrFloristeria,new DTODecoracio("d5",240,"FUSTA"));   
      dtoDecoracio = oController.afegirDecoracio(mCurrFloristeria,new DTODecoracio("d6",150,"PLASTIC"));   
      dtoDecoracio = oController.afegirDecoracio(mCurrFloristeria,new DTODecoracio("d7",155,"PLASTIC"));   
      dtoDecoracio = oController.afegirDecoracio(mCurrFloristeria,new DTODecoracio("d8",160,"PLASTIC"));   
      dtoDecoracio = oController.afegirDecoracio(mCurrFloristeria,new DTODecoracio("d9",165,"PLASTIC"));   
      dtoDecoracio = oController.afegirDecoracio(mCurrFloristeria,new DTODecoracio("d10",170,"PLASTIC"));   
      
    }
    catch(Exception ex)
    { ;
    }    

 
    }

    
    /**
      * Procesar dobles click sobre el JTREE item
      * 
      * Cada opció del menu gestiona els inputs d'entrada amb validació, crida l'operacio
      * corresponent del model sobre oController.* i si cal displaya dades en forma de
      * finestra emergent o al jtable central
      * 
      */
   protected void procesaOperacion(String pOperacion)
   {
     switch(pOperacion)
     { case "[Selecció d'Operació, N1F1 - Crear Floristeria]": // Operacio CREAR FLORISTERIA
       { crearFloristeria();  
         break;
       }	 
       case "[Selecció d'Operació, N1F1 - Seleccionar Floristeria]": // Operacio SELECCIONAR FLORISTERIA DE TREBALL
       { seleccionarFloristeriaActual();
         break;
       }       
       case "[Selecció d'Operació, N1F1 - Afegir Arbre]": // Operacio AFEGIR ARBRE a la floristeria actual
       { afegirArbre();
    	 break;
       }
       case "[Selecció d'Operació, N1F1 - Afegir Flor]":  // Operacio AFEGIR FLOR a la floristeria actual
       { afegirFlor();    
         break;
       }
       case "[Selecció d'Operació, N1F1 - Afegir Decoració]":  // Operacio AFEGIR DECORACIO a la floristeria actual
       { afegirDecoracio();
         break;
       }
       case "[Selecció d'Operació, N1F1 - Imprimir stock]": // Operacio IMPRESSIO STOCK
       { imprimirStock();    	
         break;
       }
       case "[Selecció d'Operació, N2 - Retirar arbre]": // Operacio N2 Retirar arbre de la floristeria actual
       { retirarArbre();
         break;
       }       
       case "[Selecció d'Operació, N2 - Retirar flor]": // Operacio N2 Retirar flor de la floristeria actual
       { retirarFlor();
         break;
       }
       case "[Selecció d'Operació, N2 - Retirar decoració]": // Operacio N2 decoracio de la floristeria actual
       { retirarDecoracio();
         break;              
       }              
       case "[Selecció d'Operació, N2 - Imprimir stock amb qüantitats i valor]": // Operacio IMPRESSIO AMB QUANTITATS I VALOR
       { imprimirStockAmbQuantitatIValor();   
         break;
       }
       case "[Selecció d'Operació, N3 - Realitzar Venda]": // Operacio realitzar venda
       { realitzarVenda();
         break;
       }
       case "[Selecció d'Operació, N3 - Mostrar totes les vendes amb valor]": // Operacio imrpimir vendes
       { imprimirVendes();
         break;
       }       
       default:
       { JOptionPane.showMessageDialog(this,pOperacion,pOperacion,JOptionPane.INFORMATION_MESSAGE);
       }  
     } // end switch                  
   } // end protected void procesaOperacion(String pOperacion)          
      

   /** 
    * Clase d'utilitat per verificar l'input d'un valor float
    * @author Administrador
    *
    */
   private class InputVerifierFloat extends InputVerifier
   { JFrame mJFrame = null;
     public InputVerifierFloat(JFrame pJFrame)
     { mJFrame = pJFrame;
     }
     
     @Override
     public boolean verify(JComponent mySelf) 
     { JTextField jtf = (JTextField) mySelf;
       String strInput = jtf.getText();
       if(strInput==null) { return true; }
       strInput = strInput.trim();
       if(strInput.equalsIgnoreCase("")) { return true; } 
       try 
       { float floatValue = Float.parseFloat(strInput);
         return true;
       }
       catch(NumberFormatException ex) 
       { JOptionPane.showMessageDialog(mJFrame,"Informi un número decimal",
             "Validació d'input", JOptionPane.ERROR_MESSAGE); 
       } 
       return false;
     }
   } 
      
   /**
    * Operacio per crear una floristeria: 
    * Input del nom, comprovacio i donar de alta a traves del controlador
    * Si la dona de alta correctament, l'estableix com la floristeria de treball actual
    */
  private void crearFloristeria()
  { 
	String szNomFloristeria = (String)JOptionPane.showInputDialog(this,"Introduexi nom per la Floristeria:",
   		    "Crear Floristeria",JOptionPane.PLAIN_MESSAGE,null,//icon
               null,null);
    if(szNomFloristeria!=null)
    { szNomFloristeria = szNomFloristeria.trim();
      if(szNomFloristeria.equals(""))
      { JOptionPane.showMessageDialog(this,"Cal informar un nom","Informació",
   		   JOptionPane.INFORMATION_MESSAGE); 
        return;
      }        
      try
      { Floristeria oFloristeria = oController.crearFloristeria(szNomFloristeria);
        mFloristeriaActual = oFloristeria;
        mCurrFloristeria=mFloristeriaActual.getNom();
        mLabelCurrFloristeria="FLORISTERIA : "+mCurrFloristeria;
        oAppMainJFrameJPanelNorth.setLabelText(mLabelCurrFloristeria);
      }
      catch(Exception ex)
      { JOptionPane.showMessageDialog(this,ex.getMessage(),
                       "Error creant la floristeria", JOptionPane.ERROR_MESSAGE);
      }
    }
  }// end crearFloristeria();
   
  
  /*
   * Selecciona la floristeria de treball actual
   */
  private void seleccionarFloristeriaActual()
  { String[] llistaFloristeries = oController.getLListaFloristeries(); // obtenir llista floristeries
    if(llistaFloristeries!=null)
    { if(llistaFloristeries.length>0)
      { String szNomFloristeria = (String)JOptionPane.showInputDialog(this,"Seleccioni la Floristeria:",
    		  "Seleccionar Floristeria", JOptionPane.PLAIN_MESSAGE,null,//icon
              llistaFloristeries,llistaFloristeries[0]);
        if(szNomFloristeria!=null)
        { mCurrFloristeria = szNomFloristeria.trim();
          mLabelCurrFloristeria="FLORISTERIA : "+mCurrFloristeria;
          oAppMainJFrameJPanelNorth.setLabelText(mLabelCurrFloristeria);
        }
      }
    }
  } // end  private void seleccionarFloristeriaActual()
   
  /**
   * Operació per afegir un arbre a la floristeria actual: input de dades, validació. 
   * Si tot correcte la transfereix amb un DTO al controlador que la dona d'alta
   */
  private void afegirArbre()
  {
    JFrame currJFrame = this;
    if(mCurrFloristeria==null)
    { JOptionPane.showMessageDialog(currJFrame,"Cal selecciona una floristeria",
                           "Informacio", JOptionPane.INFORMATION_MESSAGE); 
      return;
    }
    JTextField jtfNom    = new JTextField();
    JTextField jtfPreu   = new JTextField();
    jtfPreu.setInputVerifier(new InputVerifierFloat(this));
    JTextField jtfAlcada = new JTextField();
    jtfAlcada.setInputVerifier(new InputVerifier()
             { @Override
               public boolean verify(JComponent mySelf) 
               { JTextField jtf = (JTextField) mySelf;
                 String strInput = jtf.getText();
                 if(strInput==null) { return true; }
                 strInput = strInput.trim();
                 if(strInput.equalsIgnoreCase("")) { return true; } 
                 try 
                 { int intValue = Integer.parseInt(strInput);
                   return true;
                 }
                 catch(NumberFormatException ex) 
                 { JOptionPane.showMessageDialog(currJFrame,"Informi un número enter",
                           "Validació d'input", JOptionPane.ERROR_MESSAGE); 
                 } 
                 return false;
               }
             });
     Object[] message = { "Nom:", jtfNom, "Preu:", jtfPreu,  "Alcada:", jtfAlcada };
     if ( JOptionPane.showConfirmDialog(this, message, "Afegir arbre", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION ) 
     { try
       { float fPreu = 0;
         String szPreu = jtfPreu.getText();
         szPreu = ( szPreu == null ) ? "0" : szPreu.trim();
         if(szPreu.equals("")) szPreu = "0";
         fPreu = Float.parseFloat(szPreu);
       
         int intAlcada = 0;    
         String szAlcada = jtfAlcada.getText();
         szAlcada = ( szAlcada == null ) ? "0" : szAlcada.trim();
         if(szAlcada.equals("")) szAlcada = "0";
         intAlcada = Integer.parseInt(szAlcada);       
         
         String szNom = jtfNom.getText();
         if(szNom==null) szNom = "";
         if(szNom.equals(""))
         { JOptionPane.showMessageDialog(this,"Cal informar un nom","Informació", JOptionPane.INFORMATION_MESSAGE); 
           return;
         }   
         if(fPreu<=0)
         { JOptionPane.showMessageDialog(this,"Cal informar un preu","Informació", JOptionPane.INFORMATION_MESSAGE); 
           return;
         }
         if(intAlcada<=0)
         { JOptionPane.showMessageDialog(this,"Cal informar uns alçada","Informació", JOptionPane.INFORMATION_MESSAGE); 
           return;
         }                                    
         DTOArbre objDTO = new DTOArbre(szNom,fPreu,intAlcada);
         objDTO = oController.afegirArbre(mCurrFloristeria,objDTO);
         
       }
       catch(Exception ex)
       { JOptionPane.showMessageDialog(this,ex.getMessage(),"Error afegint l'arbre", JOptionPane.ERROR_MESSAGE);
       }
     }   	  
  } // private void afegirArbre()
  
  
  /**
   * Operació per afegir una flor a la floristeria actual: input de dades, validació. 
   * Si tot correcte la transfereix amb un DTO al controlador que la dona d'alta
   */
  private void afegirFlor()
  { if(mCurrFloristeria==null)
    { JOptionPane.showMessageDialog(this,"Cal selecciona una floristeria",
                          "Informacio", JOptionPane.INFORMATION_MESSAGE); 
      return;
    }
    JTextField jtfNom    = new JTextField();
    JTextField jtfPreu   = new JTextField();
    jtfPreu.setInputVerifier(new InputVerifierFloat(this));          
    JTextField jtfColor  = new JTextField();
    
    Object[] message = { "Nom:", jtfNom, "Preu:", jtfPreu,  "Color:", jtfColor };
    if ( JOptionPane.showConfirmDialog(this, message, "Afegir flor", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION ) 
    { try
      { float fPreu = 0;
        String szPreu = jtfPreu.getText();
        szPreu = ( szPreu == null ) ? "0" : szPreu.trim();
        if(szPreu.equals("")) szPreu = "0";
        fPreu = Float.parseFloat(szPreu);   
      
        String szNom = jtfNom.getText();
        if(szNom==null) szNom = "";
        if(szNom.equals(""))
        { JOptionPane.showMessageDialog(this,"Cal informar un nom", "Informacio", JOptionPane.INFORMATION_MESSAGE); 
          return;
        }   
        if(fPreu<=0)
        { JOptionPane.showMessageDialog(this,"Cal informar un preu","Informacio", JOptionPane.INFORMATION_MESSAGE); 
          return;
        }                  
        DTOFlor objDTO = new DTOFlor(szNom,fPreu,jtfColor.getText());
        objDTO = oController.afegirFlor(mCurrFloristeria,objDTO);            
      }
      catch(Exception ex)
      { JOptionPane.showMessageDialog(this,ex.getMessage(),"Error afegint la flor", JOptionPane.ERROR_MESSAGE);
      }
    } 
  } // private void afegirFlor()
  
  /**
   * Operació per afegir una decoracio a la floristeria actual: input de dades, validació. 
   * Si tot correcte la transfereix amb un DTO al controlador que el dona d'alta
   */
  private void afegirDecoracio()
  { if(mCurrFloristeria==null)
    { JOptionPane.showMessageDialog(this,"Cal selecciona una floristeria",
                          "Informacio", JOptionPane.INFORMATION_MESSAGE); 
      return;
    }
    JTextField jtfNom    = new JTextField();
    JTextField jtfPreu   = new JTextField();
    jtfPreu.setInputVerifier(new InputVerifierFloat(this));          
    JComboBox<String> jcbTipusMaterial  = new JComboBox<String>();
    String[] lItems = oController.getLListaTipusMaterialDecoracio();
    if(lItems!=null)
    { for(String s:lItems)
      { jcbTipusMaterial.addItem(s);
      }
    }
    Object[] message = { "Nom:", jtfNom, "Preu:", jtfPreu,  "Tipus material:", jcbTipusMaterial };
    if ( JOptionPane.showConfirmDialog(this, message, "Afegir decoració", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION ) 
    { try
      { float fPreu = 0;
        String szPreu = jtfPreu.getText();
        szPreu = ( szPreu == null ) ? "0" : szPreu.trim();
        if(szPreu.equals("")) szPreu = "0";
        fPreu = Float.parseFloat(szPreu);     
      
        String szNom = jtfNom.getText();
        if(szNom==null) szNom = "";
        if(szNom.equals(""))
        { JOptionPane.showMessageDialog(this,"Cal informar un nom",
                              "Informacio", JOptionPane.INFORMATION_MESSAGE); 
          return;
        }   
        if(fPreu<=0)
        { JOptionPane.showMessageDialog(this,"Cal informar un preu",
                              "Informacio", JOptionPane.INFORMATION_MESSAGE); 
          return;
        }            
                  
        DTODecoracio objDTO = new DTODecoracio(szNom,fPreu,(String)jcbTipusMaterial.getSelectedItem());
        objDTO = oController.afegirDecoracio(mCurrFloristeria,objDTO);            
      }
      catch(Exception ex)
      { JOptionPane.showMessageDialog(this,ex.getMessage(),
                     "Error afegint decoració", JOptionPane.ERROR_MESSAGE);
      }
    } 
  } // private void afegirDecoracio()

  /**
   * Imprsessio de l'stock. L'obte via controlador i el llista sobre la jtable de la vista 
   */
  private void imprimirStock()
  { if(mCurrFloristeria==null)
    { JOptionPane.showMessageDialog(this,"Cal selecciona una floristeria",
                       "Informacio", JOptionPane.INFORMATION_MESSAGE); 
      return;
    }
    DTOStock objDTO = oController.getStock(mCurrFloristeria);
    oAppMainJFrameJPanelCenter.initJTable(objDTO.mHeaders,objDTO.mData);	  
  } // end private void imprimirStock()
  

  /**
   * Ofereix input de dades per retirar el primer arbre amb el nom introduit.
   */
  private void retirarArbre()
  { if(mCurrFloristeria==null)
    { JOptionPane.showMessageDialog(this,"Cal selecciona una floristeria",
                          "Informacio", JOptionPane.INFORMATION_MESSAGE); 
      return;
    }
    JTextField jtfNom    = new JTextField();
    Object[] message = { "Nom:", jtfNom  };
    if ( JOptionPane.showConfirmDialog(this, message, "Retirar arbre", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION ) 
    { try
      { boolean bRet = oController.retirarArbre(mCurrFloristeria,jtfNom.getText().trim());   
        if(bRet==true)
        { JOptionPane.showMessageDialog(this,"S'ha retirat correctament un arbre amb el nom "+jtfNom.getText(),
                          "Informacio", JOptionPane.INFORMATION_MESSAGE);                 
        }
        else
        { JOptionPane.showMessageDialog(this,"No s'ha pogut retirar un arbre amb el nom "+jtfNom.getText(),
                          "Informacio", JOptionPane.ERROR_MESSAGE); 
        }
      }
      catch(Exception ex)
      { JOptionPane.showMessageDialog(this,ex.getMessage(),
                     "Error retirant l'arbre", JOptionPane.ERROR_MESSAGE);
      }
    }             
  } // end retirarArbre()
  
  /**
   * Ofereix input de dades per retirar la primera flor amb el nom introduit de la floristeria actual.
   */
  private void retirarFlor()
  { if(mCurrFloristeria==null)
    { JOptionPane.showMessageDialog(this,"Cal selecciona una floristeria",
                           "Informacio", JOptionPane.INFORMATION_MESSAGE); 
      return;
    }
    JTextField jtfNom    = new JTextField();
    Object[] message = { "Nom:", jtfNom  };
    if ( JOptionPane.showConfirmDialog(this, message, "Retirar flor", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION ) 
    { try
      { boolean bRet = oController.retirarFlor(mCurrFloristeria,jtfNom.getText().trim());   
        if(bRet==true)
        { JOptionPane.showMessageDialog(this,"S'ha retirat correctament una flor amb el nom "+jtfNom.getText(),
                          "Informacio", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        { JOptionPane.showMessageDialog(this,"No s'ha pogut retirar una flor amb el nom "+jtfNom.getText(),
                          "Informacio", JOptionPane.ERROR_MESSAGE); 
        }
      }
      catch(Exception ex)
      { JOptionPane.showMessageDialog(this,ex.getMessage(),
                     "Error retirant la flor", JOptionPane.ERROR_MESSAGE);
      }
    } 	 
  }
  
  /**
   * Ofereix input de dades per retirar la primera decoracio amb el nom introduit de la floristeria actual.
   */
  private void retirarDecoracio()
  { if(mCurrFloristeria==null)
    { JOptionPane.showMessageDialog(this,"Cal selecciona una floristeria",
                           "Informacio", JOptionPane.INFORMATION_MESSAGE); 
      return;
    }
    JTextField jtfNom    = new JTextField();
    Object[] message = { "Nom:", jtfNom  };
    if ( JOptionPane.showConfirmDialog(this, message, "Retirar decoració", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION ) 
    { try
      { boolean bRet = oController.retiraDecoracio(mCurrFloristeria,jtfNom.getText().trim());   
        if(bRet==true)
        { JOptionPane.showMessageDialog(this,"S'ha retirat correctament una decoració amb el nom "+jtfNom.getText(),
                           "Informacio", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        { JOptionPane.showMessageDialog(this,"No s'ha pogut retirar una decoració amb el nom "+jtfNom.getText(),
                          "Informacio", JOptionPane.ERROR_MESSAGE); 
        }
      }
      catch(Exception ex)
      { JOptionPane.showMessageDialog(this,ex.getMessage(),"Error retirant la decoració ", JOptionPane.ERROR_MESSAGE);
      }
    }       	  
  } // end retirarDecoracio()
  
  
  /**
   * Obtenir l'stock amb quantitat i valor a través del controlador. Imprimir a la jtable
   */
  private void imprimirStockAmbQuantitatIValor()
  { if(mCurrFloristeria==null)
    { JOptionPane.showMessageDialog(this,"Cal selecciona una floristeria",
                            "Informacio", JOptionPane.INFORMATION_MESSAGE); 
      return;
    }
    DTOStock objDTO = oController.getStockValor(mCurrFloristeria);
    oAppMainJFrameJPanelCenter.initJTable(objDTO.mHeaders,objDTO.mData);    
  }  
  
  /**
   * Realitza una venda generant un numero de ticket, 
   */
  private void realitzarVenda()
  {
	if(mCurrFloristeria==null)
    { JOptionPane.showMessageDialog(this,"Cal selecciona una floristeria",
                          "Informacio", JOptionPane.INFORMATION_MESSAGE); 
      return;
    }
    
	//Obtenir nou ticket a través del controlador ...  
    final JFrame currJFrame = this;
    int dGetIdTicket = 0;
    try { dGetIdTicket = oController.getNewTicket(mCurrFloristeria);  }
    catch(Exception ex)
    { JOptionPane.showMessageDialog(currJFrame, ex.getMessage(),"Excepció",JOptionPane.ERROR_MESSAGE); 
      return ;
    }
    int idTicket = dGetIdTicket ; // aquest cambalache pq ha de ser final o efectivament final
      
    JComboBox<String> jcbProducte  = new JComboBox<String>();
    String[] lItems = { "Arbre", "Flor", "Decoracio" };
    if(lItems!=null)
    { for(String s:lItems)
      { jcbProducte.addItem(s);
      }
    }
    JTextField jtfNom   = new JTextField();
    JButton jbAfegir = new JButton("Afegir");
    
    // Validacio de l'input de dades al clickar al boto afegir
    jbAfegir.addActionListener(
            new ActionListener() 
            { @Override
              public void actionPerformed(ActionEvent e) 
              { int dIdxSel = jcbProducte.getSelectedIndex();
                if(dIdxSel>=0)
                { 
                  String szItem = (String)jcbProducte.getItemAt(dIdxSel);
                  String szNom  = jtfNom.getText();
                  String szMsg  = "Afegir el item " + szItem + " amb id " + szNom + 
                                  " al ticket de venda?";
                  if(szItem==null)
                  { JOptionPane.showMessageDialog(currJFrame, "Cal seleccionar un item");
                    return;  
                  }
                  if( (szNom==null) || ( szNom.trim().equals("") ) )
                  { JOptionPane.showMessageDialog(currJFrame, "Cal informar un nom de producte");
                    return; 
                  }
                  if ( JOptionPane.showConfirmDialog(currJFrame, szMsg, "Afegir producte al ticket", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION ) 
                  { try
                    { if(oController.afegirProducteTicket(mCurrFloristeria,idTicket,szItem,szNom)==true) 
                    { JOptionPane.showMessageDialog(currJFrame, "Afegit!!"); }
                         else { JOptionPane.showMessageDialog(currJFrame, "No s'ha pogut afegir el producte al ticket."); }
                    }
                    catch(Exception ex)
                    { JOptionPane.showMessageDialog(currJFrame, ex.getMessage(),"Excepció",JOptionPane.ERROR_MESSAGE); 
                    }
                  }
                  
                }   
              } // public void actionPerformed(ActionEvent e) 
            }
        );    
    
    // Confirmacio i alta a traves del controller 
    Object[] message = { "Producte:", jcbProducte, "Nom Producte:", jtfNom, "Afegir:", jbAfegir ,"Ticket actual :" +idTicket ,"OK-Confirma la compra"};
    if ( JOptionPane.showConfirmDialog(this, message, "Afegir producte a ticket de venda", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION ) 
    { try
      { if(oController.confirmarTicket(mCurrFloristeria,idTicket)==true)
        { JOptionPane.showMessageDialog(currJFrame,"Ticket confirmat","Resultat d'operació",JOptionPane.INFORMATION_MESSAGE);
        } 
        else
        { JOptionPane.showMessageDialog(currJFrame,"No s'ha pogut confirmar el ticket","Resultat d'operació",JOptionPane.ERROR_MESSAGE);
        }
      }
      catch(Exception ex)
      { JOptionPane.showMessageDialog(currJFrame, ex.getMessage(),"Excepció",JOptionPane.ERROR_MESSAGE); 
      }
    }
  
  } // end  private void realitzarVenda()
  
  /**
   * Obtenir totes les vendes a traves d'un DTO del controlador, imprimir a la jtable
   */
  private void imprimirVendes()
  { if(mCurrFloristeria==null)
    { JOptionPane.showMessageDialog(this,"Cal selecciona una floristeria",
                        "Informacio", JOptionPane.INFORMATION_MESSAGE); 
       return;
    }
    try 
    { DTOStock objDTO = oController.mostrarVendes(mCurrFloristeria);
      oAppMainJFrameJPanelCenter.initJTable(objDTO.mHeaders,objDTO.mData); 
    }
    catch (Exception ex) 
    { JOptionPane.showMessageDialog(this, ex.getMessage(),"Excepció",JOptionPane.ERROR_MESSAGE);
    }             
  }
  
  
}
