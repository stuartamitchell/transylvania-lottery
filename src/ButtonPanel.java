import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class ButtonPanel extends JPanel
{
	private JButton drawLottery;
	
	public ButtonPanel()
	{
		super();
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.drawLottery = new JButton("Draw Lottery");
		this.add(this.drawLottery, gbc);
	}
	
	public JButton getDrawLottery()
	{
		return this.drawLottery;
	}
	
	public void setDrawLotter(JButton drawLottery)
	{
		this.drawLottery = drawLottery;
	}
}
