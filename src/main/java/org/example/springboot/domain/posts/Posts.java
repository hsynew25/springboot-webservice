package org.example.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter // 클래스 내 모든 필드의 Getter 메소드를 자동 생성
@NoArgsConstructor  //기본 생성자 자동 추가
                    // public Posts(){} 와 같은 효과
@Entity //테이블과 링크될 클래스
public class Posts extends BaseTimeEntity {    //실제 DB의 테이블과 매칭될 클래스(Entity 클래스라고도 함)
                        //JPA 사용하면 DB 데이터에 작업할 경우 실제 쿼리를 날리기 보다는 이 Entity클래스의 수정을 통해 작업함)

    @Id //해당 테이블의 PK 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙을 나타냄
    private Long id;

    // 테이블의 컬럼을 나타냄, 굳이 선언안해도 해당 클래스의 모든 필드는 컬럼이 됨
    // 사용 이유: 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
    @Column(length = 500, nullable = false)
    private  String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    //해당 클래스의 빌더 패턴 클래스를 생성
    //생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
