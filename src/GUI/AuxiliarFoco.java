package GUI;

import javax.swing.JComponent;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class AuxiliarFoco implements AncestorListener {

    private boolean removeListener;

    public AuxiliarFoco() {
        this(true);
    }

    public AuxiliarFoco(boolean removeListener) {
        this.removeListener = removeListener;
    }

    @Override
    public void ancestorAdded(AncestorEvent e) {
        JComponent component = e.getComponent();
        component.requestFocusInWindow();

        if (removeListener) {
            component.removeAncestorListener(this);
        }
    }

    @Override
    public void ancestorMoved(AncestorEvent e) {
    }

    @Override
    public void ancestorRemoved(AncestorEvent e) {
    }
}
