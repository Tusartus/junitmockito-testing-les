
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PostRepositoryTest {

  @Mock
  private Database database;

  @InjectMocks
  private PostRepository repository;

  @Test
  public void testGetPosts() {
    when(database.getPosts()).thenReturn(Arrays.asList(
      new Post(1, "First Post", "image1.jpg", "This is the first post", System.currentTimeMillis()),
      new Post(2, "Second Post", "image2.jpg", "This is the second post", System.currentTimeMillis()),
      new Post(3, "Third Post", "image3.jpg", "This is the third post", System.currentTimeMillis())
    ));

    List<Post> posts = repository.getPosts();
    assertEquals(3, posts.size());
    assertEquals("First Post", posts.get(0).getTitle());
    assertEquals("Second Post", posts.get(1).getTitle());
    assertEquals("Third Post", posts.get(2).getTitle());
  }

  @Test
  public void testGetPost() {
    when(database.getPost(1)).thenReturn(
      new Post(1, "First Post", "image1.jpg", "This is the first post", System.currentTimeMillis())
    );

    Post post = repository.getPost(1);
    assertEquals(1, post.getId());
    assertEquals("First Post", post.getTitle());
    assertEquals("This is the first post", post.getDescription());
  }

  @Test
  public void testAddPost() {
    Post post = new Post(1, "First Post", "image1.jpg", "This is the first post", System.currentTimeMillis());
    repository.addPost(post);
    // Verify that the database.addPost method was called with the expected argument
    verify(database).addPost(post);
  }

  @Test
  public void testUpdatePost() {
    Post post = new Post(1, "First Post", "image1.jpg", "This is the first post", System.currentTimeMillis());
    repository.updatePost(post);
    // Verify that the database.updatePost method was called with the expected argument
    verify(database).updatePost(post);
  }

  @Test
  public void testDeletePost() {
    repository.deletePost(1);
    // Verify that the database.deletePost method was called with the expected argument
    verify(database).deletePost(1);
  }







  
   
