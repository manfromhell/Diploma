package ua.edu.lp.sadiploma.tool;

import java.util.List;

public interface Component extends Comparable<Component>, Cloneable{
	public void addComponent(Component component);

	public void removeComponent(Component component);

	public Component findComponent(int index);

	public Component getRoot();

	public void setValue(int value);

	public Component getParentNode();

	public void setParentNode(Component parentNode);

	public List<Component> getComponents();

	public void setComponents(List<Component> components);

	List<Integer> getAllValues();

	int getSize();

	void setIndex(int index);

	int getValue();

	int[][] createTable(List<Integer> parentCode);

	boolean getEndOfChain();

	void setEndOfChain(boolean endOfChain);

	List<Component> checkNeighbours(List<Component> c1, List<Component> c2);

	List<List<Component>> getAllCombinations(Component root);

	int getIndex();

	List<Integer> getParentCode();

	void setParentCode(List<Integer> parentCode);
	
	void swap(Component component);
}
