package Org.example.model;

public class Result {
    //合并文档排序用
    private Integer id;    //docInfo的id,文档合并时,文档身份标识
    private int weight;    //权重:同一个文档合并时,权重相加,再排序
    //返回前端使用
    private String title;  //对应文档docinfo的标题
    private String url;    //docInfo的url
    private String desc;   //docInfo的content(超长时,截取特定长度)

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", weight=" + weight +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
