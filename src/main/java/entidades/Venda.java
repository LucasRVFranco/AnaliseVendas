/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author lucasf
 */
public class Venda {

    private Date dataVenda;
    private BigDecimal total = BigDecimal.ZERO;
    private Cliente cliente;
    private List<ItemVenda> itensVenda = new ArrayList<>();

    public void adicionarProduto(Produto produto, BigDecimal quantidade) {

        if (produto.getEstoque().compareTo(quantidade) >= 0) {
            ItemVenda item = new ItemVenda();
            item.setVenda(this);
            item.setProduto(produto);
            item.setQuantidade(quantidade);

            itensVenda.add(item);

            BigDecimal quantidadeAtual = produto.getEstoque().subtract(quantidade);

            produto.setEstoque(quantidadeAtual);

            total = total.add(produto.getValor().multiply(quantidade));

        }else{
            JOptionPane.showMessageDialog(null,"Vocë nào tem estoque suficiente!");
        }

    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

}
