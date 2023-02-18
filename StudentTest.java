import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class StudentTest {
	public MyQueue<String> stringQ;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleQ
	public MyQueue<Double> doubleQ;
	public MyStack<Double> doubleS;
	
	// STUDENT: add variables as needed for your student tests
	Double first = new Double(1.0);
	Double second = new Double(2.0);
	Double third = new Double(3.0);
	
	@BeforeEach
	public void setUp() throws Exception {
		stringQ = new MyQueue<String>(5);
		stringQ.enqueue(a);
		stringQ.enqueue(b);
		stringQ.enqueue(c);
		
		//STUDENT: add setup for doubleQ for student tests
		doubleQ = new MyQueue<Double>(6);
		doubleQ.enqueue(first);
		doubleQ.enqueue(second);
		doubleQ.enqueue(third);
		
		doubleS = new MyStack<Double>(5);
		doubleS.push(first);
		doubleS.push(second);
		doubleS.push(third);
	}

	@AfterEach
	public void tearDown() throws Exception {
		stringQ = null;
		doubleQ = null;
	}
	@Test
	public void testPopStudent() {
		//Use the doubleQ for student tests

		try {
			assertEquals(third, doubleS.pop());
			assertEquals(second, doubleS.pop());
			assertEquals(first, doubleS.pop());
			doubleS.pop();
			assertTrue("This should have caused an StackUnderrflowException", false);
		}
		catch(StackUnderflowException e)
		{
			assertTrue("This should have caused an StackUnderflowException", true);
		}
		catch(Exception e)
		{
			assertTrue("This should have caused an StackUnderFlowException", true);
		}
	}
	
	@Test
	public void testPushStudent() {
		//Use the doubleQ for student tests
		try {
			assertEquals(3, doubleS.size());
			assertEquals(true, doubleS.push(first));
			assertEquals(4, doubleS.size());
			assertEquals(true, doubleS.push(second));
			assertEquals(5, doubleS.size());
			//Queue is full, next statement should cause QueueOverFlowException
			doubleS.push(third);
			assertTrue("This should have caused an StackOverflowException", false);
		}
		catch (StackOverflowException e){
			assertTrue("This should have caused an StackOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackOverflowException", false);
		}
	}

	@Test
	public void testDequeueStudent() {
		//Use the doubleQ for student tests
		try {
			assertEquals(first, doubleQ.dequeue());
			assertEquals(second, doubleQ.dequeue());
			assertEquals(third, doubleQ.dequeue());
			//Queue is empty, next statement should cause QueueUnderFlowException
			doubleQ.dequeue();
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
		catch (QueueUnderflowException e){
			assertTrue("This should have caused an QueueUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
	}

	@Test
	public void testEnqueueStudent() {
		//Use the doubleQ for student tests
		try {
			assertEquals(3, doubleQ.size());
			assertEquals(true, doubleQ.enqueue(first));
			assertEquals(4, doubleQ.size());
			assertEquals(true, doubleQ.enqueue(second));
			assertEquals(5, doubleQ.size());
			assertEquals(true, doubleQ.enqueue(third));
			assertEquals(6, doubleQ.size());
			//Queue is full, next statement should cause QueueOverFlowException
			doubleQ.enqueue(first);
			assertTrue("This should have caused an QueueOverflowException", false);
		}
		catch (QueueOverflowException e){
			assertTrue("This should have caused an QueueOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueOverflowException", false);
		}
	}
	
	@Test
	public void testToStringStudent() {
		//Use the doubleQ for student tests
		assertEquals("1.02.03.0", doubleQ.toString());
		doubleQ.enqueue(first);
		assertEquals("1.02.03.01.0", doubleQ.toString());
		doubleQ.enqueue(second);
		assertEquals("1.02.03.01.02.0", doubleQ.toString());
	}
}
