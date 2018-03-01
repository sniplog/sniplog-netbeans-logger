/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sniplog.sniploglogger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
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
        // TODO implement action body
    }
}
