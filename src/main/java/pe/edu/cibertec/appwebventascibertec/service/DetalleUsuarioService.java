package pe.edu.cibertec.appwebventascibertec.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.appwebventascibertec.model.bd.Rol;
import pe.edu.cibertec.appwebventascibertec.model.bd.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class DetalleUsuarioService
        implements UserDetailsService {
    private IUsuarioService iUsuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = iUsuarioService
                .obtenerUsuarioxNomUsuario(username);
        return obtenerUsuarioAutenticado(usuario,
                obtenerListaRolesUsuario(usuario.getRoles()));
    }

    private List<GrantedAuthority> obtenerListaRolesUsuario(
            Set<Rol> roles
    ){
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        for (Rol rol: roles){
            grantedAuthorityList.add(new SimpleGrantedAuthority(
                    rol.getNomrol()
            ));
        }
        return grantedAuthorityList;
    }

    private UserDetails obtenerUsuarioAutenticado(
            Usuario usuario,
            List<GrantedAuthority> grantedAuthorityList
    ){
        return new User(usuario.getNomusuario(),
                usuario.getPassword(),
                usuario.getActivo(), true,
                true, true,
                grantedAuthorityList);
    }
}
