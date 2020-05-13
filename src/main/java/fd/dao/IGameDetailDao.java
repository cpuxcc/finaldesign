package fd.dao;

import fd.entity.GameDetail;

import java.util.List;

/**
 * 游戏细节
 */
public interface IGameDetailDao {
    void save(GameDetail gameDetail);

    /**
     * 根据主键获取
     * @param id
     * @return
     */
    GameDetail selectByPrimaryKey(Integer id);

    List<GameDetail> findAll();
}
