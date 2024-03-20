package viewer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JanelaBanco janBanco;

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal() {
		setTitle("Sistema Bancário");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Banco");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (janBanco == null || !janBanco.isVisible()) {
					janBanco = new JanelaBanco();
					janBanco.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(123, 80, 144, 73);
		contentPane.add(btnNewButton);

		JButton btnNewButton_3 = new JButton("Sair");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnNewButton_3.setBounds(142, 211, 97, 39);
		contentPane.add(btnNewButton_3);
	}

}
