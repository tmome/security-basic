package sample.securitybasic.domain.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sample.securitybasic.domain.security.dto.AuthTokenInfo;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class MemberLoginResponseDto {

  private AuthTokenInfo authTokenInfo;
  private String memberLoginId;

  public MemberLoginResponseDto(
      AuthTokenInfo authTokenInfo,
      String memberLoginId
  ) {
    this.authTokenInfo = authTokenInfo;
    this.memberLoginId = memberLoginId;
  }
}
