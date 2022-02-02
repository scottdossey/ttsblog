package com.techtalentsouth.techtalentblog.blogpost;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogPostController {
	
	@Autowired
	private BlogPostRepository blogPostRepository;
	private static List<BlogPost> posts = new ArrayList<>();
	
	@GetMapping(value="/")
	public String index(Model model) {
		model.addAttribute("posts", posts);
		return "blogpost/index";
	}	
	
	@GetMapping(value="/new")
	public String newBlog(Model model) {
		//Our form needs default values!
		//Title/Author/BlogPost -- it'd be nice if those had default values...
		//The way we get those default values into the web page is we need
		//to provide a blogPost variable
		BlogPost defaultPost = new BlogPost("My Blog", "Scott Dossey", "This is my story.");
		model.addAttribute("blogPost", defaultPost);
		return "blogpost/new";
	}
	
	@PostMapping(value="/")
	public String addNewBlogPost(BlogPost blogPost, Model model) {
		blogPostRepository.save(blogPost);
		posts.add(blogPost);
		model.addAttribute("title", blogPost.getTitle());
		model.addAttribute("author", blogPost.getAuthor());
		model.addAttribute("blogEntry", blogPost.getBlogEntry());
		return "blogpost/result";
	}
}
