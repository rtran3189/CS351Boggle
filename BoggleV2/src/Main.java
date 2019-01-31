/**
 * Primary class for the Boggle game.
 * @author Richard Tran
 */

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Controller gameController = new Controller();
        Parent root = gameController.init();

        Scene scene = new Scene(root, 1000, 500);

        primaryStage.setTitle("Boggle!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
