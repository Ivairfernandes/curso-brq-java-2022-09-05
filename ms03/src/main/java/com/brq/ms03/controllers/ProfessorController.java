package com.brq.ms03.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


// comentário

/*
 * comentário
 * */

@RestController
public class ProfessorController {



    // private UsuarioService usuService = new UsuarioService();
    // @Autowired é importante pois permite que o Spring "instancie" o objeto do tipo UsuarioService
    @Autowired
    private com.brq.ms03.services.ProfessorService usuService;


    /*
     * o @GetMapping permite associoar o verbo GET com a rota /usuarios
     * */
    @GetMapping("professor")
    public List<com.brq.ms03.dtos.ProfessorDTO> getAllUsuarios(){

        // ISSO É VERDADEIRO?????
        /*
         * EM JAVA, NÃÃÃÃÃÃÃOOOO SE COMPARA STRING COM OPERADOR ==
         * */
//        if ("aaa" == "aaa"){
//
//        }
//        if ("aaa".equalsIgnoreCase("aaa")){
//
//        }
        usuService.mostrarMensagemService();
        //return usuarios;
//        ArrayList<UsuarioModel> usuarios = usuService.getAllUsuarios();
//          MANIPULAR AQUI
//        return usuarios;

        return usuService.getAllUsuarios();
    }

    @PostMapping("professor")
    public com.brq.ms03.dtos.ProfessorDTO create(@Valid @RequestBody com.brq.ms03.dtos.ProfessorDTO usuario){
//        UsuarioModel u = usuService.create(usuario);
//        return u;
        // return usuService.create(usuario);
        var t = usuService.create(usuario);

        return t;

    } // create

    // /usuarios/1 -> o valor do id vai ser 1

    @PatchMapping("professor/{id}")
    public com.brq.ms03.dtos.ProfessorDTO update(@RequestBody com.brq.ms03.dtos.ProfessorDTO usuarioBody,
                                                 @PathVariable int id ){
        //        UsuarioModel u = usuService.update(id, usuarioBody);
        //        return u;
        return usuService.update(id, usuarioBody);
    } // update()

    @DeleteMapping("professor/{id}")
    public String delete(@PathVariable int id){

//        String response = usuService.delete(id);
//        return response;

        return usuService.delete(id);
    } // delete

    // busca por apenas um usuário (pelo id)
    @GetMapping("professor/{id}")
    public com.brq.ms03.dtos.ProfessorDTO getOne(@PathVariable int id){

//        UsuarioModel u = usuService.getOne(id);
//        return u;

        return usuService.getOne(id);

    } // getOne

} // UsuarioController
