package Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RootController implements Initializable{
	
	// ////////////////////////////
	// Bind controllers from GroupView.fxml
	// ////////////////////////////

	@FXML private TreeView<String> groupTreeView;
	
	// ////////////////////////////
	// Make icons ImageViews
	// ////////////////////////////
	
	private final Node companyIcon = new ImageView(
		new Image(getClass().getResourceAsStream("/ImageResources/companyIcon.png"))
	);
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		TreeItem<String> rootItem = new TreeItem<String> ("Company", companyIcon);
		rootItem.setExpanded(true);
		for (int i = 1; i < 6; i++) {
			TreeItem<String> item = new TreeItem<String> ("Employer " + i, new ImageView(
					new Image(getClass().getResourceAsStream("/ImageResources/girlIcon.png"))
				)
			);
			rootItem.getChildren().add(item);
		}
		groupTreeView.setRoot(rootItem);
	}
		
}

