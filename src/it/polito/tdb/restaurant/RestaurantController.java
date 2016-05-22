package it.polito.tdb.restaurant;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdb.restaurant.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class RestaurantController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtResult;

    private Model model;
    
    @FXML
    void doSimulation(ActionEvent event) {
    	
    }

    @FXML
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Restaurant.fxml'.";
        txtResult.setEditable(false);
    }

	public void setModel(Model model) {
		this.model = model;
	}
    
}
