package cursojava.thread;

import javax.swing.JOptionPane;

public class AulaThread {

	public static void main(String[] args) throws InterruptedException {
		
		new Thread() {
			
			public void run() {
				for (int pos = 0; pos < 10; pos++) {
					
					System.out.println("executando a função por tras da tela");
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		}.start();
		
		
		System.out.println("Chegando ao fim");
		
		JOptionPane.showMessageDialog(null, "Sitema em processo para usuário");
	}
}
