package it.fabiobiscaro.prodotti;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Spesagrafica {

	protected Shell shlJackzando;
	private Text codiceProdotto;
	private Text tipo;
	private Text prezzo;
	private Text totale;

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
		shlJackzando.setSize(450, 196);
		shlJackzando.setText("Supermercati JAck&ZAndo");
		
		Button aggiungiScontrino = new Button(shlJackzando, SWT.NONE);
		aggiungiScontrino.setBounds(10, 10, 114, 25);
		aggiungiScontrino.setText("Aggiungi scontrino");
		
		codiceProdotto = new Text(shlJackzando, SWT.BORDER);
		codiceProdotto.setText("");
		codiceProdotto.setBounds(348, 14, 76, 21);
		
		tipo = new Text(shlJackzando, SWT.BORDER);
		tipo.setBounds(348, 41, 76, 21);
		
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
		
		Button btnAggiungiProdotto = new Button(shlJackzando, SWT.NONE);
		btnAggiungiProdotto.setBounds(305, 123, 119, 25);
		btnAggiungiProdotto.setText("Aggiungi Prodotto");
		
		Button btnTesseraFedelt = new Button(shlJackzando, SWT.CHECK);
		btnTesseraFedelt.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
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

	}
}
