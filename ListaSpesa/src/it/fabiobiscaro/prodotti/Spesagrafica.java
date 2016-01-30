package it.fabiobiscaro.prodotti;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.PrintWriter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;

public class Spesagrafica {

	protected Shell shlJackzando;
	private Text codiceProdotto;
	private Text nome;
	private Text prezzo;
	private Text totale;
	private boolean p;
	private boolean alimentare;
	private Button btnTesseraFedelt;
	//vaariabile del file
	


	
	
	//array di prodotti
	private Prodotto[] carrello = new Prodotto[100];
	int num = 0;
	// codice
	private String c;
	// descrizione
	private String d;
	// prexxo
	private float r;
	ListaSpesa lista;
	Prodotto s;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Spesagrafica window = new Spesagrafica();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlJackzando.open();
		shlJackzando.layout();
		while (!shlJackzando.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlJackzando = new Shell();
		shlJackzando.setSize(486, 398);
		shlJackzando.setText("Supermercati JAck&ZAndo");
		
		Button aggiungiScontrino = new Button(shlJackzando, SWT.NONE);
		aggiungiScontrino.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				p=btnTesseraFedelt.getSelection();
				System.out.println(p);
				
			}
		});
		
		btnTesseraFedelt = new Button(shlJackzando, SWT.CHECK);
		btnTesseraFedelt.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				p=btnTesseraFedelt.getSelection();
				lista = new ListaSpesa(p);
			}
		});
		btnTesseraFedelt.setBounds(130, 14, 101, 16);
		btnTesseraFedelt.setText("Tessera Fedelt\u00E0");
		
		Group grpTipo = new Group(shlJackzando, SWT.NONE);
		grpTipo.setText("Tipo");
		grpTipo.setBounds(185, 66, 114, 82);
		
		Button btnAlimentare = new Button(grpTipo, SWT.RADIO);
		btnAlimentare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				alimentare=true;
			}
		});
		btnAlimentare.setBounds(0, 25, 90, 16);
		btnAlimentare.setText("Alimentare");
		
		
		Button btnNonAlimentare = new Button(grpTipo, SWT.RADIO);
		btnNonAlimentare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				alimentare=false;
			}
		});
		btnNonAlimentare.setBounds(0, 47, 104, 16);
		btnNonAlimentare.setText("Non Alimentare");

		List list = new List(shlJackzando, SWT.BORDER);
		list.setBounds(10, 154, 449, 196);
		
		totale = new Text(shlJackzando, SWT.BORDER);
		totale.setBounds(117, 45, 76, 21);
		
		aggiungiScontrino.setBounds(10, 10, 114, 25);
		aggiungiScontrino.setText("Nuovo scontrino");

		
		codiceProdotto = new Text(shlJackzando, SWT.BORDER);
		codiceProdotto.setText("");
		codiceProdotto.setBounds(348, 14, 76, 21);
		
		
		nome = new Text(shlJackzando, SWT.BORDER);
		nome.setBounds(348, 41, 76, 21);
		
		
		prezzo = new Text(shlJackzando, SWT.BORDER);
		prezzo.setBounds(348, 68, 76, 21);
		
		
		
		Label lblcodiceProdotto = new Label(shlJackzando, SWT.NONE);
		lblcodiceProdotto.setBounds(252, 20, 90, 15);
		lblcodiceProdotto.setText("Codice Prodotto");
		
		Label lblNomeProdotto = new Label(shlJackzando, SWT.NONE);
		lblNomeProdotto.setBounds(259, 47, 83, 15);
		lblNomeProdotto.setText("Nome Prodotto");
		
		Label lblPrezzo = new Label(shlJackzando, SWT.NONE);
		lblPrezzo.setBounds(305, 74, 37, 15);
		lblPrezzo.setText("Prezzo");
		
		//aggiungi prodotto
		Button btnAggiungiProdotto = new Button(shlJackzando, SWT.NONE);
		btnAggiungiProdotto.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
					c=codiceProdotto.getText();
					d=nome.getText();
					r=Float.parseFloat(prezzo.getText());
					if(alimentare==true){
						Data data=new Data();
						s=new Alimentare(c,d,r,data);
						//s=new Prodotto(c,d,r);
						try {
							lista.aggiungiProdotto(s);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//scrivi il prodotto sulla lista
						list.add(s.toString());
					}
					else{
						String materiale=new String("Ferro");
						s=new NonAlimentare(c,d,r,materiale);
						//s=new Prodotto(c,d,r);
						try {
							lista.aggiungiProdotto(s);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//scrivi il prodotto sulla lista
						list.add(s.toString());
					}
			}
		});
		btnAggiungiProdotto.setBounds(340, 123, 119, 25);
		btnAggiungiProdotto.setText("Aggiungi Prodotto");
		
		
		
		
		Button btnSalvaScontrino = new Button(shlJackzando, SWT.NONE);
		btnSalvaScontrino.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//for (int i=0; i<num; i++){
					//ListaSpesa p= carrello [i];
					//if(p instanceof Alimentare){
						

					//}
				//}
			}
		});
		btnSalvaScontrino.setBounds(10, 92, 101, 25);
		btnSalvaScontrino.setText("Salva scontrino");
		
		Button btnCaricaScontrino = new Button(shlJackzando, SWT.NONE);
		btnCaricaScontrino.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCaricaScontrino.setBounds(10, 123, 101, 25);
		btnCaricaScontrino.setText("Carica scontrino");
		
		Button btnCalcolaTotale = new Button(shlJackzando, SWT.NONE);
		btnCalcolaTotale.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String costo = Float.toString(lista.calcolaSpesa());
				totale.setText(costo);
			}
		});
		btnCalcolaTotale.setBounds(10, 41, 101, 25);
		btnCalcolaTotale.setText("Calcola totale");
		
		
		


	}
}
