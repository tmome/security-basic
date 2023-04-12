package sample.securitybasic.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sample.securitybasic.domain.member.domain.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

}
