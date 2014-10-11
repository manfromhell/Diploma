package ua.edu.lp.sadiploma.tool;

import java.util.ArrayList;
import java.util.List;

public class TreeBundle implements Bundle {
	private Component component;

	public TreeBundle(Component component) {
		this.component = new Node(component);
	}

	@Override
	public List<Integer> generateCombinations() {
		List<Integer> allNumbers = new ArrayList<Integer>();
		List<List<Component>> combinations = component
				.getAllCombinations(component);
		for (List<Component> list : combinations) {
			int result = 0;
			for (Component c : list) {
				result += c.getValue();
			}
			allNumbers.add(result);
		}
		return allNumbers;
	}

	@Override
	public BundleType getBundleType() {
		return BundleType.TreeBundle;
	}

	@Override
	public Bundle clone() {
		Bundle bundle = new TreeBundle(getData());
		return bundle;
	}

	@Override
	public Component getData(int i) {
		return component.getRoot().findComponent(i);
	}

	public int getDataLength() {
		return component.getSize();
	}

	@Override
	public String toString() {
		return component.toString();

	}

	@Override
	public Component getData() {
		return component;
	}

	@Override
	public void setData(Component data) {
		this.component = data;

	}

	@Override
	public void setData(int index, int value) {
		this.component.getRoot().findComponent(index).setValue(value);
	}

	@Override
	public int getDataSum() {
		int result = 0;
		for (int value : this.component.getAllValues()) {
			result += value;
		}
		return result;
	}

	@Override
	public boolean hasRepeats() {
		List<Integer> intData = component.getAllValues();
		for (int i = 0; i < intData.size() - 1; i++) {
			for (int j = i + 1; j < intData.size(); j++) {
				if (intData.get(i).equals(intData.get(j))) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean hasNegatives() {
		for (int val : component.getAllValues()) {
			if (val < 1) {
				return true;
			}
		}
		return false;
	};

	/**
	 * @return the component
	 */
	@Override
	public Component getComponent() {
		return component;
	}

	/**
	 * @param component
	 *            the component to set
	 */
	@Override
	public void setComponent(Component component) {
		this.component = component;
	}
}
