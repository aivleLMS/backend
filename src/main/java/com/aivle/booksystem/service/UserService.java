package com.aivle.booksystem.service;
// User - regist = post
// User - Token 받아오는 이유? 고유코드 = get

import com.aivle.booksystem.domain.User;

public interface UserService {

    // 신규 사용자 등록
    User userName(User user);

    // 사용자 조회
    User findUserById(Long id);

    // 유저 토큰 확인
    User checkToken(Long token);


}
