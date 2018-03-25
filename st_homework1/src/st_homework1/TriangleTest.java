package st_homework1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TriangleTest {

	Triangle triangle;
	@Before
	public void setUp() throws Exception {
		triangle = new Triangle();
	}

	@Test
	public void testTri() {
		assertEquals("判断是否为三角形有问题","not a triangle",triangle.tri(1,2,4));
		assertEquals("判断等边三角形有问题","equilateral",triangle.tri(4,4,4));
		assertEquals("判断等腰三角形有问题","isosceles",triangle.tri(4,2,4));
		assertEquals("判断三角形有问题","scalene",triangle.tri(6,5,4));
		assertEquals("判断是否为三角形有问题","not a triangle",triangle.tri(3,2,4));
		assertEquals("判断等边三角形有问题","equilateral",triangle.tri(6,4,4));
		assertEquals("判断等腰三角形有问题","isosceles",triangle.tri(4,2,5));
		assertEquals("判断三角形有问题","scalene",triangle.tri(6,6,7));
	}

}
