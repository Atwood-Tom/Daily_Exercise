import Org.example.model.DocInfo;

import java.util.ArrayList;
import java.util.List;

public class TestArraylist {
    private static List<DocInfo> list=new ArrayList<>();
    public static void init() {
        DocInfo doc1=new DocInfo();
        doc1.setId(1);
        doc1.setTitle("A");
        DocInfo doc2=new DocInfo();
        doc2.setId(2);
        doc2.setTitle("B");
        DocInfo doc3=new DocInfo();
        doc3.setId(3);
        doc3.setTitle("C");
        DocInfo doc4=new DocInfo();
        doc4.setId(4);
        doc4.setTitle("D");
        list.add(doc4);
        list.add(doc2);
        list.add(doc3);
        list.add(doc1);
    }

    public static void main(String[] args) {
        init();
        DocInfo doc =new DocInfo();
        doc.setId(1);
        System.out.println(list.contains(doc));
        System.out.println(list.indexOf(doc));
    }
}
