import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CanvasWindow extends JFrame {

    public CanvasWindow()
    {
        setTitle("RandomRem 5-in-a-row");
        setSize(525 + 100, 525 + 100);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                showExitConfirmation();
            }
        });
    }

    private void showExitConfirmation()
    {
        int n = JOptionPane.showConfirmDialog(this, "Really wanna quit? T_T",
                "Sure?", JOptionPane.YES_NO_OPTION);
        if (n == JOptionPane.YES_OPTION)
        {
            this.dispose();
        }
    }
}
