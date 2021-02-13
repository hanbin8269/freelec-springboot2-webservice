package com.hanbin.book.springboot.domain.posts;
import com.hanbin.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor // 덜 중요한 롬복 어노테이션은 위로 물러남
@Entity // 테이블과 링크될 클래스임을 나타냄
public class Posts extends BaseTimeEntity {

    @Id // primary key 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // primary key 생성 규칙 (IDENTITY = auto_inclement)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    // Column 어노테이션은 구지 안써도 됨
    // 변경하고자 하는 옵션이 있으면 사용됨

    private String author; // 이렇게 해도 테이블의 칼럼이 된다

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
        // 객체를 변경만 함
    }
}
