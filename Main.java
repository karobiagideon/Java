import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main extends JFrame {
  private final JDesktopPane desktopPane = new JDesktopPane();

  public Main() {
    JInternalFrame frame1 = new JInternalFrame("Frame 1", true, true, true,true);

    JInternalFrame frame2 = new JInternalFrame("Frame 2", true, true, true, true);

    frame1.getContentPane().add(new JLabel("Frame 1  contents..."));
    frame1.pack();
    frame1.setVisible(true);

    frame2.getContentPane().add(new JLabel("Frame 2  contents..."));
    frame2.pack();
    frame2.setVisible(true);

    int x2 = frame1.getX() + frame1.getWidth() + 10;
    int y2 = frame1.getY();
    frame2.setLocation(x2, y2);

    desktopPane.add(frame1);
    desktopPane.add(frame2);

    this.add(desktopPane, BorderLayout.CENTER);

    this.setMinimumSize(new Dimension(300, 300));
  }
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception e) {
      e.printStackTrace();
    }
    SwingUtilities.invokeLater(() -> {
      Main frame = new Main();
      frame.pack();
      frame.setVisible(true);
      frame.setExtendedState(frame.MAXIMIZED_BOTH);
    });
  }
}
