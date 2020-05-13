package fd.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "g_user")

public class User implements Serializable {
    //对象标识
    private Integer id;
    //类型名称
    private String userName;
    private String passWord;
    public User(){}
    public User(String userName,String passWord){
        this.userName=userName;
        this.passWord=passWord;
    }

/**主键的生成策略...**/
    @Id
    @GeneratedValue
    public Integer getId(){return id;}

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", password='").append(passWord).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
