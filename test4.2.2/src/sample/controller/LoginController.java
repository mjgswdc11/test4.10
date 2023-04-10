package sample.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Main;
import sample.util.DBUtil;
import sample.util.StringUtil;

public class LoginController {

    @FXML
    private TextField account;

    @FXML
    private PasswordField password;


    @FXML
    private Label errorinfo;

    @FXML
    public void initialize(){

    }
    @FXML
    public void doLogin() {
        String accountText =account.getText();
        String passwordText=password.getText();

        if(StringUtil.isEmpty(accountText)){
            errorinfo.setText("账户不能为空！");
            errorinfo.setVisible(true);
            return;
        }
        if(StringUtil.isEmpty(passwordText)){
            errorinfo.setText("密码不能为空！");
            errorinfo.setVisible(true);
            return;
        }
        if(DBUtil.userLoginCheck(accountText,passwordText))
        {
            Main.changeView("view/ticketbooking.fxml");
        }
        else
        {
            errorinfo.setText("账户或密码错误！！！");
            errorinfo.setVisible(true);
        }
//        if(accountText.equals("admin")&&passwordText.equals("admin")){
//            //进入系统
//            Main.changeView("view/ticketbooking.fxml");
//        }
//        else{
//            errorinfo.setText("账户或密码错误！！！");
//            errorinfo.setVisible(true);
//        }
    }
}
