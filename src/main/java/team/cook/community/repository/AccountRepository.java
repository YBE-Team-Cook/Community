package team.cook.community.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.cook.community.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
