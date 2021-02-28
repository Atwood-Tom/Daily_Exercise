package Org.example.util;

import Org.example.model.DocInfo;
import Org.example.model.Weight;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 构建索引
 * 正排索引:从本地文件数据中读取到java内存  (类似于数据库报损的数据)
 * 倒排索引:构建Map<String,List<信息>>  (类似于数据库hash索引)
 * Map键:关键词
 * Map值-信息
 * (1)docInfo对象引用或是docInfo的id
 * (2)信息:docInfo对象引用或是docInfo的id,权重(标题对应关键词数量*10+正文对应关键词数量*1)   10和1自行定义
 * (3)关键词(待定)
 */
public class Index {
    //正排索引
    private static final List<DocInfo> FORWARD_INDEX=new ArrayList<>();
    //倒排索引
    private static final Map<String,List<Weight>> INVERTED_INDEX=new HashMap<>();


    /**
     * 构建正排索引的内容;从本地raw_data进行读取
     */
    public static void buildForwordIndex() {
        try {
            FileReader fr = new FileReader(Parser.RAW_DATA);
            BufferedReader br = new BufferedReader(fr);
            int id = 0;//行号设置成docInfo的id
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().equals("")) {
                    continue;
                }
                //一行对应一个docInfo对象(对应数据库一行数据对应java对象)
                DocInfo doc = new DocInfo();
                doc.setId(++id);
                String parts[] = line.split("\3");//每一行按照\3来进行切割
                doc.setTitle(parts[0]);
                doc.setUrl(parts[1]);
                doc.setContent(parts[2]);
                //添加到正排索引
                FORWARD_INDEX.add(doc);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Weight> get(String keyword){
        return INVERTED_INDEX.get(keyword);
    }


    /**
     * 构建倒排索引:从java内存中正排索引过去文档信息来构建
     */
    public static void buildInvertedIndex(){
        for (DocInfo doc:FORWARD_INDEX){
            //一个doc分别对标题对正文分词,每一个分词生成一个weight对象,需要计算权重
            Map<String,Weight> cache=new HashMap<>();
            List<Term> titleFencis= ToAnalysis.parse(doc.getTitle()).getTerms();
            for (Term titleFenci:titleFencis){
                Weight w=cache.get(titleFenci.getName());
                if (w==null){//如果没有就创建一个并放到map中
                    w=new Weight();
                    w.setDoc(doc);
                    w.setKeyword(titleFenci.getName());
                    cache.put(titleFenci.getName(),w);
                }
                w.setWeight(w.getWeight()+10);
            }

            List<Term> contentFencis= ToAnalysis.parse(doc.getContent()).getTerms();
            for (Term contentFenci:contentFencis){
                Weight w=cache.get(contentFenci.getName());
                if (w==null){//如果没有就创建一个并放到map中
                    w=new Weight();
                    w.setDoc(doc);
                    w.setKeyword(contentFenci.getName());
                    cache.put(contentFenci.getName(),w);
                }
                w.setWeight(w.getWeight()+1);
            }
            //把临时保存的map数据(keyword-weight),全部保存到倒排索引中
            for (Map.Entry<String,Weight> e:cache.entrySet()){
                String keyword=e.getKey();
                Weight w=e.getValue();
                List<Weight> weights=INVERTED_INDEX.get(keyword);
                if (weights==null){//如果拿不到,就创建一个并且放入倒排索引
                    weights=new ArrayList<>();
                    INVERTED_INDEX.put(keyword,weights);
                }
                //System.out.println(keyword+" ::("+w.getDoc().getId()+","+w.getWeight()+")");
                weights.add(w);
            }
        }
    }


    public static void main(String[] args) {
        Index.buildForwordIndex();
        //FORWARD_INDEX.stream().forEach(System.out::println);
        Index.buildInvertedIndex();
        for (Map.Entry<String,List<Weight>> e:INVERTED_INDEX.entrySet()){
            String keyword=e.getKey();
            System.out.print(keyword+": ");
            List<Weight> weights=e.getValue();
            for (Weight w : weights) {
                String s = "(" + w.getDoc().getId() + "," + w.getWeight() + ")";
                System.out.print(s);
            }
            System.out.println();
        }
    }
}
