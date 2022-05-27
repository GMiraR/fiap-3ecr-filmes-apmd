package br.com.fiap.movies.view;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import br.com.fiap.movies.controller.MovieController;
import br.com.fiap.movies.view.util.ListingPanel;
import br.com.fiap.movies.view.util.RegisterEditPanel;

public class WindowView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JTabbedPane tabs = new JTabbedPane();
	
	private MovieController movieController = new MovieController(this);
	
	private RegisterEditPanel editPanel = new RegisterEditPanel(movieController);
	private ListingPanel listingPanel = new ListingPanel(movieController);
	
	public WindowView() {
		setSize(800, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	public void init() {
		
		editPanel.init();
		listingPanel.init();
		
		tabs.add(editPanel, "Register");
		tabs.add(listingPanel, "Movie List" );
		add(tabs);
		setVisible(true);
	}

	public ListingPanel getListing() { return listingPanel; }
	
	public RegisterEditPanel getEditPanel() { return editPanel; }
}
