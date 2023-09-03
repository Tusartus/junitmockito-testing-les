
JUnit 5 provides several static methods in the org.junit.jupiter.api.Assertions 
class for writing assertions in your tests. Here is a list of some commonly used 
assertions along with examples and explanations:

1. assertEquals: Compares the actual value with the expected value and throws
 an exception if they are not equal. For example:

 assertEquals(expectedValue, actualValue);


2. assertTrue: Verifies that a condition is true. For example:

assertTrue(1 > 0);


3. assertFalse: Verifies that a condition is false. For example:
assertFalse(1 < 0);


4.assertNull: Verifies that an object is null. For example:

Object obj = null;
assertNull(obj);

5. assertNotNull: Verifies that an object is not null. For example:

Object obj = new Object();
assertNotNull(obj);


6.assertArrayEquals: Compares two arrays for equality. For example:

int[] expectedArray = {1, 2, 3};
int[] actualArray = {1, 2, 3};
assertArrayEquals(expectedArray, actualArray);


7. assertSame: Verifies that two references refer to the same object. For example:

Object obj1 = new Object();
Object obj2 = obj1;
assertSame(obj1, obj2);


8. assertNotSame: Verifies that two references do not refer to the same object. 
For example:

Object obj1 = new Object();
Object obj2 = new Object();
assertNotSame(obj1, obj2);


9. assertThrows: Verifies that a specific exception is thrown. For example:

@Test
void testException() {
    assertThrows(ArithmeticException.class, () -> {
        int i = 1 / 0;
    });
}


***********************************************************************

---> 
@BeforeEach  must contains what specific and when like 
 when(repository.findById(1L)).thenReturn(Optional.of(expected)); is used to do what?


The @BeforeEach annotation is used to specify a method that should be executed 
before each test method in the test class. This method can be used to set up any
 preconditions that are required for the tests to run.

In the example you provided, 
when(repository.findById(1L)).thenReturn(Optional.of(expected)) is used 
to specify a behavior for a mock object. The when method is part of the Mockito 
framework and it is used to specify
 the behavior of a mock object in response to a specific method call. In 
 this case, the findById method of the repository object is being stubbed 
 to return Optional.of(expected) when called with the argument 1L.

This is a common technique used in unit testing to isolate the code being 
tested from its dependencies. By using mock objects, you can control the 
behavior of the dependencies and ensure that the code under test behaves as expected.





***************************************************


is there other arguments behalve this the argument 1L :
-------------------------------

Yes, the argument 1L in the example is just an example. You can specify any
 argument that the findById method takes. For example, if the findById method
  takes an int instead of a long, you can specify the argument like this:


when(repository.findById(123)).thenReturn(Optional.of(expected));


Or, if the method takes multiple arguments, you can specify the arguments like this:

when(repository.findById(arg1, arg2, arg3)).thenReturn(Optional.of(expected));


----------
You can also use the any method from the Mockito framework to match any
 argument, regardless of its value. For example:

when(repository.findById(Mockito.any())).thenReturn(Optional.of(expected));


This will return Optional.of(expected) for any call to the findById method, 
regardless of the argument passed to it.



