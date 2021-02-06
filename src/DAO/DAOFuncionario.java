package DAO;

import conexoes.ConexaoMySql;
import model.ModelFuncionario;
import java.util.ArrayList;
/**
 * @author  sérgio bruno
 * restaurante
*/
public class DAOFuncionario extends ConexaoMySql {

    /**
    * grava Funcionario
    * @param pModelFuncionario
    * return int
    */
    public int salvarFuncionarioDAO(ModelFuncionario pModelFuncionario){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO funcionarios ("
                    + "nome,"
                    + "endereco,"
                    + "bairro,"
                    + "cidade,"
                    + "uf,"
                    + "cep,"
                    + "telefone,"
                    + "perc_comissao"    
                + ") VALUES ("
                    + "'" + pModelFuncionario.getNome() + "',"
                    + "'" + pModelFuncionario.getEndereco() + "',"
                    + "'" + pModelFuncionario.getBairro() + "',"
                    + "'" + pModelFuncionario.getCidade() + "',"
                    + "'" + pModelFuncionario.getUf() + "',"
                    + "'" + pModelFuncionario.getCep() + "',"
                    + "'" + pModelFuncionario.getTelefone() + "',"
                    + "'" + pModelFuncionario.getPercComissao() + "'"    
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera Funcionario
    * @param pCodigo
    * return ModelFuncionario
    */
    public ModelFuncionario getFuncionarioDAO(int pCodigo){
        ModelFuncionario modelFuncionario = new ModelFuncionario();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "endereco,"
                    + "bairro,"
                    + "cidade,"
                    + "uf,"
                    + "cep,"
                    + "telefone,"
                    + "perc_comissao"    
                 + " FROM"
                     + " funcionarios"
                 + " WHERE"
                     + " codigo = '" + pCodigo + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFuncionario.setCodigo(this.getResultSet().getInt(1));
                modelFuncionario.setNome(this.getResultSet().getString(2));
                modelFuncionario.setEndereco(this.getResultSet().getString(3));
                modelFuncionario.setBairro(this.getResultSet().getString(4));
                modelFuncionario.setCidade(this.getResultSet().getString(5));
                modelFuncionario.setUf(this.getResultSet().getString(6));
                modelFuncionario.setCep(this.getResultSet().getString(7));
                modelFuncionario.setTelefone(this.getResultSet().getString(8));
                modelFuncionario.setPercComissao(this.getResultSet().getBigDecimal(9));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelFuncionario;
    }
    
    /**
    * recupera Funcionario
    * @param pNome
    * return ModelFuncionario
    */
    public ModelFuncionario getFuncionarioDAO(String pNome){
        ModelFuncionario modelFuncionario = new ModelFuncionario();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "endereco,"
                    + "bairro,"
                    + "cidade,"
                    + "uf,"
                    + "cep,"
                    + "telefone,"
                    + "perc_comissao"    
                 + " FROM"
                     + " funcionarios"
                 + " WHERE"
                     + " nome = '" + pNome + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFuncionario.setCodigo(this.getResultSet().getInt(1));
                modelFuncionario.setNome(this.getResultSet().getString(2));
                modelFuncionario.setEndereco(this.getResultSet().getString(3));
                modelFuncionario.setBairro(this.getResultSet().getString(4));
                modelFuncionario.setCidade(this.getResultSet().getString(5));
                modelFuncionario.setUf(this.getResultSet().getString(6));
                modelFuncionario.setCep(this.getResultSet().getString(7));
                modelFuncionario.setTelefone(this.getResultSet().getString(8));
                modelFuncionario.setPercComissao(this.getResultSet().getBigDecimal(9));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelFuncionario;
    }

    /**
    * recupera uma lista de Funcionario
        * return ArrayList
    */
    public ArrayList<ModelFuncionario> getListaFuncionarioDAO(){
        ArrayList<ModelFuncionario> listamodelFuncionario = new ArrayList();
        ModelFuncionario modelFuncionario = new ModelFuncionario();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "codigo,"
                    + "nome,"
                    + "endereco,"
                    + "bairro,"
                    + "cidade,"
                    + "uf,"
                    + "cep,"
                    + "telefone,"
                    + "perc_comissao"    
                 + " FROM"
                     + " funcionarios"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFuncionario = new ModelFuncionario();
                modelFuncionario.setCodigo(this.getResultSet().getInt(1));
                modelFuncionario.setNome(this.getResultSet().getString(2));
                modelFuncionario.setEndereco(this.getResultSet().getString(3));
                modelFuncionario.setBairro(this.getResultSet().getString(4));
                modelFuncionario.setCidade(this.getResultSet().getString(5));
                modelFuncionario.setUf(this.getResultSet().getString(6));
                modelFuncionario.setCep(this.getResultSet().getString(7));
                modelFuncionario.setTelefone(this.getResultSet().getString(8));
                modelFuncionario.setPercComissao(this.getResultSet().getBigDecimal(9));
                listamodelFuncionario.add(modelFuncionario);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelFuncionario;
    }

    /**
    * atualiza Funcionario
    * @param pModelFuncionario
    * return boolean
    */
    public boolean atualizarFuncionarioDAO(ModelFuncionario pModelFuncionario){
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                    "UPDATE funcionarios SET "
                    + "codigo = '" + pModelFuncionario.getCodigo() + "',"
                    + "nome = '" + pModelFuncionario.getNome() + "',"
                    + "endereco = '" + pModelFuncionario.getEndereco() + "',"
                    + "bairro = '" + pModelFuncionario.getBairro() + "',"
                    + "cidade = '" + pModelFuncionario.getCidade() + "',"
                    + "uf = '" + pModelFuncionario.getUf() + "',"
                    + "cep = '" + pModelFuncionario.getCep() + "',"
                    + "telefone = '" + pModelFuncionario.getTelefone() + "',"
                    + "perc_comissao = '" + pModelFuncionario.getPercComissao() + "'"        
                + " WHERE "
                    + "codigo = '" + pModelFuncionario.getCodigo() + "'"
                + ";"
            );
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui Funcionario
    * @param pCodigo
    * return boolean
    */
    public boolean excluirFuncionarioDAO(int pCodigo){
        try {
            this.conectar();
            this.executarUpdateDeleteSQL(
                "DELETE FROM funcionarios "
                + " WHERE "
                    + "codigo = '" + pCodigo + "'"
                + ";"
            );
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
}