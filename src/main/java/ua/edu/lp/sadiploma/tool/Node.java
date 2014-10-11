package ua.edu.lp.sadiploma.tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Node implements Component {
	private int index;
	private int value;
	private boolean endOfChain;
	private List<Integer> parentCode;

	private Component parentNode;
	private List<Component> components;

	/**
	 * @param index
	 * @param value
	 * @param endOfChain
	 * @param parentNode
	 * @param components
	 */
	public Node(Component component) {
		super();
		this.index = component.getIndex();
		this.value = component.getValue();
		this.endOfChain = component.getEndOfChain();
		if (component.getParentNode() != null){
			this.parentNode = new Node(component.getParentNode());
		}
		if (component.getParentCode() != null){
			this.parentCode = new ArrayList<Integer>(component.getParentCode());
		}
		if (component.getComponents() == null){
			this.components = new ArrayList<Component>();
		} else{
			this.components = new ArrayList<Component>();
			for (Component tmpComponent : component.getComponents()){
				this.components.add(copyComponent(tmpComponent, null));
			 }
		}
	}

	@Override
	protected Component clone() {
		return copyComponent(this, null);
	}

	public static Component copyComponent(Component source,Component newComponentParent) {
		Component result = new Node(source.getIndex(), source.getValue(),
				newComponentParent);
		if (source.getComponents() != null) {
			for (Component tmpComponent : source.getComponents()) {
				result.addComponent(copyComponent(tmpComponent,result));
			}
		}
		return result;
	}

	/**
	 * @return the endOfChain
	 */
	@Override
	public boolean getEndOfChain() {
		return endOfChain;
	}

	/**
	 * @param endOfChain
	 *            the endOfChain to set
	 */
	@Override
	public void setEndOfChain(boolean endOfChain) {
		this.endOfChain = endOfChain;
	}

	public Node(int index, int value, Component parentNode) {
		this.index = index;
		this.value = value;
		this.parentNode = parentNode;
		if ((parentNode != null) && (parentNode.getParentCode() != null)) {
			this.parentCode = parentNode.getParentCode();
		}
		this.components = new ArrayList<Component>();
	}

	public Node(int value) {
		this.index = 1;
		this.value = value;
		this.parentNode = null;
		this.components = new ArrayList<Component>();
	}

	public Node() {
		this.index = 1;
		this.value = 0;
		this.parentNode = null;
		this.components = new ArrayList<Component>();

	}

	@Override
	public Component getRoot() {
		if (this.parentNode == null) {
			return this;
		}
		return this.parentNode.getRoot();
	}

	public void addComponent(Component component) {
		components.add(component);
	}

	public void removeComponent(Component component) {
		components.remove(component);
	}

	/**
	 * Use only for root component
	 */
	@Override
	public Component findComponent(int index) {
		if (this.index == index) {
			return this;
		}
		for (Component component : this.getComponents()) {
			Component foundComponent = component.findComponent(index);
			if (foundComponent != null) {
				return foundComponent;
			}
		}
		return null;
	}

	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public Component getParentNode() {
		return parentNode;
	}

	@Override
	public void setParentNode(Component parentNode) {
		this.parentNode = parentNode;
	}

	@Override
	public List<Component> getComponents() {
		return components;
	}

	@Override
	public void setComponents(List<Component> components) {
		this.components = components;
	}

	public static Component generateTree(String parentCode, String data) {
		String[] parentCodeArray = parentCode.split("[, /;-]|(, )");
		List<Integer> intParentCode = new ArrayList<Integer>();
		String[] dataArray = data.split("[, /;-]|(, )");
		int[] dataArrayInt = new int[dataArray.length];

		for (int i = 0; i < parentCodeArray.length; i++) {
			intParentCode.add(Integer.parseInt(parentCodeArray[i]));
			dataArrayInt[i] = Integer.parseInt(dataArray[i]);
		}
		System.out
				.println(intParentCode + "\n" + Arrays.toString(dataArrayInt));
		Component root = new Node(dataArrayInt[0]);
		root.setParentCode(intParentCode);
		for (int i = 1; i < dataArrayInt.length; i++) {
			Component component = root.findComponent(intParentCode.get(i));
			component.addComponent(new Node(i + 1, dataArrayInt[i], component));
		}
		return root;
	}

	@Override
	public int getSize() {
		if (this.components.size() > 0) {
			int result = 1;
			for (Component c : components) {
				result += c.getSize();
			}
			return result;
		} else {
			return 1;
		}
	}

	@Override
	public List<Integer> getAllValues() {
		List<Integer> result = new ArrayList<Integer>();
		result.add(this.value);
		for (Component c : this.components) {
			result.addAll(c.getAllValues());
		}
		return result;
	}

	@Override
	public String toString() {
		return "Node [index=" + index + ", value=" + value
				+ ", components=\n\t" + components + "]";
	}

	@Override
	public int[][] createTable(List<Integer> parentCode) { // List<List<Integer>>
		int[][] result = new int[this.getSize()][this.getSize()];
		for (int col = 1; col < getSize(); col++) {
			result[parentCode.get(col) - 1][col] = 1;
		}
		return result;
	}

	@Override
	public List<List<Component>> getAllCombinations(Component root) {
		List<List<Component>> components = new ArrayList<List<Component>>();
		int[][] matrix = root.createTable(root.getParentCode());
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[0].length; column++) {
				if (matrix[row][column] == 1) {
					Component c1 = root.findComponent(row + 1);
					c1.setEndOfChain(true);
					Component c2 = root.findComponent(column + 1);
					c2.setEndOfChain(true);
					components.add(Arrays.asList(c1, c2));
				}
			}
		}

		List<List<Component>> tmpResult;
		do {
			tmpResult = new ArrayList<List<Component>>();
			for (int i = 0; i < components.size() - 1; i++) {
				for (int j = i + 1; j < components.size(); j++) {
					List<Component> newChain = checkNeighbours(
							components.get(i), components.get(j));
					if (newChain != null && !listContains(components, newChain)
							&& !listContains(tmpResult, newChain)) {
						tmpResult.add(newChain);
					}
				}
			}

			if (tmpResult.size() > 0) {
				components.addAll(tmpResult);
			}
		} while (tmpResult.size() > 0);

		for (Integer i : root.getAllValues()) {
			List<Component> l = new ArrayList<Component>();
			l.add(new Node(i, i, null));
			components.add(l);
		}
		Collections.sort(components, new ComponentListComparator());
		return components;

	}

	private static boolean listsEqual(List<Component> l1, List<Component> l2) {
		for (Component c : l1) {
			if (!l2.contains(c)) {
				return false;
			}
		}
		for (Component c : l2) {
			if (!l1.contains(c)) {
				return false;
			}
		}
		return true;
	}

	private static boolean listContains(List<List<Component>> l1,
			List<Component> l2) {
		for (List<Component> c : l1) {
			if (listsEqual(c, l2)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Component> checkNeighbours(List<Component> c1,
			List<Component> c2) {
		List<Component> result = new ArrayList<Component>();
		boolean isSingle = false;
		for (Component component : c1) {
			if (c2.contains(component)) {
				if (isSingle == true) {
					return null;
				}
				isSingle = true;
				if ((component.getEndOfChain() == true)
						&& (c2.get(c2.indexOf(component)).getEndOfChain())) {
					Component component2 = new Node(component);
					for (Component c : c1) {
						if (!c.equals(component)) {
							result.add(new Node(c));
						}
					}
					component2.setEndOfChain(false);
					result.add(component2);
					for (Component c : c2) {
						if (!c.equals(component)) {
							result.add(new Node(c));
						}
					}
				}
			}
		}
		return result.size() > 0 ? result : null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (index != other.index)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public List<Integer> getParentCode() {
		return parentCode;
	}

	@Override
	public void setParentCode(List<Integer> parentCode) {
		this.parentCode = parentCode;
	}

	@Override
	public int compareTo(Component o) {
		return Integer.compare(this.index, o.getIndex());
	}

	@Override
	public void swap(Component component) {
		int value = this.value;
		this.value = component.getValue();
		component.setValue(value);
	}

}
