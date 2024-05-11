package pe.edu.cibertec.appwebventascibertec.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.appwebventascibertec.model.bd.Usuario;
import pe.edu.cibertec.appwebventascibertec.model.dto.request.UsuarioRequest;
import pe.edu.cibertec.appwebventascibertec.model.dto.response.RespuestaResponse;
import pe.edu.cibertec.appwebventascibertec.service.IUsuarioService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/seguridad")
public class SeguridadController {
    private IUsuarioService iUsuarioService;
    @GetMapping("/init")
    public String formUsuario(Model model){
        model.addAttribute("listausuarios",
                iUsuarioService.listarUsuarios());
        return "backoffice/seguridad/frmusuario";
    }

    @PostMapping("/usuario")
    @ResponseBody
    public RespuestaResponse registrarUsuario(
            @RequestBody UsuarioRequest usuarioRequest
            ){
        String mensaje = "Usuario registrado correctamente";
        boolean respuesta = true;
        try{
            Usuario usuario = new Usuario();
            usuario.setNombres(usuarioRequest.getNombres());
            usuario.setApellidos(usuarioRequest.getApellidos());
            if(usuarioRequest.getIdusuario() > 0){
                usuario.setIdusuario(usuarioRequest.getIdusuario());
                usuario.setActivo(usuarioRequest.getActivo());
                iUsuarioService.actualizarUsuario(usuario);
            }else {
                usuario.setNomusuario(usuarioRequest.getNomusuario());
                usuario.setEmail(usuarioRequest.getEmail());
                iUsuarioService.guardarUsuario(usuario);
            }
        }catch (Exception ex){
            mensaje = "Usuario no registrado, error en la BD.";
            respuesta = false;
        }
        return RespuestaResponse.builder()
                .mensaje(mensaje).resultado(respuesta).build();
    }
    @GetMapping("/usuario/{id}")
    @ResponseBody
    public Usuario obtenerUsuarioxId(@PathVariable("id")
                                     int id){
        return iUsuarioService.obtenerUsuarioxId(id);
    }
    @GetMapping("/usuario")
    @ResponseBody
    public List<Usuario> listarUsuario(){
        return iUsuarioService.listarUsuarios();
    }


}
