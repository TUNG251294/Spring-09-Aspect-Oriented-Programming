package com.example.repository;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends PagingAndSortingRepository<Blog,Long> {


    @Query("SELECT b FROM Blog b ORDER BY b.name DESC")
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByAuthor(String author, Pageable pageable);


    @Query(value = "from Blog b where b.name like %:name%")
    Page<Blog> queryByName(@Param("name")String name, Pageable pageable);

//


//    Optional<List<Blog>> findByName(String name);
    //    Iterable<Blog> findByName(@Param("name")String name);

}
