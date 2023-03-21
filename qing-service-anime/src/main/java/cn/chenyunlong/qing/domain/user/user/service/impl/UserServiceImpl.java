// ---Auto Generated by Project Qing ---
package cn.chenyunlong.qing.domain.user.user.service.impl;

import cn.chenyunlong.common.constants.CodeEnum;
import cn.chenyunlong.common.exception.BusinessException;
import cn.chenyunlong.common.model.PageRequestWrapper;
import cn.chenyunlong.jpa.support.EntityOperations;
import cn.chenyunlong.qing.domain.user.user.QUser;
import cn.chenyunlong.qing.domain.user.user.User;
import cn.chenyunlong.qing.domain.user.user.creator.UserCreator;
import cn.chenyunlong.qing.domain.user.user.mapper.UserMapper;
import cn.chenyunlong.qing.domain.user.user.query.UserQuery;
import cn.chenyunlong.qing.domain.user.user.repository.UserRepository;
import cn.chenyunlong.qing.domain.user.user.service.IUserService;
import cn.chenyunlong.qing.domain.user.user.updater.UserUpdater;
import cn.chenyunlong.qing.domain.user.user.vo.UserVO;
import cn.chenyunlong.qing.infrastructure.domain.BaseEntity;
import cn.hutool.core.lang.Snowflake;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    /**
     * createImpl
     */
    @Override
    public Long createUser(UserCreator creator) {
        Optional<User> user = EntityOperations.doCreate(userRepository)
                .create(() -> UserMapper.INSTANCE.dtoToEntity(creator))
                .update(BaseEntity::init)
                .execute();
        return user.isPresent() ? user.get().getId() : 0;
    }

    /**
     * update
     */
    @Override
    public void updateUser(UserUpdater updater) {
        EntityOperations.doUpdate(userRepository)
                .loadById(updater.getId())
                .update(updater::updateUser)
                .execute();
    }

    /**
     * valid
     */
    @Override
    public void validUser(Long id) {
        EntityOperations.doUpdate(userRepository)
                .loadById(id)
                .update(e -> e.valid())
                .execute();
    }

    /**
     * invalid
     */
    @Override
    public void invalidUser(Long id) {
        EntityOperations.doUpdate(userRepository)
                .loadById(id)
                .update(e -> e.invalid())
                .execute();
    }

    /**
     * findById
     */
    @Override
    public UserVO findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return new UserVO(user.orElseThrow(() -> new BusinessException(CodeEnum.NotFindError)));
    }

    /**
     * findByPage
     */
    @Override
    public Page<UserVO> findByPage(PageRequestWrapper<UserQuery> query) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        Page<User> page = userRepository.findAll(booleanBuilder,
                PageRequest.of(query.getPage() - 1, query.getPageSize(), Sort.by(
                        Sort.Direction.DESC, "createdAt")));
        return new PageImpl<>(page.getContent()
                .stream().map(UserVO::new)
                .collect(Collectors.toList()), page.getPageable(), page.getTotalElements());
    }

    /**
     * @param username 用户名
     * @return 用户信息
     */
    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    /**
     * 通过
     *
     * @param userName 用户名
     * @param password 密码
     * @param authCode 验证码
     */
    @Override
    public Optional<User> authenticate(String userName, String password, String authCode) {
        return findUserByUsername(userName)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()));
    }


    /**
     * @param user 用户信息
     * @return 用户信息
     */
    @Override
    public User addUserInfo(User user) {
        if (findUserByUsername(user.getUsername()).isPresent()) {
            throw new BusinessException(CodeEnum.ValidateError);
        }
        user.setUid(new Snowflake().nextId());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.saveAndFlush(user);
    }

    /**
     * 更新密码
     *
     * @param userId   用户id
     * @param password 暗语
     */
    @Override
    public User updatePassword(String userId, String password) {
        QUser user = QUser.user;
        return null;
    }
}
