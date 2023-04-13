package sample.securitybasic.domain.member.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sample.securitybasic.domain.member.domain.MemberEntity;
import sample.securitybasic.domain.member.dto.MemberSaveRequestDto;
import sample.securitybasic.domain.member.dto.MemberSaveResponseDto;
import sample.securitybasic.domain.member.repository.MemberRepository;

@ExtendWith(SpringExtension.class)
@DisplayName("member sing up test")
class MemberSignUpServiceTest {

  @MockBean
  private MemberRepository memberRepository;
  @MockBean
  private PasswordEncoder passwordEncoder;

  private MemberSignUpService memberSignUpService;

  @BeforeEach
  public void init() {
    memberSignUpService = new MemberSignUpService(memberRepository, passwordEncoder);
  }

  @Test
  void 멤버_회원가입_테스트() {
    //given
    final var memberRequestDto = MemberSaveRequestDto.builder()
        .memberLoginId("test")
        .memberPassword("test")
        .authority("USER").build();

    final var memberEntity = MemberEntity.builder()
        .memberId(1L)
        .memberLoginId(memberRequestDto.getMemberLoginId())
        .memberPassword(passwordEncoder.encode(memberRequestDto.getMemberPassword()))
        .authority(memberRequestDto.getAuthority())
        .build();

    when(memberRepository.save(any())).thenReturn(memberEntity);
    //when


    final var result =  memberSignUpService.createForMember(memberRequestDto);

    //then
    assertThat(result).isNotNull()
        .isInstanceOf(MemberSaveResponseDto.class)
        .extracting("memberLoginId")
        .isEqualTo(memberEntity.getMemberLoginId());
  }
}