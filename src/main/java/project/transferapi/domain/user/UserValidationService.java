package project.transferapi.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.transferapi.application.user.UserBadRequestException;

import static project.transferapi.application.ErrorStatus.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserValidationService {
    private final UserRepository repo;

    /**
     * 회원 유무 검증
     * @param id 회원 ID
     */
    public void validUser(UserId id) {
        long count = repo.countById(id);
        if (count < 1) {
            throw new UserBadRequestException(USER_NOT_FOUND);
        }
    }
}