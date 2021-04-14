//Name: Sunayana Ambakanti
//Tic-Tac-Toe Game


import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Assignment10 extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int rows,columns;// rows and colums position
	JButton[][] layout=new JButton[3][3];
	String humanMove="X";// Human move indicates with X
	String computerMove="O";//Computer move indicates with O
	int computer=1, human=2;;
	int i=0,v=0,cnt=0;
	JButton jbtn=new JButton("Play");
	public int grid=3;
	JLabel jl=new JLabel();
	private JFrame introscreen ; // Screen for intruduction
	
	public void popupintroscreen(){// method for help button
		// Creating help button to show Name and instructions
		JButton showinstructions = new JButton("Help");
        showinstructions.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent displayinstructionsprompt)
            {
              JOptionPane.showMessageDialog(null, "Game implementer: SUNAYANA AMBAKANTI \r\n"+ "Click on OK for game Rules");
              JOptionPane.showMessageDialog(null, "Game Rules: \r\n"+"Rule 1: If I have a winning move, take it.\r\n" + 
              		"Rule 2: If the opponent has a winning move, block it.\r\n" + 
              		"Rule 3: If I can create a fork (two winning ways) after this move, do it.\r\n" + 
              		"Rule 4: Do not let the opponent creating a fork after my move. (Opponent may block your winning move and create a fork.)\r\n" + 
              		"Rule 5: Place in the position such as I may win in the most number of possible ways.");
              
             
            }
        });
        
        JPanel gamebuttonsholder = new JPanel(new BorderLayout());
        gamebuttonsholder.add(showinstructions,BorderLayout.CENTER);// Displays the help button
        
        introscreen = new JFrame("Tic-Tac-Toe");
        introscreen.setSize(100,100);
        introscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// game will exit when closes the x button
        introscreen.setLocationRelativeTo(null);
        introscreen.add(gamebuttonsholder);
        introscreen.setVisible(true);
        
	}
	
	Assignment10()// Method for layout
	 { 
		 setLayout(new GridLayout(4, 3));// creates grid
		 setVisible(true);
		 setTitle("Tic-Tac-Toe Game");// title of the game
		 setSize(400,400);
		 setResizable(false);// resize is not possible	 
	 }
	 public void initialization()
	 {
		 for(i=0;i<3;i++)
		 {
			 for(v=0;v<3;v++)
			 {
				 layout[i][v]=new JButton();
				 layout[i][v].addActionListener(this);
				 add(layout[i][v]);
				 layout[i][v].setEnabled(true);
			 }
		 }
	 }
	 
	 public void statusMessage()
	 {
		 jl.setBounds(78, 190, 85, 20);
		 add(jl);
    }

	 boolean isMoveLeft(JButton[][] b) throws InterruptedException
		 {
			 
			for(i=0;i<3;i++)
			 {
				 for(v=0;v<3;v++)
				 {
					 String getText_Board=b[i][v].getText();
					 if(getText_Board.equals(""))
					 {
						Thread.sleep(60);
						 b[i][v].setText("O");
						
						 b[i][v].setEnabled(false);
						 return true;
					 }
				 }
			 }
		
			 return false;
		 }
		
		    
		
			boolean rowCrossed(JButton[][] board)
			{
				String boards0 = null, boards1=null, boards2=null;
				for(i=0;i<grid;i++)
				{
					 boards0=board[i][0].getText();
					 boards1=board[i][1].getText();
					 boards2=board[i][2].getText();
					
					if(boards0.equals("X")&&boards1.equals("X")&&boards2.equals("X"))
					{
						jl.setText("Winner: Player");
						return true;
					}
					else if(boards0.equals("O")&&boards1.equals("O")&&boards2.equals("O"))
					{
						jl.setText("Winner: Computer");
						return true;
					}
					
				}
				
				return false;
			}	
		    
			boolean columnsCrossed(JButton[][] board)
			{
				for(i=0;i<grid;i++)
				{
					String board0s=board[0][i].getText();
					String board1s=board[1][i].getText();
					String board2s=board[2][i].getText();
					if(board0s.equals("X")&&board1s.equals("X")&&board2s.equals("X"))
					{
						jl.setText("Winner: Player");
						return true;
					}
					else if(board0s.equals("O")&&board1s.equals("O")&&board2s.equals("O"))
					{
						jl.setText("Winner: Computer");
						return true;
					}
				}	
				return false;
			}
			boolean diagonalCrossed(JButton[][] board) 
			{ 
			   
				String board00=board[0][0].getText();
				String board11=board[1][1].getText();
				String board22=board[2][2].getText();
				String board02=board[0][2].getText();
				String board20=board[2][0].getText();
				
				if (board00.equals("X") && board11.equals("X")&&board22.equals("X"))
				{
					jl.setText("Winner: Player");
			        return true; 
				}
				
			          
				else  if (board02.equals("X") && board11.equals("X")&&board20.equals("X")) 
			    {
			    	jl.setText("Winner: Player");
			    	return true ; 
			    }
				else  if (board00.equals("O") && board11.equals("O")&&board22.equals("O"))
				{
			    	jl.setText("Winner: Computer");
			        return true; 
				}
				
			          
				else   if (board02.equals("O") && board11.equals("O")&&board20.equals("O")) 
			    {
			    	jl.setText("Winner: Computer");
			    	return true ; 
			    }
				
			    return false; 
			}
			
			boolean draw(JButton[][] board)
			{
				for(i=0;i<grid;i++)
				{
					String boards0=board[i][0].getText();
					String boards1=board[i][1].getText();
					String boards2=board[i][2].getText();
					String board0s=board[0][i].getText();
					String board1s=board[1][i].getText();
					String board2s=board[2][i].getText();
					String board00=board[0][0].getText();
					String board11=board[1][1].getText();
					String board22=board[2][2].getText();
					String board02=board[0][2].getText();
					String board20=board[2][0].getText();
					if(!boards0.equals(boards1)&&!boards1.equals(boards2)&&!boards0.equals(boards2)||
							!board0s.equals(board1s)&&!board1s.equals(board2s)&&!board0s.equals(board2s)||
							!board00.equals(board11)&&!board11.equals(board22)&&!board00.equals(board22)||
							!board02.equals(board11)&&!board11.equals(board20)&&!board02.equals(board20))
					{
						jl.setText("Draw");
						return true;
					}
				}
							return false;
					 
			}
		    
		
		  
	JButton jb;
	public void actionPerformed(ActionEvent e) 
	{
		jb=(JButton)e.getSource();
		jb.setText("X");
		jb.setEnabled(false);
		rowCrossed(layout);
		columnsCrossed(layout);
		diagonalCrossed(layout);
		// TODO Auto-generated method stub
			try {
				isMoveLeft(layout);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	 
	public static void main(String[] args) // Main method
	{  
		Assignment10 assign=new Assignment10();
        assign.initialization();
        assign.popupintroscreen(); // calling help button method
        assign.statusMessage(); // calling status messgae method
       
     }
}