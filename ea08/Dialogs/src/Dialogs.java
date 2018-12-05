import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

public class Dialogs extends JFrame
{
    private JTextArea   info;

    private Colour[]      colors = { new Colour("Black", Color.black), new Colour("White", Color.white),
                                   new Colour("Gray", Color.gray), new Colour("Red", Color.red),
                                   new Colour("Green", Color.green), new Colour("Blue", Color.blue),
                                   new Colour("Yellow", Color.yellow), new Colour("Magenta", Color.magenta),
                                   new Colour("Cyan", Color.cyan) };

    private int         value = 10;

    private SliderDlg   sliderDlg = new SliderDlg(this, "Slider", 0, 20, value, 5);
    private AbstractAction  sliderAction = new AbstractAction("Slider")
    {
        public void actionPerformed(ActionEvent e)
        {
            sliderDlg.setValue(value);
            sliderDlg.setVisible(true);
            if ( sliderDlg.getButtonCode() != OKCancelDialog.OK )  return;
            value = sliderDlg.getValue();
            info.append("Slider value: " + value + "\n");
        }
    };

    private boolean     inverse = false;
    private ButtonDlg   buttonDlg = new ButtonDlg(this, "Background color", colors, inverse);
    private AbstractAction  buttonAction = new AbstractAction("Buttons")
    {
        public void actionPerformed(ActionEvent e)
        {
            buttonDlg.setValue(inverse);
            buttonDlg.setVisible(true);
            if ( buttonDlg.getButtonCode() != OKCancelDialog.OK ) return;
            if ( inverse = buttonDlg.inverseMode() )
            {
                info.setBackground(inverse(info.getForeground()));
                info.append("Inverse background\n");
            }
            else
            {
                info.setBackground(colors[buttonDlg.color()].color());
                info.append("Background " + colors[buttonDlg.color()].name() + "\n");
            }
        }
    };

    private ListDlg     listDlg = new ListDlg(this, "Szövegszín", colors);
    private AbstractAction  listAction = new AbstractAction("List")
    {
        public void actionPerformed(ActionEvent e)
        {
            listDlg.setVisible(true);
            if ( listDlg.getButtonCode() != OKCancelDialog.OK )    return;
            Colour    sz = listDlg.getValue();
            info.setForeground(sz.color());
            info.append("Text " + sz.name() + "\n");
        }
    };

    private ComboDlg    comboDlg = new ComboDlg(this, "Combo", colors);
    private AbstractAction  comboAction = new AbstractAction("Combobox")
    {
        public void actionPerformed(ActionEvent e)
        {
            comboDlg.setVisible(true);
            if ( comboDlg.getButtonCode() != OKCancelDialog.OK )    return;
            info.append("Combo: " + comboDlg.getValue() + "\n");
        }
    };

    private ComboListDlg    comboListDlg = new ComboListDlg(this, "Combolist", colors);
    private AbstractAction  comboListAction = new AbstractAction("Combolist")
    {
        public void actionPerformed(ActionEvent e)
        {
            comboListDlg.setVisible(true);
            if ( comboListDlg.getButtonCode() != OKCancelDialog.OK )    return;
            info.append("Combolist: " + comboListDlg.getValue().name() + "\n");
        }
    };

    private EditDlg     editDlg = new EditDlg(this, "Texteditor");
    private AbstractAction  editAction = new AbstractAction("Texteditor")
    {
        public void actionPerformed(ActionEvent e)
        {
            editDlg.setVisible(true);
            if ( editDlg.getButtonCode() != OKCancelDialog.OK ) return;
            info.append("Texteditor: " + editDlg.getValue() + "\n");
        }
    };

    private SpinnerDlg  spinnerDlg = new SpinnerDlg(this, "Spinner", 0, 20, value);
    private AbstractAction  spinnerAction = new AbstractAction("Spinner")
    {
        public void actionPerformed(ActionEvent e)
        {
            spinnerDlg.setValue(value);
            spinnerDlg.setVisible(true);
            if ( spinnerDlg.getButtonCode() != OKCancelDialog.OK )  return;
            value = spinnerDlg.getValue();
            info.append("Spinner: " + value + "\n");
        }
    };

    private TableDlg tableDlg = new TableDlg(this, "Table of colors", colors);
    private AbstractAction  tableAction = new AbstractAction("Table")
    {
        public void actionPerformed(ActionEvent e)
        {
            tableDlg.setVisible(true);
        }
    };

    public Dialogs()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JMenuBar    menu = new JMenuBar();
        JMenu       dlg = new JMenu("Dialogs");
        dlg.setMnemonic('P');
        JMenuItem   item;
        item = dlg.add(sliderAction);    item.setMnemonic('C');
        item = dlg.add(buttonAction);     item.setMnemonic('G');
        item = dlg.add(listAction);      item.setMnemonic('L');
        item = dlg.add(comboAction);      item.setMnemonic('O');
        item = dlg.add(comboListAction);  item.setMnemonic('I');
        item = dlg.add(editAction);       item.setMnemonic('E');
        item = dlg.add(spinnerAction);    item.setMnemonic('S');
        item = dlg.add(tableAction);      item.setMnemonic('T');
        menu.add(dlg);
        setJMenuBar(menu);
        info = new JTextArea();
        info.setForeground(colors[0].color());
        add(new JScrollPane(info));
        setSize(300, 200);
        setVisible(true);
    }

    private Color inverse(Color c)
    {
        return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
    }

    public static void main(String[] args)
    {
        new Dialogs();
    }
}
