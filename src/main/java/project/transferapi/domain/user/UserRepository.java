package project.transferapi.domain.user;


public interface UserRepository {
    long countById(UserId id);
}
