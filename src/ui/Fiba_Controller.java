package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Fiba_Controller {
	//Constant
	public static final String PLAYERS_FILE_NAME="data/DataPlayers.bbd";
	@FXML
	private BorderPane basePane;
	private Stage stage;

	public Fiba_Controller(Stage s) throws IOException {
		stage=s;
		try {
			loadPlayers();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		savePlayers();
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
	private void savePlayers() throws IOException {
		ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(PLAYERS_FILE_NAME));
		oos.writeObject(players);
		oos.close();
	}
	private void loadPlayers() throws IOException, ClassNotFoundException{
		File f=new File(PLAYERS_FILE_NAME);
		if(f.exists()) {
			ObjectInputStream ois= new ObjectInputStream(new FileInputStream(f));
			restaurants=(ArrayList<Restaurant>) ois.readObject();
			ois.close();
		}
	}
	public void importDataPlayers(String name) throws IOException {
		File f=new File(name);
		int cont=0;
		BufferedReader br =new BufferedReader(new FileReader(f));
		String line=br.readLine();
		while(line!=null) {
			if(cont>0){
			String [] parts=line.split(",");
			Player(parts[0],parts[1],Integer.parseInt(parts[2]),parts[3],Integer.parseInt(parts[4]),Integer.parseInt(parts[5]),Integer.parseInt(parts[6]),Integer.parseInt(parts[7]));
			}
			cont++;
			line=br.readLine();
		}
		br.close();
	}
}
