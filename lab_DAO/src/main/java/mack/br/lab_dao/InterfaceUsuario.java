package mack.br.lab_dao;
import mack.br.lab_dao.entidades.contas;
import mack.br.lab_dao.persistencia.contasDAO;

import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {
    contasDAO dao;
    Scanner in;
    
    public InterfaceUsuario(contasDAO dao) {
        this.dao = dao;
        this.in = new Scanner (System.in);
    }
    
    public void iniciar(){
        imprimirMenu();
    }
    
    private void imprimirMenu(){
        int opc = 0;
        do{
            System.out.println("\n==============");
            System.out.println("==== Menu ====");
            System.out.println("==============");
            System.out.println("\t1. Create");
            System.out.println("\t2. Read");
            System.out.println("\t3. Update");
            System.out.println("\t4. Delete");
            System.out.println("\t5. sair");
            System.out.print("Escolha uma opção: ");
            opc = in.nextInt();
            
            in.nextLine();

            switch (opc) {
                case 1:
                    this.create();
                    break;
                case 2:
                    this.read();
                    break;
                case 3:
                    this.update();
                    break;
                case 4:
                    this.delete();
                    break;
                case 5:
                    System.out.println("tchau :)");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }while(opc !=5);
    }
    
    private void create(){
        contas conta = new contas();
        System.out.println("\n******************");
        System.out.println("*** Nova conta ***");
        System.out.println("******************");
        
        System.out.print("\nInforme o numero da conta: ");
        conta.setIdconta(in.nextLine());
        
        
        System.out.print("Informe o saldo da conta: ");
        conta.setSaldo(in.nextInt());
        
        if (dao.create(conta)) {
            System.out.println("Conta adicionado ao banco de Dados");
        } else {
            System.out.println("Ops: problema ao adicionar a conta ao banco de dados");
        }
    }
    
    private void read(){
        List<contas> contaL = dao.read();
        System.out.println("\n***********************************");
        System.out.println("*** Lista de Contas Cadastradas ***");
        System.out.println("***********************************");
        for(contas conta :  contaL){
            System.out.println(conta);
        }
    
    }
    
    private void update(){
        List<contas> contaL = dao.read();
        while(true){
        System.out.println("\n***********************************");
        System.out.println("*** Lista de Contas Cadastradas ***");
        System.out.println("***********************************");
        int i =0;
        for(contas conta: contaL){
                System.out.println("Id: "+i+" - "+ conta);
                i++;
        }
        System.out.println("ID: "+i+ " - Cancelar operação" );
        System.out.println("Escolha o id da conta que deseja atualizar. ");
        int opc = in.nextInt();
        in.nextLine();
        if (opc ==i){
                break;
        }
        
        
        System.out.print("Informe o novo saldo da conta: ");
        contaL.get(opc).setSaldo(in.nextInt());
        
        if(opc>= contaL.size() || opc < 0){
                System.out.println("Esta opção não é válida");
            } else{
                if(dao.update(contaL.get(opc))){
                    System.out.println("Conta "+ contaL.get(opc).getIdconta() + 
                            " atualizada com sucesso");
                } else{
                    System.out.println("OPS: falha ao tentar atualizar");
                }
                break;
            }
    }
    }
    
    private void delete(){
        List<contas> contaL = dao.read();
        while(true){
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Contas Cadastradas ***");
            System.out.println("***********************************");
            int i =0;
            for(contas conta: contaL){
                System.out.println("ID: "+i+" - "+ conta);
                i++;
            }
            System.out.println("ID: "+i+ " - Cancelar operação" );
            System.out.println("Digite o ID da conta que deseja remover");
            int opc = in.nextInt();
            in.nextLine();
            
            if (opc ==i){
                break;
            }
            if(opc>= contaL.size() || opc < 0){
                System.out.println("Esta opção não é válida");
            } else{
                if(dao.delete(contaL.get(opc))){
                    System.out.println("Conta "+ contaL.get(opc).getIdconta() + 
                            " removida com sucesso");
                } else{
                    System.out.println("OPS: falha ao tentar remover");
                }
                break;
            }
        }
    }
}
