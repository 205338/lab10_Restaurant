package it.polito.tdb.restaurant;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdb.restaurant.simulation.Core;
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

    private Core core;
    
    @FXML
    void doSimulation(ActionEvent event) {
    	core.generateEvents();
    	core.setTables();
    	core.simulate();
    	
    	txtResult.setText(core.getStats());
    }

    @FXML
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Restaurant.fxml'.";
        txtResult.setEditable(false);
    }

	public void setCore(Core core) {
		this.core = core;
	}
    
}
