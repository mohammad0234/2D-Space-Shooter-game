package game;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyTimerCode implements ActionListener {

    private GameLevel gl;
    public MyTimerCode(GameLevel gl){
        this.gl = gl;
    }
    int counter = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        counter++;
        System.out.println(counter);

        Enemy er = new Enemy(gl);
    }

}

