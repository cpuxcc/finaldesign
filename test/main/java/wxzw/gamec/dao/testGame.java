package wxzw.gamec.dao;

import org.junit.Test;
import wxzw.gamec.dao.impl.GameAbstractImpl;
import wxzw.gamec.dao.impl.GameDetailImpl;
import wxzw.gamec.entity.GameAbstract;
import wxzw.gamec.entity.GameDetail;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class testGame {
    private IGameDetailDao igameDetailDao=new GameDetailImpl();
    private IGameAbstractDao igameAbstractDao=new GameAbstractImpl();
    @Test
    public void save(){
        for(int i=0;i<20;i++){
            String rm=UUID.randomUUID().toString();
            GameDetail gameDetail=new GameDetail();
            gameDetail.setGameName("重装"+i);
            gameDetail.setPlantForm("FC"+i%6);
            gameDetail.setKind("RPG"+i%6);
            gameDetail.setDescribe("科幻末世风格"+rm+"的");
            gameDetail.setCoverImg("/ggimg/game"+i+".jpg");
            Date date=new Date();
            gameDetail.setCreateDate(date);
            gameDetail.setAssess(i);
            gameDetail.setHeat(i);
            igameDetailDao.save(gameDetail);
        }

    }
    @Test
    public void dall(){
        List<GameDetail> gameDetails=igameDetailDao.findAll();
        System.err.println(gameDetails);

    }
    @Test
    public void all(){
        List<GameAbstract> gameAbstractList=igameAbstractDao.selectHighHeatLowAssess();
        System.err.println(gameAbstractList);
    }
    @Test
    public void select(){
        GameAbstract gameAbstract=new GameAbstract();
     //   gameAbstract.setId(7);
      //  gameAbstract.setGameName("重装机兵");
     //   gameAbstract.setPlantForm("FC");
     //   gameAbstract.setKind("RPG");

        List<GameAbstract> gameAbstractList=igameAbstractDao.selectByGA(gameAbstract);
        System.err.println(gameAbstractList);
    }

    @Test
    public void newL(){
        List<GameAbstract> l=igameAbstractDao.selectNew();
        for(GameAbstract temp:l){
            System.out.println(temp);
        }
    }
}
