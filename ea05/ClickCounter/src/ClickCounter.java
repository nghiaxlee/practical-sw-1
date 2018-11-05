import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Toolkit;

public class ClickCounter extends JFrame
{
    public static void main(String[] args)
    {
        new ClickCounter();
    }

    private int     value;
    private JLabel  label;

    public ClickCounter()
    {
        addWindowListener(exit);
        setLayout(new BorderLayout());
        JPanel  buttons = new JPanel(new FlowLayout());
        label = new JLabel("Clicks: 0");
        buttons.add(new JButton(clickAction));
        buttons.add(new JButton(exitAction));
        add("Center", label);
        add("South", buttons);
        java.net.URL    url = ClickCounter.class.getResource("icon.png");
        setIconImage(Toolkit.getDefaultToolkit().getImage(url));
        setTitle("Click Counter");
        pack();
        setVisible(true);
    }

    private void kilép()
    {
        System.exit(0);
    }

    private WindowAdapter   exit = new WindowAdapter()
    {
        @Override
        public void windowClosing(WindowEvent e)
        {
            kilép();
        }
    };

    private AbstractAction  exitAction = new AbstractAction("Exit")
    {
        public void actionPerformed(ActionEvent e)
        {
            kilép();
        }
    };

    private AbstractAction  clickAction = new AbstractAction("Click Me!")
    {
        public void actionPerformed(ActionEvent e)
        {
            value++;
            label.setText("Clicks: " + value);
        }
    };
}
