
package mack.br.lab_dao.entidades;

public class contas {
    private String idconta;
    private int saldo;
    
    public contas(){}
    
    public contas(String idconta, int saldo){
        this.idconta = idconta;
        this.saldo = saldo;
    }
    
    public String getIdconta() {
        return idconta;
    }
    
    public void setIdconta(String idconta) {
        this.idconta = idconta;
    }
    
    public int getSaldo() {
        return saldo;
    }
    
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    @Override
    public String toString() {
        return 
                " [conta:" + idconta +
                ", saldo: " + saldo + "]";
    }
    
    
}

