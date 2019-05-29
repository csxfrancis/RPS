/** This is a basic Rock Paper Scissor Game
 	where you play Rock Paper Scizzor with a 
 	computer. You amount of wons are tracked.
 */



import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class RPS extends JFrame implements ActionListener{
//static JLabel cpr;
static int wc = 0;

/*** 
 * Simulates Rock Paper Scizzor
	0 you lose
	1 you win
	-1 you tied
***/




/**
 This will check to see if you won the game and 
 update UI elements based of this.
 */
public static void checkPlay(int res,JLabel jl,JLabel wins)
{
	if(res == 1)
	{
		wc++;
		jl.setText("you won");
		wins.setText("Wins : " + wc);
	}
	else if(res == 0)
	{
		jl.setText("You lost");
	}
	else if(res ==  -1)
	{
		jl.setText("You tied");
	}

}
public static int playRPS(String hand,JLabel cpr)
{
	Random r = new Random();
	int num = r.nextInt(3)+1;
	if(num == 1)
	{
		cpr.setText("rock");
	}
	else if(num == 2)
	{
		cpr.setText("paper");
	}
	else
	{
		cpr.setText("scissor");
	}
	if(hand.equals("rock"))
		
	{
		if(num == 1)
		{
			return -1;
		}
		else if(num == 2)
		{
			return  0;
		}
		else if(num == 3)
		{
			return 1;
		}
	}
	else if(hand.equals("paper"))
	{
		if(num == 1)
		{
			return 1;
		}
		else if(num == 2)
		{
			return  -1;
		}
		else if(num == 3)
		{
			return 0;
		}
	}
	else if(hand.equals("scissor"))
	{
		if(num == 1)
		{
			return 0;
		}
		else if(num == 2)
		{
			return  1;
		}
		else if(num == 3)
		{
			return -1;
		}	
	}
	return -10;
	
}
public static void main(String args[])
{
	
	JFrame test = new JFrame("");
	//test.setBounds(50,50,200,200);
	test.setSize(1000,1000);
	test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Container cp = test.getContentPane();
	JLabel jl = new JLabel("testing");
	
	JButton rock = new JButton("Rock");
	JButton paper = new JButton("Paper");
	GridLayout gl = new GridLayout(0,3);
	JButton scizzor = new JButton("Scissor");
	JLabel cpr = new JLabel("");
	JLabel wins = new JLabel("");
	rock.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent a)
		{
			jl.setText("You Played Rock");
			int res = playRPS("rock",cpr);
			checkPlay(res,jl,wins);
					}
	});
	paper.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent a)
		{
			jl.setText("You Played Paper");
			int res = playRPS("paper",cpr);
			checkPlay(res,jl,wins);
		}
	});
	scizzor.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent a)
		{
			jl.setText("You Played Scissor");
			int res = playRPS("scissor",cpr);
			checkPlay(res,jl,wins);
		}
	});
	cp.add(rock);
	cp.add(paper);
	cp.add(scizzor);
	cp.add(jl);
	cp.add(cpr);
	cp.add(wins);
	test.setLayout(gl);
	test.pack();
	test.setVisible(true);
}

@Override
public void actionPerformed(ActionEvent arg0) {
	
	
}
}
