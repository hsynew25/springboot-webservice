package org.example.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//Posts 클래스로 DB 접근하게 해주는 레포지토리(Dao임, JPA에선 '레포지토리'라고 부름)
public interface PostsRepository extends JpaRepository<Posts,Long> {
}
