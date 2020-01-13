package rectangles.store;

import java.util.Properties;

public class Rectangle implements IRectangle, Comparable<Rectangle> {
    Integer left;
    Integer top;
    Integer right;
    Integer bottom;
    Properties properties;

    
	public Rectangle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rectangle(Integer left, Integer top, Integer right, Integer bottom, Properties properties) {
		super();
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
		this.properties = properties;
	}

	@Override
	public int compareTo(Rectangle other) {
		int res = this.top.compareTo(other.top);
		return res == 0? this.left.compareTo(other.left): res;
	}

	@Override
	public int getLeft() {
		return left;
	}

	@Override
	public int getTop() {
		return top;
	}

	@Override
	public int getRight() {
		return right;
	}

	@Override
	public int getBottom() {
		return bottom;
	}

	@Override
	public Properties getProperties() {
		return properties;
	}

}
