package TrackControlModule;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.layout.GridLayout;
import swing2swt.layout.FlowLayout;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.wb.swt.layout.grouplayout.GroupLayout;
import org.eclipse.swt.widgets.Composite;
import swing2swt.layout.BoxLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Label;


public class TrackControlUI {

	protected Shell shell;
	private Table table;
	private Table table_1;
	private Table table_2;
	private Table table_3;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TrackControlUI window = new TrackControlUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(720, 417);
		shell.setText("SWT Application");
		
		TabFolder tabFolder = new TabFolder(shell, SWT.NONE);
		
		TabItem tbtmRedTrack = new TabItem(tabFolder, SWT.NONE);
		tbtmRedTrack.setText("Red Track");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		tbtmRedTrack.setControl(composite);
		composite.setLayout(new GridLayout(1, false));
		
		Combo combo = new Combo(composite, SWT.NONE);
		GridData gd_combo = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_combo.heightHint = 1;
		combo.setLayoutData(gd_combo);
		combo.setText("Choose Track Controller");
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_table.heightHint = 2;
		table.setLayoutData(gd_table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		table_1 = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		GridData gd_table_1 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_table_1.heightHint = 150;
		table_1.setLayoutData(gd_table_1);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TabItem tbtmGreenTrack = new TabItem(tabFolder, SWT.NONE);
		tbtmGreenTrack.setText("Green Track");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tbtmGreenTrack.setControl(composite_1);
		composite_1.setLayout(new GridLayout(1, false));
		
		Combo combo_1 = new Combo(composite_1, SWT.NONE);
		GridData gd_combo_1 = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
		gd_combo_1.heightHint = 1;
		combo_1.setLayoutData(gd_combo_1);
		combo_1.setText("Choose Track Controller");
		
		table_2 = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table_2.setLinesVisible(true);
		table_2.setHeaderVisible(true);
		GridData gd_table_2 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_table_2.heightHint = 2;
		table_2.setLayoutData(gd_table_2);
		
		table_3 = new Table(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table_3.setLinesVisible(true);
		table_3.setHeaderVisible(true);
		GridData gd_table_3 = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_table_3.heightHint = 150;
		table_3.setLayoutData(gd_table_3);
		GroupLayout gl_shell = new GroupLayout(shell);
		gl_shell.setHorizontalGroup(
			gl_shell.createParallelGroup(GroupLayout.LEADING)
				.add(tabFolder, GroupLayout.PREFERRED_SIZE, 704, GroupLayout.PREFERRED_SIZE)
		);
		gl_shell.setVerticalGroup(
			gl_shell.createParallelGroup(GroupLayout.LEADING)
				.add(tabFolder, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)
		);
		shell.setLayout(gl_shell);

	}
}
