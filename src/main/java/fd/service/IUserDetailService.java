package fd.service;

import java.util.List;
import fd.entity.UserDetail;

public interface IUserDetailService {
    List<UserDetail> findAll();
}
