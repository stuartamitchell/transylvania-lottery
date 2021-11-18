import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LotteryPanel extends JPanel
{
	private JLabel number1;
	private JLabel number2;
	private JLabel number3;
	
	public LotteryPanel()
	{
		super();
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridy = 0;
		
		gbc.gridx = 0;
		number1 = this.initLabel("0");
		this.add(number1, gbc);
		
		gbc.gridx = 1;
		JLabel blank1 = this.initLabel(" ");
		this.add(blank1, gbc);
		
		gbc.gridx = 2;
		number2 = this.initLabel("0");
		this.add(number2, gbc);
		
		gbc.gridx = 3;
		JLabel blank2 = this.initLabel(" ");
		this.add(blank2, gbc);
		
		gbc.gridx = 4;
		number3 = this.initLabel("0");
		this.add(number3, gbc);
	}
	
	private JLabel initLabel(String text)
	{
		JLabel label = new JLabel(text);
		label.setFont(new Font("Verdana", Font.PLAIN, 150));
		
		return label;
	}
	
	public void updateLabels(int[] numbers)
	{
		this.number1.setText(Integer.valueOf(numbers[0]).toString());
		this.number2.setText(Integer.valueOf(numbers[1]).toString());
		this.number3.setText(Integer.valueOf(numbers[2]).toString());
	}
}
