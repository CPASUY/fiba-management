package ui;

import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


import java.io.IOException;
import java.util.ArrayList;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.AVL;
import model.BST;
import model.Player;

public class Fiba_Controller {
	//Constant
	public static final String PLAYERS_FILE_NAME="data/DataPlayers.csv";
	@FXML
	private BorderPane basePane;
	private Stage stage;
	private Player p;
	private AVL<String,Integer>[] avls;
	private BST<String,Integer> bst;
	@FXML
	private TableView<Player> tablePlayers;

	@FXML
	private TableColumn<Player, String> idName;

	@FXML
	private TableColumn<Player, String> idLast_Name;

	@FXML
	private TableColumn<Player, Integer> idAge;

	@FXML
	private TableColumn<Player, String> idTeam;

	@FXML
	private TableColumn<Player, Integer> idPoints;

	@FXML
	private TableColumn<Player, Integer> idRebounds;

	@FXML
	private TableColumn<Player, Integer> idAssists;

	@FXML
	private TableColumn<Player, Integer> idRobberies;
	
	@FXML
	private TableColumn<Player, Integer> idBlocks;

	public Fiba_Controller(Stage s) throws IOException, CsvException {
		stage=s;
		avls = null;
		bst = null;
	}
	public void initialize() {
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				System.out.println("Closing the window!");
			}
		});

	}
	public void loadBuscarJugadores(){
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("BuscarJugadores.fxml"));
		fxmload.setController(this);
		Parent root;
		try {
			root = fxmload.load();
			basePane.getChildren().clear();
			basePane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void loadBaseDeDatos(){
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("BaseDeDatos.fxml"));
		fxmload.setController(this);
		Parent root;
		try {
			root = fxmload.load();
			basePane.getChildren().clear();
			basePane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FXML
	void buscar(){
		loadBaseDeDatos();
	}

	void chargePlayers() {
		FileReader filereader = null;
		try {
			filereader = new FileReader(PLAYERS_FILE_NAME);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
		CSVReader csvReader = new CSVReaderBuilder(filereader).withCSVParser(parser).build();
		List<String[]> allData = null;
		try {
			allData = csvReader.readAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fillAVL(allData,2,4);
		fillBST(allData,2,4);
		
	}
	
	void fillAVL(List<String[]> values,int startColum,int finishColum) {
		int columns = startColum;
		int index = 0;
		AVL<String, Integer> temp = new AVL<String,Integer>();
		while(columns != finishColum ) {
			for(int i = 1;i<200000;i++) {
				temp.insertE(values.get(i)[columns], i);
			}
		avls[index] = temp;
		index++;
		columns++;
		}
	}
	
	void fillBST(List<String[]> values,int startColum,int finishColum) {
		int columns = startColum;
		BST<String, Integer> temp = new BST<String,Integer>();
		while(columns != finishColum ) {
			for(int i = 1;i<200000;i++) {
				temp.insertE(values.get(i)[columns], i);
			}
		bst = temp;
		columns++;
		}
	}

	public void loadPlayersList() {
    	basePane.setOnKeyPressed(null);
    	FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Seccion1.fxml"));
		fxmload.setController(this);
		Parent root;
		try {
			root = fxmload.load();
			basePane.getChildren().clear();
			basePane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
		tablePlayers.getItems().clear();
		//ArrayList<Player> list=books.booksList();
		//ObservableList<Book>books= FXCollections.observableArrayList(list);
		//tableBooks.setItems(books);
		
		idName.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
		idLast_Name.setCellValueFactory(new PropertyValueFactory<Player, String>("last_name"));
		idAge.setCellValueFactory(new PropertyValueFactory<Player, Integer>("age"));
		idTeam.setCellValueFactory(new PropertyValueFactory<Player,String>("team"));
		idPoints.setCellValueFactory(new PropertyValueFactory<Player, Integer>("pointsPerGame"));
		idRebounds.setCellValueFactory(new PropertyValueFactory<Player,Integer>("reboundsPerGame"));
		idAssists.setCellValueFactory(new PropertyValueFactory<Player, Integer>("assistsPerGame"));
		idRobberies.setCellValueFactory(new PropertyValueFactory<Player,Integer>("robberiesPerGame"));
		idBlocks.setCellValueFactory(new PropertyValueFactory<Player,Integer>("blocksPerGame"));
	}
}
