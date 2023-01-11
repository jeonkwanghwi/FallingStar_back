package login_test.repository;

import login_test.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }
/*
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }*/

    public List<Member> findByEmail(String email) { // email로 유저 찾기
        return em.createQuery("select m from Member m where m.email = :email", Member.class)
                .setParameter("email", email)
                .getResultList();
    }

 /*   public Optional<Member> findByKakaoId(Long kakaoId) {
        return em.createQuery("select k from Member k where k.kakaoId = :kakaoId", Member.class)
                .setParameter("kakaoId", kakaoId)
                .getResultStream().findAny();
    }*/
}
