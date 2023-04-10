package sample.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Main;
import sample.entity.Shuttle;
import sample.util.DBUtil;
//import sample.util.FileUtil;

import java.util.List;

public class TicketbookingController {
    @FXML
    private TableView<Shuttle>tableView;
    @FXML
    private TableColumn<Shuttle,String>startTime;
    @FXML
    private TableColumn<Shuttle,String>ticketsPrices;
    @FXML
    private TableColumn<Shuttle,String>ticketsNumber;
    @FXML
    private ChoiceBox<String > startChoiceBox;
    @FXML
    private ChoiceBox<String> endChoiceBox;
    @FXML
    private Button bookingButton;
    @FXML
    public void initialize(){
        //对tableview初始化
        List<Shuttle> shuttles = DBUtil.readShuttle();
        startTime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        ticketsPrices.setCellValueFactory(new PropertyValueFactory<>("ticketsPrices"));
        ticketsNumber.setCellValueFactory(new PropertyValueFactory<>("ticketsNumber"));
        tableView.setItems(FXCollections.observableList(shuttles));
    }
    @FXML
    public void showsuccessfulBookingView() {
        Main.successfulBookingView("view/successfulbooking.fxml");
    }
}
