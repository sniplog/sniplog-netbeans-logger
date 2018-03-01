package org.sniplog.sniploglogger;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zieteada
 */
public class SniplogLoggerUnitTest {

    SniplogLogger sniplogLogger;
    JSONObject jsonResult;
    
    public SniplogLoggerUnitTest() throws JSONException, IOException {
        this.sniplogLogger = new SniplogLogger();
        this.jsonResult = this.sniplogLogger.sendAction("push_snip", "9");
    }
    
    @Test
    public void checkSendActionStatus() throws JSONException  {
         assertEquals(true, this.jsonResult.getBoolean("success"));
         System.out.println(this.jsonResult);
         //assertEquals(true, this.jsonResult.getJSONArray("data"));
    }
    
    @Test 
    public void checkResponseData() throws JSONException, IOException {
        
    }
    
    
}
