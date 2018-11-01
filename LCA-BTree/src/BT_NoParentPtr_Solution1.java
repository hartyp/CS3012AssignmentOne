import java.util.ArrayList;


public class BT_NoParentPtr_Solution1 {

	public class Node<T> {

		public T data;
		public ArrayList<Node<T>> edgesTo;
		public T key;
		public int indeg;
		public int outdeg;

		public Node(T keyIn, T value) {
			key = keyIn;
			data = value;
			edgesTo = new ArrayList<Node<T>>();
			indeg = 0;
			outdeg = edgesTo.size();
		}

		public void link(Node<T> childNode) {
			if (childNode != null) {
				this.edgesTo.add(childNode);
				childNode.indeg++;
			}

		}

		public void deleteFrom(ArrayList<Node<T>> node) {
			if (node == null)
				return;
			for (int i = 0; i < node.size(); i++) {
				Node<T> tmp = node.get(i);
				if (tmp.edgesTo.contains(this)) {
					tmp.edgesTo.remove(tmp.edgesTo.indexOf(this));
				}
			}
			this.edgesTo = null;
		}

		public void unlink(Node<T> childNode) {
			if (childNode == null) {
				return;
			}
			
			this.edgesTo.remove(childNode);
			childNode.indeg--;
		}

		public String toString() {
			return this.key.toString();
		}
	}
	
	public static ArrayList<Node> getLCA(ArrayList<Node> listOfNodes, Node x, Node y) {
		//Check if it is acyclic
	
		

	}

	private static boolean lookForImpasse(ArrayList<Node> commonAncestors) {
		for (int i = 0; i < commonAncestors.size(); i++) {
			Node tmp = commonAncestors.get(i);
			if (overlap(commonAncestors, tmp.edgesTo).size() != 0) {
				return false;
			}
		}
		return true;
	}

	public static void find(Node root, ArrayList<Node> ancesX, ArrayList<Node> ancesY) {
		if (root.edgesTo == null || root.edgesTo.size() == 0)
			return;

		for (int i = 0; i < root.edgesTo.size(); i++) {
			Node tmp = (Node) root.edgesTo.get(i);
			if (!(ancesX.contains(tmp) || ancesY.contains(tmp)))
				find(tmp, ancesX, ancesY);
			if (ancesX.contains(tmp))
				ancesX.add(root);
			if (ancesY.contains(tmp))
				ancesY.add(root);
		}
	}

	public static boolean acyclicTest(ArrayList<Node> list) {

		if (list == null || list.size() == 0)
			return true;

		for (int i = 0; i < list.size(); i++) {
			ArrayList<Node> inspected = new ArrayList<Node>();
			ArrayList<Node> stack = new ArrayList<Node>();
			Node tmp = list.get(i);
			boolean cyclical = false;
			cyclical = checkCycle(list, tmp, inspected, stack, cyclical);
			if (cyclical) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkCycle(ArrayList<Node> list, Node tmp, ArrayList<Node> inspected, ArrayList<Node> stack,
			boolean cyclical) {
		inspected.add(tmp);
		stack.add(tmp);

		for (int i = 0; i < tmp.edgesTo.size(); i++) {
			Node a = (Node) tmp.edgesTo.get(i);
			if (!inspected.contains(a)) {
				cyclical = cyclical || checkCycle(list, a, inspected, stack, cyclical);
			} else if (stack.contains(a)) {
				cyclical = true;
				return cyclical;
			}
		}
		stack.remove(tmp);
		return cyclical;
	}


	public static ArrayList<Node> overlap(ArrayList<Node> firstList, ArrayList<Node> secondList) {
		ArrayList<Node> list = new ArrayList<Node>();

		for (Node n : firstList) {
			if (secondList.contains(n)) {
				list.add(n);
			}
		}

		return list;
	}


}
