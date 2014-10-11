/**
 * 
 */
package ua.edu.lp.sadiploma.tool;

/**
 * @author user
 *
 */
public enum BundleType {
	LineBundle(1), RingBundle(2), TreeBundle(3);

	BundleType(int type) {
	}

	public static int getType(BundleType type) {
		if (type.name().equalsIgnoreCase(LineBundle.name())) {
			return 1;
		} else if (type.name().equalsIgnoreCase(RingBundle.name())) {
			return 2;
		} else {
			return 3;
		}
	}

	public static BundleType getType(int n) {
		switch (n) {
		case 1:
			return BundleType.LineBundle;
		case 2:
			return BundleType.RingBundle;
		default:
			return BundleType.TreeBundle;
		}
	}

}
