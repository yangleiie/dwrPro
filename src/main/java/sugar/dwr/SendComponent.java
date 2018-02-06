package sugar.dwr;

import org.springframework.stereotype.Component;
import sugar.task.MyTask;

import javax.annotation.PostConstruct;
import java.util.Timer;

/**
 * Created by lei on 2018/2/5.
 */
//@Component
public class SendComponent {

    private Timer timer = null;

    @PostConstruct
    public void sendDwrMsg(){
        timer = new Timer(true);
        timer.schedule(new MyTask(), 0, 1000*6);
    }

}
