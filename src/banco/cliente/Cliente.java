package banco.cliente;

import banco.conta.Corrente;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

 public static List<Cliente> clientes = new ArrayList<>();
 private static int codigo = 100;
 protected String nome;
 protected String endereco;
 protected String cpf;
 protected int id;

 public Cliente(String nome, String cpf, String endereco) {
  this.id = codigo++;
  this.nome = nome;
  this.cpf = cpf;
  this.endereco = endereco;
 }

 public int getId() {
  return id;
 }

 public String getNome() {
  return nome;
 }

 public String getEndereco() {
  return endereco;
 }

 public String getCpf() {
  return cpf;
 }



 public void setNome(String nome) {
  this.nome = nome;
 }

 public void setEndereco(String endereco) {
  this.endereco = endereco;
 }

 public void setCpf(String cpf) {
  this.cpf = cpf;
 }

 @Override
 public String toString() {
  return "Cliente (id,nome,cpf): " + id + " " + nome  + " " + cpf;
 }

 public static void adicionarCliente (String nome, String cpf, String endereco) {
  clientes.add(new Cliente(nome, cpf, endereco));
 }

 public static void listarClientes() {
  for (Cliente cliente : clientes) {
   System.out.println(cliente);
  }
 }
  public static void removerCliente(int id){
   for (Cliente cliente:clientes) {
    if(cliente.getId() == id) {
     clientes.remove(cliente);
    }
   }
 }

}



