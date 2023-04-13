package sample.securitybasic.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sample.securitybasic.domain.member.domain.MemberEntity;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDto {
  private String memberLoginId;
  private String authority;


  public static MemberResponseDto of(final MemberEntity member) {
    return MemberResponseDto
        .builder()
        .memberLoginId(member.getMemberLoginId())
        .authority(member.getAuthority())
        .build();
  }

}
