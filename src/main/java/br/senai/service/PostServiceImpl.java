package br.senai.service;

import br.senai.model.Post;
import br.senai.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public List <Post> findAll(){
        return postRepository.findAll();
    }
    @Override
    public Optional<Post> findById(long id){
        return postRepository.findById(id);
    }
    @Override
    public Post create(Post newPost){
        return postRepository.save(newPost);
    }

    @Override
    public Post update(Post updatedPost, Long id){
        return postRepository.findById(id)
                .map(post -> {
                    post.setNome(updatedPost.getNome());
                    return postRepository.save(post);
                })
                .orElseGet(()->{
                   updatedPost.setId(id);
                   return postRepository.save(updatedPost);
                });

    }

    @Override
    public void delete(long id) {
        postRepository.deleteById(id);
    }




}
