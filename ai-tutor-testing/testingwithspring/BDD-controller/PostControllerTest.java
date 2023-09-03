import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PostControllerTest {

  @Mock
  private PostService postService;

  @InjectMocks
  private PostController postController;

  @Test
  void createPost() {
    Post post = new Post("Test Title", "Test Image", "Test Description", LocalDateTime.now());
    postController.createPost(post);
    verify(postService).createPost(post);
  }

  @Test
  void getPost() {
    Post expected = new Post("Test Title", "Test Image", "Test Description", LocalDateTime.now());
    given(postService.getPost(1L)).willReturn(Optional.of(expected));
    Post actual = postController.getPost(1L).get();
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void updatePost() {
    Post original = new Post("Test Title", "Test Image", "Test Description", LocalDateTime.now());
    given(postService.getPost(1L)).willReturn(Optional.of(original));
    Post updated = new Post("Updated Title", "Updated Image", "Updated Description", LocalDateTime.now());
    postController.updatePost(1L, updated);
    verify(postService).updatePost(1L, updated);
  }

  @Test
  void deletePost() {
    Post post = new Post("Test Title", "Test Image", "Test Description", LocalDateTime.now());
    given(postService.getPost(1L)).willReturn(Optional.of(post));
    postController.deletePost(1L);
    verify(postService).deletePost(1L);
  }
}



/*

This example uses JUnit 5's @ExtendWith and @Mock annotations to define the test 
class and its dependencies. The behavior of the PostService class is stubbed 
using Mockito's given method, and the behavior of the PostController class is 
verified using the verify method. 
The test assertions are made using AssertJ's fluent assertions.


*/