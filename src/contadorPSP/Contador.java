package contadorPSP;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Contador extends JFrame implements Runnable, ActionListener {

	private JPanel contentPane;
	private JButton btnParar;
	private JButton btnContinuar;
	private Thread hilo;
	private Font fuente;
	private int cont = 0;
	String contador = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					Contador frame = new Contador();
					frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Contador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnContinuar = new JButton("Iniciar Contador");
		btnContinuar.setBounds(176, 173, 133, 23);
		btnContinuar.addActionListener(this);
		contentPane.add(btnContinuar);
		fuente = new Font("Times new Roman", Font.BOLD, 36);
		btnParar = new JButton("Parar");
		btnParar.setBounds(176, 207, 133, 23);
		btnParar.addActionListener(this);
		contentPane.add(btnParar);
	}
	public void paint(Graphics g) {
		g = contentPane.getGraphics();
		g.clearRect(25, 25, 1200, 100);
		g.setFont(fuente);
		g.setColor(Color.RED);
		this.contador = String.valueOf(cont);
		g.drawString(this.contador, 220, 50);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if(obj == btnContinuar) {
			if(btnContinuar.getText().equalsIgnoreCase("Iniciar Contador")) {
				btnContinuar.setText("Continuar");
				hilo = new Thread(this);
				hilo.start();
			}else {
				hilo = new Thread(this);
				hilo.start();
			}
		}
		if(obj == btnParar) {
			hilo = null;
		}
		
	}

	@Override
	public void run() {
		
		while(hilo !=null) {
			cont++;			
			repaint();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
