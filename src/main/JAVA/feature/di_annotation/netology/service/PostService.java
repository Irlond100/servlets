package feature.di_annotation.netology.service;

import feature.di_annotation.netology.exception.NotFoundException;
import feature.di_annotation.netology.model.Post;
import feature.di_annotation.netology.repository.PostRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService {
  private final PostRepository repository;

  public PostService(PostRepository repository) {
    this.repository = repository;
  }

  public List<Post> all() {
    return repository.all();
  }

  public Post getById(long id) {
    return repository.getById(id).orElseThrow(NotFoundException::new);
  }

  public Post save(Post post) {
    return repository.save(post);
  }

  public Post removeById(long id) {
    return  repository.removeById(id);
  }
}
