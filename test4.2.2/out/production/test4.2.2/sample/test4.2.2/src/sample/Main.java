package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class   Main extends  Application{

    private static Stage stage;


    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Main.stage=stage;
        stage.setTitle("长江大学班车购票系统");
        changeView("view/login.fxml");
        stage.show();
    }
    public static void changeView(String fxml){//切换页面方法
        Parent root= null;
        try {
            root = FXMLLoader.load(Main.class.getResource(fxml));
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void successfulBookingView(String fxml){//展示第三个页面方法
        Stage stage =new Stage();
        Parent root= null;
        try {
            root = FXMLLoader.load(Main.class.getResource(fxml));
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.show();
    }
}



