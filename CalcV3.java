package calculadoraV3;

import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class CalcV3 extends JFrame{
	
	public CalcV3() {
		boolean init[]= new boolean[1];
		
		init[0]=true;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.EXIT_ON_CLOSE);
		setSize(230,400);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel back= new JPanel();
		add(back);
		back.setBackground(Color.LIGHT_GRAY);
		back.setVisible(true);
		back.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		back.setBackground(Color.white);
		JPanel ContnTela = new JPanel();
		ContnTela.setPreferredSize(new Dimension(170,60));
		back.add(ContnTela);
		
		JLabel tela[] = new JLabel[2];
		
		tela[0] = new JLabel("",JLabel.RIGHT);
		ContnTela.add(tela[0]);
		tela[0].setPreferredSize(new Dimension(65,20));
		tela[0].setOpaque(true);
		tela[0].setBackground(Color.white);
		
		JLabel Operation = new JLabel("",JLabel.CENTER);
		Operation.setOpaque(true);
		Operation.setPreferredSize(new Dimension(20,20));
		Operation.setBackground(Color.white);
		ContnTela.add(Operation);
		
		tela[1] = new JLabel("", JLabel.LEFT);
		ContnTela.add(tela[1]);
		tela[1].setPreferredSize(new Dimension(65,20));
		tela[1].setOpaque(true);
		tela[1].setBackground(Color.white);
		
		JLabel rest = new JLabel("",JLabel.CENTER);
		rest.setPreferredSize(new Dimension(160,30));
		rest.setOpaque(true);
		rest.setBackground(Color.white);
		ContnTela.add(rest);
		
		JPanel ContnButton = new JPanel();
		ContnButton.setPreferredSize(new Dimension(190,280));
		back.add(ContnButton);
		back.setOpaque(true);
		back.setBackground(Color.white);
		
		JButton button[] = new JButton[15];
		for(int n=0;n<button.length;n++) {
			button[n] = new JButton();
			if(n<9) {
				button[n].setText(Integer.toString(n+1));
			}
			switch(n) {
				case 9:
					button[n].setText("=");
					break;
				case 10:
					button[n].setText(Integer.toString(0));
					break;
				case 11:
					button[n].setText("+");
					break;
				case 12:
					button[n].setText("-");
					break;
				case 13:
					button[n].setText("X");
					break;
				case 14:
					button[n].setText("/");
					break;
				}
			ContnButton.add(button[n]);
			button[n].setVisible(true);
			button[n].setPreferredSize(new Dimension(50,50));
			
			int scp = n;
			button[n].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(scp<9||scp==10) {
						if(init[0]==true) {
							tela[0].setText(tela[0].getText()+button[scp].getText());
						}else {
							tela[1].setText(tela[1].getText()+button[scp].getText());
						}
					}else if(scp>10&&scp<15){//&&tela.getText().equals("")){
						if(tela[0].getText().equals("")) {
							tela[0].requestFocus();
						}else {
							Operation.setText(button[scp].getText());
							init[0]=false;
						}
						Operation.setText(button[scp].getText());
					}else{
						int n1= Integer.parseInt(tela[0].getText());
						int n2= Integer.parseInt(tela[1].getText());
						String operate = Operation.getText();
						int result;
						
						switch(operate) {
						case "+":
							result=n1+n2;
							rest.setText("= "+Integer.toString(result));
							break;
						case"-":
							result=n1-n2;
							rest.setText("= "+Integer.toString(result));
							break;
						case"/":
							result=n1/n2;
							rest.setText("= "+Integer.toString(result));
							break;
						case"X":
							result=n1*n2;
							rest.setText("= "+Integer.toString(result));
						}
					}
				}
			});
		}
		///Fim laco For
		ContnButton.setBackground(Color.white);
		ContnTela.setBackground(Color.white);
		setVisible(true);
	}
	public static void main(String args[] ){
		new CalcV3();
	}
}
