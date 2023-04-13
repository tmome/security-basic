package sample.securitybasic.domain.member.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.securitybasic.domain.member.dto.MemberLoginRequestDto;
import sample.securitybasic.domain.member.dto.MemberLoginResponseDto;
import sample.securitybasic.domain.security.dto.AuthTokenInfo;
import sample.securitybasic.domain.security.provider.JwtTokenProvider;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberLoginService {

  private final AuthenticationManagerBuilder authenticationManagerBuilder;
  private final JwtTokenProvider jwtTokenProvider;

  public MemberLoginResponseDto login(final MemberLoginRequestDto memberLoginRequestDto) {
    final var createToken = jwtTokenProvider.createToken(authentication(authenticationToken(memberLoginRequestDto)));
    return buildForMemberLoginResponseDto(createToken, memberLoginRequestDto);
  }

  private UsernamePasswordAuthenticationToken authenticationToken(final MemberLoginRequestDto request) {
    return new UsernamePasswordAuthenticationToken(request.getMemberLoginId(), request.getMemberPassword());
  }

  private Authentication authentication(final UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) {
    return authenticationManagerBuilder.getObject()
        .authenticate(usernamePasswordAuthenticationToken);
  }

  private MemberLoginResponseDto buildForMemberLoginResponseDto(
      final AuthTokenInfo authTokenInfo,
      final MemberLoginRequestDto dto
  ) {
    return MemberLoginResponseDto.builder()
        .authTokenInfo(authTokenInfo)
        .memberLoginId(dto.getMemberLoginId())
        .build();
  }

}
