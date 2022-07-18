package br.senai.service;
import br.senai.model.Post;


import java.util.List;
import java.util.Optional;

public interface PostService {
    public List<Post> findAll();
    public Optional<Post> findById(long id);
    public Post create(Post newPost);
    public Post update(Post updatedPost, Long id);
    public void delete(long id);
}
