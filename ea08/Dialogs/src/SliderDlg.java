import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class SliderDlg extends OKCancelDialog implements ChangeListener
{
    private JSlider     slider;
    private JLabel      info;

    public SliderDlg(JFrame frame, String name, int min, int max, int value, int major)
    {
        super(frame, name);
        if ( value < min || value > max )   value = min;
        info = new JLabel("" + value, SwingConstants.CENTER);
        slider = new JSlider(min, max, value);
        slider.setMajorTickSpacing(major);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.addChangeListener(this);
        setLayout(new BorderLayout());
        add("North", info);
        add("Center", slider);
        add("South", btnPanel);

        setSize(new Dimension(250, 120));
        setResizable(false);
    }

    @Override
    protected boolean processOK()   { return true; }

    @Override
    protected void processCancel()  {}

    public int getValue()           { return slider.getValue(); }

    public void setValue(int v)
    {
        if ( v < slider.getMinimum() ) v = slider.getMinimum();
        if ( v > slider.getMaximum() ) v = slider.getMaximum();
        slider.setValue(v);
    }

    public void stateChanged(ChangeEvent e)
    {
            info.setText("" + slider.getValue());
    }
}
