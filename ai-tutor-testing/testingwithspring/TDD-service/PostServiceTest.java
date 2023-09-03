import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class PostServiceTest {

  @Mock
  private PostRepository repository;

  private PostService service;

  @BeforeEach
  void setup() {
    MockitoAnnotations.initMocks(this);
    service = new PostService(repository);
  }

  @Test
  void testCreatePost() {
    Post post = new Post("Test Title", "Test Image", "Test Description", LocalDateTime.now());
    service.createPost(post);
    verify(repository).save(post);
  }

  @Test
  void testGetPost() {
    Post expected = new Post("Test Title", "Test Image", "Test Description", LocalDateTime.now());
    when(repository.findById(1L)).thenReturn(Optional.of(expected));
    Post actual = service.getPost(1L).get();
    assertEquals(expected, actual);
  }

  @Test
  void testUpdatePost() {
    Post original = new Post("Test Title", "Test Image", "Test Description", LocalDateTime.now());
    when(repository.findById(1L)).thenReturn(Optional.of(original));
    Post updated = new Post("Updated Title", "Updated Image", "Updated Description", LocalDateTime.now());
    service.updatePost(1L, updated);
    verify(repository).save(updated);
  }

  @Test
  void testDeletePost() {
    Post post = new Post("Test Title", "Test Image", "Test Description", LocalDateTime.now());
    when(repository.findById(1L)).thenReturn(Optional.of(post));
    service.deletePost(1L);
    verify(repository).delete(post);
  }

  @Test
  void testGetAllPosts() {
    List<Post> expected = new ArrayList<>();
    expected.add(new Post("Test Title 1", "Test Image 1", "Test Description 1", LocalDateTime.now()));
    expected.add(new Post("Test Title 2", "Test Image 2", "Test Description 2", LocalDateTime.now()));
    when(repository.findAll()).thenReturn(expected);
    List<Post> actual = service.getAllPosts();
    assertEquals(expected, actual);
  }
}
