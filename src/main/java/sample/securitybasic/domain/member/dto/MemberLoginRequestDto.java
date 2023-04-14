package sample.securitybasic.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class MemberLoginRequestDto {
  private String memberLoginId;
  private String memberPassword;

  public MemberLoginRequestDto(String memberLoginId, String memberPassword) {
    this.memberLoginId = memberLoginId;
    this.memberPassword = memberPassword;
  }
}


