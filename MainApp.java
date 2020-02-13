import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainApp implements StateClient {
	private JFrame frame = new JFrame("Dryckjom 2000");
	private JButton slot = new JButton("Myntinkast");
	private JButton b1 = new JButton("Default");
	private JButton b2 = new JButton("Default");
	private JButton b3 = new JButton("Default");
	private JButton cancel = new JButton("Avbryt");
	private JLabel message = new JLabel("Default");

	public MainApp() {
		buildTheUI();
		setUpEventHandling();
		State.reset(this);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainApp();
			}
		});
	}

	public void setGenericButtonTexts(String[] context) {
		b1.setText(context[0]);
		b2.setText(context[1]);
		b3.setText(context[2]);
	}

	public void setMessage(String text) {
		message.setText(text);
	}

	private void setUpEventHandling() {
		// The interesting part:
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				State.getState().handleButton1(MainApp.this);
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				State.getState().handleButton2(MainApp.this);
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				State.getState().handleButton3(MainApp.this);
			}
		});
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				State.getState().handleCancel(MainApp.this);
			}
		});
		slot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				State.getState().handleCoinInserted(MainApp.this);
			}
		});
	}

	private void buildTheUI() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel upper = new JPanel();
		upper.add(cancel);
		upper.add(slot);
		JPanel mid = new JPanel();
		mid.add(b1);
		mid.add(b2);
		mid.add(b3);
		JPanel lower = new JPanel();
		lower.add(message);
		JPanel panel = new JPanel();
		panel.add(upper);
		panel.add(mid);
		panel.add(lower);
		frame.add(panel);
		frame.setSize(300, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
