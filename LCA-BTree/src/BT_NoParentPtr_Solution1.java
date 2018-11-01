import java.util.ArrayList;


public class BT_NoParentPtr_Solution1 {

	

		public static ArrayList<Node> getLCA(ArrayList<Node> listOfNodes, Node x, Node y) {
		// Check if it is acyclic
		if (listOfNodes == null || x == null || y == null || listOfNodes.size() == 0 || !listOfNodes.contains(x)
				|| !listOfNodes.contains(y))
			return null;
		if (!acyclicTest(listOfNodes))
			return null;
		ArrayList<Node> listOfRoots = new ArrayList<Node>();
		ArrayList<Node> commonAncestors = new ArrayList<Node>();
		ArrayList<Node> ancesX = new ArrayList<Node>();
		ArrayList<Node> ancesY = new ArrayList<Node>();

		for (int i = 0; i < listOfNodes.size(); i++) {
			if (listOfNodes.get(i).indeg == 0) {
				listOfRoots.add(listOfNodes.get(i));
			}
		}

		ancesX.add(x);
		ancesY.add(y);
		for (int i = 0; i < listOfRoots.size(); i++) {
			find(listOfRoots.get(i), ancesX, ancesY);
		}
		commonAncestors = overlap(ancesX, ancesY);
		if (commonAncestors.size() == 0)
			return null;
		while (commonAncestors.size() != 1) {
			for (int i = 0; i < commonAncestors.size(); i++) {

				if (lookForImpasse(commonAncestors)) {
					return commonAncestors;
				}

				else {
					if (overlap(commonAncestors, commonAncestors.get(i).edgesTo).size() != 0) {
						commonAncestors.remove(i);
					}
				}
			}
		}
		return commonAncestors;

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
