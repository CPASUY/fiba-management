package ui;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
}
