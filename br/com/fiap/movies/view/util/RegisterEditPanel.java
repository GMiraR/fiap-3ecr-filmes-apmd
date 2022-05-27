package br.com.fiap.movies.view.util;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import br.com.fiap.movies.controller.MovieController;

public class RegisterEditPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel image = new JLabel(new ImageIcon("src/images/frank.jpeg"));
	
	private DefaultLabel title = new DefaultLabel("Title");
	private DefaultTextField titleText = new DefaultTextField();
	
	private DefaultLabel synopsis = new DefaultLabel("Synopsis");
	private DefaultTextArea synopsisText = new DefaultTextArea();

	private DefaultLabel genre = new DefaultLabel("Genre");
	private JComboBox<String> genreCheckBox
			= new JComboBox<>(new String[]{ "Horror",	"Comedy",	"Cult",	"Classic"});

	private DefaultLabel streaming = new DefaultLabel("Streaming Platform");

	private DefaultLabel rating = new DefaultLabel("Rating");
	
	private JButton save = new JButton();
	private JButton cancel = new JButton();
	
	private MovieController movieController;
	
	public RegisterEditPanel(MovieController movieController) {
		setLayout(null);
		this.movieController = movieController;
	}
	
	public void init() {
	    
		image.setBounds(40, 35, 180, 250);
		resizeImage(image);
		this.add(image);

		title.setBounds(
				image.getX() + image.getWidth() + 50, 28, 100, 15);
		this.add(title);

		titleText.setBounds(
				title.getX(),
				title.getY()+ title.getHeight()+10,250,29);
		this.add(titleText);

		synopsis.setBounds(
				titleText.getX(),
				titleText.getY()+ titleText.getHeight()+20, 100, 15);
		this.add(synopsis);

		synopsisText.setBounds(
				synopsis.getX(),
				synopsis.getY()+ synopsis.getHeight()+10, 250, 60);
		this.add(synopsisText);

		genre.setBounds(
				synopsisText.getX(),
				synopsisText.getY()+ synopsisText.getHeight()+20, 100, 15);
		this.add(genre);

		genreCheckBox.setBounds(
				genre.getX(),
				genre.getY()+ genre.getHeight()+10, 250, 29);

		genreCheckBox.setFont(new Font("Arial", Font.BOLD, 16));

		this.add(genreCheckBox);
		
		save.setBounds(
				genreCheckBox.getX(),
				genreCheckBox.getY()+ genreCheckBox.getHeight()+20, 100,38);
		save.setFont(new Font("Arial", Font.BOLD, 14));
		save.setText("Save");
		this.add(save);
		
		cancel.setBounds(
				save.getX()+ save.getWidth()+15,
				save.getY(), 140, 38);
		cancel.setFont(new Font("Arial", Font.BOLD, 14));
		cancel.setText("Cancel");
		this.add(cancel);

		streaming.setBounds(
				titleText.getX() + titleText.getWidth() + 50,
				title.getY(),150, 15);
		this.add(streaming);
		
		ButtonGroup genreGroupBtn = new ButtonGroup();
		
        JRadioButton radio1 = new JRadioButton();
        radio1.setText("Netflix");
        radio1.setBounds(
        		streaming.getX(),
        		streaming.getY() + streaming.getHeight() + 15, 150, 15);

        radio1.setFont(new Font("Arial", Font.BOLD, 15));
        
        genreGroupBtn.add(radio1);
        
        JRadioButton radio2 = new JRadioButton();
        radio2.setText("Prime Video");
        radio2.setBounds(
        		radio1.getX(),
        		radio1.getY() + radio1.getHeight() + 10, 150, 15);

        radio2.setFont(new Font("Arial", Font.BOLD, 15));
        
        genreGroupBtn.add(radio2);
        
        JRadioButton radio3 = new JRadioButton();
        radio3.setText("Combo Plus");
        radio3.setBounds(
        		radio2.getX(),
        		radio2.getY() + radio2.getHeight() + 10, 150, 15);

        radio3.setFont(new Font("Arial", Font.BOLD, 15));
        
        genreGroupBtn.add(radio3);
        
        this.add(radio1);
        this.add(radio2);
        this.add(radio3);
        
        JCheckBox watched = new JCheckBox("Watched");
        watched.setBounds(
        		radio3.getX(),
        		radio3.getY() + radio3.getHeight() + 20, 150, 15);
        watched.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(watched);

        rating.setBounds(
        		watched.getX(),
        		watched.getY() + watched.getHeight() + 20, 150, 15);
        this.add(rating);
        
        StarRater starRatingField = new StarRater(5);
        starRatingField.setBounds(
        		rating.getX(),
        		rating.getY() + rating.getHeight() + 15, 150, 15);
        this.add(starRatingField);

		save.addActionListener((ActionEvent e)->{
			boolean invalid = titleText.getText().equalsIgnoreCase("");
			invalid = invalid || synopsisText.getText().equalsIgnoreCase("");
			invalid = invalid || ((String) genreCheckBox.getSelectedItem()).equalsIgnoreCase("");
			invalid = invalid || !( radio1.isSelected()
					|| radio2.isSelected()
					|| radio3.isSelected());
			invalid = invalid || starRatingField.getSelection() == 0;
			
			if(invalid) {
				JOptionPane.showMessageDialog(null, "Field error!");
				return;
			}
			movieController.save(
					titleText.getText(),
					synopsisText.getText().trim(),
					(String) genreCheckBox.getSelectedItem(),
					radio1.isSelected() ? radio1.getText()
							: radio2.isSelected() ? radio2.getText()
							: radio3.isSelected() ? radio3.getText()
							: "None",
					watched.isSelected(),
					starRatingField.getSelection()
					);	
		});
		cancel.addActionListener((ActionEvent e)->{
			titleText.setText("");
			synopsisText.setText("");
			genreCheckBox.setSelectedIndex(0);
			genreGroupBtn.clearSelection();
			starRatingField.setSelection(0);
			watched.setSelected(false);
		});
		setVisible(true);
	}
	
	public void resizeImage(JLabel imagem) {
		imagem.setBounds(imagem.getX(), imagem.getY(), imagem.getWidth(), imagem.getHeight());
		ImageIcon myImage = (ImageIcon) imagem.getIcon();
        Image image = myImage.getImage();
        Image scaledImage = image.getScaledInstance(imagem.getWidth(), imagem.getHeight(),Image.SCALE_SMOOTH);
        imagem.setIcon( new ImageIcon(scaledImage) );
	}
}
