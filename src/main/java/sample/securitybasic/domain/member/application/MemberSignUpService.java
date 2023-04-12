package sample.securitybasic.domain.member.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.securitybasic.domain.member.domain.MemberEntity;
import sample.securitybasic.domain.member.dto.MemberRequestDto;
import sample.securitybasic.domain.member.dto.MemberResponseDto;
import sample.securitybasic.domain.member.repository.MemberRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberSignUpService {

  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;

  public MemberResponseDto save(final MemberRequestDto memberRequestDto) {
    final var saveMemberEntity = memberRepository.save(buildForMemberEntity(memberRequestDto));

    return MemberResponseDto.of(saveMemberEntity);
  }

  private MemberEntity buildForMemberEntity(final MemberRequestDto memberRequestDto) {
    return MemberEntity.builder()
        .memberLoginId(memberRequestDto.getMemberLoginId())
        .memberPassword(passwordEncoder.encode(memberRequestDto.getMemberPassword()))
        .authority(memberRequestDto.getAuthority())
        .build();
  }

}
