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
		assertEquals("�ж��Ƿ�Ϊ������������","not a triangle",triangle.tri(1,2,4));
		assertEquals("�жϵȱ�������������","equilateral",triangle.tri(4,4,4));
		assertEquals("�жϵ���������������","isosceles",triangle.tri(4,2,4));
		assertEquals("�ж�������������","scalene",triangle.tri(6,5,4));
		assertEquals("�ж��Ƿ�Ϊ������������","not a triangle",triangle.tri(3,2,4));
		assertEquals("�жϵȱ�������������","equilateral",triangle.tri(6,4,4));
		assertEquals("�жϵ���������������","isosceles",triangle.tri(4,2,5));
		assertEquals("�ж�������������","scalene",triangle.tri(6,6,7));
	}

}
