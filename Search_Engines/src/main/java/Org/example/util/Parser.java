package Org.example.util;


import Org.example.model.DocInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Parser {
    //API目录
    public static final String API_PATH="F:\\helper\\Project_helper\\docs\\api";
    //构建的本地文件正排索引
    public static final String RAW_DATA="F:\\Daily_Exercise\\Search_Engines\\raw_data.txt";
    //官方API文档的根路径
    public static final String API_BASE_PATH="https://docs.oracle.com/javase/8/docs/api";

    public static void main(String[] args) throws IOException {
        //将API本地路径下所有的html文件找到,并保存至res中
        List<File> html=listHtml(new File(API_PATH));
       // List<DocInfo> docs=new ArrayList<>();
        FileWriter fw=new FileWriter(RAW_DATA);
        //BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(fw,true);//打印输出流,自动刷新
        for (int i=0;i<html.size();i++){
            //一个html介意DocInfo有的属性,保存本地正排索引文件
            DocInfo doc=ParseHtml(html.get(i));
            //docs.add(doc);
            //保存本地正排索引那件,输出流输出到目标文件
            System.out.println("Parse "+html.get(i).getAbsolutePath());
            pw.println(doc.getTitle()+"\3"+doc.getUrl()+"\3"+doc.getContent());
        }
    }

    private static DocInfo ParseHtml(File file) {
        DocInfo docInfo=new DocInfo();
        docInfo.setTitle(file.getName().substring(0,file.getName().length()-".html".length()));//5==".html".length
        String uri=file.getAbsolutePath().substring(API_PATH.length());//获取相对路径 :==例:/java/lang/String.html
        docInfo.setUrl(API_BASE_PATH+uri);
        docInfo.setContent(parseContent(file));
        return docInfo;//目前是从本地api目录的html文件解析为文档对象,这部不需要设置id
    }

    /**
     *解析html文件内容
     * <标签>内容<标签/>
     * 只取内容,有多个内容进行拼接
     */
    private static String parseContent(File file) {
        StringBuilder sb=new StringBuilder();
        try {
            FileReader fr=new FileReader(file);
            int i;
            boolean isContent=false;
            //一个字符一个字符进行读取
            while((i=fr.read())!=-1){
                char c = (char) i;
                //根据读取的字符c是否是'<'   '>'  isContent决定是否拼接字符
                if (isContent){
                    if (c=='<'){//当前标签内容读取结束
                        isContent=false;
                        continue;
                    }else if (c=='\n'||c=='\r'){
                        sb.append(" ");
                        continue;
                    }
                    sb.append(c);
                }else if (c=='>'){
                    isContent=true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    //递归遍历子文件
    private static List<File> listHtml(File div){
        List<File> list=new ArrayList<>();
        File children[]=div.listFiles();
        for (File child:children){
            if (child.isDirectory()){
                list.addAll(listHtml(child));
            }else if (child.getName().endsWith(".html")){
                list.add(child);
            }
        }
        return list;
    }
}
