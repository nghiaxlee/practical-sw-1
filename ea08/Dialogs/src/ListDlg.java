import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ListDlg extends OKCancelDialog
{
    private JList   list;

    public ListDlg(JFrame frame, String name, Colour[] colors)
    {
        super(frame, name);
        list = new JList(colors);
        list.addMouseListener(mouseListener);
        list.setCellRenderer(cellRenderer);
        setLayout(new BorderLayout());
        add("Center", new JScrollPane(list));
        add("South", btnPanel);

        pack();
        setResizable(false);
    }

    public Colour getValue()          { return (Colour)list.getSelectedValue(); }

    @Override
    protected boolean processOK()   { return list.getSelectedIndex() > -1; }

    @Override
    protected void processCancel()  {}

    private MouseListener   mouseListener = new MouseAdapter()
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            if ( e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1 )
                btnOK.doClick();
        }
    };

    private DefaultListCellRenderer cellRenderer = new DefaultListCellRenderer()
    {
        @Override
        public Component getListCellRendererComponent(JList l, Object o, int index,
                                                      boolean isSelected,
                                                      boolean cellHasFocus)
        {
            super.getListCellRendererComponent(l, o, index, isSelected, cellHasFocus);
            BufferedImage   im = new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB);
            Graphics        g = im.createGraphics();
            g.setColor(((Colour)o).color());
            g.fillRect(0, 0, 16, 16);
            setIcon(new ImageIcon(im));
            return this;
	    }
    };
}
