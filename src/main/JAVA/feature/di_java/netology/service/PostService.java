package feature.di_java.netology.service;

import feature.di_java.netology.exception.NotFoundException;
import feature.di_java.netology.model.Post;
import feature.di_java.netology.repository.PostRepository;

import java.util.List;

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

