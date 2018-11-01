import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
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
	    public void testGetLCA()
	    {
		 	Node a = new Node("a",3);
		    Node b = new Node("b",4);
		    Node c = new Node("c",55);
		    Node d = new Node("d",152);
		    
		    a.link(b);
		    b.link(c);
		    a.link(d);
		    assertEquals("Testing null", null, BT_NoParentPtr_Solution1.getLCA(null, null, null));
		    assertEquals("Testing null", null, BT_NoParentPtr_Solution1.getLCA(null, a, null));
		    
		    ArrayList<Node> list = new ArrayList<Node>();
		    assertEquals("Check empty", null, BT_NoParentPtr_Solution1.getLCA(list, a, b));
		   
		    list.add(a);
		    list.add(b);
		    assertEquals("Missing node", null, BT_NoParentPtr_Solution1.getLCA(list, c, b));
		    list.add(c);
		    list.add(d);
		    ArrayList<Node> outcomes = new ArrayList<Node>();
		    outcomes.add(a);
		    assertEquals("One Common Ancestor", false, outcomes.retainAll(BT_NoParentPtr_Solution1.getLCA(list, c, d)));
		    
		    Node e = new Node("e",234);
		    e.link(b);
		    list.add(e);
		    assertEquals("One Common Ancestor.", false, outcomes.retainAll(BT_NoParentPtr_Solution1.getLCA(list, c, d)));
		    e.link(d);
		    outcomes.add(e);
		    assertEquals("Two Common Ancestors.", false, outcomes.retainAll(BT_NoParentPtr_Solution1.getLCA(list, c, d)));
		    
	    }
	 


}
