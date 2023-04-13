package sample.securitybasic.domain.member.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.securitybasic.domain.member.domain.MemberEntity;
import sample.securitybasic.domain.member.dto.MemberSaveRequestDto;
import sample.securitybasic.domain.member.dto.MemberSaveResponseDto;
import sample.securitybasic.domain.member.repository.MemberRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberSignUpService {

  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;

  public MemberSaveResponseDto createForMember(final MemberSaveRequestDto memberSaveRequestDto) {
    final var saveMemberEntity = memberRepository.save(buildForMemberEntity(memberSaveRequestDto));

    return MemberSaveResponseDto.of(saveMemberEntity);
  }

  private MemberEntity buildForMemberEntity(final MemberSaveRequestDto memberSaveRequestDto) {
    return MemberEntity.builder()
        .memberLoginId(memberSaveRequestDto.getMemberLoginId())
        .memberPassword(passwordEncoder.encode(memberSaveRequestDto.getMemberPassword()))
        .authority(memberSaveRequestDto.getAuthority())
        .build();
  }

}
