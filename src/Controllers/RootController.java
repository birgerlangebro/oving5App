package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RootController implements Initializable{
	
	// ////////////////////////////
	// Bind controllers from GroupView.fxml
	// ////////////////////////////

	@FXML private TreeView<String> groupTreeView;
	
	@FXML private Button addGroupButton;
	
	// ////////////////////////////
	// Make icons ImageViews
	// ////////////////////////////
	
	private final Node companyIcon = new ImageView(
		new Image(getClass().getResourceAsStream("/ImageResources/companyIcon.png"))
	);
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		populateGroupTree();
	}
	
	
	private void populateGroupTree() {
		TreeItem<String> rootItem = new TreeItem<String> ("Company", companyIcon);
		rootItem.setExpanded(true);
		for (int i = 1; i < 6; i++) {
			TreeItem<String> item = new TreeItem<String> ("Employer " + i, new ImageView(
					new Image(getClass().getResourceAsStream("/ImageResources/girlIcon.png"))
				)
			);
			rootItem.getChildren().add(item);
		}
		
		for (int i = 1; i < 3; i++) {
			TreeItem<String> item = new TreeItem<String> ("Group " + i, new ImageView(
					new Image(getClass().getResourceAsStream("/ImageResources/groupIcon.png"))
				)
			);
			for (int p = 1; p < 4; p++) {
				TreeItem<String> subItem = new TreeItem<String> ("Group Member " + p, new ImageView(
						new Image(getClass().getResourceAsStream("/ImageResources/boyIcon.png"))
					)
				);
				item.getChildren().add(subItem);
			}
			rootItem.getChildren().add(item);
		}
		
		groupTreeView.setRoot(rootItem);
	}
	
	
	@FXML public void addGroupButtonClicked(ActionEvent event) {
		System.out.println("add group button was clicked!");
		
	}
	
}

