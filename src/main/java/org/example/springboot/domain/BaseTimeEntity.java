package org.example.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   //  JPA Entity 클래스들이 BaseTimeEntity를 상속할 겨ㅓㅇ우 필드들도 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class)   //BaseTimeEntity 클래스에 Auditing 기능을 포함시킴
public class BaseTimeEntity {   //모든 Entity의 상위 클래스가 되어 Entity들의 생성시간, 수정시간을 자동으로 관리하는 역할

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
