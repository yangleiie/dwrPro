package sugar.task;

import sugar.dwr.MessagePush;
import sugar.dwr.SendUtils;

import java.util.TimerTask;

/**
 * Created by lei on 2018/2/5.
 */
public class MyTask extends TimerTask {

    int i=0;

//    @Override
//    public void run() {
//        MessagePush push = new MessagePush();
//        push.send("hello"+i++);
//        System.out.println("hello world");
//    }

    @Override
    public void run(){
        SendUtils sendUtils = new SendUtils();
//        sendUtils.sendSingle("hello"+i++);
        sendUtils.sendMany("hello"+i++);
        System.out.println("hello world");

    }
}
