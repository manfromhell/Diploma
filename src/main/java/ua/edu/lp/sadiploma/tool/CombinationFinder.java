package ua.edu.lp.sadiploma.tool;

import java.util.ArrayList;
import java.util.List;

public class CombinationFinder {
	private int idealSum;
	List<Integer> lists;
	private int number;
	
	
	public CombinationFinder(int number, BundleType type){
		lists = new ArrayList<Integer>();
		switch (BundleType.getType(type)) {
		case 1:
			idealSum = (number * (number + 1)) / 2;
			break;
		default:
			idealSum = number * (number - 1) + 1;
		}
		this.number = number;
	}
	public List<Integer> findCombination() {
		lists.clear();
		findNumbers(3, 3, "1 2 ");//new ArrayList<Integer>()
		return lists;
	}

	private void findNumbers(int start, int sum, String list) { // List<Integer> list
		for (int i = start; i <= idealSum / 2 +1; i++) {
			if ((sum + i )< idealSum){
				findNumbers(i+1, sum+i, list+i+" ");
			} else if ((sum + i ) == idealSum){
				List<Integer> tmpList = new ArrayList<Integer>();
				String[] strs = list.concat(i+"").split(" ");
				for (String val : strs){
					tmpList.add(Integer.parseInt(val));
				}
				if ((tmpList.size()==number)&&(lists.size()<number)){
					lists.addAll(tmpList);
					return;
				}
				
			}
		}
	}

}
