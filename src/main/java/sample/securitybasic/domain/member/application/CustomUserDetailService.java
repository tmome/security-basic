package sample.securitybasic.domain.member.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.securitybasic.domain.member.domain.MemberEntity;
import sample.securitybasic.domain.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomUserDetailService implements UserDetailsService {

  private final MemberRepository memberRepository;

  /**
   * 원하는 throw message 구현을 위해서는
   * AuthenticationProvider 생성 시에 setHideUserNotFoundException(false) 로 설정하면 BadCrentialsException 발생 안함
   * 하지만 강력한 보안을 위해 현재 샘플 코드에서는 그대로 두었음.
   */
  @Override
  public UserDetails loadUserByUsername(String memberLoginId) throws UsernameNotFoundException {
    return memberRepository.findByMemberLoginId(memberLoginId)
        .map(this::createUserDetails)
        .orElseThrow(() -> new UsernameNotFoundException("해당 유저를 찾을 수 없습니다."));
  }

  private UserDetails createUserDetails(final MemberEntity memberEntity) {
    return User.builder()
        .username(memberEntity.getMemberLoginId())
        .password(memberEntity.getMemberPassword())
        .roles(memberEntity.getAuthority())
        .build();
  }
}
