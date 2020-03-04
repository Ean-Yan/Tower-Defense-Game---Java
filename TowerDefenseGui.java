import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import java.awt.Font;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;

@SuppressWarnings("serial")
public class TowerDefenseGui extends JFrame {

	private MousePanel panel;
	private JLabel lblMoney;

	private int money;
	private int health;

	private JLabel lblHealth;

	public TowerDefenseGui() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(1190, 670));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{95, 860, 0};
		gridBagLayout.rowHeights = new int[]{41, 27, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, 0, 0, -1, 109, 120, 9, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

		money = 100;
		health = 100;

		JLabel lblNewLabel_5 = new JLabel(" ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 0;
		getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);

		panel = new MousePanel(this);
		panel.setBackground(Color.LIGHT_GRAY);;
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.weightx = 0.5;
		gbc_panel.gridheight = 18;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);





		//Pause
		JButton btnPause = new JButton("  Pause  ");
		btnPause.setFont(new Font("Arial", Font.PLAIN, 18));
		btnPause.setSize(new Dimension(50, 50));
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setStartGame(false);
			}
		});



		//Start
		JButton btnStart = new JButton("Start");
		btnStart.setFont(new Font("Arial Unicode MS", Font.PLAIN, 18));
		btnStart.setSize(new Dimension(50, 50));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel.setStartGame(true);
			}
		});
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.fill = GridBagConstraints.BOTH;
		gbc_btnStart.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart.gridx = 0;
		gbc_btnStart.gridy = 3;
		getContentPane().add(btnStart, gbc_btnStart);
		

		//get component		

		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panel,lblNewLabel_5, btnStart, btnPause, lblHealth, lblMoney}));
		GridBagConstraints gbc_btnPause = new GridBagConstraints();
		gbc_btnPause.fill = GridBagConstraints.BOTH;
		gbc_btnPause.insets = new Insets(0, 0, 5, 5);
		gbc_btnPause.gridx = 0;
		gbc_btnPause.gridy = 4;
		getContentPane().add(btnPause, gbc_btnPause);


		//-------
		JLabel seperet = new JLabel("-----------------");
		GridBagConstraints gbc_seperet = new GridBagConstraints();
		gbc_seperet.insets = new Insets(0, 0, 5, 5);
		gbc_seperet.gridx = 0;
		gbc_seperet.gridy = 6;
		getContentPane().add(seperet, gbc_seperet);
		JLabel seperet2 = new JLabel("-----------------");
		GridBagConstraints gbc_seperet2 = new GridBagConstraints();
		gbc_seperet2.insets = new Insets(0, 0, 5, 5);
		gbc_seperet2.gridx = 0;
		gbc_seperet2.gridy = 7;
		getContentPane().add(seperet2, gbc_seperet2);



		//Labels
		JLabel lblLevel = new JLabel("Wave 1");
		lblLevel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblLevel.setFont(new Font("Arial Unicode MS", Font.PLAIN, 17));
		GridBagConstraints gbc_lblLevel = new GridBagConstraints();
		gbc_lblLevel.insets = new Insets(0, 0, 5, 5);
		gbc_lblLevel.gridx = 0;
		gbc_lblLevel.gridy = 9;
		getContentPane().add(lblLevel, gbc_lblLevel);

		JLabel lblMap = new JLabel("Enemys: 6");
		lblMap.setFont(new Font("Arial Unicode MS", Font.PLAIN, 17));
		GridBagConstraints gbc_lblMap = new GridBagConstraints();
		gbc_lblMap.insets = new Insets(0, 0, 5, 5);
		gbc_lblMap.gridx = 0;
		gbc_lblMap.gridy = 10;
		getContentPane().add(lblMap, gbc_lblMap);

		lblHealth = new JLabel("Health 100");
		lblHealth.setFont(new Font("Arial Unicode MS", Font.PLAIN, 17));
		GridBagConstraints gbc_lblHealth = new GridBagConstraints();
		gbc_lblHealth.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealth.gridx = 0;
		gbc_lblHealth.gridy = 11;
		getContentPane().add(lblHealth, gbc_lblHealth);

		lblMoney = new JLabel("$ 100");
		lblMoney.setFont(new Font("Arial Unicode MS", Font.PLAIN, 17));
		GridBagConstraints gbc_lblMoney = new GridBagConstraints();
		gbc_lblMoney.insets = new Insets(0, 0, 5, 5);
		gbc_lblMoney.gridx = 0;
		gbc_lblMoney.gridy = 12;
		getContentPane().add(lblMoney, gbc_lblMoney);


		JLabel label = new JLabel("------------------");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 14;
		getContentPane().add(label, gbc_label);

		//Tower 1 
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setTowerIndex(0);
				panel.setDrawTheTower(true);
				panel.setPressed(true);

			}
		});
		btnNewButton_2.setIcon(new ImageIcon("G:\\Eclipse_WorkSpace\\TowerDefence\\Tower1-icon.png"));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 15;
		getContentPane().add(btnNewButton_2, gbc_btnNewButton_2);

		//Tower 2
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setTowerIndex(1);
				panel.setDrawTheTower(true);
				panel.setPressed(true);

			}
		});
		btnNewButton_3.setIcon(new ImageIcon("G:\\Eclipse_WorkSpace\\TowerDefence\\Tower2-icon.png"));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 16;
		getContentPane().add(btnNewButton_3, gbc_btnNewButton_3);

		//Tower3
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setTowerIndex(2);
				panel.setDrawTheTower(true);
				panel.setPressed(true);

			}
		});
		btnNewButton_4.setIcon(new ImageIcon("G:\\Eclipse_WorkSpace\\TowerDefence\\Tower3-icon.png"));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 17;
		getContentPane().add(btnNewButton_4, gbc_btnNewButton_4);
		setVisible(true);


	}

	public int getHealth() {
		return health;
	}

	public void reduceHealth(int amount) {
		this.health -= amount;
		lblHealth.setText("Health: " + health);
	}

	public int getMoney() {
		return money;
	}
	
	public void reduceMoney(int amount) {
		this.money-=amount;
		lblMoney.setText("$ " + money);
	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		TowerDefenseGui g = new TowerDefenseGui();
	}

}
