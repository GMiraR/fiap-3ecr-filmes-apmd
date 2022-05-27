package br.com.fiap.movies.view.util;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class DefaultTextField extends JTextField{

	private static final long serialVersionUID = 1L;

		public DefaultTextField() {
			super(20);
			init();
		}

		private void init() {
			this.setForeground(new Color(50,50,50));
			this.setBackground(Color.white);
			this.setBorder(new LineBorder(new Color(50, 50, 50)));
			this.setBorder(BorderFactory.createCompoundBorder(
			        this.getBorder(), 
			        BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		}
}
