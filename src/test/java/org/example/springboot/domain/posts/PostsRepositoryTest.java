package org.example.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)    //스프링부트와 Junit 연결
@SpringBootTest //별다른 설정없이 사용할 경우 H2 데이터베이스를 자동으로 실행해 줌
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After  //Junit에서 단계가 끝날 때마다 수행되는 메소드 지정
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        String title = "테스트 게시글";
        String content = "테스트 본문";

        // 테이블 posts에 insert/update 쿼리 실행 (id값이 있으면 update, 없으면 insert)
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("hsy")
                .build());

        // 테이블 posts에 있는 모든 데이터를 조회
        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록(){
        LocalDateTime now = LocalDateTime.of(2023,1,15,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("hsy")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts= postsList.get(0);

        System.out.println(">>>> createDate="+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
