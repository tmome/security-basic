package sample.securitybasic.domain.member.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.securitybasic.domain.member.application.MemberSignUpService;
import sample.securitybasic.domain.member.dto.MemberRequestDto;
import sample.securitybasic.domain.member.dto.MemberResponseDto;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberApi {

  private final MemberSignUpService memberSignUpService;

  @PostMapping("/signup")
  public MemberResponseDto create(final @RequestBody MemberRequestDto memberRequestDto) {
    return memberSignUpService.save(memberRequestDto);
  }
}
