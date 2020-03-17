import java.io.*;
import net.sf.ezmorph.Morpher;
import net.sf.ezmorph.MorpherRegistry;
import net.sf.ezmorph.bean.BeanMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;


/**
 * 导出json格式
 * saveJson
 */
class saveJson {

    public static void convertObject(InfectStatistic.Province p, InfectStatistic.Commands cmds) {
        

        //1、使用JSONObject
        JSONObject json = JSONObject.fromObject(p);
        //2、使用JSONArray
        //JSONArray array=JSONArray.fromObject(p);
        
        String strJson=json.toString();
        //String strArray=array.toString();

        BufferedWriter writer = null;
        File file = new File("c:\\Users\\13067\\Desktop\\test2.0\\result\\"+ p.getName() + cmds.date + ".json");
        //如果文件不存在，则新建一个
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //写入
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,false), "UTF-8"));
            writer.write(strJson);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       //System.out.println("文件写入成功！");
    }
} 
