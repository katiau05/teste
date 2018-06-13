package splash;

import java.awt.EventQueue;

import javax.swing.JFrame;

import menuPrincipal.Principal;

public class Splash implements Runnable{

	private JFrame frame;

	Thread tarefa;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splash window = new Splash();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Splash() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame .DISPOSE_ON_CLOSE);
		//sempre no centro do desktop
		frame.setLocationRelativeTo(null);
		//desabilitar o botao minimizar e maximizar
		frame.setResizable(false);
		frame.setTitle("Meu Projeto");
		
		tarefa = new Thread(Splash.this);
		tarefa.start();//vai para run multitarefa
	}

	@Override
	public void run() {
		try {
			//definir uma pausa
			Thread.sleep(2000);
			//abra a proxima janela
			Principal proximaJanela = new Principal();
			proximaJanela.main(null);
			frame.setVisible(false);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
