package calculadoraV4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class CalcV4 extends JFrame{
	JPanel ctnMain, ctnView, ctnTeclas;
	JTextField inserts;
	JButton[] teclas = new JButton[15];
	String[] integers= {"1","2","3","4","5","6","7","8","9","0"};
	String Var1 ="0";
	String Var2="0";
	int Result= 0;
	String Operation;
	boolean init[] = new boolean[1];
	public CalcV4() {
		init[0] = true;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200,400);
		setResizable(false);
		setLocationRelativeTo(null);
		
		ctnMain = new JPanel();// FlowLayout(FlowLayout.CENTER,5,5));
		
		add(ctnMain);
		
		ctnMain.setPreferredSize(new Dimension(getWidth(),getHeight()));		
		ctnView = new JPanel();
		ctnView.setPreferredSize(new Dimension(getWidth(),30));
		ctnView.setOpaque(true);
		ctnMain.add(ctnView);
		
		
		
		inserts = new JFormattedTextField("");
		inserts.setPreferredSize(new Dimension(getWidth()-15,30));
		inserts.setOpaque(true);
		inserts.setDisabledTextColor(Color.black);
		
		
		
		ctnView.add(inserts);
		
		
		inserts.setEnabled(false);
		inserts.setHorizontalAlignment(SwingConstants.CENTER);
		inserts.setVisible(true);
		
		
		ctnTeclas = new JPanel();
		ctnTeclas.setPreferredSize(new Dimension(getWidth(),360));
		ctnTeclas.setOpaque(true);
		ctnTeclas.setBackground(Color.white);
		ctnMain.add(ctnTeclas);
		
		//config das teclas na tela
		for(int n=0;n<15;n++) {
			teclas[n] = new JButton();
			teclas[n].setPreferredSize(new Dimension(50,50));
			teclas[n].setHorizontalTextPosition(JButton.CENTER);
			if(n<9){
				teclas[n].setText(Integer.toString(n+1));
			}else if(n==9) {
				teclas[n].setText("0");
			}else {
				switch(n) {
				case 10:
					teclas[n].setText("=");
					break;
				case 11:
					teclas[n].setText("+");
					break;
				case 12:
					teclas[n].setText("-");
					break;
				case 13:
					teclas[n].setText("X");
					break;
				case 14:
					teclas[n].setText("/");
					break;
				}
			}
			
			int scp = n;
			
			teclas[n].setFocusable(false);
			
			teclas[n].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(scp<10){
						if(init[0]==true){
							if(inserts.getText().equals("0")){
								inserts.setText(teclas[scp].getText());
							}
							inserts.setText(inserts.getText()+teclas[scp].getText());
						}else if(inserts.getText().equals("+")||inserts.getText().equals("-")
						||inserts.getText().equals("X")||inserts.getText().equals("/")){
							Operation=inserts.getText();
							inserts.setText(teclas[scp].getText());
						}else {
							inserts.setText(inserts.getText()+teclas[scp].getText());
						}
					}else if(!inserts.getText().equals("")&&!inserts.getText().equals("0")&&scp>10){
						
						if(init[0]==true) {
				 	 		Var1=inserts.getText();
				 			inserts.setText(teclas[scp].getText());
					 		init[0]=false;
					 	}
					 }
					else {
						if(init[0]==false){
							Var2 = inserts.getText();
							int a = Integer.parseInt(Var1);
							int b = Integer.parseInt(Var2);
							switch(Operation) {
							case "+":
								Result = a+b;
								inserts.setText(Integer.toString(Result));
								break;
							case "-":
								Result = a-b;
								inserts.setText(Integer.toString(Result));
								break;
							case "X":
								Result = a*b;
								inserts.setText(Integer.toString(Result));
								break;
							case "/":
								Result = a/b;
								inserts.setText(Integer.toString(Result));
								break;
							}
							init[0]=true;
						}
					}
				 }
			});
			
			ctnTeclas.add(teclas[n]);
		
		}
		//Fim do Laco For	
		//fim config das teclas da tela
		
		
		
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				for(int n =0;n<integers.length;n++) {
					if(inserts.getText().length()<25&&e.getKeyChar()==integers[n].charAt(0)){
						if(inserts.getText().equals("+")||inserts.getText().equals("-")||inserts.getText().equals("X")||inserts.getText().equals("/")) {
							inserts.setText(String.valueOf(e.getKeyChar()));
						}else {
							inserts.setText(inserts.getText()+String.valueOf(e.getKeyChar()));
						}
					}
				}
				switch(String.valueOf(e.getKeyChar())) {
				case "+":
					if(!inserts.getText().equals("0")){
						if(init[0]==true) {
							Var1=inserts.getText();
							inserts.setText(String.valueOf(e.getKeyChar()));
							init[0]=false;
							Operation="+";
						}else {
							e.consume();
						}
					}
					break;
				case "-":
					if(!inserts.getText().equals("0")){
						if(init[0]==true) {
							Var1=inserts.getText();
							inserts.setText(String.valueOf(e.getKeyChar()));
							init[0]=false;
							Operation="-";
						}else {
							e.consume();
						}
					}				
					break;
				case "X":
					if(!inserts.getText().equals("0")){
						if(init[0]==true) {
							Var1=inserts.getText();
							inserts.setText(String.valueOf(e.getKeyChar()));
							init[0]=false;
							Operation="X";
						}else {
							e.consume();
						}
					}
					break;
				case "/":
					if(!inserts.getText().equals("0")){
						if(init[0]==true) {
							Var1=inserts.getText();
							inserts.setText(String.valueOf(e.getKeyChar()));
							Operation="/";
							init[0]=false;
						}else {
							e.consume();
						}
					}
					break;
				}
				if(e.getKeyCode()==KeyEvent.VK_ENTER){//&&init[0]==false&&!inserts.getText().equals("0")){
					if(init[0]==true) {
						e.consume();
					}else {
						Var2=inserts.getText();
						int a = Integer.parseInt(Var1);
						int b= Integer.parseInt(Var2);
						switch(Operation) {
						case "+":
							Result = a+b;
							inserts.setText(Integer.toString(Result));
							break;
						case "-":
							Result = a-b;
							inserts.setText(Integer.toString(Result));
							break;
						case "X":
							Result = a*b;
							inserts.setText(Integer.toString(Result));
							break;
						case "/":
							Result = a/b;
							inserts.setText(Integer.toString(Result));
							break;
						}
						init[0]=true;
					}
				}
			}
		});
	}
	public static void main(String[] args) {
		new CalcV4().setVisible(true);
	}
} 