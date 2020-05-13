package fd.service;

import java.util.List;
import fd.entity.GameAbstract;

public interface ISearchService {
    List<GameAbstract> searchList(GameAbstract gameAbstract);
}
