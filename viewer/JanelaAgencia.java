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

import model.Agencia;
import model.ModelException;

public class JanelaAgencia extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfCidade;
	private JTextField tfUf;
	private JTextField tfBairro;
	private JanelaContaCorrente janConta;
	private JButton btConta;

	/**
	 * Create the frame.
	 */
	public JanelaAgencia() {
		setTitle("Agência");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setBounds(10, 31, 46, 14);
		contentPane.add(lblNewLabel);

		tfCodigo = new JTextField();
		tfCodigo.setBounds(66, 28, 86, 20);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Cidade:");
		lblNewLabel_1.setBounds(10, 69, 46, 14);
		contentPane.add(lblNewLabel_1);

		tfCidade = new JTextField();
		tfCidade.setBounds(66, 66, 86, 20);
		contentPane.add(tfCidade);
		tfCidade.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("UF:");
		lblNewLabel_2.setBounds(10, 106, 46, 14);
		contentPane.add(lblNewLabel_2);

		tfUf = new JTextField();
		tfUf.setBounds(66, 103, 86, 20);
		contentPane.add(tfUf);
		tfUf.setColumns(10);

		JButton btConta = new JButton("Conta Corrente");
		btConta.setEnabled(false);
		btConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (janConta == null || !janConta.isVisible()) {
					janConta = new JanelaContaCorrente();
					janConta.setVisible(true);
				}
			}
		});
		btConta.setBounds(162, 203, 124, 23);
		contentPane.add(btConta);

		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigo = tfCodigo.getText();
				String cidade = tfCidade.getText();
				String uf = tfUf.getText();
				String bairro = tfBairro.getText();
				Agencia a;

				try {
					a = new Agencia(codigo, bairro, cidade, uf);
				} catch (ModelException me) {
					JOptionPane.showMessageDialog(btOk, "ERRO: " + me.getMessage());
					return;
				}
				JOptionPane.showMessageDialog(btOk, a);
				btConta.setEnabled(true);
				tfCodigo.setEnabled(false);
				tfCidade.setEnabled(false);
				tfUf.setEnabled(false);
				tfBairro.setEnabled(false);
			}
		});
		btOk.setBounds(63, 203, 89, 23);
		contentPane.add(btOk);

		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btCancelar.setBounds(296, 203, 89, 23);
		contentPane.add(btCancelar);

		JLabel lblNewLabel_3 = new JLabel("Bairro:");
		lblNewLabel_3.setBounds(10, 142, 46, 14);
		contentPane.add(lblNewLabel_3);

		tfBairro = new JTextField();
		tfBairro.setBounds(66, 142, 86, 20);
		contentPane.add(tfBairro);
		tfBairro.setColumns(10);

	}

}
