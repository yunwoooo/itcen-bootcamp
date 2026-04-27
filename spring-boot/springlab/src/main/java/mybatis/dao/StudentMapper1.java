package mybatis.dao;

import com.example.springlab.domain.StudentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper1 {
    @Select("select * from student")
    public List<StudentDTO> listAll();

    @Select("select * from student order by score desc")
    public List<StudentDTO> listOrderByScoreDesc();

    @Select("select * from student where score >= 70")
    public List<StudentDTO> listByScoreGreaterEqualThan70();

    @Select("select * from student where name like '%짱%'")
    public List<StudentDTO> listByContainName();

    @Select("select score from student where name = #{name}")
    public Integer getScore(String name);

    @Select("select avg(score) from student")
    public double getScoreAvg();
}
