package ui;

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
import model.Player;

public class Fiba_Controller {
	//Constant
	public static final String PLAYERS_FILE_NAME="data/DataPlayers.bbd";
	@FXML
	private BorderPane basePane;
	private Stage stage;
	private Player p;
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

	public Fiba_Controller(Stage s) throws IOException {
		stage=s;
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
