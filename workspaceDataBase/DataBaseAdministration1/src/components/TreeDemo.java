
package components;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

public class TreeDemo extends JPanel implements TreeSelectionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JEditorPane htmlPane;
	private JTree tree;
	private static boolean DEBUG = false;

	// Optionally play with line styles. Possible values are
	// "Angled" (the default), "Horizontal", and "None".
	private static boolean playWithLineStyle = false;
	private static String lineStyle = "Horizontal";

	// Optionally set the look and feel.
	private static boolean useSystemLookAndFeel = false;

	public TreeDemo() {
		super(new GridLayout(1, 0));

		// Create the nodes.
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Connexions");
		createNodes(top);

		// Create a tree that allows one selection at a time.
		tree = new JTree(top);
		/******** Listener ********/
		// Where the tree is initialized: you can select one node
		tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

		// Listen for when the selection changes.
		tree.addTreeSelectionListener(this);
		/****************/

		// to request that the Java look and feel use only horizontal lines to group
		// nodes, use the following code:"Angled" (default)
		if (playWithLineStyle) {
			System.out.println("line style = " + lineStyle);
			tree.putClientProperty("JTree.lineStyle", lineStyle);
		}
		/** component's panel **/
		// Create the scroll pane and add the tree to it.
		JScrollPane treeView = new JScrollPane(tree);

		// Create the HTML viewing pane.
		htmlPane = new JEditorPane();
		htmlPane.setEditable(false);
		// Create an other scroll pane and add the htmlPane tree to it.
		JScrollPane htmlView = new JScrollPane(htmlPane);

		// Add the scroll panes to a split pane.
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setTopComponent(treeView);
		splitPane.setBottomComponent(htmlView);

		Dimension minimumSize = new Dimension(500, 500);

		htmlView.setMinimumSize(minimumSize);
		treeView.setMinimumSize(minimumSize);
		splitPane.setDividerLocation(500);
		splitPane.setPreferredSize(new Dimension(1000, 500));

		// Add the split pane to this panel.
		add(splitPane);
	}

	/** Required by TreeSelectionListener interface. */
	public void valueChanged(TreeSelectionEvent e) {
		// Returns the last path element of the selection.
		// This method is useful only when the selection model allows a single
		// selection.

		DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

		if (node == null)
			return;

		Object nodeInfo = node.getUserObject();
		if (node.isLeaf()) {
			// current node selected
			System.out.println(node.toString());
		}

		if (DEBUG) {
			System.out.println(nodeInfo.toString());
		}
	}

	private class BookInfo {
		public String bookName;
		public URL bookURL;

		public BookInfo(String book, String filename) {
			bookName = book;
			bookURL = getClass().getResource(filename);
			if (bookURL == null) {
				System.err.println("Couldn't find file: " + filename);
			}
		}

		public String toString() {
			return bookName;
		}
	}

	private void createNodes(DefaultMutableTreeNode top) {
		DefaultMutableTreeNode category = null;
		DefaultMutableTreeNode book = null;
		DefaultMutableTreeNode component = null;
		DefaultMutableTreeNode attribut = null;

		category = new DefaultMutableTreeNode("HR");

		component = new DefaultMutableTreeNode("Tables");
		attribut = new DefaultMutableTreeNode("Attribut");
		component.add(attribut);
		category.add(component);
		top.add(category);

		component = new DefaultMutableTreeNode("Views");
		attribut = new DefaultMutableTreeNode("Attributs");
		component.add(attribut);
		category.add(component);
		top.add(category);

		component = new DefaultMutableTreeNode("Indexs");
		attribut = new DefaultMutableTreeNode("Attributs");
		component.add(attribut);
		category.add(component);
		attribut = new DefaultMutableTreeNode("Attributs");
		component.add(attribut);
		category.add(component);

		top.add(category);

		// original Tutorial
		book = new DefaultMutableTreeNode(
				new BookInfo("The Java Tutorial: A Short Course on the Basics", "tutorial.html"));
		category.add(book);

		// Tutorial Continued
		book = new DefaultMutableTreeNode(
				new BookInfo("The Java Tutorial Continued: The Rest of the JDK", "tutorialcont.html"));
		category.add(book);

		// JFC Swing Tutorial
		book = new DefaultMutableTreeNode(
				new BookInfo("The JFC Swing Tutorial: A Guide to Constructing GUIs", "swingtutorial.html"));
		category.add(book);

		// Bloch
		book = new DefaultMutableTreeNode(new BookInfo("Effective Java Programming Language Guide", "bloch.html"));
		category.add(book);

		// Arnold/Gosling
		book = new DefaultMutableTreeNode(new BookInfo("The Java Programming Language", "arnold.html"));
		category.add(book);

		// Chan
		book = new DefaultMutableTreeNode(new BookInfo("The Java Developers Almanac", "chan.html"));
		category.add(book);

		
		category = new DefaultMutableTreeNode("OX");
		
		
		
		top.add(category);

		// VM
		book = new DefaultMutableTreeNode(new BookInfo("The Java Virtual Machine Specification", "vm.html"));
		category.add(book);

		// Language Spec
		book = new DefaultMutableTreeNode(new BookInfo("The Java Language Specification", "jls.html"));
		category.add(book);

	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be invoked
	 * from the event dispatch thread.
	 */
	private static void createAndShowGUI() {
		if (useSystemLookAndFeel) {
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				System.err.println("Couldn't use system look and feel.");
			}
		}

		// Create and set up the window.
		JFrame frame = new JFrame("TreeDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add content to the window.
		frame.add(new TreeDemo());

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}