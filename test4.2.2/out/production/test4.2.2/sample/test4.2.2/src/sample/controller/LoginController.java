package sample.controller;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Main;
import sample.util.DBUtil;
import sample.util.StringUtil;

public class LoginController {
public static  String accountText;//用于传值给第三个页面
private static String passwordText;
public static String trueUserName;
    @FXML
    private TextField account;//接受账号输入

    @FXML
    private PasswordField password;//接受密码输入


    @FXML
    private Label errorinfo;//弹出错误信息

    @FXML
    public void initialize(){

    }
    @FXML
    public void doLogin() {
        accountText=account.getText();
        passwordText=password.getText();

        if(StringUtil.isEmpty(accountText)){//调用StringUtil中isEmpty方法判断输入框是否为空
            errorinfo.setText("账户不能为空！");
            errorinfo.setVisible(true);
            return;
        }
        if(StringUtil.isEmpty(passwordText)){
            errorinfo.setText("密码不能为空！");
            errorinfo.setVisible(true);
            return;
        }
        if(DBUtil.userLoginCheck(accountText,passwordText))//调用DBUtil中userLoginCheck方法并传入当前输入的用户名与密码为形参判断是否正确
        {
            //如果与数据库中账号对比成功
            trueUserName=DBUtil.takeUserTrueName(accountText);//调用DBUtil中takeUserTrueName方法并传入输入的用户名取出数据库中该用户对应的真名
            Main.changeView("view/ticketbooking.fxml");//就进入新页面
        }
        else
        {
//            否则弹出错误信息
            errorinfo.setText("账户或密码错误！！！");//设置弹出错误信息的内容
            errorinfo.setVisible(true);//设置错误信息控件为可见
        }

    }
}
