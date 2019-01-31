import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.Scanner;

public class Controller implements EventHandler<ActionEvent> {
    private Tray tray;
    private Dictionary dict;

    private GridPane root;
    private VBox init;
    private Button gameStartButton;
    private Canvas canvas;
    private GraphicsContext gc;

    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            updateBoard();
        }
    };

    /**
     * The initial generation of the game window.
     * @return A parent.
     * */
    public Parent init() {
        root = new GridPane();
        init = new VBox(50);

        root.setAlignment(Pos.TOP_LEFT);
        root.setPadding(new Insets(20, 20, 20, 20));
        root.setHgap(5.5);
        root.setVgap(5.5);

        gameStartButton = new Button("Start");
        gameStartButton.setOnAction(this);

        tray = new Tray();
        dict = new Dictionary();

        Text txtWelcome = new Text("Welcome to Boggle!!");
        txtWelcome.setFont(new Font("Verdana", 32));


        init.setAlignment(Pos.CENTER);
        init.getChildren().addAll(gameStartButton, txtWelcome);
        root.add(init, 0, 0);

        return root;
    }

    @Override
    public void handle(ActionEvent event) {
        Object source = event.getSource();
        if (source == gameStartButton) {
            canvas = new Canvas(800, 500);
            gc = canvas.getGraphicsContext2D();

            root.add(canvas, 5, 5);
            timer.start();
        }
    }

    private void updateBoard()
    {
        tray.printTray();
        String input = getInput();

        System.out.println("Is the word in the dictionary list? " + dict.isValid(input));
        System.out.println("Does the word appear in the grid? " + tray.doesExist(input));
    }

    private String getInput()
    {
        String input;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input a word: ");
        input = scanner.nextLine();

        return input;
    }
}
