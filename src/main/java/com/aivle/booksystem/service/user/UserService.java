package com.aivle.booksystem.service.user;

import com.aivle.booksystem.domain.User;

public interface UserService {

    // 신규 유저 등록
    User registerUser(User user);

    // 유저 api key 받아오기
    String getToken();
}
