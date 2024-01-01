package HomeShopping.HomeShopping.repository;

import HomeShopping.HomeShopping.domain.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSourceExtensionsKt;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.sql.DataSource;

@Repository
public class MysqlMemberRepository implements MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MysqlMemberRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public MemberDTO save(MemberDTO member) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", member.getMemberName());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        member.setId(key.longValue());
        return member;
    }

    @Override
    public Optional<MemberDTO> findByPassword(Long password) {
        List<MemberDTO> result = jdbcTemplate.query("select * from members where email = ?", memberDTORomMapper());
        return result.stream().findAny();
    }

    @Override
    public List<MemberDTO> findAll() {
        return jdbcTemplate.query("select * from member", memberDTORomMapper());
    }

    private RowMapper<MemberDTO> memberDTORomMapper() {
        return (rs, rowNum) -> {
            MemberDTO member = new MemberDTO();
            member.setId(rs.getLong("id"));
            member.setMemberEmail(rs.getString("email"));
            return member;
        };
    }
}
