package com.hanbin.book.springboot.domain.posts;
import org.springframework.data.jpa.repository.JpaRepository;

// Entity(Posts)와 Entity Repository(PostsRepository)는 같은 공간에 위치해야 한다.
public interface PostsRepository extends JpaRepository<Posts, Long>{
}
