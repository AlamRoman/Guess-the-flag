package view;

import javax.swing.ImageIcon;

import control.HardcoreController;
import model.ImageLoader;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Color;

public class HardcorePanel extends FlagQuizPanel{
	
	private ImageIcon heart;
	private ImageIcon emptyHeart;
	
	private final int MAX_HEART = 5;
	private int nHeart;
	
	private JPanel panelHearts;

	public HardcorePanel() {
		super();
		lblTitle.setText("Hardcore Mode");
		
		nHeart = MAX_HEART - 1;
		
		ImageLoader imageLoader = new ImageLoader();
		
		heart = imageLoader.getImageFrom("resources/heart.png");
		heart = imageLoader.scaleImage(heart, 27, 27);
		
		emptyHeart = imageLoader.getImageFrom("resources/empty-heart.png");
		emptyHeart = imageLoader.scaleImage(emptyHeart, 21, 21);
		
		//hearts container
		panelHearts = new JPanel();
		panelHearts.setBackground(new Color(208, 255, 255));
		panelHearts.setBounds(21, 72, 172, 33);
		add(panelHearts);
		panelHearts.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		showHearts();
	}
	
	public void addListener(HardcoreController controller) {
		
		btnBack.addActionListener(controller);
		
		btnOption1.addActionListener(controller);
		btnOption2.addActionListener(controller);
		btnOption3.addActionListener(controller);
		btnOption4.addActionListener(controller);
	}
	
	public void showHearts() {
		
		for (int i = 0; i < MAX_HEART; i++) {
			if (i < nHeart) {
				panelHearts.add(new JLabel(heart));
			}else {
				panelHearts.add(new JLabel(emptyHeart));
			}
		}
	
	}
}
