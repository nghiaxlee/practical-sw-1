// Le Minh Nghia
//
// AAOGMU
//
// 2nd Assignment - Tricky 5-in-a-row
//
// 2018/11/18 14:14:19
//
// This solution was submitted and prepared by Le Minh Nghia, AAOGMU for the
// 2nd Assignment - Tricky 5-in-a-row assignment of the Practical software engineering I. course.
//
// I declare that this solution is my own work.
//
// I have not copied or used third party solutions.
//
// I have not passed my solution to my classmates, neither  made it public.
//
// Students’ regulation of Eötvös Loránd University (ELTE Regulations
// Vol. II. 74/C. § ) states that as long as a student presents another
// student’s work - or at least the significant part of it - as his/her own
// performance, it will count as a disciplinary fault. The most serious
// consequence of a disciplinary fault can be dismissal of the student from
// the University.

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CanvasWindow extends JFrame {

    public CanvasWindow()
    {
        setTitle("RandomRem 5-in-a-row");
        setSize(525 + 100, 525 + 120);
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
