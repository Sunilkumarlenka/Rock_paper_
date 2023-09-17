import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Game extends JFrame {
	
	//Create label for Computer Choice and for result
	JLabel computerChoice , result,result1;
	
	//Create label for Display Score
	JLabel computerScore, PlayerScore;
	int player_score=0;
	int computer_score=0;
	
	ImageIcon image_rock , image_paper , image_scissor;
	public void setup() {
		image_rock= new ImageIcon(new ImageIcon("rock.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		image_paper= new ImageIcon(new ImageIcon("paper.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		image_scissor= new ImageIcon(new ImageIcon("scissor.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		
		
		//Create label
		JLabel score= new JLabel("Score");
		score.setBounds(500,0,100,100);
		
		computerScore=new JLabel();
		computerScore.setText("Computer : 0");
		computerScore.setBounds(500, 15, 100, 100);
		
		PlayerScore = new JLabel();
		PlayerScore.setText("Player : 0");
		PlayerScore.setBounds(500,30,100,100);
		
		
		//For Computer Choice
		computerChoice= new JLabel();
		computerChoice.setHorizontalTextPosition(JLabel.CENTER);
		computerChoice.setVerticalTextPosition(JLabel.BOTTOM);
		computerChoice.setBounds(250, 90, 100, 100);
		
		//For Result
		result= new JLabel();
		result.setFont(new Font("Serif" , Font.BOLD , 20));
		result.setBounds(250, 450, 100, 100);
		
		JLabel lable_computer= new JLabel();
		lable_computer.setText("Computer");
		lable_computer.setFont(new Font("Serif" , Font.BOLD , 20));
		lable_computer.setBounds(254,150,100,100);
		
		JLabel lable_vs=new JLabel();
		lable_vs.setText("V/S");
		lable_vs.setFont(new Font("Serif" , Font.BOLD , 20));
		lable_vs.setBounds(278,185,100,100);
		
		JLabel lable_player= new JLabel();
		lable_player.setText("Player");
		lable_player.setFont(new Font("Serif" , Font.BOLD , 20));
		lable_player.setBounds(270,220,100,100);
		
		
		/*
		 * For Result1 result1= new JLabel(); result1.setFont(new Font("Serif" ,
		 * Font.BOLD , 20)); result1.setBounds(0,0,100,100);
		 */
		
		//1.For Rock
		JLabel lable_rock=new JLabel();
		lable_rock.setText("Rock");
		lable_rock.setIcon(image_rock); //set icon
		lable_rock.setHorizontalTextPosition(JLabel.CENTER);
		lable_rock.setVerticalTextPosition(JLabel.BOTTOM);
		lable_rock.setBounds(150,300,100,100);
		
		//2.For Paper
		JLabel lable_paper=new JLabel();
		lable_paper.setText("Paper");
		lable_paper.setIcon(image_paper); //set icon
		lable_paper.setHorizontalTextPosition(JLabel.CENTER);
		lable_paper.setVerticalTextPosition(JLabel.BOTTOM);
		lable_paper.setBounds(250,300,100,100);
		
		//3.For Scissor
		JLabel lable_scissor=new JLabel();
		lable_scissor.setText("Scissor");
		lable_scissor.setIcon(image_scissor); //set icon
		lable_scissor.setHorizontalTextPosition(JLabel.CENTER);
		lable_scissor.setVerticalTextPosition(JLabel.BOTTOM);
		lable_scissor.setBounds(350,300,100,100);
		
		//Add Mouse Listener
		//For Rock
		lable_rock.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//call calculate method
				calculate(lable_rock.getText());
			}
		});
		
		//For Paper
		lable_paper.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//call calculate method
				calculate(lable_paper.getText());
			}
		});
		
		//For Scissor
		lable_scissor.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//call calculate method
				calculate(lable_scissor.getText());
			}
		});
		
		
		//add component in frame
		add(lable_rock);
		add(lable_paper);
		add(lable_scissor);
		add(computerChoice);
		add(result);
		add(score);
		add(computerScore);
		add(PlayerScore);
		add(lable_computer);
		add(lable_vs);
		add(lable_player);
		setLayout(null);
	}
	
	public void calculate(String player) {
		String[] list= {"Rock" , "Paper" , "Scissor"};
		int random_choice=(int)((Math.random()*10)%3);
		String computer=list[random_choice];
		
		//Display Computer Choice
		computerChoice.setText(computer);
		if(random_choice==0) {
			computerChoice.setIcon(image_rock);
		}
		else if(random_choice==1) {
			computerChoice.setIcon(image_paper);
		}
		else {
			computerChoice.setIcon(image_scissor);
		}
		
		//Logic
		String res="";
		if(player.equals(computer)) {
			res="Draw";
		}
		
		else if(player.equals("Rock")) {
			if(computer.equals("Paper")) {
			res="You Lose";
			computer_score++;
			}
			else {
				res="You Win";
				player_score++;
			}
		}
		else if(player.equals("Paper")) {
			if(computer.equals("Scissor")) {
				res="You Lose";
				computer_score++;
			}
			else {
				res="You Win";
				player_score++;
			}
		}
		else {
			if(computer.equals("Rock")) {
				res="You Lose";
				computer_score++;
			}
			else {
				res="You Win";
				player_score++;
			}
		}
		result.setText(res);
		PlayerScore.setText("Player :"+player_score);
		computerScore.setText("Computer:"+computer_score);
	}
	

	public static void main(String[] args) {
		
		//Create Frame;
		Game g= new Game();
		g.setTitle("ROCK PAPER SCISSOR GAME...");
		g.setBounds(200,100,600,600);
		g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		g.getContentPane().setBackground(new java.awt.Color(215, 198, 244));
		g.setup();
		g.setResizable(false);
		g.setVisible(true);
		
		
	}

}
