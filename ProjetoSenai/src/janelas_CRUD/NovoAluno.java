package janelas_CRUD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import CRUD.CRUDAlunos;
import menuPrincipal.Principal;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NovoAluno {

	private JFrame frmCadastroNovo;
	private JTextField tfNome;
	private JTextField tfIdade;
	private JTextField tfEmail;
	private JTextField tfTelefone;
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino ;
	private JButton btnSalvar;
	private JButton btnLimpar;
	String sexo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoAluno window = new NovoAluno();
					window.frmCadastroNovo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NovoAluno() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroNovo = new JFrame();
		frmCadastroNovo.setBounds(100, 100, 450, 300);
		frmCadastroNovo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCadastroNovo.setResizable(false);
		frmCadastroNovo.setLocationRelativeTo(null);
		frmCadastroNovo.getContentPane().setLayout(null);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 11, 46, 14);
		frmCadastroNovo.getContentPane().add(lblNome);
		
		JLabel lblIdade = new JLabel("IDADE:");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdade.setBounds(10, 36, 46, 14);
		frmCadastroNovo.getContentPane().add(lblIdade);
		
		JLabel lblSexo = new JLabel("SEXO:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSexo.setBounds(10, 61, 46, 14);
		frmCadastroNovo.getContentPane().add(lblSexo);
		
		JLabel lblEmail = new JLabel("E-MAIL:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 86, 56, 14);
		frmCadastroNovo.getContentPane().add(lblEmail);
		
		JLabel lblTelefone = new JLabel("TELEFONE:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(10, 110, 76, 14);
		frmCadastroNovo.getContentPane().add(lblTelefone);
		
		tfNome = new JTextField();
		tfNome.setBounds(57, 10, 377, 20);
		frmCadastroNovo.getContentPane().add(tfNome);
		tfNome.setColumns(10);
		
		tfIdade = new JTextField();
		tfIdade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = "0123456789";
				if(!caracteres.contains(e.getKeyChar()+"")) {
					e.consume();
				}
			}
		});
		
		tfIdade.setColumns(10);
		tfIdade.setBounds(57, 35, 67, 20);
		frmCadastroNovo.getContentPane().add(tfIdade);
		
		rbMasculino = 
		new JRadioButton("Masculino");
		rbMasculino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rbMasculino.setSelected(true);
				rbFeminino.setSelected(false);
			}
		});
		rbMasculino.setBounds(57, 57, 109, 23);
		frmCadastroNovo.getContentPane().add(rbMasculino);
		
		rbFeminino = new JRadioButton("Feminino");
		rbFeminino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbMasculino.setSelected(false);
				rbFeminino.setSelected(true);
			}
		});
		rbFeminino.setBounds(168, 59, 109, 23);
		frmCadastroNovo.getContentPane().add(rbFeminino);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(57, 85, 377, 20);
		frmCadastroNovo.getContentPane().add(tfEmail);
		
		tfTelefone = new JTextField();
		tfTelefone.setColumns(10);
		tfTelefone.setBounds(89, 111, 125, 20);
		frmCadastroNovo.getContentPane().add(tfTelefone);
		
		btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfNome.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "informe um nome valido");
					tfNome.requestFocus();
					return;
		}
				if(tfIdade.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "informe uma idade valida");
					tfIdade.requestFocus();
					return;
		}
				
				if(!(rbFeminino.isSelected() || rbMasculino.isSelected())) {
					JOptionPane.showMessageDialog(null, "marque uma opção de sexo");
					return;
				}
				
				if(!(tfEmail.getText().contains("@") && tfEmail.getText().contains(".com"))) {
					JOptionPane.showMessageDialog(null, "informe um e-mail valido");
					tfEmail.requestFocus();
					return;
				}
				
				if (rbFeminino.isSelected()) {
					  sexo ="F";
				}
				
				if (rbMasculino.isSelected()) {
					  sexo ="M";
				}
				
				CRUDAlunos salvar = new CRUDAlunos();
				boolean resposta = salvar.novoAluno(tfNome.getText(),
					Integer.parseInt(tfIdade.getText()),
					sexo,
					tfEmail.getText(), 
					tfTelefone.getText());
				
				if(resposta) {
					JOptionPane.showMessageDialog(null, "salvo com sucesso");
				}else {
					JOptionPane.showMessageDialog(null, "erro ao salvar");
				}
				
				btnLimpar.doClick();
				
			}
		});
		btnSalvar.setBounds(10, 182, 125, 63);
		frmCadastroNovo.getContentPane().add(btnSalvar);
		
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfNome.setText(null);
				tfEmail.setText(null);
				tfIdade.setText(null);
				rbFeminino.setSelected(false);
				rbMasculino.setSelected(false);
				tfTelefone.setText(null);
				
			}
		});
		btnLimpar.setBounds(162, 182, 125, 63);
		frmCadastroNovo.getContentPane().add(btnLimpar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCadastroNovo.dispose();
				Principal.frmMeuProjetoCrud.setVisible(true);
				
			}
		});
		btnVoltar.setBounds(309, 182, 125, 63);
		frmCadastroNovo.getContentPane().add(btnVoltar);
		
	}
}
