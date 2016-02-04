package it.fabiobiscaro.prodotti;

public class ListaSpesa {
	protected Prodotto lista[];
	private int numProdotti;
	private boolean tesseraFedelt�;
	private final int MAX_PRODOTTI = 100;
	
	public ListaSpesa(boolean p){
		lista= new Prodotto[10];
		numProdotti=0;
		this.tesseraFedelt� = p;
	}
	public void aggiungiProdotto(Prodotto p) throws Exception{
		if(numProdotti < MAX_PRODOTTI){
			if(tesseraFedelt�){
				p.applicaSconto();
			}
			lista[numProdotti++]=p;
		} else{
			throw new Exception("la lista � piena");
		}
		
	} 
	
	public float calcolaSpesa(){
		float totale = 0;
		for(int i=0; i<numProdotti;i++){
			totale = totale +lista[i].getPrezzo();
		}
		return totale;
	}
	
	public void eliminaProdotto(){
		
	}
}
