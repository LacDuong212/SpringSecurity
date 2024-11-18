package ld01.demospringsecurity.service;

import ld01.demospringsecurity.entity.UserInfo;
import ld01.demospringsecurity.repository.UserInfoRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public record UserService (UserInfoRepository repository, PasswordEncoder passwordEncoder) {
    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "Thêm user thành công";
    }
}