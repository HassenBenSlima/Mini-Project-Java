package data_base.iit;

import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;

public class ViewDataBase extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void TreeDemo() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Connexions");

		DefaultMutableTreeNode children = new DefaultMutableTreeNode("Books for Java Programmers");
		root.add(children);

	}

}
