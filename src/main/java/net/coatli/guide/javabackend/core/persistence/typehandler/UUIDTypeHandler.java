package net.coatli.guide.javabackend.core.persistence.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(UUID.class)
public class UUIDTypeHandler extends BaseTypeHandler<UUID> {

  @Override
  public void setNonNullParameter(
      final PreparedStatement ps,
      final int i,
      final UUID parameter,
      final JdbcType jdbcType) throws SQLException {

    ps.setString(i, parameter.toString());
  }

  @Override
  public UUID getNullableResult(
      final ResultSet rs,
      final String columnName) throws SQLException {

    return UUID.fromString(rs.getString(columnName));
  }

  @Override
  public UUID getNullableResult(
      final ResultSet rs,
      final int columnIndex) throws SQLException {

    return UUID.fromString(rs.getString(columnIndex));
  }

  @Override
  public UUID getNullableResult(
      final CallableStatement cs,
      final int columnIndex) throws SQLException {

    return UUID.fromString(cs.getString(columnIndex));
  }

}
