package com.brq.ms03.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
 * A camada Service é responsável por armazenar as regras de negócio da aplicação
 * */
@Service
public class ProfessorService {

    // ESTE ARRAYLIST É DIDÁTICO, POIS ESTÁ SIMULANDO UM BANCO DE DADOS
    private ArrayList<com.brq.ms03.models.ProfessorModel> professor = new ArrayList<>();
    private int counter = 1;

    @Autowired
    private com.brq.ms03.repositories.ProfessorRepository usuRepository;

    public void mostrarMensagemService(){
        System.out.println("Mensagem do serviço");
    }

    public List<com.brq.ms03.dtos.ProfessorDTO> getAllUsuarios(){

        // a repository vai executar : SELECT * FROM professor;

        List<com.brq.ms03.models.ProfessorModel> list = usuRepository.findAll();

        // COMO CONVERTER UMA LISTA DE MODEL PARA LISTA DE DTO?

        List<com.brq.ms03.dtos.ProfessorDTO> listDTO = new ArrayList<>();

        // Tipo da variável -
        for (com.brq.ms03.models.ProfessorModel balde : list) {
            listDTO.add( balde.toDTO() );
        }

        return listDTO;
        //return professor;
    }

    public com.brq.ms03.dtos.ProfessorDTO create(com.brq.ms03.dtos.ProfessorDTO professor){

        // usuario.setId( counter );
        //usuarios.add(usuario);
        //counter++;

        // TEMOS QUE CONVERTER UM DTO PARA UM MODEL
        // jeito Fabrizio (Burro)
//        UsuarioModel usuarioDTOtoModel = new UsuarioModel();
//        usuarioDTOtoModel.setId( usuario.getId() );
//        usuarioDTOtoModel.setNome(usuario.getNome());
//        usuarioDTOtoModel.setTelefone(usuario.getTelefone());
//        usuarioDTOtoModel.setEmail(usuario.getEmail());

        // INSERT INTO professor (name_user, email_user ) VALUEs()....

        com.brq.ms03.models.ProfessorModel professorSalvo = usuRepository.save( professor.toModel() );

        // return  usuRepository.save( usuario );
        // return "POST Usuários";
        //return usuario;
        return professorSalvo.toDTO();
    }

    public com.brq.ms03.dtos.ProfessorDTO update(int id, com.brq.ms03.dtos.ProfessorDTO usuarioBody)  {

    //    com.brq.ms03.models.ProfessorModel usuario = usuRepository.findById(id)
        com.brq.ms03.models.ProfessorModel professor = usuRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Usuário não localizado") );


        professor.setCpf( usuarioBody.getCpf() );
        professor.setNome( usuarioBody.getNome() );
        professor.setTelefone( usuarioBody.getTelefone() );

     //   return usuRepository.save(usuario).toDTO();
        return usuRepository.save(professor).toDTO();

        // ver com prof . --> save(usario...
        // ver com prof . --> save(usario...



//
//        // ver se os dados existem
//        Optional<UsuarioModel> usuarioOptional = usuRepository.findById(id);
//
//        // eu achei o usuário no banco de dados
//        if (usuarioOptional.isPresent()){
//            // retorna os valores do usuário encontrado no banco de dados
//            UsuarioModel meuUsuario = usuarioOptional.get();
//
//            meuUsuario.setEmail( usuarioBody.getEmail() );
//            meuUsuario.setNome( usuarioBody.getNome() );
//
//            UsuarioModel usuarioSalvo = usuRepository.save(meuUsuario);
//
//            return usuarioSalvo;
//        }
//        // não achei o usuário no banco
//        else{
//            return usuarioOptional.orElseThrow( () -> new RuntimeException("Usuário não encontrado"));
//        }

//        // como achar o usuário a ser alterado?
//        for ( int i = 0; i <  usuarios.size(); i++ ){
//            if (usuarios.get(i).getId() == id){
//                // achamos o usuário a ser alterado
//                usuarios.get(i).setNome( usuarioBody.getNome() );
//                usuarios.get(i).setEmail( usuarioBody.getEmail() );
//
//                return usuarios.get(i);
//            } // if
//        }// for
//
//        return null;
    }

    public String delete(int id){
        // FORECH
//        for (UsuarioModel usuarioLocal: usuarios) {
//            usuarios.remove(usuarioLocal);
//        }
//        for (int i = 0; i < usuarios.size(); i++){
//            // se achar o usuário, então delete do arraylist
//            if (usuarios.get(i).getId() == id){
//                usuarios.remove(i);
//                return "Usuário delatado com sucesso!";
//            } // if
//        } // for
//        return "Usuário não encontrado";

        usuRepository.deleteById(id);
        return "professor delatado com sucesso!";
    }

    public com.brq.ms03.dtos.ProfessorDTO getOne(int id){

        com.brq.ms03.models.ProfessorModel professor = usuRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("professor não localizado"));

        return professor.toDTO();


//        Optional<UsuarioModel> usuarioOptional = usuRepository.findById(id);
//
//        if (usuarioOptional.isPresent()){
//            UsuarioModel usuario = usuarioOptional.get();
//
//            return usuario;
//        }
//        else {
//            return usuarioOptional.orElseThrow( ()-> new RuntimeException("Usuário não localizado") );
//        }


//        for (int i = 0; i < usuarios.size(); i++){
//            if (usuarios.get(i).getId() == id){
//                return usuarios.get(i);
//            } // if
//        } // for
//        return null;
    }
}
