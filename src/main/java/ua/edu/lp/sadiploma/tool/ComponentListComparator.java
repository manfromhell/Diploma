/**
 * 
 */
package ua.edu.lp.sadiploma.tool;

import java.util.Comparator;
import java.util.List;

/**
 * @author Taras Hrytsko
 *
 */
public class ComponentListComparator implements Comparator<List<Component>> {

	@Override
	public int compare(List<Component> o1, List<Component> o2) {
		int result1 = 0;
		int result2 = 0;
		for (Component c : o1) {
			result1 +=c.getValue();
		}
		for (Component c : o2) {
			result2 +=c.getValue();
		}
		return Integer.compare(result1, result2);
	}


}
