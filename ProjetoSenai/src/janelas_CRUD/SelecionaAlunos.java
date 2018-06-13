package janelas_CRUD;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import CRUD.Aluno;
import CRUD.CRUDAlunos;
import menuPrincipal.Principal;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelecionaAlunos {

	private JFrame frmMeuCrud;
	private JTextField tfProcurar;
	private JButton btnProcurar;
	private JTable tabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelecionaAlunos window = new SelecionaAlunos();
					window.frmMeuCrud.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SelecionaAlunos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMeuCrud = new JFrame();
		frmMeuCrud.setTitle("MEU CRUD - Alunos cadastrados");
		frmMeuCrud.setBounds(100, 100, 610, 387);
		frmMeuCrud.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmMeuCrud.getContentPane().setLayout(null);
		frmMeuCrud.setLocationRelativeTo(null);
		frmMeuCrud.setResizable(false);
		
		tfProcurar = new JTextField();
		tfProcurar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
					btnProcurar.doClick();
				}
			}
		});
		tfProcurar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(tfProcurar.getText().toString().equals("Entre com o nome a ser procurado")) {
					tfProcurar.setForeground(Color.BLACK);
					tfProcurar.setText(null);
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(tfProcurar.getText().isEmpty()) {
					
				}
			}
		});
		tfProcurar.setForeground(Color.LIGHT_GRAY);
		tfProcurar.setText("Entre com o nome a ser procurado");
		tfProcurar.setBounds(10, 11, 368, 20);
		frmMeuCrud.getContentPane().add(tfProcurar);
		tfProcurar.setColumns(10);
		
		btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tfProcurar.getText().equals("Entre com o nome a ser procurado")) {
					criaTabela(new CRUDAlunos().selecionaAlunos());
				}else {
					criaTabela(new CRUDAlunos().procuraNomeAluno(tfProcurar.getText().toString()));
				}
			}
		});
		btnProcurar.setBounds(388, 10, 206, 23);
		frmMeuCrud.getContentPane().add(btnProcurar);
		
		tabela = new JTable();
		tabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int linha = tabela.getSelectedRow();
				Aluno alunoEdit = new Aluno();
				alunoEdit.setIdAluno(Integer.parseInt(tabela.getValueAt(linha, 0).toString()));
				alunoEdit.setNome(tabela.getValueAt(linha, 1).toString());
				alunoEdit.setIdade(Integer.parseInt(tabela.getValueAt(linha, 2).toString()));
				alunoEdit.setSexo(tabela.getValueAt(linha, 3).toString());
				alunoEdit.setEmail(tabela.getValueAt(linha, 4).toString());
				alunoEdit.setFone(tabela.getValueAt(linha, 5).toString());
				//EditarRemover editar = new EditarRemover();
				//editar.aluno = alunoEdit;
				EditarRemover.aluno =  alunoEdit;
				EditarRemover.main(null);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 50, 584, 252);
		frmMeuCrud.getContentPane().add(scrollPane);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmMeuCrud.dispose();
				Principal.frmMeuProjetoCrud.setVisible(true);
			}
		});
		btnVoltar.setBounds(505, 325, 89, 23);
		frmMeuCrud.getContentPane().add(btnVoltar);
		
		criaTabela(new CRUDAlunos().selecionaAlunos());
		
	}//fim do metodo inicializee
	
	public void criaTabela(ResultSet dados) {
		 String[] colunas = {"ID","NOME","IDADE","SEXO","E-MAIL","TELEFONE"};
		 ArrayList<Object> linhas = new ArrayList<>();
		 
		 try {
			while (dados.next()) {
				linhas.add(new Object[] {dados.getString("idaluno"),
						dados.getString("nome"),
						dados.getString("idade"),
						dados.getString("sexo"),
						dados.getString("email"),
						dados.getString("fone")});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("erro");
		}
		 ModeloDaTabela modelo = new ModeloDaTabela(colunas, linhas);
		 tabela.setModel(modelo);
		 tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
		 tabela.getColumnModel().getColumn(0).setResizable(false);
		 tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
		 tabela.getColumnModel().getColumn(2).setPreferredWidth(70);
		 tabela.getColumnModel().getColumn(2).setResizable(false);
		 tabela.getColumnModel().getColumn(3).setPreferredWidth(50);
		 tabela.getColumnModel().getColumn(3).setResizable(false);
		 tabela.getColumnModel().getColumn(4).setPreferredWidth(150);
		 tabela.getColumnModel().getColumn(5).setPreferredWidth(111);
		 
		 tabela.setAutoResizeMode(tabela.AUTO_RESIZE_OFF);
		 tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 
		 DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
		 centralizado.setHorizontalAlignment(SwingConstants.CENTER);
		 
		 tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);
		 tabela.getColumnModel().getColumn(1).setCellRenderer(centralizado);
		 tabela.getColumnModel().getColumn(2).setCellRenderer(centralizado);
		 tabela.getColumnModel().getColumn(3).setCellRenderer(centralizado);
		 tabela.getColumnModel().getColumn(4).setCellRenderer(centralizado);
		 tabela.getColumnModel().getColumn(5).setCellRenderer(centralizado);
	}
}
