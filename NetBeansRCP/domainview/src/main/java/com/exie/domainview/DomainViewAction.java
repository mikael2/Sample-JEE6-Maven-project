package com.exie.domainview;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;

/**
 * Action which shows DomainView component.
 */
public class DomainViewAction extends AbstractAction {

    public DomainViewAction() {
        super(NbBundle.getMessage(DomainViewAction.class, "CTL_DomainViewAction"));
//        putValue(SMALL_ICON, new ImageIcon(Utilities.loadImage(DomainViewTopComponent.ICON_PATH, true)));
    }

    public void actionPerformed(ActionEvent evt) {
        TopComponent win = DomainViewTopComponent.findInstance();
        win.open();
        win.requestActive();
    }
}
