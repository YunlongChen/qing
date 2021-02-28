package chenyunlong.zhangli.service.impl;

import chenyunlong.zhangli.common.exception.BadRequestException;
import chenyunlong.zhangli.common.exception.ErrorCode;
import chenyunlong.zhangli.common.exception.MyException;
import chenyunlong.zhangli.entities.Permission;
import chenyunlong.zhangli.entities.User;
import chenyunlong.zhangli.mapper.PermissionMapper;
import chenyunlong.zhangli.mapper.UserMapper;
import chenyunlong.zhangli.service.UserService;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author stan
 * @date 2020-09-25
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final PermissionMapper permissionMapper;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserMapper userMapper,
                           PermissionMapper permissionMapper,
                           PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.permissionMapper = permissionMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findUserByUserId(Long userId) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    /**
     * 更新用户的密码
     *
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @param userId      用户ID
     * @return 放弃上面的东西
     */
    @Override
    public User updatePassword(String oldPassword, String newPassword, Integer userId) {
        Assert.hasText(oldPassword, "Old password must not be blank");
        Assert.hasText(newPassword, "New password must not be blank");
        Assert.notNull(userId, "User id must not be blank");
        if (oldPassword.equals(newPassword)) {
            throw new BadRequestException("新密码和旧密码不能相同");
        }
        User user = userMapper.selectById(userId);
        if (!passwordEncoder.matches(user.getPassword(), oldPassword)) {
            throw new BadRequestException("旧密码错误").setErrorData(oldPassword);
        }
        user.setPassword(newPassword);

        userMapper.updatePassword(user);

        return user;
    }

    @Override
    public User register(User userInfo) {
        return null;
    }

    @Override
    public User login(User user) {

        User userInfo = userMapper.findByUsername(user.getUsername());

        String encode = passwordEncoder.encode(user.getUsername());
        if (userInfo == null) {
            return null;
        }
        if (passwordEncoder.matches(user.getPassword(), userInfo.getPassword())) {
            return userInfo;
        }
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public List<Permission> getPermissionByUsername(String username) {
        return permissionMapper.getPermissionByUsername(username);
    }

    @Override
    public void addUserInfo(User user) throws MyException {

        User userInfo = userMapper.findByUsername(user.getUsername());

        if (userInfo != null) {
            throw new MyException("用户已存在", ErrorCode.USER_ALREADY_EXISTS);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userMapper.addUser(user);
    }

    /**
     * 根据Email获取用户信息
     *
     * @param email email
     * @return 用户信息
     */
    @Override
    public User findUserByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    /**
     * 检查密码是否匹配用户的密码
     *
     * @param userInfo 用户信息
     * @param password 输入的密码
     * @return 密码匹配结果
     */
    @Override
    public boolean passwordMatch(@NonNull User userInfo, @Nullable String password) {
        return passwordEncoder.matches(password, userInfo.getPassword());
    }

}
