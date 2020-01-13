package rectangles.store.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import rectangles.store.IRectangle;
import rectangles.store.IRectanglesStore;
import rectangles.store.Rectangle;
import rectangles.store.RectanglesStore;

class RectangleStoreTests {
	IRectangle r1;
	IRectangle r2;
	IRectangle r3;
	List<IRectangle> rectangles;
	IRectangle bounds;
	IRectanglesStore store;
	
	@BeforeEach
	void setUp() throws Exception {
		r1 = new Rectangle(1, -1, 3, -3, null);
		r2 = new Rectangle(2, -2, 4, -4, null);
		r3 = new Rectangle(3, -3, 10, -10, null);
		rectangles = new ArrayList<>();
		rectangles.add(r1);
		rectangles.add(r2);
		rectangles.add(r3);
		bounds = new Rectangle(0, 0, 8, -8, null);
		store = new RectanglesStore();
		store.initialize(bounds, rectangles);
	}

	@Test
	void testFound() {
		IRectangle res = store.findRectangleAt(2, -2);
		assertEquals(4, res.getRight());
	}
	@Test
	void testNotFound() {
		IRectangle res = store.findRectangleAt(5, -5);
		assertNull(res);
	}
	@Test
	void testOutOfBound() {
		IRectangle res = store.findRectangleAt(3, -3);
		assertNull(res);
	}

}
