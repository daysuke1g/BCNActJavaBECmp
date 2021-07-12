package m11.repository;

import java.util.HashMap;
import java.util.List;

import m11.model.Arbre;
import m11.model.Decoracio;
import m11.model.Flor;
import m11.model.Floristeria;
import m11.model.Ticket;

public class BaseDades {
	private HashMap<String,Floristeria> mHTFloristeria;      // Lista de Floristeries que controla el programa
	private HashMap<String,List<Arbre>> mHTFloristeriaArbre; // LLista o stock d'arbres de la floristeria 'key'
	private HashMap<String,List<Flor>>  mHTFloristeriaFlor;  // LLista o stock de flors de la floristeria 'key'
	private HashMap<String,List<Decoracio>> mHTFloristeriaDecoracio; // LLista o stock de decoracio de la floristeria 'key'
	private HashMap<String,HashMap<Integer,Ticket>>     mHTTicketsOberts;  // LLista de tickets que s'esta gestionant la venda actualment;
	private HashMap<String,HashMap<Integer,Ticket>>     mHTTicketsTancats; // LLista de tickets que ja s'ha gestionant la venda;  
	
	public BaseDades() {
		mHTFloristeria = new HashMap<String, Floristeria>();
		mHTFloristeriaArbre = new HashMap<String,List<Arbre>>();
		mHTFloristeriaFlor = new HashMap<String,List<Flor>>();
		mHTFloristeriaDecoracio = new HashMap<String,List<Decoracio>>();
		mHTTicketsOberts = new HashMap<String,HashMap<Integer,Ticket>>();
		mHTTicketsTancats = new HashMap<String,HashMap<Integer,Ticket>>();
	}

	public HashMap<String, Floristeria> getmHTFloristeria() {
		return mHTFloristeria;
	}

	public HashMap<String, List<Arbre>> getmHTFloristeriaArbre() {
		return mHTFloristeriaArbre;
	}

	public HashMap<String, List<Flor>> getmHTFloristeriaFlor() {
		return mHTFloristeriaFlor;
	}

	public HashMap<String, List<Decoracio>> getmHTFloristeriaDecoracio() {
		return mHTFloristeriaDecoracio;
	}

	public HashMap<String, HashMap<Integer, Ticket>> getmHTTicketsOberts() {
		return mHTTicketsOberts;
	}

	public HashMap<String, HashMap<Integer, Ticket>> getmHTTicketsTancats() {
		return mHTTicketsTancats;
	}
}
