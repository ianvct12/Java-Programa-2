package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.ContaCorrente;
import model.ModelException;

public class JanelaContaCorrente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNumero;
	private JTextField tfAbertura;
	private JTextField tfNome;
	private JTextField tfSaldo;

	/**
	 * Create the frame.
	 */
	public JanelaContaCorrente() {
		setTitle("Conta Corrente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Número:");
		lblNewLabel.setBounds(10, 31, 67, 14);
		contentPane.add(lblNewLabel);

		tfNumero = new JTextField();
		tfNumero.setBounds(87, 28, 86, 20);
		contentPane.add(tfNumero);
		tfNumero.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Dia da Abertura:");
		lblNewLabel_1.setBounds(10, 67, 129, 14);
		contentPane.add(lblNewLabel_1);

		tfAbertura = new JTextField();
		tfAbertura.setBounds(104, 64, 86, 20);
		contentPane.add(tfAbertura);
		tfAbertura.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Nome do Correntista:");
		lblNewLabel_2.setBounds(10, 96, 129, 14);
		contentPane.add(lblNewLabel_2);

		tfNome = new JTextField();
		tfNome.setBounds(137, 93, 138, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Saldo Inicial:");
		lblNewLabel_3.setBounds(10, 137, 84, 14);
		contentPane.add(lblNewLabel_3);

		tfSaldo = new JTextField();
		tfSaldo.setBounds(104, 134, 86, 20);
		contentPane.add(tfSaldo);
		tfSaldo.setColumns(10);

		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = tfNumero.getText();
				String diaAbertura = tfAbertura.getText();
				String nomeCorrentista = tfNome.getText();
				String aux = tfSaldo.getText();

				int saldo;
				try {
					saldo = Integer.parseInt(aux);
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(btOk, "O saldo deve conter dígitos numéricos.");
					return;
				}
				ContaCorrente cc;
				try {
					cc = new ContaCorrente(numero, diaAbertura, nomeCorrentista, saldo);
				} catch (ModelException me) {
					JOptionPane.showMessageDialog(btOk, "ERRO: " + me.getMessage());
					return;
				}
				JOptionPane.showMessageDialog(btOk, cc);
			}
		});
		btOk.setBounds(63, 191, 89, 23);
		contentPane.add(btOk);

		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btCancelar.setBounds(240, 191, 89, 23);
		contentPane.add(btCancelar);
	}

}
