import java.util.HashMap;
import java.util.List;

public class 员工的重要性 {
    //链接:https://leetcode-cn.com/problems/employee-importance/
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
    public HashMap<Integer,Employee> hashMap=new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        for (int i=0;i<employees.size();i++){
            hashMap.put(employees.get(i).id,employees.get(i));
        }
        return dfs(id);
    }

    private int dfs(int id) {
        int result=hashMap.get(id).importance;
        List<Integer> x=hashMap.get(id).subordinates;
        for (Integer i:x){
            result+=dfs(i);
        }
        return result;
    }
}
