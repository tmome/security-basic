package sample.securitybasic.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class MemberRequestDto {
  private String memberLoginId;
  private String memberPassword;
  private String authority;

  public MemberRequestDto(
      String memberLoginId,
      String memberPassword,
      String authority
  ) {
    this.memberLoginId = memberLoginId;
    this.memberPassword = memberPassword;
    this.authority = authority;
  }
}
