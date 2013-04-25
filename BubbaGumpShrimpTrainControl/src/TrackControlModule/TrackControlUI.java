package TrackControlModule;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Table;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

//Most UI code generated automatically using WindowBuilder Eclipse plugin

public class TrackControlUI extends ApplicationWindow {
	private DataBindingContext m_bindingContext;
	
	private TrackLine redLine;
	private TrackLine greenLine;
	private Table greenControllerTable;
	private Table greenBlockTable;
	private TableViewer greenBlockTable1;
	private TableViewer greenControllerTable1;
	private TableColumn greenBlockNumber;
	private TableViewerColumn tableViewerColumn;
	private TableColumn greenStatus;
	private TableViewerColumn tableViewerColumn_1;
	private TableColumn greenTrain;
	private TableViewerColumn tableViewerColumn_2;
	private TableColumn greenSignal;
	private TableViewerColumn tableViewerColumn_3;
	private TableColumn greenSwitch;
	private TableViewerColumn tableViewerColumn_4;
	private TableColumn greenCrossing;
	private TableViewerColumn tableViewerColumn_5;
	private TableColumn greenControllerColumn;
	private TableViewerColumn tableViewerColumn_6;
	private Composite composite_1;
	private Table redControllerTable;
	private TableViewer redControllerTable1;
	private TableColumn redControllerColumn;
	private TableViewerColumn tableViewerColumn_7;
	private Table redBlockTable;
	private TableViewer redBlockTable1;
	private TableColumn redBlockNumber;
	private TableViewerColumn tableViewerColumn_8;
	private TableColumn redStatus;
	private TableViewerColumn tableViewerColumn_9;
	private TableColumn redTrain;
	private TableViewerColumn tableViewerColumn_10;
	private TableColumn redSignal;
	private TableViewerColumn tableViewerColumn_11;
	private TableColumn redSwitch;
	private TableViewerColumn tableViewerColumn_12;
	private TableColumn redCrossing;
	private TableViewerColumn tableViewerColumn_13;
	private Table redTrainTable;
	private Table greenTrainTable;
	private TableViewer greenTrainTable1;
	private TableColumn greenTrainList;
	private TableViewerColumn tableViewerColumn_18;
	private TableColumn greenTrainBlock;
	private TableViewerColumn tableViewerColumn_19;
	private TableColumn greenTrainAuthority;
	private TableViewerColumn tableViewerColumn_20;
	private TableColumn greenTrainSpeed;
	private TableViewerColumn tableViewerColumn_21;

	/**
	 * Create the application window.
	 */
	public TrackControlUI() {
		super(null);
		//Initialize the two track lines using the included Excel resource file
		redLine = new TrackLine("Red Line","TrackControlLines.xls");
		greenLine = new TrackLine("Green Line","TrackControlLines.xls");
		createActions();
		addMenuBar();
		addStatusLine();
	}

	/**
	 * Create contents of the application window.
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		{
			TabFolder tabFolder = new TabFolder(container, SWT.NONE);
			{
				TabItem tbtmGreenLine = new TabItem(tabFolder, SWT.NONE);
				tbtmGreenLine.setText("Green Line");
				{
					Composite composite = new Composite(tabFolder, SWT.NONE);
					tbtmGreenLine.setControl(composite);
					
					greenControllerTable1 = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
					greenControllerTable = greenControllerTable1.getTable();
					greenControllerTable.setLinesVisible(true);
					greenControllerTable.setHeaderVisible(true);
					greenControllerTable.setBounds(10, 10, 80, 486);
					
					tableViewerColumn_6 = new TableViewerColumn(greenControllerTable1, SWT.NONE);
					greenControllerColumn = tableViewerColumn_6.getColumn();
					greenControllerColumn.setWidth(75);
					greenControllerColumn.setText("Controller");
					
					greenBlockTable1 = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
					greenBlockTable = greenBlockTable1.getTable();
					greenBlockTable.setHeaderVisible(true);
					greenBlockTable.setLinesVisible(true);
					greenBlockTable.setBounds(96, 10, 470, 311);
					
					tableViewerColumn = new TableViewerColumn(greenBlockTable1, SWT.NONE);
					greenBlockNumber = tableViewerColumn.getColumn();
					greenBlockNumber.setWidth(75);
					greenBlockNumber.setText("Block Number");
					
					tableViewerColumn_1 = new TableViewerColumn(greenBlockTable1, SWT.NONE);
					greenStatus = tableViewerColumn_1.getColumn();
					greenStatus.setWidth(75);
					greenStatus.setText("Status");
					
					tableViewerColumn_2 = new TableViewerColumn(greenBlockTable1, SWT.NONE);
					greenTrain = tableViewerColumn_2.getColumn();
					greenTrain.setWidth(75);
					greenTrain.setText("Train");
					
					tableViewerColumn_3 = new TableViewerColumn(greenBlockTable1, SWT.NONE);
					greenSignal = tableViewerColumn_3.getColumn();
					greenSignal.setWidth(75);
					greenSignal.setText("Signal");
					
					tableViewerColumn_4 = new TableViewerColumn(greenBlockTable1, SWT.NONE);
					greenSwitch = tableViewerColumn_4.getColumn();
					greenSwitch.setWidth(75);
					greenSwitch.setText("Switch");
					
					tableViewerColumn_5 = new TableViewerColumn(greenBlockTable1, SWT.NONE);
					greenCrossing = tableViewerColumn_5.getColumn();
					greenCrossing.setText("Crossing");
					greenCrossing.setWidth(70);
					
					greenTrainTable1 = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
					greenTrainTable = greenTrainTable1.getTable();
					greenTrainTable.setLinesVisible(true);
					greenTrainTable.setHeaderVisible(true);
					greenTrainTable.setBounds(96, 327, 470, 169);
					
					tableViewerColumn_18 = new TableViewerColumn(greenTrainTable1, SWT.NONE);
					greenTrainList = tableViewerColumn_18.getColumn();
					greenTrainList.setWidth(75);
					greenTrainList.setText("Train");
					
					tableViewerColumn_19 = new TableViewerColumn(greenTrainTable1, SWT.NONE);
					greenTrainBlock = tableViewerColumn_19.getColumn();
					greenTrainBlock.setWidth(75);
					greenTrainBlock.setText("Block");
					
					tableViewerColumn_20 = new TableViewerColumn(greenTrainTable1, SWT.NONE);
					greenTrainAuthority = tableViewerColumn_20.getColumn();
					greenTrainAuthority.setWidth(75);
					greenTrainAuthority.setText("Authority");
					
					tableViewerColumn_21 = new TableViewerColumn(greenTrainTable1, SWT.NONE);
					greenTrainSpeed = tableViewerColumn_21.getColumn();
					greenTrainSpeed.setWidth(100);
					greenTrainSpeed.setText("Speed");
					
					Button btnToggleOccupied = new Button(composite, SWT.NONE);
					btnToggleOccupied.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							System.out.println("Button pressed: "+greenLine.getTrackController(1).getBlock(13).isOccupied());
							greenLine.getTrackController(1).getBlock(13).toggleOccupied();
							System.out.println("Button pressed: "+greenLine.getTrackController(1).getBlock(13).isOccupied());
						}
					});
					btnToggleOccupied.setBounds(572, 10, 94, 25);
					btnToggleOccupied.setText("Toggle Occupied");
				}
			}
			{
				TabItem tbtmRedLine = new TabItem(tabFolder, SWT.NONE);
				tbtmRedLine.setText("Red Line");
				
				composite_1 = new Composite(tabFolder, SWT.NONE);
				tbtmRedLine.setControl(composite_1);
				
				redControllerTable1 = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
				redControllerTable = redControllerTable1.getTable();
				redControllerTable.setLinesVisible(true);
				redControllerTable.setHeaderVisible(true);
				redControllerTable.setBounds(10, 10, 80, 486);
				
				tableViewerColumn_7 = new TableViewerColumn(redControllerTable1, SWT.NONE);
				redControllerColumn = tableViewerColumn_7.getColumn();
				redControllerColumn.setWidth(75);
				redControllerColumn.setText("Controller");
				
				redBlockTable1 = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
				redBlockTable = redBlockTable1.getTable();
				redBlockTable.setLinesVisible(true);
				redBlockTable.setHeaderVisible(true);
				redBlockTable.setBounds(96, 10, 470, 311);
				
				tableViewerColumn_8 = new TableViewerColumn(redBlockTable1, SWT.NONE);
				redBlockNumber = tableViewerColumn_8.getColumn();
				redBlockNumber.setWidth(75);
				redBlockNumber.setText("Block Number");
				
				tableViewerColumn_9 = new TableViewerColumn(redBlockTable1, SWT.NONE);
				redStatus = tableViewerColumn_9.getColumn();
				redStatus.setWidth(75);
				redStatus.setText("Status");
				
				tableViewerColumn_10 = new TableViewerColumn(redBlockTable1, SWT.NONE);
				redTrain = tableViewerColumn_10.getColumn();
				redTrain.setWidth(75);
				redTrain.setText("Train");
				
				tableViewerColumn_11 = new TableViewerColumn(redBlockTable1, SWT.NONE);
				redSignal = tableViewerColumn_11.getColumn();
				redSignal.setWidth(75);
				redSignal.setText("Signal");
				
				tableViewerColumn_12 = new TableViewerColumn(redBlockTable1, SWT.NONE);
				redSwitch = tableViewerColumn_12.getColumn();
				redSwitch.setWidth(75);
				redSwitch.setText("Switch");
				
				tableViewerColumn_13 = new TableViewerColumn(redBlockTable1, SWT.NONE);
				redCrossing = tableViewerColumn_13.getColumn();
				redCrossing.setWidth(70);
				redCrossing.setText("Crossing");
				
				TableViewer redTrainTable1 = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
				redTrainTable = redTrainTable1.getTable();
				redTrainTable.setLinesVisible(true);
				redTrainTable.setHeaderVisible(true);
				redTrainTable.setBounds(96, 327, 470, 169);
				
				TableViewerColumn tableViewerColumn_14 = new TableViewerColumn(redTrainTable1, SWT.NONE);
				TableColumn redTrainList = tableViewerColumn_14.getColumn();
				redTrainList.setWidth(75);
				redTrainList.setText("Train");
				
				TableViewerColumn tableViewerColumn_15 = new TableViewerColumn(redTrainTable1, SWT.NONE);
				TableColumn redTrainBlock = tableViewerColumn_15.getColumn();
				redTrainBlock.setWidth(75);
				redTrainBlock.setText("Block");
				
				TableViewerColumn tableViewerColumn_16 = new TableViewerColumn(redTrainTable1, SWT.NONE);
				TableColumn redTrainAuthority = tableViewerColumn_16.getColumn();
				redTrainAuthority.setWidth(75);
				redTrainAuthority.setText("Authority");
				
				TableViewerColumn tableViewerColumn_17 = new TableViewerColumn(redTrainTable1, SWT.NONE);
				TableColumn redTrainSpeed = tableViewerColumn_17.getColumn();
				redTrainSpeed.setWidth(100);
				redTrainSpeed.setText("Speed");
			}
		}
		m_bindingContext = initDataBindings();

		return container;
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Create the status line manager.
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		Display display = Display.getDefault();
		Realm.runWithDefault(SWTObservables.getRealm(display), new Runnable() {
			public void run() {
				try {
					TrackControlUI window = new TrackControlUI();
					window.setBlockOnOpen(true);
					window.open();
					Display.getCurrent().dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Configure the shell.
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("New Application");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(700, 600);
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		IObservableMap observeMap = PojoObservables.observeMap(listContentProvider.getKnownElements(), TrackController.class, "trackControllerID");
		greenControllerTable1.setLabelProvider(new ObservableMapLabelProvider(observeMap));
		greenControllerTable1.setContentProvider(listContentProvider);
		//
		IObservableList trackControllerListGreenLineObserveList = PojoProperties.list("trackControllerList").observe(greenLine);
		greenControllerTable1.setInput(trackControllerListGreenLineObserveList);
		//
		ObservableListContentProvider listContentProvider_1 = new ObservableListContentProvider();
		IObservableMap[] observeMaps = PojoObservables.observeMaps(listContentProvider_1.getKnownElements(), Block.class, new String[]{"blockID", "broken", "occupied", "signal", "switchString", "crossingString"});
		greenBlockTable1.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
		greenBlockTable1.setContentProvider(listContentProvider_1);
		//
		IObservableValue observeSingleSelectionGreenControllerTable1 = ViewerProperties.singleSelection().observe(greenControllerTable1);
		IObservableList tableViewer_3BlockListObserveDetailList = PojoProperties.list(TrackController.class, "blockList", Block.class).observeDetail(observeSingleSelectionGreenControllerTable1);
		greenBlockTable1.setInput(tableViewer_3BlockListObserveDetailList);
		//
		ObservableListContentProvider listContentProvider_2 = new ObservableListContentProvider();
		IObservableMap observeMap_1 = PojoObservables.observeMap(listContentProvider_2.getKnownElements(), TrackController.class, "trackControllerID");
		redControllerTable1.setLabelProvider(new ObservableMapLabelProvider(observeMap_1));
		redControllerTable1.setContentProvider(listContentProvider_2);
		//
		IObservableList trackControllerListRedLineObserveList = PojoProperties.list("trackControllerList").observe(redLine);
		redControllerTable1.setInput(trackControllerListRedLineObserveList);
		//
		ObservableListContentProvider listContentProvider_3 = new ObservableListContentProvider();
		IObservableMap[] observeMaps_1 = PojoObservables.observeMaps(listContentProvider_3.getKnownElements(), Block.class, new String[]{"blockID", "broken", "occupied", "signal", "switchString", "crossingString"});
		redBlockTable1.setLabelProvider(new ObservableMapLabelProvider(observeMaps_1));
		redBlockTable1.setContentProvider(listContentProvider_3);
		//
		IObservableValue observeSingleSelectionRedControllerTable1 = ViewerProperties.singleSelection().observe(redControllerTable1);
		IObservableList redControllerTable1BlockListObserveDetailList = PojoProperties.list(TrackController.class, "blockList", Block.class).observeDetail(observeSingleSelectionRedControllerTable1);
		redBlockTable1.setInput(redControllerTable1BlockListObserveDetailList);
		//
		ObservableListContentProvider listContentProvider_4 = new ObservableListContentProvider();
		IObservableMap[] observeMaps_2 = PojoObservables.observeMaps(listContentProvider_4.getKnownElements(), Train.class, new String[]{"assumedNumber", "blockLocated", "authorityIssued", "speedIssued"});
		greenTrainTable1.setLabelProvider(new ObservableMapLabelProvider(observeMaps_2));
		greenTrainTable1.setContentProvider(listContentProvider_4);
		//
		IObservableValue observeSingleSelectionGreenControllerTable1_1 = ViewerProperties.singleSelection().observe(greenControllerTable1);
		IObservableList greenControllerTable1TrainListObserveDetailList = PojoProperties.list(TrackController.class, "trainList", Train.class).observeDetail(observeSingleSelectionGreenControllerTable1_1);
		greenTrainTable1.setInput(greenControllerTable1TrainListObserveDetailList);
		//
		return bindingContext;
	}
}
