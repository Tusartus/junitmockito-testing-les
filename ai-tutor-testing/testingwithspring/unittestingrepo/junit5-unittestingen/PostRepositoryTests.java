/*

added unittesting for save() ,  findByName()   , 
List<Post> findByCategory(Category category); 	
public void updateEnabledStatus(Integer id, boolean enabled);
	
	public Long countById(Integer id);

*/


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PostRepositoryTest {

  @Mock
  private PostRepository repository;

  private Post expected;
  private Category category;

  @BeforeEach
  public void setUp() {
    expected = new Post(1L, "Title", "Description", "Image", null);
    category = new Category(1, "Category");
    when(repository.findById(1L)).thenReturn(Optional.of(expected));
    when(repository.findByName("Title")).thenReturn(Optional.of(expected));
    when(repository.findByCategory(category)).thenReturn(Arrays.asList(expected));
    when(repository.countById(1)).thenReturn(1L);
    when(repository.findAll()).thenReturn(Arrays.asList(expected));
  }

  @Test
  public void testFindById() {
    Optional<Post> result = repository.findById(1L);
    assertTrue(result.isPresent());
    assertEquals(1L, result.get().getId());
    assertEquals("Title", result.get().getTitle());
    assertEquals("Description", result.get().getDescription());
    assertEquals("Image", result.get().getImage());
  }

  @Test
  public void testFindByName() {
    Optional<Post> result = repository.findByName("Title");
    assertTrue(result.isPresent());
    assertEquals(1L, result.get().getId());
    assertEquals("Title", result.get().getTitle());
    assertEquals("Description", result.get().getDescription());
    assertEquals("Image", result.get().getImage());
  }

  @Test
  public void testFindByCategory() {
    List<Post> result = repository.findByCategory(category);
    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(1L, result.get(0).getId());
    assertEquals("Title", result.get(0).getTitle());
    assertEquals

  }







