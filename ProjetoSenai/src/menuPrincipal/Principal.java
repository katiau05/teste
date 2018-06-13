package menuPrincipal;

import java.awt.EventQueue;

import javax.swing.JFrame;

import janelas_CRUD.NovoAluno;
import janelas_CRUD.SelecionaAlunos;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal {

	public static JFrame frmMeuProjetoCrud;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmMeuProjetoCrud.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMeuProjetoCrud = new JFrame();
		frmMeuProjetoCrud.setTitle("MEU PROJETO CRUD");
		frmMeuProjetoCrud.setBounds(100, 100, 450, 300);
		frmMeuProjetoCrud.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMeuProjetoCrud.getContentPane().setLayout(null);
		frmMeuProjetoCrud.setResizable(false);//botaozinho maximizar
		frmMeuProjetoCrud.setLocationRelativeTo(null);//meio tela
		
		JButton btnNovoAluno = new JButton("CADASTRAR NOVO ALUNO");
		btnNovoAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMeuProjetoCrud.setVisible(false);
				NovoAluno.main(null);
				
			}
		});
		btnNovoAluno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNovoAluno.setBounds(10, 11, 414, 57);
		frmMeuProjetoCrud.getContentPane().add(btnNovoAluno);
		
		JButton btnVisualizarAlunos = new JButton("VISUALIZAR ALUNOS");
		btnVisualizarAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMeuProjetoCrud.setVisible(false);
				SelecionaAlunos.main(null);
			}
		});
		btnVisualizarAlunos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVisualizarAlunos.setBounds(10, 79, 414, 58);
		frmMeuProjetoCrud.getContentPane().add(btnVisualizarAlunos);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSair.setBounds(10, 203, 414, 37);
		frmMeuProjetoCrud.getContentPane().add(btnSair);
	}
}
