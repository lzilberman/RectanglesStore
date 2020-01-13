package rectangles.store;

import java.util.Collection;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class RectanglesStore implements IRectanglesStore {

	TreeSet<Rectangle> tree;
	
	public RectanglesStore() {  // (Comparator<Rectangle> comp) {
		super();
		this.tree = new TreeSet<>();
	}

	private boolean checkRectangle(IRectangle bounds, IRectangle rectangle) {
		
		return bounds.getLeft() <= rectangle.getLeft() && 
			   bounds.getRight() >= rectangle.getRight() &&
			   bounds.getTop() >= rectangle.getTop() &&
			   bounds.getBottom() <= rectangle.getBottom();
	}
	
	private Collection<IRectangle> checkCollection(IRectangle bounds, Collection<IRectangle> rectangles) {
		return rectangles.stream()
				.filter(r->checkRectangle(bounds, r))
				.collect(Collectors.toList());
	}
	
	@Override
	public void initialize(IRectangle bounds, Collection<IRectangle> rectangles) {
		this.tree.addAll((Collection<? extends Rectangle>) checkCollection(bounds, rectangles));
	}

	@Override
	public IRectangle findRectangleAt(int x, int y) {
		Rectangle other = new Rectangle(x, y, x+1, y-1, null);
		IRectangle res = tree.floor(other);
		return res == null ? null : res.getTop() == y ? res : null;
	}

}
