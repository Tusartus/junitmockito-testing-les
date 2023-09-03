import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class CategoryServiceTest {

  @Mock
  private CategoryRepository repository;

  private CategoryService service;

  @BeforeEach
  void setup() {
    MockitoAnnotations.initMocks(this);
    service = new CategoryService(repository);
  }

  @Test
  void testCreateCategory() {
    Category category = new Category("Test Category");
    service.createCategory(category);
    verify(repository).save(category);
  }

  @Test
  void testGetCategory() {
    Category expected = new Category("Test Category");
    when(repository.findById(1L)).thenReturn(Optional.of(expected));
    Category actual = service.getCategory(1L).get();
    assertEquals(expected, actual);
  }

  @Test
  void testUpdateCategory() {
    Category original = new Category("Test Category");
    when(repository.findById(1L)).thenReturn(Optional.of(original));
    Category updated = new Category("Updated Category");
    service.updateCategory(1L, updated);
    verify(repository).save(updated);
  }

  @Test
  void testDeleteCategory() {
    Category category = new Category("Test Category");
    when(repository.findById(1L)).thenReturn(Optional.of(category));
    service.deleteCategory(1L);
    verify(repository).delete(category);
  }
}



/**
*In this example, we are testing the CategoryService class, which is responsible 
for performing CRUD operations on Category objects. We are using the 
CategoryRepository interface to interact with a database to store the categories.

We use the @Mock annotation from Mockito to create a mock object for the 
CategoryRepository, and we use the setup method with
 MockitoAnnotations.initMocks to initialize the mocks. This allows 
 us to verify that the correct methods are being called on the repository
  without actually making any database changes.

In each test method, we use the when method from Mockito to specify what the 
repository should return when its methods are called. We then call the 
appropriate method on the CategoryService and use verify to check that 
the correct methods were called on the repository. Finally, we use 
JUnit assertions to check that the results of the methods are as expected.

This example provides a basic demonstration of how to test
 a CRUD application using JUnit 5 and Mockito in Java. Of course,
  in a real-world application, you would likely need to write many more
   tests to thoroughly test the behavior of the application.
   
*
*
*
*
*/




