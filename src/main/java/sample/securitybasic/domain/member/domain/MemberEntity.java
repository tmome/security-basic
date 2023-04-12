package sample.securitybasic.domain.member.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "member")
public class MemberEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_id", nullable = false)
  private Long memberId;

  @Column(name = "member_login_id", nullable = false)
  private String memberLoginId;

  @Column(name = "member_password", nullable = false)
  private String memberPassword;

  @Column(name = "authority", nullable = false)
  private String authority;

  @Builder
  public MemberEntity(
      Long memberId,
      String memberLoginId,
      String memberPassword,
      String authority
  ) {
    this.memberId = memberId;
    this.memberLoginId = memberLoginId;
    this.memberPassword = memberPassword;
    this.authority = authority;
  }
}
