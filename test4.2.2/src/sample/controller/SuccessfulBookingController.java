package sample.controller;

        import javafx.fxml.FXML;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.stage.Stage;
        import sample.util.DBUtil;

        import static sample.controller.LoginController.accountText;
        import static sample.controller.LoginController.trueUserName;
        import static sample.controller.TicketbookingController.*;


public class SuccessfulBookingController {

    @FXML
    private Button successfulBookingButton;

    @FXML
    private Button cancelBookingButton;

    @FXML
    private Label userNameLabel;

    @FXML
    private Label startStationLabel;

    @FXML
    private Label trueNameLabel;

    @FXML
    private Label startTimeLabel;

    @FXML
    private Label endStationLabel;
    @FXML
    public void initialize(){//初始化页面各控件的值
        userNameLabel.setText(accountText);
        trueNameLabel.setText(trueUserName);
        startStationLabel.setText(startStation2);
        endStationLabel.setText(endStation2);
        startTimeLabel.setText(startTime2);

    }


@FXML
    public void enSure(){
    successfulBookingButton.setOnAction(e->{//当是确定按钮触发事件时，先执行DBUtil中ticketsNumberCut方法并传入前一个页面选中的车次的id为形参，使对应的车票数-1
        Stage stage=(Stage) successfulBookingButton.getScene().getWindow();
        DBUtil.ticketsNumberCut(shuttleID2);
        stage.close();
    });
        cancelBookingButton.setOnAction(e->{//当是取消按钮触发事件时，直接关闭当前窗口
            Stage stage=(Stage) cancelBookingButton.getScene().getWindow();
            stage.close();
        });
    }
}
