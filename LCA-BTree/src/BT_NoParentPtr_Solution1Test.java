import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class BT_NoParentPtr_Solution1Test {
	
	 @Test
	    public void testConstructor()
	    {
	        new BT_NoParentPtr_Solution1();
	    }
	 
	 @Test
	    public void testFindLCA()
	    {
		    BT_NoParentPtr_Solution1 tree = new BT_NoParentPtr_Solution1(); 
	        BT_NoParentPtr_Solution1.root = new Node(1); 
	        BT_NoParentPtr_Solution1.root.left = new Node(2); 
	        BT_NoParentPtr_Solution1.root.right = new Node(3); 
	        BT_NoParentPtr_Solution1.root.left.left = new Node(4); 
	        BT_NoParentPtr_Solution1.root.left.right = new Node(5); 
	        BT_NoParentPtr_Solution1.root.right.left = new Node(6); 
	        BT_NoParentPtr_Solution1.root.right.right = new Node(7); 
		    assertEquals("Checking LCA", 2, BT_NoParentPtr_Solution1.findLCA(4, 5));
		    assertEquals("Checking LCA", 1, BT_NoParentPtr_Solution1.findLCA(4, 6));
		    assertEquals("Checking LCA", 1, BT_NoParentPtr_Solution1.findLCA(3, 4));
		    assertEquals("Checking LCA", 2, BT_NoParentPtr_Solution1.findLCA(2, 4));
	    }

}
