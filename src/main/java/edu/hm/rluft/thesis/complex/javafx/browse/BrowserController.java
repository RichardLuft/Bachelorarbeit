package edu.hm.rluft.thesis.complex.javafx.browse;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import org.beanfabrics.Path;
import org.beanfabrics.javafx.binder.BnFxBinder;
import org.beanfabrics.javafx.controller.BnFxControllerBase;

import edu.hm.rluft.thesis.complex.javafx.data.BrowseData;
import edu.hm.rluft.thesis.complex.javafx.view.ViewerController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class BrowserController extends BnFxControllerBase<BrowserPM> {

	@FXML
	private BorderPane root;

	@FXML
	private TableView<BrowserZeilePM> table;
	@FXML
	private ViewerController viewerController;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Binding
		initializeTableView();
		setPresentationModel(new BrowserPM());
		BnFxBinder.bind(viewerController, getLocalModelProvider(), new Path("viewer"));
	}

	private void initializeTableView() {
		BnFxBinder.bind(table, getLocalModelProvider(), new Path("eintraege"));
		ObservableList<TableColumn<BrowserZeilePM, ?>> cols = table.getColumns();
		cols.add(BnFxBinder.newTableColumn("kundenNr").withText("Kundennummer").withPrefWidth(200).buildAsTextField());
		cols.add(BnFxBinder.newTableColumn("name").withText("Name").withPrefWidth(200).buildAsTextField());
		table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	}

	public Parent getParent() {
		return root;
	}

	public static BrowserController load() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(BrowserController.class.getResource("Browser.fxml"));
		loader.load();
		return loader.getController();
	}

	public void setData(Map<Long,BrowseData> loadData) {
		getPresentationModel().setData(loadData);
	}

}
