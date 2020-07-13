package Mappers;

import Models.Usuario;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;

@Mapper
public interface UsuarioMapper {

//  !- CRUD -!
    Integer countAll();

    List<Usuario> selectAll();

    Integer insert(Usuario usuario);

    Integer update(Usuario usuario);

    Integer delete(@Param("idUsuario") Integer idUsuario);

//  !- CONSULTAS -!
    Usuario selectByPrimaryKey(@Param("idUsuario") Integer idUsuario);

    Usuario selectByUsuario(@Param("usuario") String usuario);

}
