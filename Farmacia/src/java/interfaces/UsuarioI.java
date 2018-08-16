package interfaces;

import java.util.List;
import modelo.UsuarioM;

public interface UsuarioI {
    void agregar(UsuarioM usu)throws Exception;
    
    void modificar(UsuarioM usu)throws Exception;
    
    void eliminar(UsuarioM usu)throws Exception; // cambia de estado a la usuario por Inactivo 
    
    List<UsuarioM> listar() throws Exception;
}
