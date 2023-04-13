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
public class MemberSaveResponseDto {
  private String memberLoginId;
  private String authority;


  public static MemberSaveResponseDto of(final MemberEntity member) {
    return MemberSaveResponseDto
        .builder()
        .memberLoginId(member.getMemberLoginId())
        .authority(member.getAuthority())
        .build();
  }

}
