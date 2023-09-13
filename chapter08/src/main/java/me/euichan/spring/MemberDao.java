package me.euichan.spring;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDao {

	private JdbcTemplate jdbcTemplate;

	public MemberDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Member selectByEmail(String email) {
		// RowMapper는 ResultSet에서 데이터를 읽어와 Member 객체로 변환한다.
		List<Member> results = jdbcTemplate.query(
			"select * from MEMBER where EMAIL = ?",
			(rs, rowNum) -> {
				Member member = new Member(
					rs.getString("EMAIL"),
					rs.getString("PASSWORD"),
					rs.getString("NAME"),
					rs.getTimestamp("REGDATE").toLocalDateTime());
				member.setId(rs.getLong("ID"));
				return member;
			}, email);
		return results.isEmpty() ? null : results.get(0);
	}

	public void insert(Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(con -> {
			PreparedStatement pstmt = con.prepareStatement(
				"insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE)" + "values (?, ?, ?, ?)", new String[] {"ID"});
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
			return pstmt;
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
	}

	public void update(Member member) {
		jdbcTemplate.update(
			"update MEMBER set NAME = ?, PASSWORD = ? where EMAIL = ?",
			member.getName(), member.getPassword(), member.getEmail());
	}

	public List<Member> selectAll() {
		return jdbcTemplate.query("select * from MEMBER",
			(rs, rowNum) -> {
				Member member = new Member(
					rs.getString("EMAIL"),
					rs.getString("PASSWORD"),
					rs.getString("NAME"),
					rs.getTimestamp("REGDATE").toLocalDateTime());
				member.setId(rs.getLong("ID"));
				return member;
			});
	}

	public int count() {
		return jdbcTemplate.queryForObject(
			"select count(*) from MEMBER", Integer.class);
	}
}
