package Practice5.olgagavryliuk;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.googlecode.ehcache.annotations.Cacheable;

@Repository
public class JdbcStudentsDao implements StudentsDao {
	private static final String SQL_INSERT_STUDENT = "insert into students (pib,course) values (?,?)";

	private static final String SQL_SELECT_STUDENT_BY_ID = "select id, pib, course from students where id = ?";

	@Autowired
	private SimpleJdbcTemplate jdbcTemplate;

	public void addStudent(Student student) {
		jdbcTemplate.update(SQL_INSERT_STUDENT, student.getPib(), student.getCourse());
	}

	@Cacheable(cacheName = "studentsCache")
	public Student getStudentById(int id) {
		return jdbcTemplate.queryForObject(SQL_SELECT_STUDENT_BY_ID, new ParameterizedRowMapper<Student>() {
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				student.setStudentId(rs.getInt(1));
				student.setPib(rs.getString(2));
				student.setCourse(rs.getInt(3));
				return student;
			}
		}, id);
	}

	public Student getStudentById() {
		// TODO Auto-generated method stub
		return null;
	}
}