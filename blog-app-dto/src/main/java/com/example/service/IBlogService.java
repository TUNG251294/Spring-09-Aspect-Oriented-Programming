package com.example.service;

import com.example.model.Blog;
import com.example.model.BlogDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface IBlogService extends IGeneralService<BlogDto>{

    //    @Override
    //    public void save(BlogDto blogDto) {
    //        try {
    //            Blog blog = modelMapper.map(blogDto,Blog.class);
    //            blogRepository.save(blog);
    //        } catch (Exception ex) {
    //            // Xử lý lỗi tại đây
    //            throw new RuntimeException("Error while saving blog", ex);
    //        }
    //    }

    Page<BlogDto> findAllByAuthor(String author, Pageable pageable);


    Page<BlogDto> queryByName(String name, Pageable pageable);
//    Iterable<Blog> findByName(String name);
//    List<Blog> findByName(String name);

}
