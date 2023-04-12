CREATE TABLE IF NOT EXISTS member (
    member_id BIGINT(5) AUTO_INCREMENT PRIMARY KEY COMMENT '멤버 식별자',
    member_login_id VARCHAR(20) NOT NULL COMMENT '멤버 로그인 아이디',
    member_password VARCHAR(100) NOT NULL COMMENT '멤버 비밀번호',
    authority VARCHAR(10) NOT NULL DEFAULT 'MEMBER' COMMENT '멤버 권한'
);
COMMENT ON TABLE member is '멤버 테이블';
