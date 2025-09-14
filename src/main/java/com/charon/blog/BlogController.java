package com.charon.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogController {
    
    @Autowired
    private PostRepository postRepository;
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("posts", postRepository.findAllByOrderByCreatedAtDesc());
        return "index";
    }
    
    @GetMapping("/new")
    public String newPost(Model model) {
        model.addAttribute("post", new Post());
        return "new-post";
    }
    
    @PostMapping("/posts")
    public String createPost(@ModelAttribute Post post) {
        postRepository.save(post);
        return "redirect:/";
    }
    
    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        Post post = postRepository.findById(id).orElse(null);
        model.addAttribute("post", post);
        return "post-detail";
    }
}