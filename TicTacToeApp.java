import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TicTacToeApp 
{
	JFrame frame=new JFrame("TEST");
	JPanel[] panel=new JPanel[3];
	JLabel label=new JLabel("Its first Player Turn");
	JButton[] bt=new JButton[9];
	JButton reset=new JButton("Reset");
	JButton exit=new JButton("Exit");
	
	ImageIcon icon1=new ImageIcon(getClass().getResource("image/user1.png"));
	ImageIcon icon2=new ImageIcon(getClass().getResource("image/user2.png"));
	
	int player=1,count=0;
	boolean winnerFound=false;
	public TicTacToeApp() 
	{
		frame.setSize(550, 600);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.GREEN);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addPanel();
		frame.setVisible(true);
	}
	private void addPanel()
	{
		for(int i=0;i<3;i++)
		{
			panel[i]=new JPanel();
			frame.add(panel[i]);
		}
		panel[0].setBounds(20,20,500,40);
		panel[1].setBounds(20, 80,500,420);
		panel[2].setBounds(20,510,500,40);
		
		addLabel();
	}
	private void addLabel()
	{
		panel[0].add(label);
		label.setFont(new Font("Elephant",Font.PLAIN, 20));
		label.setForeground(Color.DARK_GRAY);
		panel[0].setBackground(Color.green);
		
		addButton();
	}
	private void addButton()
	{
		panel[1].setLayout(new GridLayout(3,3));
		TicListener listener=new TicListener();
		for(int i=0;i<9;i++)
		{
			bt[i]=new JButton();
			bt[i].setBackground(Color.orange);
			bt[i].addActionListener(listener);
			panel[1].add(bt[i]);
		}
		resetAndExit();
	}
	private void resetAndExit()
	{
		panel[2].add(reset);
		panel[2].add(exit);
		Font fo=new Font("Arial",Font.BOLD,18);
		reset.setFont(fo);
		reset.addActionListener(new resetListener());
		exit.addActionListener(new exitListener());
		exit.setFont(fo);
		reset.setBackground(Color.magenta);
		exit.setBackground(Color.red);
		panel[2].setOpaque(false);
		reset.setEnabled(false);
	}
	class TicListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt) 
		{
			JButton bb=(JButton) evt.getSource();
			if(player==1)
			{
				bb.setIcon(icon1);
				label.setText("Its Second Player Turn");
				panel[0].setBackground(Color.CYAN);
				player=2;
			}
			else if(player==2)
			{
				bb.setIcon(icon2);
				label.setText("Its First Player Turn");
				panel[0].setBackground(Color.MAGENTA);
				player=1;
			}
			bb.setEnabled(false);
			findWinner();
			count++;
			if(count==9 && !winnerFound)
			{
				label.setText("Game is Over");
				panel[0].setBackground(Color.red);
				reset.setEnabled(true);
				
				JOptionPane.showMessageDialog(frame,"No One Has Won");
				
			}
		}
		private void findWinner()
		{
			if(bt[0].getIcon()==icon1 && bt[1].getIcon()==icon1 && bt[2].getIcon()==icon1)
				winnerFinder(0,1,2);
			else if(bt[0].getIcon()==icon2 && bt[1].getIcon()==icon2 && bt[2].getIcon()==icon2)
				winnerFinder(0,1,2);
			
			else if(bt[3].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[5].getIcon()==icon1)
				winnerFinder(3,4,5);
			else if(bt[3].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[5].getIcon()==icon2)
				winnerFinder(3,4,5);
			
			else if(bt[6].getIcon()==icon1 && bt[7].getIcon()==icon1 && bt[8].getIcon()==icon1)
				winnerFinder(6,7,8);
			else if(bt[6].getIcon()==icon2 && bt[7].getIcon()==icon2 && bt[8].getIcon()==icon2)
				winnerFinder(6,7,8);
			
			else if(bt[0].getIcon()==icon1 && bt[3].getIcon()==icon1 && bt[6].getIcon()==icon1)
				winnerFinder(0,3,6);
			else if(bt[0].getIcon()==icon2 && bt[3].getIcon()==icon2 && bt[6].getIcon()==icon2)
				winnerFinder(0,3,6);
			
			else if(bt[1].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[7].getIcon()==icon1)
				winnerFinder(1,4,7);
			else if(bt[1].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[7].getIcon()==icon2)
				winnerFinder(1,4,7);
			
			else if(bt[2].getIcon()==icon1 && bt[5].getIcon()==icon1 && bt[8].getIcon()==icon1)
				winnerFinder(2,5,8);
			else if(bt[2].getIcon()==icon2 && bt[5].getIcon()==icon2 && bt[8].getIcon()==icon2)
				winnerFinder(2,5,8);
			
			else if(bt[0].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[8].getIcon()==icon1)
				winnerFinder(0,4,8);
			else if(bt[0].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[8].getIcon()==icon2)
				winnerFinder(0,4,8);
			
			else if(bt[2].getIcon()==icon1 && bt[4].getIcon()==icon1 && bt[6].getIcon()==icon1)
				winnerFinder(2,4,6);
			else if(bt[2].getIcon()==icon2 && bt[4].getIcon()==icon2 && bt[6].getIcon()==icon2)
				winnerFinder(2,4,6);
				
		}
		private void winnerFinder(int i,int j,int k)
		{
			winnerFound=true;
			reset.setEnabled(true);
			bt[i].setBackground(Color.green);
			bt[j].setBackground(Color.green);
			bt[k].setBackground(Color.green);
			label.setText("Game is over");
			panel[0].setBackground(Color.red);
			
			disableButtons();
			
			if(player==2)
			{
				JOptionPane.showMessageDialog(frame,"First player has won");
			}
			else
			{
				JOptionPane.showMessageDialog(frame, "Second player has won");
			}
		}
		private void disableButtons()
		{
			for(int i=0;i<9;i++)
			{
				bt[i].setEnabled(false);
			}
		}
	}
	class resetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt) 
		{
			for(int i=0;i<9;i++)
			{
				bt[i].setIcon(null);
				bt[i].setBackground(Color.orange);
				bt[i].setEnabled(true);
			}
			label.setText("Its First Player Turn");
			panel[0].setBackground(Color.magenta);
			winnerFound=false;
			player=1;
			count=0;
			reset.setEnabled(false);
		}
	}
	public class exitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt) 
		{
             System.exit(0);
		}
	}
	public static void main(String[] args) 
	{
		new TicTacToeApp();
	}

}
