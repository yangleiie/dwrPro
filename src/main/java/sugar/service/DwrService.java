package sugar.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import sugar.dwr.SendUtils;

/**
 * Created by lei on 2018/2/5.
 */
@Service
public class DwrService {

    int i=0;

    @Scheduled(cron = "*/1 * * * * ?")
    public void send(){
        SendUtils sendUtils = new SendUtils();
//        sendUtils.sendSingle("hello"+i++);
        sendUtils.sendMany("hello"+i++);
        System.out.println("hello world");
    }

}
