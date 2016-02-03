package it.fabiobiscaro.prodotti;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.FileNotFoundException;
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
	PrintWriter out;

	//ciao zandi
	
	
	//array di prodotti
	private Prodotto[] carrello = new Prodotto[100];
	int num = 10;
	// codice
	private String c;
	// descrizione
	private String d;
	// prexxo
	private float r;
	ListaSpesa lista;
	Prodotto s;
	private Text materialetxt;
	private Text gg;
	private Text mm;
	private Text aa;

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
		shlJackzando.setSize(486, 446);
		shlJackzando.setText("Supermercati JAck&ZAndo");
		
		Button aggiungiScontrino = new Button(shlJackzando, SWT.NONE);
		aggiungiScontrino.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				p=btnTesseraFedelt.getSelection();
				System.out.println(p);
				
			}
		});
		
		materialetxt = new Text(shlJackzando, SWT.BORDER);
		materialetxt.setBounds(383, 127, 76, 21);
		
		Label lblMateriale = new Label(shlJackzando, SWT.NONE);
		lblMateriale.setBounds(322, 128, 55, 15);
		lblMateriale.setText("Materiale");
		
		gg = new Text(shlJackzando, SWT.BORDER);
		gg.setBounds(322, 173, 37, 21);
		
		mm = new Text(shlJackzando, SWT.BORDER);
		mm.setBounds(365, 173, 37, 21);
		
		aa = new Text(shlJackzando, SWT.BORDER);
		aa.setBounds(408, 173, 51, 21);
		
		Label lblGg = new Label(shlJackzando, SWT.NONE);
		lblGg.setBounds(322, 152, 22, 15);
		lblGg.setText("GG");
		
		Label lblMm = new Label(shlJackzando, SWT.NONE);
		lblMm.setBounds(365, 152, 22, 15);
		lblMm.setText("MM");
		
		Label lblAaaa = new Label(shlJackzando, SWT.NONE);
		lblAaaa.setBounds(408, 152, 55, 15);
		lblAaaa.setText("AAAA");
		
		List list = new List(shlJackzando, SWT.BORDER);
		list.setBounds(10, 202, 449, 196);

		
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
		grpTipo.setBounds(202, 71, 114, 82);
		
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


		
		totale = new Text(shlJackzando, SWT.BORDER);
		totale.setBounds(117, 45, 76, 21);
		
		aggiungiScontrino.setBounds(10, 10, 114, 25);
		aggiungiScontrino.setText("Nuovo scontrino");
		
		
		codiceProdotto = new Text(shlJackzando, SWT.BORDER);
		codiceProdotto.setText("");
		codiceProdotto.setBounds(383, 12, 76, 21);
		
		
		nome = new Text(shlJackzando, SWT.BORDER);
		nome.setBounds(383, 41, 76, 21);
		
		
		prezzo = new Text(shlJackzando, SWT.BORDER);
		prezzo.setBounds(383, 71, 76, 21);
		
		
		
		Label lblcodiceProdotto = new Label(shlJackzando, SWT.NONE);
		lblcodiceProdotto.setBounds(287, 20, 90, 15);
		lblcodiceProdotto.setText("Codice Prodotto");
		
		Label lblNomeProdotto = new Label(shlJackzando, SWT.NONE);
		lblNomeProdotto.setBounds(294, 48, 83, 15);
		lblNomeProdotto.setText("Nome Prodotto");
		
		Label lblPrezzo = new Label(shlJackzando, SWT.NONE);
		lblPrezzo.setBounds(340, 77, 37, 15);
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
						String materiale=new String(materialetxt.getText());
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
		btnAggiungiProdotto.setBounds(197, 171, 119, 25);
		btnAggiungiProdotto.setText("Aggiungi Prodotto");
		
		
		
		
		Button btnSalvaScontrino = new Button(shlJackzando, SWT.NONE);
		btnSalvaScontrino.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//dichiarazione stringa
				try {
					out = new PrintWriter("Lista_della_spesa.txt");
					out.println( "Lista della spesa" );
					for (int i=0; i<num; i++){
						System.out.println("entra nel for");
						s= carrello [i];
						if(s instanceof Alimentare){
							System.out.println("Alimentare");
							out.println( "Alimentare" );
							out.println( "p.getDescrizione()" );
							out.println( "p.getCodice ");
							out.println( "p.getPrezzo ");
						}else{
							System.out.println("Non Alimentare");
							out.println( "Non Alimentare ");
							out.println( "p.getDescrizione()" );
							out.println( "p.getCodice ");
							out.println( "p.getPrezzo ");
						}
					}
					out.close();
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		});
		btnSalvaScontrino.setBounds(10, 138, 101, 25);
		btnSalvaScontrino.setText("Salva scontrino");
		
		Button btnCaricaScontrino = new Button(shlJackzando, SWT.NONE);
		btnCaricaScontrino.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCaricaScontrino.setBounds(10, 169, 101, 25);
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
