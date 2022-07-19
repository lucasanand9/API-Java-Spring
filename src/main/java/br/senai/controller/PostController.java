package br.senai.controller;

import br.senai.model.Post;
import br.senai.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    @Autowired
    PostServiceImpl postService;

    @GetMapping("/post")
    public List<Post> findAll(){return postService.findAll();};
    @GetMapping("/post/{id}")
    public Optional <Post> findById(@PathVariable long id){return postService.findById(id);}

    @PostMapping("/post")
    public Post create (@RequestBody Post post){return postService.create(post);}

    @DeleteMapping("/post/{id}")
    public void delete (@PathVariable long id){postService.delete(id);}

}
