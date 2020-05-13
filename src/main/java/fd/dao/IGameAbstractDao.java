package fd.dao;

import fd.entity.GameAbstract;
import java.util.List;

public interface IGameAbstractDao {
    /**
     * 根据条件筛选
     * @param gameAbstract
     * @return
     */
    List<GameAbstract> selectByGA(GameAbstract gameAbstract);

    List<GameAbstract> selectNew();

    List<GameAbstract> selectHighAssess();

    List<GameAbstract> selectHighHeat();

    List<GameAbstract> selectHighHeatLowAssess();

    List<GameAbstract> findAll();
}
