package sample.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Main;
import sample.entity.Shuttle;
import sample.util.DBUtil;
import sample.util.StringUtil;


import java.time.LocalDate;

import java.util.List;

public class TicketbookingController {
    @FXML
    private TableView<Shuttle> tableView;
    @FXML
    private TableColumn<Shuttle, String> startTime;
    @FXML
    private TableColumn<Shuttle, Float> ticketsPrices;
    @FXML
    private TableColumn<Shuttle, Integer> ticketsNumber;
    @FXML
    private ChoiceBox<String> startChoiceBox;
    @FXML
    private ChoiceBox<String> endChoiceBox;
    @FXML
    private Button bookingButton;
    @FXML
    private DatePicker departureDatePicker;
    @FXML
    private Button checkTicketsButton;
    @FXML
    private Button resetButton;
    @FXML
    private Label errorinfo;
    //station用于给两个choicebox初始化
    private String[] stataion = {"东校区", "西校区", "武汉校区"};

    public  static String startStation2;
    public  static String endStation2;
    public static String startTime2;
    public static Integer shuttleID2;


    @FXML
    public void initialize() {
        //对tableview初始化
        List<Shuttle> shuttles = DBUtil.readShuttle();//调用DBUtil中readShuttle方法，读出数据库中所有的车次
        startTime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        ticketsPrices.setCellValueFactory(new PropertyValueFactory<>("ticketsPrices"));
        ticketsNumber.setCellValueFactory(new PropertyValueFactory<>("ticketsNumber"));
        tableView.setItems(FXCollections.observableList(shuttles));
        //对startChoiceBox和endChoiceBox初始化
        startChoiceBox.getItems().addAll(stataion);//将station字符串数组内容添加到choicebox中
        endChoiceBox.getItems().addAll(stataion);
        startChoiceBox.getSelectionModel().select(0);//默认初始化选择
        endChoiceBox.getSelectionModel().select(1);
        //对datepicker初始化
        departureDatePicker.setValue(LocalDate.now());//默认初始化为当前时间
    }


    @FXML
    public void showsuccessfulBookingView() {//点击预订按钮时

        if(tableView.getSelectionModel().getSelectedIndex()!=-1){//如果至少选中了一项
            //将当前tableview选框的车辆id传入shuttleID2
            shuttleID2=tableView.getSelectionModel().getSelectedItem().getShuttleID();
            //将当前选中的车次所对应的id传入DBUtil的takeStart Time方法，获取到字符串型的出发时间
            startTime2=DBUtil.takeStartTime(shuttleID2);
            //展现第三个页面
            Main.successfulBookingView("view/successfulbooking.fxml");
            //取消选择框中已选择的
            tableView.getSelectionModel().clearSelection();
        }
        else {//如果连一个都没选中
            errorinfo.setText("至少选择一项再预订!!!");//错误预订提示框，默认是不可见的，只有没选中车票就预订会显示出来
            errorinfo.setVisible(true);
        }


    }
    @FXML
    public void checkTickets() {//点击查询按钮时
//        System.out.println(startChoiceBox.getValue());
//        System.out.println(endChoiceBox.getValue());
//        System.out.println(departureDatePicker.getValue());
//     System.out.println(StringUtil.localdateToString(departureDatePicker.getValue()));
        //获取查询需要的三个要素，时间，始发站，终点站
        String startTime1=StringUtil.localdateToString(departureDatePicker.getValue());
        String startStation1=startChoiceBox.getValue();
        String endStation1=endChoiceBox.getValue();
        startStation2=startChoiceBox.getValue();
        endStation2=endChoiceBox.getValue();
        //调用DBUtil中shuttleCheck方法，并传入开始时间，始发站，终点站为形参查询符合条件的车次信息
        List<Shuttle> shuttles =DBUtil.shuttlesCheck(startTime1,startStation1,endStation1);
        startTime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        ticketsPrices.setCellValueFactory(new PropertyValueFactory<>("ticketsPrices"));
        ticketsNumber.setCellValueFactory(new PropertyValueFactory<>("ticketsNumber"));
        tableView.setItems(FXCollections.observableList(shuttles));
    }
    @FXML
    void resetTableView() {//点击重置按钮时
        List<Shuttle> shuttles = DBUtil.readShuttle();//重读一遍数据
        startTime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        ticketsPrices.setCellValueFactory(new PropertyValueFactory<>("ticketsPrices"));
        ticketsNumber.setCellValueFactory(new PropertyValueFactory<>("ticketsNumber"));
        tableView.setItems(FXCollections.observableList(shuttles));

    }
}
