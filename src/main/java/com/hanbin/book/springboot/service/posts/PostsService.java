package com.hanbin.book.springboot.service.posts;

import com.hanbin.book.springboot.domain.posts.Posts;
import com.hanbin.book.springboot.domain.posts.PostsRepository;
import com.hanbin.book.springboot.web.dto.PostsResponseDto;
import com.hanbin.book.springboot.web.dto.PostsSaveRequestDto;
import com.hanbin.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional // 트랜잭션 안에서 데이터베이스에서 데이터를 가져오면 영속성 컨텍스트가 유지됨
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        // Dto를 가지고 객체를 변경함
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        // 쿼리를 날리는 부분이 없는데, JPA의 영속성 컨텍스트 때문이다
        return id;
    }
    // 트랜잭션이 끝나는 시점에서 해당 테이블에 변경분을 반영함 (Entity 객체)

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        return new PostsResponseDto(entity);
        // Dto로 반환함 (Controller에서 써야하기 때문에)
    }
}
