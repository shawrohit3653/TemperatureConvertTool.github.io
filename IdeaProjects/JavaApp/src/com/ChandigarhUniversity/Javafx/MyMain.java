package com.ChandigarhUniversity.Javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("inti");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Start");
		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
		MenuBar menuBar=createMenu();
		rootNode.getChildren().add(0,menuBar);
		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Convert Tool");
		primaryStage.show();
	}

	private MenuBar createMenu()
	{
		// file menu
		Menu fileMenu=new Menu("FIle");
		MenuItem newMenuItem=new MenuItem("New");

		newMenuItem.setOnAction(event -> System.out.println("New menu item clicked"));

		SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
		MenuItem quitMenuItem=new MenuItem("Quit");

		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.out.println("quit menu item clicked");
		});
		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);
//help menu
		Menu helpMenu=new Menu("Help");
		MenuItem aboutApp=new MenuItem("About");
		aboutApp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				aboutApp();
			}

			public  void aboutApp(){
				Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);
				alertDialog.setTitle("My first Desketop");
				alertDialog.setHeaderText("leaning java");
				alertDialog.setContentText("I am noob");

				ButtonType yesBtn=new ButtonType("Yes");
				ButtonType noBtn=new ButtonType("No");

				alertDialog.getButtonTypes().setAll(yesBtn,noBtn);

				Optional<ButtonType> clickedbtn=alertDialog.showAndWait();
				if(clickedbtn.isPresent() && clickedbtn.get()==yesBtn)
				{
					System.out.println("yes button");
				}
				if(clickedbtn.isPresent() && clickedbtn.get()==noBtn)
				{
					System.out.println("no button");
				}
			}
		});
		helpMenu.getItems().addAll(aboutApp);
//menu bar
		MenuBar menuBar=new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);
		return menuBar;
	}

	@Override
	public void stop() throws Exception {
		System.out.println("stop");
		super.stop();
	}
}
