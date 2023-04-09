
CREATE TABLE contact_send
(
  contact_uid VARCHAR(255) NOT NULL COMMENT '문의UID',
  id          VARCHAR(255) NOT NULL COMMENT '아이디',
  name        VARCHAR(255) NOT NULL COMMENT '이름',
  email       VARCHAR(255) NOT NULL COMMENT '이메일 주소',
  message     VARCHAR(255) NULL     COMMENT '메세지',
  PRIMARY KEY (contact_uid)
) COMMENT '문의';

CREATE TABLE education
(
  edu_uid    INTEGER      NOT NULL COMMENT '학력UID',
  resume_uid INTEGER      NOT NULL COMMENT '이력UID',
  school     VARCHAR(255) NULL     COMMENT '학교이름',
  status     VARCHAR(255) NULL     COMMENT '학력상태(수료? 졸업)',
  admission  VARCHAR(255) NULL     COMMENT '입학 년도',
  graduation VARCHAR(255) NULL     COMMENT '졸업 년도',
  PRIMARY KEY (resume_uid)
) COMMENT '학력';

CREATE TABLE member
(
  id        VARCHAR(255) NOT NULL COMMENT '아이디',
  password  VARCHAR(255) NULL     COMMENT '비밀번호',
  authority VARCHAR(255) NULL     COMMENT '권한',
  name      VARCHAR(255) NULL     COMMENT '이름',
  name_en   VARCHAR(255) NULL     COMMENT '이름(영문)',
  phone     VARCHAR(255) NULL     COMMENT '핸드폰 번호',
  email     VARCHAR(255) NULL     COMMENT '이메일 주소',
  PRIMARY KEY (id)
) COMMENT '회원';

CREATE TABLE portfolio
(
  portfolio_uid INTEGER      NOT NULL COMMENT '포트폴리오UID',
  id            VARCHAR(255) NOT NULL COMMENT '아이디',
  project_type  VARCHAR(255) NULL     COMMENT '포트폴리오 타입',
  PRIMARY KEY (portfolio_uid)
) COMMENT '포트폴리오';

CREATE TABLE project
(
  portfolio_uid   INTEGER      NOT NULL COMMENT '포트폴리오UID',
  project_uid     INTEGER      NOT NULL COMMENT '프로젝트UID',
  file           VARCHAR(255) NULL     COMMENT '프로젝트 이미지',
  project_name    VARCHAR(255) NULL     COMMENT '프로젝트 이름',
  project_content VARCHAR(255) NULL     COMMENT '프로젝트 내용',
  PRIMARY KEY (project_uid)
) COMMENT '프로젝트';

CREATE TABLE resume
(
  resume_uid  INTEGER      NOT NULL COMMENT '이력UID',
  id          VARCHAR(255) NOT NULL COMMENT '아이디',
  resume_type VARCHAR(255) NULL     COMMENT '이력 타입',
  PRIMARY KEY (resume_uid)
) COMMENT '이력';

CREATE TABLE skill
(
  skill_uid     INTEGER      NOT NULL COMMENT '기술UID',
  resume_uid    INTEGER      NOT NULL COMMENT '이력UID',
  skill         VARCHAR(255) NULL     COMMENT '기술 이름',
  skill_content VARCHAR(255) NULL     COMMENT '내용',
  PRIMARY KEY (resume_uid)
) COMMENT '기술';

CREATE TABLE social
(
  social_uid     INTEGER      NOT NULL COMMENT '사회경험UID',
  resume_uid     INTEGER      NOT NULL COMMENT '이력UID',
  job            VARCHAR(255) NULL     COMMENT '직무',
  social_content VARCHAR(255) NULL     COMMENT '내용',
  joining        VARCHAR(255) NULL     COMMENT '입사 년도',
  resignation    VARCHAR(255) NULL     COMMENT '퇴사 년도',
  PRIMARY KEY (resume_uid)
) COMMENT '사회경험';

ALTER TABLE social
  ADD CONSTRAINT FK_resume_TO_social
    FOREIGN KEY (social_uid)
    REFERENCES resume (resume_uid);

ALTER TABLE education
  ADD CONSTRAINT FK_resume_TO_education
    FOREIGN KEY (edu_uid)
    REFERENCES resume (resume_uid);

ALTER TABLE skill
  ADD CONSTRAINT FK_resume_TO_skill
    FOREIGN KEY (skill_uid)
    REFERENCES resume (resume_uid);

ALTER TABLE project
  ADD CONSTRAINT FK_portfolio_TO_project
    FOREIGN KEY (portfolio_uid)
    REFERENCES portfolio (portfolio_uid);

ALTER TABLE resume
  ADD CONSTRAINT FK_member_TO_resume
    FOREIGN KEY (id)
    REFERENCES member (id);

ALTER TABLE portfolio
  ADD CONSTRAINT FK_member_TO_portfolio
    FOREIGN KEY (id)
    REFERENCES member (id);

ALTER TABLE contact_send
  ADD CONSTRAINT FK_member_TO_contact_send
    FOREIGN KEY (id)
    REFERENCES member (id);
