package com.brq.ms03.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO {

    private int id;

    @NotEmpty(message = "Valor em branco")
    @NotNull(message = "Preenchimento Obrigatório")
    private String nome;
    private String cpf;
    private String salario;
    private String telefone;

    public com.brq.ms03.models.ProfessorModel toModel(){

        ModelMapper mapper = new ModelMapper();

        com.brq.ms03.models.ProfessorModel model = mapper.map(this , com.brq.ms03.models.ProfessorModel.class );

        return model;
    }
}
