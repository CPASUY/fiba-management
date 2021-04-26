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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.AVL;
import model.BST;
import model.Player;
import model.RBT;

public class Fiba_Controller {
	//Constant
	public static final String PLAYERS_FILE_NAME="data/DataPlayers.csv";
	@FXML
	private BorderPane basePane;
	private Stage stage;
	private Player p;
	private ArrayList<AVL<String,Integer>>avls;
	private ArrayList<RBT<String,Integer>>rbts;
	private BST<String,Integer> bst;
	private List<String[]> allData;
	private final int QUANTITY_DATA = 20;
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
	
	@FXML
	private ChoiceBox<String> criteriaBox;
	
	@FXML
	private ChoiceBox<String> comparisonBox;
	
	@FXML
	private TextField valueBox;
	

	public Fiba_Controller(Stage s) throws IOException, CsvException {
		stage=s;
		avls = new ArrayList<AVL<String,Integer>>();
		rbts = new ArrayList<RBT<String,Integer>>();
		bst = null;
		allData = null;
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
		criteriaBox.getItems().addAll("Points","Rebounds","Assists","Robberies","Blocks","Age");
		criteriaBox.setValue("Points");
		comparisonBox.getItems().addAll("=",">","<");
		comparisonBox.setValue("=");
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
	void search(){
		if(valueBox.getText() != "") {
			verifyCriteria();
		}
		loadBaseDeDatos();
	}
	
	
	void verifyComparisonBST(BST<String,Integer> abb) {
	
		if(comparisonBox.getValue().equals("=")){
			abb.searchEquals(valueBox.getText());
		}
		else if(comparisonBox.getValue().equals(">")) {
			abb.searchMore(valueBox.getText());
		}
		else {
			abb.searchLess(valueBox.getText());
		}
	}
	
	void verifyComparisonAVL(AVL<String,Integer> abb) {
		if(comparisonBox.getValue().equals("=")){
			abb.searchEquals(valueBox.getText());
		}
		else if(comparisonBox.getValue().equals(">")) {
			abb.searchMore(valueBox.getText());
		}
		else {
			abb.searchLess(valueBox.getText());
		}
	}
	
	void verifyComparisonRBT(RBT<String,Integer> abb) {
		if(comparisonBox.getValue().equals("=")){
			abb.searchEquals(valueBox.getText());
		}
		else if(comparisonBox.getValue().equals(">")) {
			abb.searchMore(valueBox.getText());
		}
		else {
			abb.searchLess(valueBox.getText());
		}
	}
	
	void verifyCriteria() {
		
		switch(criteriaBox.getValue()) {
		case "Points":
			verifyComparisonAVL(avls.get(0));
			break;
		case "Rebounds":
			verifyComparisonAVL(avls.get(1));
			break;
			
		case "Assists":
			verifyComparisonBST(bst);
			break;
		
		case "Robberies":
			verifyComparisonRBT(rbts.get(0));
			break;
			
		case "Blocks":
			verifyComparisonRBT(rbts.get(1));
			break;
			
		case "Age":
			
			break;
		default:
			break;
		}
	}
	
	@FXML
	void returnSearch() {
		loadBuscarJugadores();
	}

	void chargePlayers() {
		FileReader filereader = null;
		try {
			filereader = new FileReader(PLAYERS_FILE_NAME);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
		CSVReader csvReader = new CSVReaderBuilder(filereader).withCSVParser(parser).build();
		try {
			allData = csvReader.readAll();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (CsvException e) {
			
			e.printStackTrace();
		}
		fillAVL(allData,4,6);
		fillBST(allData,6,7);
		fillRBT(allData,7,9);
	}
	
	void fillAVL(List<String[]> values,int startColum,int finishColum) {
		int columns = startColum;
		while(columns != finishColum ) {
		AVL<String, Integer> temp = new AVL<String,Integer>();
		for(int i = 1;i<QUANTITY_DATA;i++) {
			temp.insertE(values.get(i)[columns], i);
		}
		avls.add(temp);
		columns++;
		}
	}
	
	void fillBST(List<String[]> values,int startColum,int finishColum) {
		int columns = startColum;
		
		BST<String, Integer> temp = new BST<String,Integer>();
		while(columns != finishColum ) {
			for(int i = 1;i<QUANTITY_DATA;i++) {
				temp.insertE(values.get(i)[columns], i);
			}
			bst = temp;
			columns++;
		}
	}
	
	void fillRBT(List<String[]> values,int startColum,int finishColum) {
		int columns = startColum;
		while(columns != finishColum ) {
			RBT<String, Integer> temp = new RBT<String,Integer>();
			for(int i = 1;i<QUANTITY_DATA;i++) {
				temp.insertNode(values.get(i)[columns], i);
			}
		System.out.println(temp);
		rbts.add(temp);
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
