package com.exie.domainview;

import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.actions.CookieAction;

public final class DeleteUserAction extends CookieAction {

    protected void performAction(Node[] activatedNodes) {
        Node project = activatedNodes[0].getLookup().lookup(Node.class);
        // TODO use project
    }

    protected int mode() {
        return CookieAction.MODE_ALL;
    }

    public String getName() {
        return NbBundle.getMessage(DeleteUserAction.class, "CTL_DeleteUserAction");
    }

    protected Class[] cookieClasses() {
        return new Class[]{Node.class};
    }

    @Override
    protected void initialize() {
        super.initialize();
        // see org.openide.util.actions.SystemAction.iconResource() Javadoc for more details
        putValue("noIconInMenu", Boolean.TRUE);
    }

    public HelpCtx getHelpCtx() {
        return HelpCtx.DEFAULT_HELP;
    }

    @Override
    protected boolean asynchronous() {
        return false;
    }
}

