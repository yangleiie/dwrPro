package sugar.dwr;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;

import java.util.Collection;

/**
 * Created by lei on 2018/2/5.
 */
public class SendUtils {

    public void sendSingle(final String msg){
        final String userId = "2";  //这个我写死张三userId=2
        final String autoMessage = "上级已经更改了这条线索的归属人了！";
        try{
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
        Browser.withAllSessionsFiltered(new ScriptSessionFilter() {
            public boolean match(ScriptSession session){  //验证符合条件的发送人
                if (session.getAttribute("userId") == null){
                    return false;
                }else  {
                    return (session.getAttribute("userId")).equals(userId);
                }
            }
        }, new Runnable(){

            private ScriptBuffer script = new ScriptBuffer();

            public void run(){

                script.appendCall("showMessage", msg);

                Collection<ScriptSession> sessions = Browser

                        .getTargetSessions();

                for (ScriptSession scriptSession : sessions){
                    scriptSession.addScript(script);
                }
            }
        });
    }

    public void sendMany(final String msg){
        final String userId = "2,3";
//        try{
//            Thread.sleep(10000);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        final String autoMessage = "上级已经更改了这条线索的归属人了！";
        Browser.withAllSessionsFiltered(new ScriptSessionFilter() {
            public boolean match(ScriptSession session){
                if (session.getAttribute("userId") == null){
                    return false;
                }else  {
                    String attribute = (String) session.getAttribute("userId");
                    return (userId.contains(attribute));

                }
            }
        }, new Runnable(){

            private ScriptBuffer script = new ScriptBuffer();

            public void run(){

                script.appendCall("showMessage", msg);

                Collection<ScriptSession> sessions = Browser

                        .getTargetSessions();

                for (ScriptSession scriptSession : sessions){
                    scriptSession.addScript(script);
                }
            }
        });
    }


}
