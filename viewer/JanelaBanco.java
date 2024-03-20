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

import model.Banco;
import model.ModelException;

public class JanelaBanco extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCnpj;
	private JTextField tfNome;
	private JTextField tfCodigo;
	private JanelaAgencia janAgencia;
	private JButton btAgencia;

	/**
	 * Create the frame.
	 */
	public JanelaBanco() {
		setTitle("Banco");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("CNPJ:");
		lblNewLabel.setBounds(10, 41, 46, 14);
		contentPane.add(lblNewLabel);

		tfCnpj = new JTextField();
		tfCnpj.setBounds(47, 38, 143, 20);
		contentPane.add(tfCnpj);
		tfCnpj.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(10, 90, 46, 14);
		contentPane.add(lblNewLabel_1);

		tfNome = new JTextField();
		tfNome.setBounds(66, 87, 124, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Código:");
		lblNewLabel_2.setBounds(10, 129, 46, 14);
		contentPane.add(lblNewLabel_2);

		tfCodigo = new JTextField();
		tfCodigo.setBounds(76, 126, 114, 20);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);

		JButton btAgencia = new JButton("Agência");
		btAgencia.setEnabled(false);
		btAgencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (janAgencia == null || !janAgencia.isVisible()) {
					janAgencia = new JanelaAgencia();
					janAgencia.setVisible(true);
				}
			}
		});
		btAgencia.setBounds(146, 201, 89, 23);
		contentPane.add(btAgencia);

		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cnpj = tfCnpj.getText();
				String nome = tfNome.getText();
				String codigo = tfCodigo.getText();

				Banco b;

				try {
					b = new Banco(cnpj, nome, codigo);
				} catch (ModelException me) {
					JOptionPane.showMessageDialog(btOk, "ERRO:" + me.getMessage());
					return;
				}
				JOptionPane.showMessageDialog(btOk, b);
				btAgencia.setEnabled(true);
				tfCnpj.setEnabled(false);
				tfNome.setEnabled(false);
				tfCodigo.setEnabled(false);
			}

		});
		btOk.setBounds(47, 201, 89, 23);
		contentPane.add(btOk);

		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btCancelar.setBounds(250, 201, 89, 23);
		contentPane.add(btCancelar);

	}
}
