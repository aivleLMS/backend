package com.aivle.booksystem.service.user;

import com.aivle.booksystem.domain.User;

public interface UserService {

    // 신규 사용자 등록
    User newUser(User user);

    // 유저 api key 받아오기
    String getToken(Long id);

    // 사용자 조회
    User findUserById(Long id);

    // 사용자 정보 수정
    User updateUser(Long id, User user);

    // 사용자 삭제
    void deleteUser(Long id);
}
