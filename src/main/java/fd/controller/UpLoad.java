package fd.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import fd.dao.IGameDetailDao;
import fd.dao.impl.GameDetailImpl;
import fd.entity.GameDetail;

@WebServlet(urlPatterns = "/upload")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class UpLoad extends HttpServlet {
    private IGameDetailDao iGameDetailDao=new GameDetailImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String gameName=req.getParameter("gameName");
        String kind=req.getParameter("kind");
        String plantForm=req.getParameter("plantForm");
        String describe=req.getParameter("describe");
        String assess=req.getParameter("assess");
        String heat=req.getParameter("heat");
        Date date=new Date();

        GameDetail gameDetail=new GameDetail();
        gameDetail.setGameName(gameName);
        gameDetail.setKind(kind);
        gameDetail.setPlantForm(plantForm);
        gameDetail.setDescribe(describe);
        gameDetail.setAssess(Integer.parseInt(assess));
        gameDetail.setHeat(Integer.parseInt(heat));
        gameDetail.setCreateDate(date);
        System.out.println(gameDetail);

        String basePath = this.getServletContext().getRealPath("/");
        System.out.println(basePath);

        for (Part part : req.getParts()) {
            if(null!=part.getHeader("Content-Disposition")){
                System.out.println(part.getHeader("Content-Disposition"));
                if(part.getName().equals("file")){
                    String filename=getFileName(part.getHeader("Content-Disposition"));
                    gameDetail.setCoverImg("/ggimg/"+filename);
                    part.write(basePath+"ggimg/"+filename);
                }
            }
        }
        iGameDetailDao.save(gameDetail);
        /*resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("上传成功");
        out.flush();
        out.close();*/
        resp.sendRedirect("/gamec/contribute");
    }

    /**
     * 根据请求头解析出文件名
     * 请求头的格式：火狐和google浏览器下：form-data; name="file"; filename="snmp4j--api.zip"
     *                 IE浏览器下：form-data; name="file"; filename="E:\snmp4j--api.zip"
     * @param header 请求头
     * @return 文件名
     */
    public String getFileName(String header) {
        /**
         * String[] tempArr1 = header.split(";");代码执行完之后，在不同的浏览器下，tempArr1数组里面的内容稍有区别
         * 火狐或者google浏览器下：tempArr1={form-data,name="file",filename="snmp4j--api.zip"}
         * IE浏览器下：tempArr1={form-data,name="file",filename="E:\snmp4j--api.zip"}
         */
        String[] tempArr1 = header.split(";");
        /**
         *火狐或者google浏览器下：tempArr2={filename,"snmp4j--api.zip"}
         *IE浏览器下：tempArr2={filename,"E:\snmp4j--api.zip"}
         */
        String[] tempArr2 = tempArr1[2].split("=");
        //获取文件名，兼容各种浏览器的写法
        String fileName = tempArr2[1].substring(tempArr2[1].lastIndexOf("\\")+1).replaceAll("\"", "");
        return fileName;
    }
}
