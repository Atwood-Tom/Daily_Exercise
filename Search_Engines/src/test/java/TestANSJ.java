import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.List;

public class TestANSJ {
    public static void main(String[] args) {
        String str="我毕业于西安科技大学"+
                "后来去了中南海"+
                "结果被门卫干掉了";
        List<Term> terms= ToAnalysis.parse(str).getTerms();
        for (Term term:terms){
            System.out.print(term.getName()+"/");
        }
    }
}
