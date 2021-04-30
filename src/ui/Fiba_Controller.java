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
	private ArrayList<AVL<String,Integer>>avls;
	private ArrayList<RBT<String,Integer>>rbts;
	private BST<String,Integer> bst;
	private List<String[]> allData;
	private ArrayList<Player> players;
	private final int QUANTITY_DATA = 20;
	
	@FXML
	private TableView<Player> tablePlayers;

	@FXML
	private TableColumn<Player,String> idName;

	@FXML
	private TableColumn<Player,String> idLastName; 

	@FXML
	private TableColumn<Player,String> idAge;

	@FXML
	private TableColumn<Player,String> idTeam;

	@FXML
	private TableColumn<Player,String> idPoints;

	@FXML
	private TableColumn<Player,String> idRebounds;

	@FXML
	private TableColumn<Player,String> idAssists;

	@FXML
	private TableColumn<Player,String> idRobberies;
	
	@FXML
	private TableColumn<Player,String> idBlocks;
	
	@FXML
	private ChoiceBox<String> criteriaBox;
	
	@FXML
	private ChoiceBox<String> comparisonBox;
	
	@FXML
	private TextField valueBox;
	
	private long start;
	
	private long end;
	
	private long time;
	

	public Fiba_Controller(Stage s) throws IOException, CsvException {
		stage=s;
		avls = new ArrayList<AVL<String,Integer>>();
		rbts = new ArrayList<RBT<String,Integer>>();
		bst = null;
		start=0;
		end = 0;
		time = 0;
		players = new ArrayList<Player>();
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
		chargePlayers();
	}
	public void loadBaseDeDatos(){
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("BaseDeDatos.fxml"));
		fxmload.setController(this);
		Parent root;
		try {
			root = fxmload.load();
			basePane.getChildren().clear();
			basePane.setCenter(root);
			loadPlayersList();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	void search(){
		if(valueBox.getText() != null && valueBox.getText().trim().isEmpty() == false) {
			start = System.currentTimeMillis();
			verifyCriteria();
			end = System.currentTimeMillis();
			time = end-start;
			loadBaseDeDatos();
			System.out.println("THE TIME OF THE SEARCH IN MILISECONDS IS : " + time);
		}
	}

	void verifyComparison(BST<String,Integer> abb) {
		
		if(comparisonBox.getValue().equals("=")){
			
			if(abb.searchEquals(valueBox.getText()) != null){
				generateBSTplayers(abb);
			}
		}
		else if(comparisonBox.getValue().equals(">")) {
			abb.inOrderMore(abb.getRoot(),valueBox.getText());
			generateSearchPlayers(abb);
		}
		else {
			abb.inOrderLess(abb.getRoot(),valueBox.getText());
			generateSearchPlayers(abb);
		}
	}
	
	void verifyCriteria() {
		
		switch(criteriaBox.getValue()) {
		case "Points":
			verifyComparison(avls.get(0));
			break;
		case "Rebounds":
			verifyComparison(avls.get(1));
			break;
			
		case "Assists":
			verifyComparison(bst);
			break;
		
		case "Robberies":
			verifyComparison(rbts.get(0));
			break;
			
		case "Blocks":
			verifyComparison(rbts.get(1));
			break;
			
		case "Age":
			linealSearch(comparisonBox.getValue(),valueBox.getText());
			break;
		default:
			break;
		}
	}
	
	@FXML
	void returnSearch() {
		players.clear();
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
			temp.insert(values.get(i)[columns], i+1);
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
				temp.insertE(values.get(i)[columns], i+1);
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
				temp.insertNode(values.get(i)[columns], (i+1));
			}
		rbts.add(temp);
		columns++;
		}
	}
	
	void linealSearch(String v,String search) {
		players.clear();
		int age = Integer.valueOf(search);
		if(v.equals("=")){
			for(int i=1;i<QUANTITY_DATA;i++) {
				if(age == Integer.valueOf(allData.get(i)[2])) {
					players.add(new Player(allData.get(i)[0],allData.get(i)[1],allData.get(i)[2]
					,allData.get(i)[3],allData.get(i)[4],allData.get(i)[5]
					,allData.get(i)[6],allData.get(i)[7]
					,allData.get(i)[8]));
				}
			}
		}
		else if(v.equals(">")) {
			for(int i=1;i<QUANTITY_DATA;i++) {
				if(age < Integer.valueOf(allData.get(i)[2])) {
					players.add(new Player(allData.get(i)[0],allData.get(i)[1],allData.get(i)[2]
							,allData.get(i)[3],allData.get(i)[4],allData.get(i)[5]
							,allData.get(i)[6],allData.get(i)[7]
							,allData.get(i)[8]));
				}
			}
		}
		else {
			for(int i=1;i<QUANTITY_DATA;i++) {
				if(age > Integer.valueOf(allData.get(i)[2])) {
					players.add(new Player(allData.get(i)[0],allData.get(i)[1],allData.get(i)[2]
							,allData.get(i)[3],allData.get(i)[4],allData.get(i)[5]
							,allData.get(i)[6],allData.get(i)[7]
							,allData.get(i)[8]));
				}
			}
		}
	}
	
	void generateSearchPlayers(BST<String,Integer> abb) {
		
		if(players.isEmpty() == false) {
		  players.clear();
		}
		Player temp;
		for(int i =0; i<abb.indices().size();i++) {
		temp = new Player(allData.get(abb.indices().get(i)-1)[0],allData.get(abb.indices().get(i)-1)[1],allData.get(abb.indices().get(i)-1)[2],
						allData.get(abb.indices().get(i)-1)[3],allData.get(abb.indices().get(i)-1)[4],
						allData.get(abb.indices().get(i)-1)[5],allData.get(abb.indices().get(i)-1)[6],
						allData.get(abb.indices().get(i)-1)[7],allData.get(abb.indices().get(i)-1)[8]);
						players.add(temp);
			}
		abb.eraseNodes();
	}
	
	void generateBSTplayers(BST<String,Integer> abb) {
		if(players.isEmpty() == false) {
			  players.clear();
			}
		Player temp;
		for(int i =0; i<abb.searchEquals(valueBox.getText()).size();i++) {
		temp = new Player(allData.get(abb.searchEquals(valueBox.getText()).get(i)-1)[0],allData.get(abb.searchEquals(valueBox.getText()).get(i)-1)[1],allData.get(abb.searchEquals(valueBox.getText()).get(i)-1)[2],
				allData.get(abb.searchEquals(valueBox.getText()).get(i)-1)[3],allData.get(abb.searchEquals(valueBox.getText()).get(i)-1)[4],
				allData.get(abb.searchEquals(valueBox.getText()).get(i)-1)[5],allData.get(abb.searchEquals(valueBox.getText()).get(i)-1)[6],
				allData.get(abb.searchEquals(valueBox.getText()).get(i)-1)[7],allData.get(abb.searchEquals(valueBox.getText()).get(i)-1)[8]);
				players.add(temp);
				}
	abb.eraseNodes();
	}

	public void loadPlayersList() {
    	basePane.setOnKeyPressed(null);
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
		tablePlayers.getItems().clear();
		ObservableList<Player>list= FXCollections.observableArrayList(players);
		tablePlayers.setItems(list);
		
		idName.setCellValueFactory(new PropertyValueFactory<Player,String>("name"));
		idLastName.setCellValueFactory(new PropertyValueFactory<Player,String>("lastName"));
		idAge.setCellValueFactory(new PropertyValueFactory<Player,String>("age"));
		idTeam.setCellValueFactory(new PropertyValueFactory<Player,String>("team"));
		idPoints.setCellValueFactory(new PropertyValueFactory<Player,String>("pointsPerGame"));
		idRebounds.setCellValueFactory(new PropertyValueFactory<Player,String>("reboundsPerGame"));
		idAssists.setCellValueFactory(new PropertyValueFactory<Player,String>("assistsPerGame"));
		idRobberies.setCellValueFactory(new PropertyValueFactory<Player,String>("robberiesPerGame"));
		idBlocks.setCellValueFactory(new PropertyValueFactory<Player,String>("blocksPerGame"));
	}
}
