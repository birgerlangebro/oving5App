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
	// Bind controllers and views from GroupView.fxml
	// ////////////////////////////

	@FXML private TreeView<String> groupTreeView;

	@FXML private Button addGroupButton;
	
	// ////////////////////////////
	// Load icon images
	// ////////////////////////////
	
	private final Image companyIcon = new Image(getClass().getResourceAsStream("/ImageResources/companyIcon.png"));
	private final Image girlIcon = new Image(getClass().getResourceAsStream("/ImageResources/girlIcon.png"));
	private final Image boyIcon = new Image(getClass().getResourceAsStream("/ImageResources/boyIcon.png"));
	private final Image groupIcon = new Image(getClass().getResourceAsStream("/ImageResources/groupIcon.png"));
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// must be called in order to populate the TreeView with TreeItems
		populateGroupTree(); 
	}
	
	
	private void populateGroupTree() {
		// make a root item. The tree must have a root item
		TreeItem<String> rootItem = new TreeItem<String> (
			"Company", new ImageView(companyIcon)
		);
		rootItem.setExpanded(true);
		
		// give the root item two group items 
		// then fill the group items with three
		// dummy employer items
		for (int i = 1; i < 3; i++) {
			TreeItem<String> item = new TreeItem<String> (
				"Group " + i, new ImageView(groupIcon)
			);
			
			// give three dummy employer items
			for (int p = 1; p < 4; p++) {
				TreeItem<String> subItem = new TreeItem<String> (
					"Group Member " + p, new ImageView(boyIcon)
				);
				item.getChildren().add(subItem);
			}
			rootItem.getChildren().add(item);
		}
		
		// give the root item five dummy employer items
		for (int i = 1; i < 6; i++) {
			TreeItem<String> item = new TreeItem<String> (
				"Employer " + i, new ImageView(girlIcon)
			);
			rootItem.getChildren().add(item);
		}
		
		// lastly give the root item to the tree view
		groupTreeView.setRoot(rootItem);
	}
	
	// this function does nothing yet
	// it is bound to the "+ add group or folder" button
	@FXML public void addGroupButtonClicked(ActionEvent event) {
		System.out.println("add group button was clicked!");
	}
	
}

