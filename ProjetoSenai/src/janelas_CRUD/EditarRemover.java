package janelas_CRUD;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

import CRUD.Aluno;
import CRUD.CRUDAlunos;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarRemover {

	public JFrame frmEditarOuRemover;
	private JTextField tfEmail;
	private JTextField tfTelefone;
	
	public static Aluno aluno;
	private JRadioButton rbMasculino;
	private JRadioButton rbFeminino;
	private JTextField tfNome;
	private JTextField tfIdade;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditarRemover window = new EditarRemover();
					window.frmEditarOuRemover.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditarRemover() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditarOuRemover = new JFrame();
		frmEditarOuRemover.setTitle("Editar ou Remover Aluno");
		frmEditarOuRemover.setBounds(100, 100, 450, 300);
		frmEditarOuRemover.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEditarOuRemover.getContentPane().setLayout(null);
		frmEditarOuRemover.setResizable(false);
		frmEditarOuRemover.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("NOME:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 6, 46, 25);
		frmEditarOuRemover.getContentPane().add(lblNewLabel);
		
		JLabel lblIdade = new JLabel("IDADE:");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdade.setBounds(10, 35, 46, 25);
		frmEditarOuRemover.getContentPane().add(lblIdade);
		
		JLabel lblEmail = new JLabel("EMAIL:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 105, 46, 14);
		frmEditarOuRemover.getContentPane().add(lblEmail);
		
		JLabel lblTelefone = new JLabel("TELEFONE:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelefone.setBounds(10, 135, 77, 14);
		frmEditarOuRemover.getContentPane().add(lblTelefone);
		
		JLabel lblSexo = new JLabel("SEXO:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSexo.setBounds(10, 60, 46, 46);
		frmEditarOuRemover.getContentPane().add(lblSexo);
		
		rbMasculino = new JRadioButton("Masculino");
		rbMasculino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rbMasculino.setSelected(true);
				rbFeminino.setSelected(false);
			}
		});
		rbMasculino.setBounds(62, 74, 97, 23);
		frmEditarOuRemover.getContentPane().add(rbMasculino);
		
		rbFeminino = new JRadioButton("Feminino");
		rbFeminino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rbFeminino.setSelected(true);
				rbMasculino.setSelected(false);
			}
		});
		rbFeminino.setBounds(161, 74, 118, 23);
		frmEditarOuRemover.getContentPane().add(rbFeminino);
		
		tfNome = new JTextField();
		tfNome.setEditable(false);
		tfNome.setBounds(59, 10, 365, 20);
		frmEditarOuRemover.getContentPane().add(tfNome);
		
		
		tfIdade = new JTextField();
	
			
			
		
		tfIdade.setColumns(10);
		tfIdade.setBounds(59, 40, 365, 20);
	
		frmEditarOuRemover.getContentPane().add(tfIdade);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(59, 104, 365, 20);
		frmEditarOuRemover.getContentPane().add(tfEmail);
		
		tfTelefone = new JTextField();
		tfTelefone.setColumns(10);
		tfTelefone.setBounds(85, 134, 339, 20);
		frmEditarOuRemover.getContentPane().add(tfTelefone);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				try {
				CRUDAlunos editar = new CRUDAlunos();
				String sexo;
				if(rbMasculino.isSelected())
					sexo = "M";
				else
					sexo = "F";
				editar.alterarAluno(Integer.parseInt(tfIdade.getText()),sexo , tfEmail.getText(), tfTelefone.getText(), aluno.getIdAluno());
				JOptionPane.showMessageDialog(null, "Aluno alterado com seucesso!");
				frmEditarOuRemover.dispose();
				}catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados");
				}
			}
		});
		btnEditar.setBounds(10, 195, 110, 56);
		frmEditarOuRemover.getContentPane().add(btnEditar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemover.setBounds(154, 195, 125, 56);
		frmEditarOuRemover.getContentPane().add(btnRemover);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmEditarOuRemover.dispose();
			
				
			}
		});
		btnCancelar.setBounds(314, 195, 110, 56);
		frmEditarOuRemover.getContentPane().add(btnCancelar);
		
		colocaDadosNaTela();
		

	}
	private void colocaDadosNaTela() {
		tfNome.setText(aluno.getNome());
		tfIdade.setText(String.valueOf((aluno.getIdade())));
		if(aluno.getSexo().equals("m")){
			rbMasculino.setSelected(true);
		}else {
			rbFeminino.setSelected(true);}
			tfEmail.setText(aluno.getEmail());
			tfTelefone.setText(aluno.getFone());
		}
		

	
}

