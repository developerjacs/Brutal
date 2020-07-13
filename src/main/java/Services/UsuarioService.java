package Services;

import Mappers.UsuarioMapper;
import Models.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;



public class UsuarioService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UsuarioMapper usuarioMapper;

    public List<Usuario> obtenerTodos() {
        return usuarioMapper.selectAll();
    }
    
    public Usuario obtenerPorId(Integer id){
        return usuarioMapper.selectByPrimaryKey(id);
    }
    public Usuario obtenerPorUsuario(String usuario){
        return usuarioMapper.selectByUsuario(usuario);
    }
    
    public void insertarUsuario(Usuario us){
        usuarioMapper.insert(us);
    }

}
