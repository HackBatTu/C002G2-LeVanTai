package shoponlineapi.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoponlineapi.enlity.account.UserRole;
import shoponlineapi.repository.IUserRoleRepository;
import shoponlineapi.service.IUserRoleService;

@Service
public class UserRoleServiceImpl implements IUserRoleService {
    @Autowired
    private IUserRoleRepository iUserRoleRepository;

    @Override
    public void save(UserRole userRole) {
        iUserRoleRepository.save(userRole);
    }
}
