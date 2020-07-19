package com.theory.junits;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.theory.support.Locator;
import com.theory.support.LocatorService;
import com.theory.support.Point;
 
@RunWith(MockitoJUnitRunner.class)
public class LocatorTest {
 
    private static final Point TEST_POINT = new Point(11, 11);
 
    @Mock
    private LocatorService locatorServiceMock;
 
    private Locator locatorUnderTest;
 
    @Before
    public void setUp() {
        when(locatorServiceMock.geoLocate(any(Point.class)))
            .thenReturn(TEST_POINT);
 
        locatorUnderTest = new Locator(locatorServiceMock);
    }
 
    @Test
    public void testLocateWithServiceResult() {
        assertEquals(TEST_POINT, locatorUnderTest.locate(1, 1));
    }
 
    @Test
    public void testLocateLocalResult() {
        Point expected = new Point(1, 1);
        assertTrue(arePointsEqual(expected, locatorUnderTest.locate(-1, -1)));
    }
 
    private boolean arePointsEqual(Point p1, Point p2) {
        return p1.getX() == p2.getX()
            && p1.getY() == p2.getY();
    }
}
