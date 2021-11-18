import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class TransylvaniaLottery extends JFrame implements ActionListener 
{	
	private JFrame mainWindow;
	private JPanel mainPanel;
	private LotteryPanel lotteryPanel;
	private ButtonPanel buttonPanel;
	
	public TransylvaniaLottery()
	{
		super("Transylvania Lottery");
		this.mainPanel = new JPanel();
		this.mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.mainPanel.setLayout(new BorderLayout());
		this.lotteryPanel = new LotteryPanel();
		this.buttonPanel = new ButtonPanel();
		this.buttonPanel.getDrawLottery().addActionListener(this);
		this.mainPanel.add(lotteryPanel, BorderLayout.NORTH);
		this.mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		this.add(mainPanel);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		int[] lotteryNumbers = this.drawNumbers();
		this.lotteryPanel.updateLabels(lotteryNumbers);
		this.revalidate();
	}
	
	public int[] drawNumbers()
	{
		Random rand = new Random();
		int[] numbers = new int[3];
		
		numbers[0] = rand.nextInt(7) + 1;
		
		do
		{
			numbers[1] = rand.nextInt(7) + 1;
		} while (numbers[1] == numbers[0]);
		
		do
		{
			numbers[2] = rand.nextInt(7) + 1;
		} while (numbers[2] == numbers[0] || numbers[2] == numbers[1]);
		
		int temp;
		
		if (numbers[0] < numbers[1])
		{
			if (numbers[0] < numbers[2])
			{
				if (numbers[1] > numbers[2])
				{
					temp = numbers[1];
					numbers[1] = numbers[2];
					numbers[2] = temp;
				}
			}
			else
			{
				temp = numbers[0];
				numbers[0] = numbers[2];
				numbers[2] = numbers[1];
				numbers[1] = temp;
			}
		}
		else
		{
			if (numbers[1] < numbers[2])
			{
				if (numbers[0] < numbers[2])
				{
					temp = numbers[0];
					numbers[0] = numbers[1];
					numbers[1] = temp;
				}
				else
				{
					temp = numbers[0];
					numbers[0] = numbers[1];
					numbers[1] = numbers[2];
					numbers[2] = temp;
				}
			}
			else
			{
				temp = numbers[0];
				numbers[0] = numbers[2];
				numbers[2] = temp;
			}
		}
		
		return numbers;
	}

	public static void main(String[] args)
	{
		TransylvaniaLottery transLot = new TransylvaniaLottery();
	}

}
