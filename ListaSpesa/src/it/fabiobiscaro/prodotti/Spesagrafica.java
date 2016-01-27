package it.fabiobiscaro.prodotti;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;

public class Spesagrafica {

	protected Shell shlJackzando;
	private Text codiceProdotto;
	private Text nome;
	private Text prezzo;
	private Text totale;
	private boolean p;
	private Button btnTesseraFedelt;
	// codice
	private String c;
	// descrizione
	private String d;
	// prexxo
	private float r;
	ListaSpesa lista= new ListaSpesa(p);
	Prodotto s;
	private Table table;

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
		shlJackzando.setSize(508, 398);
		shlJackzando.setText("Supermercati JAck&ZAndo");
		
		Button aggiungiScontrino = new Button(shlJackzando, SWT.NONE);
		aggiungiScontrino.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				p=btnTesseraFedelt.getSelection();
				System.out.println(p);
				
			}
		});
		aggiungiScontrino.setBounds(10, 10, 114, 25);
		aggiungiScontrino.setText("Aggiungi scontrino");
		
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
				s=new Prodotto(c,d,r);
				try {
					lista.aggiungiProdotto(s);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAggiungiProdotto.setBounds(305, 123, 119, 25);
		btnAggiungiProdotto.setText("Aggiungi Prodotto");
		
		btnTesseraFedelt = new Button(shlJackzando, SWT.CHECK);
		btnTesseraFedelt.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//System.out.println("Check:" + btnTesseraFedelt.toString());
			}
		});
		btnTesseraFedelt.setBounds(130, 14, 101, 16);
		btnTesseraFedelt.setText("Tessera Fedelt\u00E0");
		
		Button btnSalvaScontrino = new Button(shlJackzando, SWT.NONE);
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
		
		Button btnAlimentare = new Button(shlJackzando, SWT.CHECK);
		btnAlimentare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		btnAlimentare.setBounds(235, 101, 76, 16);
		btnAlimentare.setText("Alimentare");
		
		Button btnNonAlimentare = new Button(shlJackzando, SWT.CHECK);
		btnNonAlimentare.setBounds(317, 101, 107, 16);
		btnNonAlimentare.setText("Non alimentare");
		
		Button btnCalcolaTotale = new Button(shlJackzando, SWT.NONE);
		btnCalcolaTotale.setBounds(10, 41, 101, 25);
		btnCalcolaTotale.setText("Calcola totale");
		
		totale = new Text(shlJackzando, SWT.BORDER);
		totale.setBounds(117, 45, 76, 21);
		
		table = new Table(shlJackzando, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 154, 449, 196);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNome = new TableColumn(table, SWT.NONE);
		tblclmnNome.setWidth(100);
		tblclmnNome.setText("Nome");
		//tblclmnNome.setText(s.getDescrizione());
		
		TableColumn tblclmnCodice = new TableColumn(table, SWT.NONE);
		tblclmnCodice.setText("Codice");
		tblclmnCodice.setWidth(74);
		
		TableColumn tblclmnPrezzo = new TableColumn(table, SWT.NONE);
		tblclmnPrezzo.setText("Prezzo");
		tblclmnPrezzo.setWidth(78);
		
		TableColumn tblclmnTipo = new TableColumn(table, SWT.NONE);
		tblclmnTipo.setText("Tipo");
		tblclmnTipo.setWidth(36);
		
		TableColumn tblclmnDataScadenza = new TableColumn(table, SWT.NONE);
		tblclmnDataScadenza.setWidth(89);
		tblclmnDataScadenza.setText("Data scadenza");
		
		TableColumn tblclmnMateriale = new TableColumn(table, SWT.NONE);
		tblclmnMateriale.setWidth(65);
		tblclmnMateriale.setText("Materiale");

	}
}
