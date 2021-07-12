package m11.repository;

import java.util.HashMap;
import java.util.List;

import m11.model.Arbre;
import m11.model.Decoracio;
import m11.model.Flor;
import m11.model.Floristeria;
import m11.model.Ticket;

public class BaseDades {
	protected HashMap<String,Floristeria> mHTFloristeria;      // Lista de Floristeries que controla el programa
	  protected HashMap<String,List<Arbre>> mHTFloristeriaArbre; // LLista o stock d'arbres de la floristeria 'key'
	  protected HashMap<String,List<Flor>>  mHTFloristeriaFlor;  // LLista o stock de flors de la floristeria 'key'
	  protected HashMap<String,List<Decoracio>> mHTFloristeriaDecoracio; // LLista o stock de decoracio de la floristeria 'key'
	  protected HashMap<String,HashMap<Integer,Ticket>>     mHTTicketsOberts;  // LLista de tickets que s'esta gestionant la venda actualment;
	  protected HashMap<String,HashMap<Integer,Ticket>>     mHTTicketsTancats; // LLista de tickets que ja s'ha gestionant la venda;  
	  
}
