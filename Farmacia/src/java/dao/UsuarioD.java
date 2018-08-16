package dao;

import interfaces.UsuarioI;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.UsuarioM;

public class UsuarioD extends Conexion implements UsuarioI{

    @Override
    public void agregar(UsuarioM usu) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into USUARIO(NOMUSU,APEUSU,USUUSU,PWDUSU,DNIUSU,LEVUSU) values(?,?,?,?,?,?)");
            st.setString(1, usu.getNOMUSU());
            st.setString(2, usu.getAPEUSU());
            st.setString(3, usu.getUSUUSU());
            st.setString(4, usu.getPWDUSU());
            st.setString(5, usu.getDNIUSU());
            st.setString(6, usu.getLEVUSU());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    @Override
    public void modificar(UsuarioM usu) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("insert into USUARIO(NOMUSU,APEUSU,USUUSU,PWDUSU,DNIUSU,LEVUSU) values(?,?,?,?,?,?)");
            st.setString(1, usu.getNOMUSU());
            st.setString(2, usu.getAPEUSU());
            st.setString(3, usu.getUSUUSU());
            st.setString(4, usu.getPWDUSU());
            st.setString(5, usu.getDNIUSU());
            st.setString(6, usu.getLEVUSU());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void eliminar(UsuarioM usu) throws Exception {
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("delete from USUARIO where NUMUSU=?");
            st.setInt(1, usu.getNUMUSU());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<UsuarioM> listar() throws Exception {
        List<UsuarioM> lista;
        ResultSet rs;
        try {
            this.Conectar();
            String sql = "Select * from Usuario";
            PreparedStatement st = this.getCn().prepareStatement(sql);
            rs = st.executeQuery();
            lista = new ArrayList();
            while (rs.next()) {                
                UsuarioM usu = new UsuarioM();
                usu.setNUMUSU(rs.getInt("NUMUSU"));
                usu.setNOMUSU(rs.getString("NOMUSU"));
                usu.setAPEUSU(rs.getString("APEUSU"));
                usu.setUSUUSU(rs.getString("USUUSU"));
                usu.setPWDUSU(rs.getString("PWDUSU"));
                usu.setDNIUSU(rs.getString("DNIUSU"));
                usu.setLEVUSU(rs.getString("LEVUSU"));
                lista.add(usu);
            }
            return lista;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
