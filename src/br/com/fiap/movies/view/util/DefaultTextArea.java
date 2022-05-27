package br.com.fiap.movies.view.util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

public class DefaultTextArea extends JTextArea{


	private static final long serialVersionUID = 1L;
	
	private int column = 30;
	private int row = 5;

	public DefaultTextArea() {
		init();
	}

	private void init() {
		this.setColumns(column);
		this.setRows(row);
		this.setBorder(new LineBorder(new Color(50, 50, 50)));
		this.setFont(new Font("Arial", Font.ITALIC, 16));
		
	}
}
