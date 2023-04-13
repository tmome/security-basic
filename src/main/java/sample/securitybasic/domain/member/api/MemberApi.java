package sample.securitybasic.domain.member.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.securitybasic.domain.member.application.MemberLoginService;
import sample.securitybasic.domain.member.application.MemberSignUpService;
import sample.securitybasic.domain.member.dto.MemberLoginRequestDto;
import sample.securitybasic.domain.member.dto.MemberLoginResponseDto;
import sample.securitybasic.domain.member.dto.MemberSaveRequestDto;
import sample.securitybasic.domain.member.dto.MemberSaveResponseDto;
import sample.securitybasic.domain.security.dto.AuthTokenInfo;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberApi {

  private final MemberSignUpService memberSignUpService;
  private final MemberLoginService memberLoginService;

  @PostMapping("/signup")
  public MemberSaveResponseDto create(final @RequestBody MemberSaveRequestDto memberSaveRequestDto) {
    return memberSignUpService.createForMember(memberSaveRequestDto);
  }

  @PostMapping("/login")
  public MemberLoginResponseDto login(final @RequestBody MemberLoginRequestDto memberLoginRequestDto) {
    return memberLoginService.login(memberLoginRequestDto);
  }
}
