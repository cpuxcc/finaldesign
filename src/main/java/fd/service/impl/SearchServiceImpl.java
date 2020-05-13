package fd.service.impl;

import fd.service.ISearchService;
import fd.dao.IGameAbstractDao;
import fd.dao.impl.GameAbstractImpl;
import fd.entity.GameAbstract;

import java.util.List;

public class SearchServiceImpl implements ISearchService {
    private IGameAbstractDao iGameAbstractDao=new GameAbstractImpl();
    @Override
    public List<GameAbstract> searchList(GameAbstract gameAbstract) {
        return iGameAbstractDao.selectByGA(gameAbstract);
    }
}
