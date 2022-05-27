package br.com.fiap.movies.view.util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class DefaultLabel extends JLabel {
	
	private static final long serialVersionUID = 1L;

	public DefaultLabel(String text) {
		this.setText(text);
		init();
	}
	
	private void init() {
		this.setForeground(new Color(80,80,80));
		this.setFont(new Font("Arial", Font.BOLD, 16));
	}
}
