package sugar.dwr;
import java.util.Collection;
import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.WebContextFactory;

import javax.servlet.ServletException;

/**
 * Created by lei on 2018/2/3.
 */
public class MessagePush {

    public void send(final String content){

        Runnable run = new Runnable(){
            private ScriptBuffer script = new ScriptBuffer();
            public void run() {
                //设置要调用的 js及参数
                script.appendCall("show" , content);
                //得到所有ScriptSession
                Collection<ScriptSession> sessions = Browser.getTargetSessions();
                //遍历每一个ScriptSession
                for (ScriptSession scriptSession : sessions){
                    scriptSession.addScript( script);
                }
            }
        };
        //执行推送
        try{

//            Thread.sleep(10000);
            Browser. withAllSessions(run);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void onPageLoad(String userId) {

        ScriptSession scriptSession = WebContextFactory.get().getScriptSession();

        scriptSession.setAttribute("userId", userId); //把前台传入的id保存

        DwrScriptSessionManagerUtil dwrScriptSessionManagerUtil = new DwrScriptSessionManagerUtil();

        try {

            dwrScriptSessionManagerUtil.init();

        } catch (ServletException e) {

            e.printStackTrace();

        }

    }
}
