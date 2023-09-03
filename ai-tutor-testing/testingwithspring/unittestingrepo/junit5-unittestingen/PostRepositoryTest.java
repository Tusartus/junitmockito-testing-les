import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

  @BeforeEach
  public void setUp() {
    Post expected = new Post(1L, "Title", "Description", "Image", null);
    when(repository.findById(1L)).thenReturn(Optional.of(expected));
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
  public void testFindAll() {
    List<Post> result = repository.findAll();
    assertNotNull(result);
    assertEquals(1, result.size());
    assertEquals(1L, result.get(0).getId());
    assertEquals("Title", result.get(0).getTitle());
    assertEquals("Description", result.get(0).getDescription());
    assertEquals("Image", result.get(0).getImage());
  }
}
