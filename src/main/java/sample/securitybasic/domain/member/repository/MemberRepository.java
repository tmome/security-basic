package sample.securitybasic.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.securitybasic.domain.member.domain.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {

}
