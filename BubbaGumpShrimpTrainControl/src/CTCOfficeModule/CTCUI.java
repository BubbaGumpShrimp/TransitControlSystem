package CTCOfficeModule;
import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Color;
import javax.swing.JSplitPane;
import java.awt.Component;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Canvas;
import javax.swing.JToolBar;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JTextArea;


public class CTCUI {

	private JFrame frmTestapplication;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final Action ModeSync = new SwingAction();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CTCUI window = new CTCUI();
					window.frmTestapplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CTCUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		final int FRAME_WIDTH = 1000;
		final int FRAME_HEIGHT = 600;
		final int FRAME_X = 100;
		final int FRAME_Y = 100;
		frmTestapplication = new JFrame();
		frmTestapplication.setResizable(false);
		frmTestapplication.setTitle("TestApplication");
		frmTestapplication.setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
		frmTestapplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTestapplication.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 0, 994, 624);
		tabbedPane_1.setBackground(Color.WHITE);
		frmTestapplication.getContentPane().add(tabbedPane_1);
		String[] test = {"Test 1", "Test 2", "Test 3", "Test 4", "Test 5"};
		
		JPanel panel = new JPanel();
		tabbedPane_1.addTab("CTC Office", null, panel, null);
		panel.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, FRAME_WIDTH, 23);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mnFile.add(mntmClose);
		
		JMenu mnMode = new JMenu("Mode");
		menuBar.add(mnMode);
		
		JRadioButtonMenuItem rdbtnmntmSimulation = new JRadioButtonMenuItem("Simulation");
		buttonGroup.add(rdbtnmntmSimulation);
		mnMode.add(rdbtnmntmSimulation);
		
		JRadioButtonMenuItem rdbtnmntmEdit = new JRadioButtonMenuItem("Edit");
		rdbtnmntmEdit.setSelected(true);
		buttonGroup.add(rdbtnmntmEdit);
		mnMode.add(rdbtnmntmEdit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
		JMenuItem mntmManual = new JMenuItem("Manual");
		mnHelp.add(mntmManual);
		panel.add(menuBar);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(SystemColor.inactiveCaptionText);
		canvas.setBounds(0, 22, 675, 607);
		panel.add(canvas);
		
		JLabel lblMode = new JLabel("Mode: ");
		lblMode.setBounds(774, 37, 52, 15);
		panel.add(lblMode);
		
		JRadioButton rdbtnSimulationMode = new JRadioButton("Simulation Mode");
		buttonGroup_1.add(rdbtnSimulationMode);
		rdbtnSimulationMode.setBounds(828, 35, 145, 18);
		panel.add(rdbtnSimulationMode);
		
		JRadioButton rdbtnEditMode = new JRadioButton("Edit Mode");
		rdbtnEditMode.setSelected(true);
		buttonGroup_1.add(rdbtnEditMode);
		rdbtnEditMode.setBounds(828, 54, 130, 18);
		panel.add(rdbtnEditMode);
		
		JLabel lblTrainlist = new JLabel("TrainList:");
		lblTrainlist.setBounds(774, 84, 77, 15);
		panel.add(lblTrainlist);
		
		JComboBox cmbTrainList = new JComboBox(test);
		cmbTrainList.setBounds(848, 79, 110, 25);
		panel.add(cmbTrainList);
		
		JLabel lblBlockList = new JLabel("Block List:");
		lblBlockList.setBounds(759, 416, 77, 15);
		panel.add(lblBlockList);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(833, 411, 110, 25);
		panel.add(comboBox);
		
		JButton btnChangeTrainRoute = new JButton("Set/Edit Train Route");
		btnChangeTrainRoute.setBounds(791, 238, 167, 27);
		panel.add(btnChangeTrainRoute);
		
		JButton btnNewButton = new JButton("View/Edit Schedule");
		btnNewButton.setBounds(801, 277, 157, 27);
		panel.add(btnNewButton);
		
		JLabel lblTrainRoute = new JLabel("Train Info");
		lblTrainRoute.setBounds(759, 124, 100, 15);
		panel.add(lblTrainRoute);
		
		JButton btnNewButton_1 = new JButton("Add Block");
		btnNewButton_1.setBounds(774, 448, 117, 27);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Remove Block");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_2.setBounds(774, 487, 133, 27);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Close Block");
		btnNewButton_3.setBounds(774, 526, 117, 27);
		panel.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setBounds(881, 314, 77, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(881, 344, 77, 27);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(881, 374, 77, 27);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSendSetSpeed = new JButton("Send Set Speed");
		btnSendSetSpeed.setBounds(723, 314, 157, 27);
		panel.add(btnSendSetSpeed);
		
		JButton btnSendAuthority = new JButton("Send Authority");
		btnSendAuthority.setBounds(723, 344, 157, 27);
		panel.add(btnSendAuthority);
		
		JButton btnSendSpeedLimit = new JButton("Send Speed Limit");
		btnSendSpeedLimit.setBounds(713, 374, 167, 27);
		panel.add(btnSendSpeedLimit);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(759, 138, 199, 88);
		panel.add(textArea);
		
		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("Track Controller", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane_1.addTab("Track Model", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane_1.addTab("Train Controller", null, panel_3, null);
		
		JPanel panel_4 = new JPanel();
		tabbedPane_1.addTab("Train Model", null, panel_4, null);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
