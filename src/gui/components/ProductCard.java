package gui.components;

import java.awt.*;
import javax.swing.*;

import gui.factory.FontFactory;
import gui.factory.LabelFactory;
import order.Product;

public class ProductCard extends JPanel{
	
	private ImageIcon productImage;
	private JLabel productimgLabel;
	private JLabel titleLabel;
	private JLabel descLabel;
	private JLabel priceLabel;
	private ImageIcon plusIcon;
	private JLabel plusButtonLabel;
	private Product product;
	
	
	public  JPanel createPanel(Product product) {
		
		this.product = product;
		
		this.setLayout(null);
		this.setPreferredSize(new Dimension(325,120));
		this.setBackground(Color.white);
	
		configureComponents();
	
		this.add(productimgLabel);
		this.add(titleLabel);
		this.add(descLabel);
		this.add(plusButtonLabel);
		this.add(priceLabel);
		return this;
	}
	
	public void configureComponents(){
		productImage = new ImageIcon(product.getPath());
		productimgLabel = LabelFactory.createIconLabel(productImage);
		productimgLabel.setBounds(10, 10, 100, 100);
		
		titleLabel = LabelFactory.createLabel(product.getName(), Color.BLACK, FontFactory.poppins(14));
		titleLabel.setBounds(120,20,200,17);
		
		descLabel = LabelFactory.createLabel(product.getDescription(), Color.GRAY, FontFactory.poppins(12));
		descLabel.setBounds(120, 35, 200, 17);
		
		plusIcon = new ImageIcon("./buttonImages/plus.png");
		plusButtonLabel = LabelFactory.createIconLabel(plusIcon);
		plusButtonLabel.setIcon(plusIcon);
		plusButtonLabel.setBounds(285, 85, 24, 24);
		plusButtonLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		priceLabel = LabelFactory.createLabel(product.getPrice() + "€", Color.BLACK, FontFactory.poppins(13));
		priceLabel.setBounds(286, 65, 43, 19);
		
		
	}

	public JLabel getPriceLabel() {
		return priceLabel;
	}

	public void setPriceLabel(JLabel priceLabel) {
		this.priceLabel = priceLabel;
	}
	
	
	
	
	
}
