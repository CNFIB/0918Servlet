import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.tjetc.empmanager.dao.DeptDao;
import com.tjetc.empmanager.dao.EmpDao;
import com.tjetc.empmanager.dao.impl.DeptDaoImpl;
import com.tjetc.empmanager.dao.impl.EmpDaoImpl;
import com.tjetc.empmanager.domain.Dept;
import com.tjetc.empmanager.domain.Emp;
import com.tjetc.empmanager.domain.Student;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        /*EmpDao dao = new EmpDaoImpl();
        List<Emp> emps =  dao.selectAll();
        String s = JSON.toJSONString(emps, SerializerFeature.WriteNullNumberAsZero,SerializerFeature.PrettyFormat);
        System.out.println(s);*/
        Student student1 = new Student(1,"aa");
        Student student2 = new Student(2,"bb");
        student1.setStudent(student2);
        student2.setStudent(student1);
        JSON.DEFAULT_GENERATE_FEATURE|= SerializerFeature.DisableCircularReferenceDetect.getMask();
        String string = JSON.toJSONString(student1,SerializerFeature.PrettyFormat);
        System.out.println(student1);
        String string2 = JSON.toJSONString(student2,SerializerFeature.PrettyFormat);
        System.out.println(string2);
    }
}
