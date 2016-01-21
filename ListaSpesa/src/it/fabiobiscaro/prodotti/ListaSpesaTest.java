package it.fabiobiscaro.prodotti;

public class ListaSpesaTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		ListaSpesa a = new ListaSpesa(true);
		
		Alimentare pollo = new Alimentare("qwe" , "pollo" , 100.0f , new Data(26,1,2016));
		a.aggiungiProdotto(pollo);
		
		Alimentare arancia = new Alimentare("rty" , "arancia" , 100.0f , new Data(2,2,2016));
		a.aggiungiProdotto(arancia);
		
		Alimentare lituania = new Alimentare("uio" , "lituania" , 100.0f , new Data(15,1,2016));
		a.aggiungiProdotto(lituania);
		
		NonAlimentare calzino = new NonAlimentare("pas" , "abbastanza bello", 100.0f, "lana");
		a.aggiungiProdotto(calzino);
		
		//calcola spesa
		float tot = a.calcolaSpesa();
		System.out.print("Il prezzo totale è ");
		System.out.println(tot);
	}

}
