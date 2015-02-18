package org.chronicweirdo.junk;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.TreeMap;

/**
 * This comparator can be configured with different a different sorting order (ascending/descending) for the value and
 * the name. Value ordering takes precedence over name ordering, but when two values are in the same range (and are
 * considered equal) the name is used for ordering. This comparator is more flexible than using an
 * @see org.springframework.util.comparator.InvertibleComparator with
 * @see com.ingenuity.uio.api.v1.model.export.networks.DoubleComparator
 */
public class ReversibleDoubleComparator implements Comparator {
    public static final double EQUALITY_THRESHOLD = 0.00001;
    private String name;
	private double value;
	private double maxValue;
    private boolean valueAscending = true;
    private boolean nameAscending = true;

	public ReversibleDoubleComparator() {
	}

	public ReversibleDoubleComparator(String categoryname, double score, double maxscore) {
        this(categoryname, score, maxscore, true, true);
    }

	public ReversibleDoubleComparator(String name, double value, double maxValue,
                                      boolean valueAscending, boolean nameAscending) {
		this.name = name;
		this.value = value;
		this.maxValue = maxValue;
        this.valueAscending = valueAscending;
        this.nameAscending = nameAscending;
	}

	public int compare(Object o1, Object o2) {
		ReversibleDoubleComparator c1 = (ReversibleDoubleComparator) o1;
		ReversibleDoubleComparator c2 = (ReversibleDoubleComparator) o2;
		return compareDoubles(c1.getValue(), c1.getName(), c2.getValue(), c2.getName(),
                this.valueAscending, this.nameAscending);
	}

    public void setValueAscending(boolean valueAscending) {
        this.valueAscending = valueAscending;
    }

    public void setNameAscending(boolean nameAscending) {
        this.nameAscending = nameAscending;
    }

    private static int compare(boolean ascending, String name1, String name2) {
        if (ascending) {
            return name1.compareTo(name2);
        } else {
            return name2.compareTo(name1);
        }
    }

    private static int compare(boolean ascending, double value1, double value2) {
        if (ascending) {
            return Double.compare(value1, value2);
        } else {
            return Double.compare(value2, value1);
        }
    }

    private static int compareDoubles(double min1, String name1, double min2, String name2,
                                      boolean valueAscending, boolean nameAscending) {
        boolean useNames = false;

        double abs = Math.abs(1 - min1 / min2);
        if ((Double.isNaN(abs) && Double.compare(min1, min2) == 0)
                || (abs < EQUALITY_THRESHOLD)) {
            useNames = true;
        }

        if (useNames) {
            return compare(nameAscending, name1, name2);
        } else {
            return compare(valueAscending, min1, min2);
        }
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReversibleDoubleComparator that = (ReversibleDoubleComparator) o;

        if (Double.compare(that.value, value) != 0) return false;
        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String getName() {return this.name;}
	public double getValue() {return this.value;}
	public double getMaxValue() {return this.maxValue;}

    @Override
    public String toString() {
        return "ReversibleDoubleComparator{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", maxValue=" + maxValue +
                ", valueAscending=" + valueAscending +
                ", nameAscending=" + nameAscending +
                '}';
    }

    public static void main(String[] args) {
        System.out.println(Double.compare(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
        ReversibleDoubleComparator c1 = new ReversibleDoubleComparator("1", Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        ReversibleDoubleComparator c2 = new ReversibleDoubleComparator("2", Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
        System.out.println(c1.equals(c2));

        ReversibleDoubleComparator comparator = new ReversibleDoubleComparator();
        comparator.setValueAscending(true);
        comparator.setNameAscending(true);
        TreeMap<ReversibleDoubleComparator, String> output = new TreeMap<ReversibleDoubleComparator, String>(comparator);
        output.put(c1, "s1");
        output.put(c2, "s2");
        System.out.println(output.size());
        for (String s: output.values()) {
            System.out.println(s);
        }
    }
}
