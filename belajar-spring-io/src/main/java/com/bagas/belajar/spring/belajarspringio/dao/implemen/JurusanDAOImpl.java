package com.bagas.belajar.spring.belajarspringio.dao.implemen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;

@Repository
public class JurusanDAOImpl implements JurusanDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Jurusan save(Jurusan param) {
        String sql = "INSERT INTO " + Table.TABLE_JURUSAN + " (nama_jurusan, kd_Fakultas) VALUES (?,?)";

        final KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, param.getNama_jurusan());
            ps.setInt(2, param.getKd_Fakultas());
            return ps;
        }, keyHolder);
        param.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());
        return param;
    }

    @Override
    public Jurusan update(Jurusan param) {
        String sql= "UPDATE " + Table.TABLE_JURUSAN +  " SET "+
                "nama = ?, idFakultas = ? WHERE id = ?";

        jdbcTemplate.update(sql,
                param.getNama_jurusan(),
                param.getKd_Fakultas(),
                param.getKd_jurusan());
        return param;
    }

    @Override
    public int delete(Jurusan param) {
        String sql= "DELETE FROM " + Table.TABLE_JURUSAN  + " WHERE id = ? ";
        final int delete = jdbcTemplate.update(sql, param.getKd_jurusan());
        return delete;
    }

    @Override
    public List<Jurusan> find() {
        String sql = "SELECT " +
                "jurusan.id AS id, " +
                "fakultas.kd AS kd_Fakultas, " +
                "jurusan.nama AS nama_jurusan, " +
                "fakultas.nama AS namaFakultas " +
                "FROM " + Table.TABLE_JURUSAN + " jurusan INNER JOIN " + Table.TABLE_FAKULTAS +
                " fakultas ON jurusan.kd_Fakultas = fakultas.kd";



        //ganti imi
        return jdbcTemplate.query(sql, new RowMapper<Jurusan>() {
            //rowmapper menyamakan antara variabel dan database
            @Override
            public Jurusan mapRow(ResultSet rs, int rowNum) throws SQLException {
                Jurusan jurusan=new Jurusan();
                jurusan.setId(rs.getString("id"));
                jurusan.setNama(rs.getString("nama"));
                jurusan.setIdFakultas(rs.getString("kd_Fakultas"));


                Fakultas fakultas=new Fakultas();
                fakultas.setId(rs.getString("Kd_Fakultas"));
                fakultas.setNama(rs.getString("namaFakultas"));
                jurusan.setFakultas(fakultas);
                return jurusan;
            }
        });//sampe sini
    }

    @Override
    public Jurusan findById(String kd_jurusan) {
        String sql = "SELECT * FROM " + Table.TABLE_JURUSAN + " WHERE kd_jurusan = ?";

        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Jurusan.class), kd_jurusan);
        } catch (EmptyResultDataAccessException ignored) {
        }

        return null;
    }
}




