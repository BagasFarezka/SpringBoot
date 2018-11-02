package com.bagas.belajar.spring.belajarspringio.dao.implemen;

import com.bagas.belajar.spring.belajarspringio.common.Table;
import com.bagas.belajar.spring.belajarspringio.dao.FakultasDao;
import com.bagas.belajar.spring.belajarspringio.entity.Fakultas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class FakultasDaoImpl implements FakultasDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Fakultas save(Fakultas param) {
        String sql = "INSERT INTO" + Table.TABLE_FAKULTAS + " (nama_fakultas, jumlah_fakultas) VALUES(?,?)";

        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getNama_fakultas());
            ps.setString(2, param.getJumlah_fakultas());
            return ps;
        }, keyHolder);

        param.setKd_fakultas(Objects.requireNonNull(keyHolder.getKey().toString()));
        return param;
    }

    @Override
    public Fakultas update(Fakultas param) {
        String sql = "UPDATE " + Table.TABLE_FAKULTAS + " SET " +
                "nama_fakultas = ?, jumlah_fakultas = ? WHERE kd_fakultas = ?";

        jdbcTemplate.update(sql,
                param.getNama_fakultas(),
                param.getJumlah_fakultas(),
                param.getKd_fakultas());
        return param;
    }

    @Override
    public String delete(Fakultas param) {
//        return null;

        String sql = "DELETE FROM " + Table.TABLE_FAKULTAS +
                " WHERE kd_fakultas = ? ";
        final String delete = String.valueOf(jdbcTemplate.update(sql, param.getKd_fakultas()));
        return delete;
    }

    @Override
    public List<Fakultas> find() {
        String sql = "SELECT * FROM " + Table.TABLE_FAKULTAS;

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Fakultas.class)); //beanproperty menyamakan database
    }

    @Override
    public Fakultas findByKd_fakultas(String kd_fakultas) {
        String sql = "SELECT * FROM " + Table.TABLE_FAKULTAS + " WHERE kd_fakultas = ? ";

        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Fakultas.class), kd_fakultas);
        } catch (EmptyResultDataAccessException ignored) {
        }

        return null;
    }
}
