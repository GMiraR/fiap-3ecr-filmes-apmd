package br.com.fiap.movies.view.util;

import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import br.com.fiap.movies.controller.MovieController;
import br.com.fiap.movies.domain.Movie;

public class ListingPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private String[] columns = {"id", "title", "synopsis", "genero", "streaming", "watched", "rating"};
	private DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
	private JTable table = new JTable(tableModel);
	private JScrollPane scrollPanel = new JScrollPane(table);
	
	private JButton deleteButton = new JButton("Delete");
	
	private MovieController movieController;
	
	public ListingPanel(MovieController movieController) {
		this.movieController = movieController;
	}
	
	public void init() {
		setLayout(null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		 a = ;
		scrollPanel.setBounds(0 ,0,
				800, 300);
		this.add(scrollPanel);
		
		deleteButton.setBounds(10, 300, 100, 30);
		deleteButton.addActionListener((ActionEvent e)->{
			String id = (String) table.getValueAt(table.getSelectedRow(), 0);
			movieController.delete(Long.parseLong(id,10));
		});
		this.add(deleteButton);
		update();
	}
	
	public void update() {
		tableModel.setRowCount(0);
		List<Movie> movies = movieController.listMovies();
		movies.forEach(movie -> tableModel.addRow(movie.getDataArray()));
	}
	

}
