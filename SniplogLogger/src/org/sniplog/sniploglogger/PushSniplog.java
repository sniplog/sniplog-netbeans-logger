/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sniplog.sniploglogger;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.tree.DefaultTreeCellEditor;
import org.json.JSONException;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Edit",
        id = "org.sniplog.sniploglogger.PushSniplog"
)
@ActionRegistration(
        displayName = "#CTL_PushSniplog"
)
@ActionReferences({
    @ActionReference(path = "Menu/File", position = 100)
    ,
  @ActionReference(path = "Shortcuts", name = "DOS-SPACE")
})
@Messages("CTL_PushSniplog=Push snip!")
public final class PushSniplog implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        Logger log = Logger.getLogger(PushSniplog.class.getName());
       
        try {
            String data = (String) Toolkit.getDefaultToolkit() 
                    .getSystemClipboard().getData(DataFlavor.stringFlavor);
            
            SniplogLogger sniplogLogger = new SniplogLogger();
            try {
                String response = sniplogLogger.sendAction("push_snip", "snip code").getJSONArray("data").toString();
                 log.log(Level.INFO, "api request status: " + response);
            
                PrintWriter writer = new PrintWriter("tmp-filename.txt", "UTF-8");
                writer.println(response);
                writer.println(data);
                writer.close();
            
            } catch (UnsupportedEncodingException ex) {
                Exceptions.printStackTrace(ex);
            } catch (ProtocolException ex) {
                Exceptions.printStackTrace(ex);
            } catch (MalformedURLException ex) {
                Exceptions.printStackTrace(ex);
            } catch (JSONException ex) {
                Exceptions.printStackTrace(ex);
            }
            
            
            log.log(Level.INFO, "with clipboard data: " + data);
            
            
        } catch (UnsupportedFlavorException ex) {
            Exceptions.printStackTrace(ex);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        
         log.log(Level.INFO, "message push sniplog with event: " + e.paramString());
         
    }
//    private static Logger log = Logger.getLogger(PushSniplog.class.getName());
}
