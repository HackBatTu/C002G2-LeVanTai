package shoponlineapi.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoponlineapi.dto.RegisterDTO;
import shoponlineapi.enlity.account.AppRole;
import shoponlineapi.enlity.account.AppUser;
import shoponlineapi.enlity.account.UserRole;
import shoponlineapi.jwt.util.EncrytedPasswordUtils;
import shoponlineapi.repository.IAppUserRepository;
import shoponlineapi.service.IAppUserService;
import shoponlineapi.service.IUserRoleService;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class AppUserServiceImpl implements IAppUserService {
    @Autowired
    private IAppUserRepository iUserRepository;

    @Autowired
    private EncrytedPasswordUtils encrytedPasswordUtils;

    @Autowired
    private IUserRoleService userRoleService;

    /**
     * @creator TaiLV
     * Date 09/08/2022
     * @param
     * @return  AppUser list
     */
    @Override
    public List<AppUser> getAllUser() {
        return iUserRepository.findAllUser();
    }

    @Override
    public AppUser findAppUserByUserName(String userName) {
        return iUserRepository.findAppUserByUserName(userName);
    }

    @Override
    public void saveAppUser(AppUser appUser) {
        iUserRepository.saveAppUser(appUser);
    }

    @Override
    public void registerUser(RegisterDTO registerDTO) {
        AppUser appUser = new AppUser();
        appUser.setUserName(registerDTO.getUsername());
        appUser.setPassword(this.encrytedPasswordUtils.encrytePassword(registerDTO.getPassword()));
        appUser.setCreationDate(Date.valueOf(LocalDate.now()));
        appUser.setIsDeleted(false);
        AppUser appUserDone = this.iUserRepository.save(appUser);

        AppRole appRole = new AppRole();
        appRole.setId(2);

        UserRole userRole = new UserRole();
        userRole.setAppRole(appRole);
        userRole.setAppUser(appUserDone);
        userRole.setIsDeleted(false);
        this.userRoleService.save(userRole);
    }

    @Override
    public AppUser getAppUserByUsername(String username) {
        return iUserRepository.getAppUserByUsername(username);
    }

    /**
     * @param appUser
     */
    @Override
    public void updatePassword(AppUser appUser) {
        this.iUserRepository.updatePassword(appUser);
    }
}
