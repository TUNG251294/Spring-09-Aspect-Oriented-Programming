package com.example.service;

import com.example.model.Blog;
import com.example.model.BlogDto;
import com.example.repository.IBlogRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<BlogDto> findAll(Pageable pageable) {
        Page<Blog> entities = blogRepository.findAll(pageable);
        List<BlogDto> dtos = new ArrayList<>(
                entities.getContent().stream()
                        .parallel()
                        .map(entity -> modelMapper.map(entity, BlogDto.class))
                        .collect(Collectors.toList()));
        return new PageImpl<>(dtos, pageable, entities.getTotalElements());
    }



    @Override
    public Optional<BlogDto> findById(Long id) {
        Blog blog = blogRepository.findById(id).orElse(null);
        return Optional.of(modelMapper.map(blog,BlogDto.class));
    }

    @Override
    public void save(BlogDto blogDto) {
        try {
            Blog blog = modelMapper.map(blogDto,Blog.class);
            blogRepository.save(blog);
        }
            catch (Exception ex) {
                System.out.println("Loi:" + ex.getCause());
            throw new RuntimeException("Error while saving blog", ex);
        }
    }


    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }


    @Override
    public Page<BlogDto> findAllByAuthor(String author, Pageable pageable) {
        Page<Blog> entities = blogRepository.findAllByAuthor(author,pageable);
        List<BlogDto> dtos = new ArrayList<>(
                entities.getContent().stream()
                        .parallel()
                        .map(entity -> modelMapper.map(entity, BlogDto.class))
                        .collect(Collectors.toList()));
        return new PageImpl<>(dtos, pageable, entities.getTotalElements());
    }


    @Override
    public Page<BlogDto> queryByName(String name, Pageable pageable) {
        Page<Blog> entities = blogRepository.queryByName(name,pageable);
        List<BlogDto> dtos = new ArrayList<>(
                entities.getContent().stream()
                        .parallel()
                        .map(entity -> modelMapper.map(entity, BlogDto.class))
                        .collect(Collectors.toList()));
        return new PageImpl<>(dtos, pageable, entities.getTotalElements());
    }

//    @Override
//    public List<Blog> findByName(String name) {
//        Optional<List<Blog>> blogs = blogRepository.findByName(name);
//        List<Blog> blogList = blogs.orElseThrow(() -> new IllegalArgumentException("SAI NAME ROI"));
//                return blogList;
//    }

//    @Override
//    public Iterable<Blog> findByName(String name) {
//        return blogRepository.findByName(name);
//    }


}
