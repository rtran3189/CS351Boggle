import javafx.animation.AnimationTimer;

public class Timer
{
    private AnimationTimer timer;

    public Timer()
    {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

            }
        };
    }

}
