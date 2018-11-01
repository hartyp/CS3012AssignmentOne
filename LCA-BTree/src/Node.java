import java.util.ArrayList;


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