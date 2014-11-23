package ua.edu.lp.sadiploma.tool;

import java.util.List;

public interface Bundle extends Cloneable{
	public int getDataSum();
	public Component getData(int i);
	public int getDataLength();
	public String toString();
	public Component getData();
	public void setData(Component data);
	public void setData(int index, int value);
	public BundleType getBundleType();
	boolean hasRepeats();
	Bundle clone();
	boolean hasNegatives();
	boolean hasOnes();
	List<Integer> generateCombinations();
	Component getComponent();
	void setComponent(Component component);
}
