package controller;

import model.ModelFuncionario;
import DAO.DAOFuncionario;
import java.util.ArrayList;
import relatorios.DAORelatorios;

/**
 * @author  sérgio bruno
 * restaurante
*/
public class ControllerFuncionario {

    private DAOFuncionario daoFuncionario = new DAOFuncionario();
    private DAORelatorios dAORelatorios = new DAORelatorios();

    /**
    * grava Funcionario
    * @param pModelFuncionario
    * return int
    */
    public int salvarFuncionarioController(ModelFuncionario pModelFuncionario){
        return this.daoFuncionario.salvarFuncionarioDAO(pModelFuncionario);
    }

    /**
    * recupera Funcionario
    * @param pCodigo
    * return ModelFuncionario
    */
    public ModelFuncionario getFuncionarioController(int pCodigo){
        return this.daoFuncionario.getFuncionarioDAO(pCodigo);
    }
    
    /**
    * recupera Funcionario
    * @param pNome
    * return ModelFuncionario
    */
    public ModelFuncionario getFuncionarioController(String pNome){
        return this.daoFuncionario.getFuncionarioDAO(pNome);
    }

    /**
    * recupera uma lista deFuncionario
    * @param pCodigo
    * return ArrayList
    */
    public ArrayList<ModelFuncionario> getListaFuncionarioController(){
        return this.daoFuncionario.getListaFuncionarioDAO();
    }

    /**
    * atualiza Funcionario
    * @param pModelFuncionario
    * return boolean
    */
    public boolean atualizarFuncionarioController(ModelFuncionario pModelFuncionario){
        return this.daoFuncionario.atualizarFuncionarioDAO(pModelFuncionario);
    }

    /**
    * exclui Funcionario
    * @param pCodigo
    * return boolean
    */
    public boolean excluirFuncionarioController(int pCodigo){
        return this.daoFuncionario.excluirFuncionarioDAO(pCodigo);
    }

    public boolean gerarRelatorioFuncionario() {
        return this.dAORelatorios.gerarRelatorioFuncionario();
    }
}